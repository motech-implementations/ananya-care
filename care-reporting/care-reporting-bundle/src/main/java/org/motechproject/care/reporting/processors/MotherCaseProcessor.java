package org.motechproject.care.reporting.processors;

import static org.motechproject.care.reporting.parser.PostProcessor.Utils.applyPostProcessors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.motechproject.care.reporting.enums.CaseType;
import org.motechproject.care.reporting.parser.CaseInfoParser;
import org.motechproject.care.reporting.parser.InfoParser;
import org.motechproject.care.reporting.parser.PostProcessor;
import org.motechproject.care.reporting.service.MapperService;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.care.reporting.utils.Constants;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotherCaseProcessor {
    private static final Logger logger = LoggerFactory
            .getLogger(MotherCaseProcessor.class);
            		//"commcare-reporting-mapper");
    private static List<PostProcessor> MOTHER_CASE_POSTPROCESSOR = new ArrayList<PostProcessor>() {
        {
            add(PostProcessor.CASE_COPY_USER_ID_AS_FLW);
            add(PostProcessor.COPY_OWNER_ID_AS_FLW_GROUP);
        }
    };

    private EventRelay eventRelay;
    private ICareService careService;
    private MapperService mapperService;
    
    
    @Autowired
    public MotherCaseProcessor(ICareService careService,
            MapperService mapperService, EventRelay eventRelay) {
        this.careService = careService;
        this.mapperService = mapperService;
        this.eventRelay = eventRelay;
        
    }

    public void process(CaseEvent caseEvent) {
        CaseType caseType = CaseType.getType(caseEvent.getCaseType());
        InfoParser infoParser = mapperService.getCaseInfoParser(caseType, null);
        Map<String, String> keyConversionMap = new HashMap<String, String>() {
            {
                put("add", "actualDeliveryDate");
            }

        };
        infoParser.setKeyConversionMap(keyConversionMap);
        Map<String, String> caseMap = new CaseInfoParser(infoParser)
                .parse(caseEvent);

        applyPostProcessors(MOTHER_CASE_POSTPROCESSOR, caseMap);

        String caseId = caseMap.get("caseId");
        logger.info(String.format(
                "Started processing mother case with case ID %s", caseId));
        
        MotherCase mother = careService.saveByExternalPrimaryKey(MotherCase.class, caseMap);
        logger.debug("Saved/Updated mother case");
        Map<String, Object> map = new HashMap<String, Object>();	
	    map.put(Constants.MOTHER_CASE_ID_PARAM, mother.getCaseId());
	    MotechEvent e = new MotechEvent(Constants.MOTHER_CREATE_UPDATE_EVENT,
	                map);
	    logger.debug("Sending Event "+e.toString());
	    eventRelay.sendEventMessage(e);
	    logger.debug("Event sent "+e.toString());
			
    
        
       
        logger.info(String.format(
                "Finished processing mother case with case ID %s", caseId));
    }
        
        
}