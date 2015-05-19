package org.motechproject.care.service.router.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.domain.Window;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.mds.query.EqualProperty;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.PropertyBuilder;
import org.motechproject.scheduletracking.domain.MilestoneAlert;
import org.motechproject.scheduletracking.events.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AlertClientAction {
    private CommcareCaseGateway commcareCaseGateway;
    private Properties ananyaCareProperties;
    Logger logger = Logger.getLogger(AlertClientAction.class);

    public AlertClientAction(CommcareCaseGateway commcareCaseGateway,
            Properties ananyaCareProperties) {
        this.commcareCaseGateway = commcareCaseGateway;
        this.ananyaCareProperties = ananyaCareProperties;
    }

    @Autowired
    MdsRepository dbRepository;

    public void invoke(MilestoneEvent event) {
        String externalId = event.getExternalId();
        MilestoneAlert milestoneAlert = event.getMilestoneAlert();
        String milestoneName = milestoneAlert.getMilestoneName();

        process(new Window(milestoneAlert.getDueDateTime(),
                milestoneAlert.getLateDateTime()), externalId, milestoneName);
    }

    public abstract void process(Window alertWindow, String externalId,
            String milestoneName);

    protected void postToCommCare(Window alertWindow, String externalId,
            String milestoneName, Client client) {
        String commcareUrl = ananyaCareProperties
                .getProperty("commcare.hq.url");
        String commcareUsername = ananyaCareProperties
                .getProperty("commcare.hq.username");
        String commcarePassword = ananyaCareProperties
                .getProperty("commcare.hq.password");

        CareCaseTask careCaseTask = createCaseTask(alertWindow, externalId,
                milestoneName, client);
       
        logger.info(String
                .format("Notifying commcare -- TaskId: %s, ExternalId: %s, EligibleDate: %s, ExpiryDate: %s ",
                        careCaseTask.getTaskId(),
                        careCaseTask.getMotherCase() == null ? careCaseTask
                                .getChildCase().getCaseId() : careCaseTask
                                .getMotherCase().getCaseId(), careCaseTask
                                .getDateEligible(), careCaseTask
                                .getDateExpires()));
       if(verifyExistingVaccinationTask(careCaseTask)== false) {
    	   commcareCaseGateway.submitCase(commcareUrl,
                CommcareTask.toCaseTask(careCaseTask), commcareUsername,
                commcarePassword, null);
    	   logger.info("Saving CareCaseTasK "+careCaseTask.getCaseId());
    	   safeSave(careCaseTask);
    	   logger.info("Saved CareCaseTasK "+careCaseTask.getCaseId());
       }else {
		   logger.info("CareCaseTask "+careCaseTask.getCaseId()+" is already sent to commcareHQ.");
       }
       
    }
    
    
    private boolean verifyExistingVaccinationTask(CareCaseTask careCaseTask) {
    	boolean flag = false;
    	List<CareCaseTask> list = findVaccinationTask(careCaseTask);
    	
    	if (list != null && list.size() > 0) {
    		logger.info("No of CareCaseTask in system with same attribute "+ list.size());
     	   	flag = true;
        }
    	return flag;
    }
    
    
    @SuppressWarnings("unchecked")
	private List<CareCaseTask> findVaccinationTask(CareCaseTask careCaseTask) {
    	List<CareCaseTask> tasks = null;
    	
    	EqualProperty<String> milestoneProperty = (EqualProperty<String>) PropertyBuilder.create("milestoneName", careCaseTask.getMilestoneName(), String.class);

    	MotherCase motherCase = careCaseTask.getMotherCase();
    	
    	ChildCase childCase = careCaseTask.getChildCase();
    	
    	EqualProperty<String> clientCaseIdProperty = null;
    	
    	if(motherCase != null) {
    		
    		clientCaseIdProperty = (EqualProperty<String>) PropertyBuilder.create("motherCase.caseId", motherCase.getCaseId(), String.class);
    	}
    	
    	if(childCase != null) {
    		
    		clientCaseIdProperty = (EqualProperty<String>) PropertyBuilder.create("childCase.caseId", childCase.getCaseId(), String.class); 
    	}
    	if (clientCaseIdProperty != null) {
    		
    		tasks = dbRepository.executeJDO(CareCaseTask.class, configureProperties(milestoneProperty, clientCaseIdProperty));
    	}
    	return tasks;
    }
    
    @SuppressWarnings("rawtypes")
	private List<Property> configureProperties(EqualProperty<String> milestoneProperty,
    		EqualProperty<String> clientCaseIdProperty) {
		List<Property> properties = new ArrayList<Property>();
		properties.add(milestoneProperty);
		properties.add(clientCaseIdProperty);
		return properties;
    }
    
    private void safeSave(CareCaseTask careCaseTask) {
    	
    	if(careCaseTask.getMotherCase()!=null) {
	    		if(careCaseTask.getMotherCase().getFlw() != null) {
	    			Set<FlwGroup> flwGroups =  careCaseTask.getMotherCase().getFlw().getFlwGroups();
	    		    if(flwGroups != null){
	    		    	for (FlwGroup flwGroup : flwGroups) {
	    		    		flwGroup.setFlws(null);
	    		    	}
	    		    }
	    		    careCaseTask.getMotherCase().getFlw().setFlwGroups(flwGroups);
	    		}
    		
	    		if(careCaseTask.getMotherCase().getFlwGroup()!= null) {
	    			Set<Flw> flws = careCaseTask.getMotherCase().getFlwGroup().getFlws();
	    			if(flws != null) {	
	    				for (Flw flw : flws) {
	    					flw.setFlwGroups(null);
	    				}
	    			}
	    			careCaseTask.getMotherCase().getFlwGroup().setFlws(flws);
	    		}
    		
    	}
    	if(careCaseTask.getChildCase()!= null) {
    		
    		if(careCaseTask.getChildCase().getFlw() != null) {
    			Set<FlwGroup> flwGroups =  careCaseTask.getChildCase().getFlw().getFlwGroups();
    			if(flwGroups != null) {
    				for (FlwGroup flwGroup : flwGroups) {
    					flwGroup.setFlws(null);
    				}
    			}
    		 careCaseTask.getChildCase().getFlw().setFlwGroups(flwGroups);
    		}
    		
    		
    		if( careCaseTask.getChildCase().getFlwGroup()!=null) {
    			Set<Flw> flws = careCaseTask.getChildCase().getFlwGroup().getFlws();
    			if(flws != null) {
    				for (Flw flw : flws) {
    					flw.setFlwGroups(null);
    				}
    			}
    			careCaseTask.getChildCase().getFlwGroup().setFlws(flws);
    		}
    	}
    	
        dbRepository.save(careCaseTask);
    }

    private CareCaseTask createCaseTask(Window alertWindow, String externalId,
            String milestoneName, Client client) {
        String motechUserId = ananyaCareProperties
                .getProperty("motech.user.id");
        String currentTime = DateUtil.now().toString();
        String taskId = MilestoneType.forType(milestoneName).getTaskId();
        String caseId = UUID.randomUUID().toString();
        String dateExpires = (alertWindow.getEnd() == null) ? null
                : alertWindow.getEnd().toString("yyyy-MM-dd");
        String flwId;
        MotherCase motherCase = null;
        ChildCase childCase = null;
        if (client.getCaseType().equals(CaseType.Mother.getType())) {
            flwId = ((MotherCase) client).getFlwGroup().getGroupId();
            motherCase = (MotherCase) client;
        } else {
            flwId = ((ChildCase) client).getFlwGroup().getGroupId();
            childCase = (ChildCase) client;
        }
        return new CareCaseTask(milestoneName, flwId, caseId, motechUserId,
                currentTime, taskId, alertWindow.getStart().toString(
                        "yyyy-MM-dd"), dateExpires, client.getCaseType(),
                motherCase, childCase);
    }
}
