package org.motechproject.care.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.motechproject.care.init.ScheduleInitializer;
import org.motechproject.care.service.router.AlertRouter;
import org.motechproject.event.MotechEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
@RequestMapping("/care/**")
public class CareCaseService  {
	
	private AlertRouter alertRouter;

    Logger logger = Logger.getLogger(CareCaseService.class);
    @Autowired
    ScheduleInitializer scheduleInitializer;
    public CareCaseService() {
      //  super(CareCase.class);
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String ping() {
        return "Ping Received Succefully with query param";
    }

//    @Override
//    public void createCase(CareCase careCase) throws CaseException {
//        validateCreateCase(careCase);
//        String caseType = careCase.getCase_type();
//        if(CaseType.Mother.getType().equals(caseType)) {
//           Flw flw = motherService.getFlw(careCase.getUser_id());
//            FlwGroup flwGroup = motherService.getFlwGroup(careCase.getOwner_id());
//            motherService.process(MotherMapper.map(careCase,flw,flwGroup));
//        }
//        else if(CaseType.Child.getType().equals(caseType)) {
//            Flw flw = childService.getFlw(careCase.getUser_id());
//            FlwGroup flwGroup = childService.getFlwGroup(careCase.getOwner_id());
//            MotherCase mother = childService.getMother(careCase.getMother_id());
//            childService.process(ChildMapper.map(careCase,flw,flwGroup,mother));
//        }
//        else 
//            logger.info(String.format("Ignoring Case with type: %s", caseType));
//    }

//    @Override
//    public void updateCase(CareCase careCase)  throws CaseException{
//    }

   
    
    //TODO remove this function. just needed to populate schedules
    
    @RequestMapping(value = "/addschedule", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void addSchedule() throws URISyntaxException, IOException {
        scheduleInitializer.addSchedules();
    }
    
    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void addTask(@RequestBody MotechEvent motechEvent) {
        
    	alertRouter.handle(motechEvent);
    	
    }

//    protected void validateCreateCase(CareCase careCase) throws CaseException {
//        validateMandatory(careCase.getCase_id(), "Case Id");
//        validateMandatory(careCase.getOwner_id(), "Owner Id");
//    }

//    protected void validateCloseCase(CareCase careCase) throws CaseException {
//        validateMandatory(careCase.getCase_id(), "Case Id");
//    }

   
}
