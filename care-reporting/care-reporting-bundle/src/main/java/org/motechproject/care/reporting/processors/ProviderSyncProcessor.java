package org.motechproject.care.reporting.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.motechproject.care.reporting.mapper.ProviderSyncMapper;
import org.motechproject.care.reporting.parser.GroupParser;
import org.motechproject.care.reporting.parser.ProviderParser;
import org.motechproject.care.reporting.service.MapperService;
import org.motechproject.care.reporting.service.Service;
import org.motechproject.commcare.provider.sync.response.Group;
import org.motechproject.commcare.provider.sync.response.Provider;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwAndFlwGroupMapList;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroupMap;
import org.motechproject.mcts.care.common.mds.dimension.LocationDimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
public class ProviderSyncProcessor {
    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");

    private GroupParser groupParser;
    private Service service;
    private ProviderParser providerParser;
    private ProviderSyncMapper genericMapper;

    @Autowired
    public ProviderSyncProcessor(Service service, MapperService mapperService, ProviderSyncMapper providerSyncMapper) {
        this(mapperService.getGroupInfoParser(), mapperService.getProviderInfoParser(), service, providerSyncMapper);
    }

    public ProviderSyncProcessor(GroupParser groupParser, ProviderParser providerParser, Service service, ProviderSyncMapper providerSyncMapper) {
        this.groupParser = groupParser;
        this.service = service;
        this.providerParser = providerParser;
        this.genericMapper = providerSyncMapper;
    }

    public void processGroupSync(List<Group> groups) {
        List<FlwGroup> flwGroups = new ArrayList<>();
        for (Group group : groups) {
            String id = group.getId();
            logger.info(String.format("Creating/Updating group with id: %s", id));
            try {
                FlwGroup flwGroup = processGroup(group);
                flwGroups.add(flwGroup);
            } catch (Exception e) {
                logger.error(String.format("Error occurred while processing group with id: %s", id), e);
            }
        }
        service.saveOrUpdateAllByExternalPrimaryKey(FlwGroup.class, flwGroups);
    }

    private FlwGroup processGroup(Group group) {
        Map<String, Object> parsedGroup = groupParser.parse(group);
        return genericMapper.map(FlwGroup.class, parsedGroup);
    }

    public void processProviderSync(List<Provider> providers) {
        List<Flw> flws = new ArrayList<>();
        List<FlwGroupMap> flwGroupMapList = new ArrayList<FlwGroupMap>();
        Map<String, FlwGroup> flwGroups = new HashMap<>();
        for (Provider provider : providers) {
            try {
                FlwAndFlwGroupMapList flwAndFlwGroupMapList = processProvider(flwGroups, provider);
                flws.add(flwAndFlwGroupMapList.getFlw());
                flwGroupMapList.addAll(flwAndFlwGroupMapList.getFlwGroupMapList());
            } catch (Exception e) {
                logger.error(String.format("Error occurred while processing provider with id: %s", provider.getId()), e);
            }
        }
        service.saveOrUpdateAllByExternalPrimaryKey(Flw.class, flws);
        service.saveAll(flwGroupMapList);
    }

    private FlwAndFlwGroupMapList processProvider(Map<String, FlwGroup> flwGroups, Provider provider) {
        logger.info(String.format("Creating/Updating provider with id: %s", provider.getId()));
        Map<String, Object> parsedProvider = providerParser.parse(provider);
        Flw flw = genericMapper.map(Flw.class, parsedProvider);
        List<FlwGroup> flwGroupsList = getAssociatedFlwGroups(provider.getGroups(), flwGroups);
        List<FlwGroupMap> flwGroupMapList = new ArrayList<FlwGroupMap>();
        for(FlwGroup currGroup : flwGroupsList) {
            FlwGroupMap flwGroupMap = new FlwGroupMap();
            flwGroupMap.setFlw(flw);
            flwGroupMap.setFlwGroup(currGroup);
            flwGroupMapList.add(flwGroupMap);
        }
        //TODO remove the below comment after two way relation is supported
        //flw.setFlwGroups(new HashSet<>(flwGroupsList));
        flw.setLocationDimension(getLocationDimension(parsedProvider));
        return new FlwAndFlwGroupMapList(flw,flwGroupMapList);
    }

    private LocationDimension getLocationDimension(Map<String, Object> parsedProvider) {
        return service.getLocation((String) parsedProvider.get("state"), (String) parsedProvider.get("district"),(String)  parsedProvider.get("block"));
    }

    private List<FlwGroup> getAssociatedFlwGroups(List<String> groups, Map<String, FlwGroup> existingFlwGroups) {
        ArrayList<FlwGroup> flwGroups = new ArrayList<>();
        if (groups == null)
            return flwGroups;
        for (String groupId : groups) {
            FlwGroup group;
            if (existingFlwGroups.containsKey(groupId)) {
                group = existingFlwGroups.get(groupId);
            } else {
                group = service.getOrCreateGroup(groupId);
                existingFlwGroups.put(groupId, group);
            }
            flwGroups.add(group);
        }
        return flwGroups;
    }
}
