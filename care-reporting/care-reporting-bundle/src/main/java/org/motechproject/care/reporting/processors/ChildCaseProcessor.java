package org.motechproject.care.reporting.processors;

import static org.motechproject.care.reporting.parser.PostProcessor.Utils.applyPostProcessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.motechproject.care.reporting.enums.CaseType;
import org.motechproject.care.reporting.parser.CaseInfoParser;
import org.motechproject.care.reporting.parser.InfoParser;
import org.motechproject.care.reporting.parser.PostProcessor;
import org.motechproject.care.reporting.service.MapperService;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildCaseProcessor {
    private static final Logger logger = LoggerFactory.getLogger("commcare-reporting-mapper");
    private static List<PostProcessor> CHILD_CASE_POSTPROCESSOR = new ArrayList<PostProcessor>() {{
        add(PostProcessor.CASE_COPY_USER_ID_AS_FLW);
        add(PostProcessor.COPY_OWNER_ID_AS_FLW_GROUP);
        add(PostProcessor.COPY_MOTHER_ID_AS_MOTHER_CASE);
    }};

    private ICareService careService;
    private MapperService mapperService;

    @Autowired
    public ChildCaseProcessor(ICareService careService, MapperService mapperService) {
        this.careService = careService;
        this.mapperService = mapperService;
    }

    public void process(CaseEvent caseEvent) {
        CaseType caseType = CaseType.getType(caseEvent.getCaseType());
        InfoParser infoParser = mapperService.getCaseInfoParser(caseType, null);
        Map<String, String> caseMap = new CaseInfoParser(infoParser).parse(caseEvent);

        applyPostProcessors(CHILD_CASE_POSTPROCESSOR, caseMap);

        String caseId = caseMap.get("caseId");

        logger.info(String.format("Started processing child case with case ID %s", caseId));
        careService.saveByExternalPrimaryKey(ChildCase.class, caseMap);
        logger.info(String.format("Finished processing child case with case ID %s", caseId));
    }
}
