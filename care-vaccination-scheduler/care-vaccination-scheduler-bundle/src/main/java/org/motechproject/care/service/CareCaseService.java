package org.motechproject.care.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.motechproject.care.request.CareCase;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.service.mapper.ChildMapper;
import org.motechproject.care.service.mapper.MotherMapper;
import org.motechproject.casexml.service.CaseService;
import org.motechproject.casexml.service.exception.CaseException;
import org.motechproject.commons.date.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.motechproject.care.init.ScheduleInitializer;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
@Controller
@RequestMapping("/care/**")
public class CareCaseService extends CaseService<CareCase> {

    private MotherService motherService;
    private ChildService childService;
    Logger logger = Logger.getLogger(CareCaseService.class);
    @Autowired
    ScheduleInitializer scheduleInitializer;
    @Autowired
    public CareCaseService(MotherService motherService, ChildService childService) {
        super(CareCase.class);
        this.motherService = motherService;
        this.childService = childService;
    }

    @Override
    public void createCase(CareCase careCase) throws CaseException {
        validateCreateCase(careCase);
        String caseType = careCase.getCase_type();
        if(CaseType.Mother.getType().equals(caseType)) {
            Flw flw = motherService.getFlw(careCase.getUser_id());
            FlwGroup flwGroup = motherService.getFlwGroup(careCase.getOwner_id());
            motherService.process(MotherMapper.map(careCase,flw,flwGroup));
        }
        else if(CaseType.Child.getType().equals(caseType)) {
            Flw flw = childService.getFlw(careCase.getUser_id());
            FlwGroup flwGroup = childService.getFlwGroup(careCase.getOwner_id());
            MotherCase mother = childService.getMother(careCase.getMother_id());
            childService.process(ChildMapper.map(careCase,flw,flwGroup,mother));
        }
        else 
            logger.info(String.format("Ignoring Case with type: %s", caseType));
    }

    @Override
    public void updateCase(CareCase careCase)  throws CaseException{
    }

    @Override
    public void closeCase(CareCase careCase) throws CaseException{
        validateCloseCase(careCase);
        boolean wasMotherClosed = motherService.closeCase(careCase.getCase_id());
        if(!wasMotherClosed)
            childService.closeCase(careCase.getCase_id());
    }
    
    //TODO remove this function. just needed to populate schedules
    
    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void addSchedule() throws URISyntaxException, IOException {
        scheduleInitializer.addSchedules();
    }

    private void validateCreateCase(CareCase careCase) throws CaseException {
        validateMandatory(careCase.getCase_id(), "Case Id");
        validateMandatory(careCase.getOwner_id(), "Owner Id");
    }

    private void validateCloseCase(CareCase careCase) throws CaseException {
        validateMandatory(careCase.getCase_id(), "Case Id");
    }

    private void validateMandatory(String fieldValue, String fieldName) throws CaseException {
        if(StringUtil.isNullOrEmpty(fieldValue)) {
            throw new CaseException(fieldName + " is a mandatory field.", HttpStatus.BAD_REQUEST);
        }
    }
}
