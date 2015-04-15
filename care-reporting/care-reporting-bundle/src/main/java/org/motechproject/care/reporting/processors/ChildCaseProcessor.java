package org.motechproject.care.reporting.processors;

import static org.motechproject.care.reporting.parser.PostProcessor.Utils.applyPostProcessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.motechproject.care.reporting.enums.CaseType;
import org.motechproject.care.reporting.parser.CaseInfoParser;
import org.motechproject.care.reporting.parser.InfoParser;
import org.motechproject.care.reporting.parser.PostProcessor;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.care.reporting.service.MapperService;
import org.motechproject.care.reporting.utils.Constants;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildCaseProcessor {
	private static final Logger logger = LoggerFactory
			.getLogger("commcare-reporting-mapper");
	private static List<PostProcessor> CHILD_CASE_POSTPROCESSOR = new ArrayList<PostProcessor>() {
		{
			add(PostProcessor.CASE_COPY_USER_ID_AS_FLW);
			add(PostProcessor.COPY_OWNER_ID_AS_FLW_GROUP);
			add(PostProcessor.COPY_MOTHER_ID_AS_MOTHER_CASE);
			add(PostProcessor.COPY_SERVER_DATE_MODIFIED_AS_SERVER_DATE_TIME_MODIFIED);
		}
	};

	private ICareService careService;
	private MapperService mapperService;
	private EventRelay eventRelay;
	
	
	@Autowired
	public ChildCaseProcessor(ICareService careService,
			MapperService mapperService, EventRelay eventRelay) {
		this.careService = careService;
		this.mapperService = mapperService;
		this.eventRelay = eventRelay;
	}

	public void process(CaseEvent caseEvent) {
		logger.info("Server Modified On" +caseEvent.getServerModifiedOn());
		CaseType caseType = CaseType.getType(caseEvent.getCaseType());
		InfoParser infoParser = mapperService.getCaseInfoParser(caseType, null);
		Map<String, String> caseMap = new CaseInfoParser(infoParser)
				.parse(caseEvent);

		applyPostProcessors(CHILD_CASE_POSTPROCESSOR, caseMap);
		logger.info("Server Modified Date "+caseMap.get("serverDateTimeModified"));

		String caseId = caseMap.get("caseId");
		logger.info(String.format(
				"Started processing child case with case ID %s", caseId));
		ChildCase child = careService.saveByExternalPrimaryKey(ChildCase.class,
					caseMap);

		Map<String, Object> map = new HashMap<String, Object>();
	    map.put(Constants.CHILD_CASE_ID_PARAM, child.getCaseId());
		MotechEvent e = new MotechEvent(Constants.CHILD_CREATE_UPDATE_EVENT,
					map);
		logger.debug("Sending Event "+e.toString());
	    eventRelay.sendEventMessage(e);
	    logger.debug("Event sent "+e.toString());
		logger.info(String.format(
				"Finished processing child case with case ID %s", caseId));
	}
}
