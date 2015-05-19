package org.motechproject.care.missing.migration.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.motechproject.care.schedule.vaccinations.ChildVaccinationSchedule;
import org.motechproject.care.schedule.vaccinations.MotherVaccinationSchedule;
import org.motechproject.care.service.schedule.Anc4Service;
import org.motechproject.care.service.schedule.AncService;
import org.motechproject.care.service.schedule.BcgService;
import org.motechproject.care.service.schedule.ChildCareService;
import org.motechproject.care.service.schedule.DptBoosterService;
import org.motechproject.care.service.schedule.DptService;
import org.motechproject.care.service.schedule.Hep0Service;
import org.motechproject.care.service.schedule.HepService;
import org.motechproject.care.service.schedule.MeaslesBoosterService;
import org.motechproject.care.service.schedule.MeaslesService;
import org.motechproject.care.service.schedule.MotherCareService;
import org.motechproject.care.service.schedule.Opv0Service;
import org.motechproject.care.service.schedule.OpvBoosterService;
import org.motechproject.care.service.schedule.OpvService;
import org.motechproject.care.service.schedule.TTBoosterService;
import org.motechproject.care.service.schedule.TTService;
import org.motechproject.care.service.schedule.VitaService;
import org.motechproject.care.service.util.CommcareTask;
import org.motechproject.casexml.gateway.CommcareCaseGateway;
import org.motechproject.commons.api.Range;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.domain.CareCaseTask;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.mds.query.EqualProperty;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.PropertyBuilder;
import org.motechproject.mds.query.RangeProperty;
import org.motechproject.scheduletracking.domain.Enrollment;
import org.motechproject.scheduletracking.repository.dataservices.EnrollmentDataService;
import org.motechproject.scheduletracking.service.EnrollmentAlertServiceToExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissingMigrationService {
	 
	private static final Logger LOGGER = Logger.getLogger(MissingMigrationService.class);
	
	private static final String FILE_LOCATION_CLOSE_TASK = "/home/naveen/skype_downloads/cases_final_tobeclosed_cchq_may6.txt";
	
	private static final String FILE_LOCATION_SUBMIT_TASK = "/home/naveen/skype_downloads/missing_tasks_commcarehq.txt";
	
	private static final String FILE_LOCATIONS_MISSING_TASKS = "/home/naveen/skype_downloads/missing_tasks_motech.txt";
	
	private static final String COMMCARE_HQ_URL = "https://india.commcarehq.org/a/care-bihar/receiver/";
	
	private static final String COMMCARE_USERNAME = "motech_care@thoughtworks.com";
	
    private static final String COMMCARE_PASSWORD = "parkingProcess0z.24";
   
	private static final int SECOND = 1000;
	 
	private static final int MINUTE = 60 * SECOND;
	
	private static final int HOUR = 60 * MINUTE;
	 
	private static final int DAY = 24 * HOUR;
    
    @Autowired
    MdsRepository dbRepository; 
    
    @Autowired
    TTService ttService;
    
    @Autowired
    TTBoosterService ttBoosterService;
    
    @Autowired
    AncService ancService;
    
    @Autowired
    Anc4Service anc4Service;
    
    @Autowired 
    MotherCareService motherCareService;
    
    @Autowired 
    MeaslesService measlesService;
    
    @Autowired
    MeaslesBoosterService measlesBoosterService;
    
    @Autowired
    BcgService bcgService;
    
    @Autowired
    VitaService vitaService;
    
    @Autowired
    Hep0Service hep0Service;
    
    @Autowired
    HepService hepService;
    
    @Autowired
    DptService dptService;
    
    @Autowired
    DptBoosterService dptBoosterService;
    
    @Autowired
    Opv0Service opv0Service;
    
    @Autowired
    OpvService opvService;
    
    @Autowired
    OpvBoosterService opvBoosterService;
    
    @Autowired
    ChildCareService childCareService;
    
    @Autowired
    private EnrollmentAlertServiceToExport enrollmentAlertServiceToExportOSGi;
    
    @Autowired
    private EnrollmentDataService EnrollmentServiceOSGi;
    
    @Autowired
    private CommcareCaseGateway commcareCaseGateway;
   
    
    
    private int vaccinationCountMother;
    
    private int vaccinationCountChild;
    

   
    
    public MissingMigrationService() {

	}
    
    
    public void enrollAllMissingMotherVaccines() throws ParseException{
    	processMothers();
    }
    
    
    
    public void enrollAllMissingChildVaccines() throws ParseException {
    	processChilds();
    }
    
    
    private void enrollUpdateMotherVaccine(MotherCase mother) {//, String schedules) {
    			LOGGER.info("Enrolling mother with case id in "+ MotherVaccinationSchedule.TT);
    			ttService.process(mother);
    			vaccinationCountMother++;
    		
    			LOGGER.info("Enrolling mother with case id in "+ MotherVaccinationSchedule.TTBooster);
    			ttBoosterService.process(mother);
    			vaccinationCountMother++;
    		
    			LOGGER.info("Enrolling mother with case id in "+ MotherVaccinationSchedule.Anc);
    			ancService.process(mother);
    			vaccinationCountMother++;
    		
    			LOGGER.info("Enrolling mother with case id in "+ MotherVaccinationSchedule.Anc4);
    			anc4Service.process(mother);
    			vaccinationCountMother++;
    		
    			LOGGER.info("Enrolling mother with case id in Mother Care");
    			motherCareService.process(mother);
    			vaccinationCountMother++;
    		
    }
 
    
    private void enrollUpdateChildVaccine(ChildCase child){ 
    	
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.Measles);
    			measlesService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.MeaslesBooster);
    			measlesBoosterService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.Bcg);
    			bcgService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.Vita);
    			vitaService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.Hepatitis0);
    			hep0Service.process(child);
    			vaccinationCountChild++;
    	
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.Hepatitis);
    			hepService.process(child);
    			vaccinationCountChild++;
    		 
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.DPT);
    			dptService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.DPTBooster);
    			dptBoosterService.process(child);
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.OPV0);
    			opv0Service.process(child);
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.OPV);
    			opvService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in "+ ChildVaccinationSchedule.OPVBooster);
    			opvBoosterService.process(child);
    			vaccinationCountChild++;
    		
    			LOGGER.info("Enrolling child with case id in Child Care");
    			childCareService.process(child);
    			vaccinationCountChild++;
    		
    }
 
	

    
    
    private void processMothers() throws ParseException {
    	
    	long starttime = System.currentTimeMillis();
    	
    	List<MotherCase> motherCases = getMotherCases();
    	LOGGER.info("Total Number of Mothers fetched are :"+motherCases.size());
        
         int motherCount = 1;
         vaccinationCountMother=1;
        
         
         for (MotherCase motherCase : motherCases) {
        	 
        	 LOGGER.info("Started Processing **** Mother "+motherCount+" :" +motherCase.getCaseId());
        	 try {
        	 
        	 LOGGER.info("Processing case name"+ motherCase.getCaseName());
        	  enrollUpdateMotherVaccine(motherCase);
        	 }  catch (Exception e) {
        		 LOGGER.info("Failed Processing mother"+e.getMessage());
        	 }
        	 LOGGER.info("Processed child vaccinations.......");
        	 motherCount++;

         }
         LOGGER.info("Total Vaccinations processed for mother "+vaccinationCountMother);
         long endtime = System.currentTimeMillis();
     	long diff = endtime -starttime;		
     	LOGGER.info("Total time for exection of all mother vaccinations  "+convertMilliSeconds(diff));		
    	
    	
    }
    
    public void processChilds() throws ParseException {
    	
    	long starttime = System.currentTimeMillis();
    	
        List<ChildCase> childCases  = getChildCases();
    	LOGGER.info("Total Number of Childs are :"+childCases.size());
    	
    	
    	int childCount = 1;
        vaccinationCountChild=1;
       
        
        for (ChildCase childCase : childCases) {
       	 
       	 LOGGER.info("Started Processing **** Child "+childCount+" :" +childCase.getCaseId());
       	 try {
       	 
       	 LOGGER.info("Processing case name"+ childCase.getCaseName());
       	  enrollUpdateChildVaccine(childCase);
       	 }  catch (Exception e) {
       		 LOGGER.info("Failed Processing child"+e.getMessage());
       	 }
       	 LOGGER.info("Processed child vaccinations.......");
       	 childCount++;

        }
        LOGGER.info("Total Vaccinations processed for child "+vaccinationCountChild);
   	
    	long endtime = System.currentTimeMillis();
    	long diff = endtime -starttime;		
    	LOGGER.info("Total time for exection of all child vaccinations  "+convertMilliSeconds(diff));		
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<MotherCase> getMotherCases() throws ParseException {
        Date start = format("10/04/2015");
        Date end = format("31/12/2020");
        Date nullDate = null;
    	EqualProperty<Date> add = (EqualProperty<Date>) PropertyBuilder.create("actualDeliveryDate", nullDate, Date.class.getName());
    	RangeProperty<Date> rangeProperty = (RangeProperty<Date>) PropertyBuilder.create("edd",new Range<Date>(start,end),Date.class.getName());
    	EqualProperty<String> status = (EqualProperty<String>) PropertyBuilder.create("status", "active", String.class);
    	
    
    	List<Property> properties = new ArrayList<Property>();
    	properties.add(add);
    	properties.add(rangeProperty);
    	properties.add(status);
		return dbRepository.executeJDO(MotherCase.class, properties);
    }
    
    private Date format(String source) throws ParseException {
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	return format.parse(source);
    	
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<ChildCase> getChildCases() throws ParseException {
    	Date now = new Date();
        Date start = format("08/04/2013");

    	RangeProperty<Date> rangeProperty = (RangeProperty<Date>) PropertyBuilder.create("dob",new Range<Date>(test,test),Date.class.getName());
    	EqualProperty<Boolean> closed = (EqualProperty<Boolean>) PropertyBuilder.create("closed", Boolean.FALSE, Boolean.class);
    	List<Property> properties = new ArrayList<Property>();
    	properties.add(rangeProperty);
    	properties.add(closed);
		return dbRepository.executeJDO(ChildCase.class, properties);
    }
    
     
    
  
    

    public void scheduleEnrollment() throws IOException {
    	long starttime = System.currentTimeMillis();
    	List<Enrollment> enrollments = getAllEnrollments();
    	for (Enrollment enrollment : enrollments) {
    		LOGGER.info("Sending alert  for Enrollment : "+enrollment.getCurrentMilestoneName());
    		enrollmentAlertServiceToExportOSGi.scheduleAlertsForCurrentMilestone(enrollment);
			LOGGER.info("Sent alert  for Enrollment : "+enrollment.getCurrentMilestoneName());
		}
    	long endtime = System.currentTimeMillis();
    	long diff = endtime -starttime;		
    	LOGGER.info("Total time for execution of all alerts for enrollments "+convertMilliSeconds(diff));		
    }
    
    
    private List<Enrollment> getAllEnrollments() throws IOException {
    	
         List<Enrollment> enrollments = new ArrayList<Enrollment>();
         List<Long> AllMissingTasks = readAllEnrollmentId(FILE_LOCATIONS_MISSING_TASKS);
         for (Long primaryId : AllMissingTasks) {
        	  LOGGER.info("Fetching Enrollment for unique key : "+primaryId);
        	  Enrollment enrollment = EnrollmentServiceOSGi.findById(primaryId);
        	  Enrollment enrollmentFinal = EnrollmentServiceOSGi.findByExternalIdScheduleNameAndStatus(enrollment.getExternalId(), enrollment.getScheduleName(), enrollment.getStatus());
        	  LOGGER.info("Fetched Enrollment with current milestone : "+enrollmentFinal.getCurrentMilestoneName());
        	 enrollments.add(enrollmentFinal);
		}
    	return enrollments;    
    }

    
    
  public void submitAllCases() throws IOException {
	    long starttime = System.currentTimeMillis();
    	List<String> careCaseTasks = readAllCareCaseId(FILE_LOCATION_SUBMIT_TASK);
    	  int counter = 1;
    	  for (String caseId : careCaseTasks) {
    		  LOGGER.info(counter+". Sending missed vaccination Care Case Task with id"+caseId);
    			  postSubmitToCommCare(caseId);
    			  counter++;
    		  }
    	   LOGGER.info("Total missed vaccination posted :"+counter);
    	   long endtime = System.currentTimeMillis();
       	   long diff = endtime -starttime;		
       	   LOGGER.info("Total time for execution of posting missing tasks to commcarehq  "+convertMilliSeconds(diff));		
    }
    
    public void closeAllCases() throws IOException {
    	long starttime = System.currentTimeMillis();
    	List<String> careCaseTasks = readAllCareCaseId(FILE_LOCATION_CLOSE_TASK);
    	  int counter = 1;
    	  for (String caseId : careCaseTasks) {
    		  LOGGER.info(counter+". Sending close case for Care Case Task with id"+caseId);
    			  postCloseToCommCare(caseId);
    			  counter++;
    		  }
    	   LOGGER.info("Total case closed :"+counter);
    	   long endtime = System.currentTimeMillis();
       	   long diff = endtime -starttime;		
           LOGGER.info("Total time for execution of a sending all close tasks to commcarehq "+convertMilliSeconds(diff));		
    }
    
    protected void postCloseToCommCare(String careCaseTaskId) {
    	
        String commcareUrl = COMMCARE_HQ_URL;
        String commcareUsername = COMMCARE_USERNAME;
        String commcarePassword = COMMCARE_PASSWORD;

        CareCaseTask careCaseTask = dbRepository.get(CareCaseTask.class, "caseId", careCaseTaskId);

        LOGGER.info(String
                .format("Notifying commcare to close task with -- TaskId: %s ",
                        careCaseTask.getCaseId()));
       commcareCaseGateway.closeCase(commcareUrl, CommcareTask.toCaseTask(careCaseTask), commcareUsername,commcarePassword, null);
       
    }
    
    
  protected void postSubmitToCommCare(String careCaseTaskId) {
    	
        String commcareUrl = COMMCARE_HQ_URL;
        String commcareUsername = COMMCARE_USERNAME;
        String commcarePassword = COMMCARE_PASSWORD;

        CareCaseTask careCaseTask = dbRepository.get(CareCaseTask.class, "caseId", careCaseTaskId);

        LOGGER.info(String
                .format("Notifying commcare to vaccination task with -- TaskId: %s ",
                        careCaseTask.getCaseId()));
       commcareCaseGateway.submitCase(commcareUrl, CommcareTask.toCaseTask(careCaseTask), commcareUsername,commcarePassword, null);
       
    }
  
    
    private List<String> readAllCareCaseId(String fileLocation) throws IOException {
    	List<String> careCaseTasks = new ArrayList<String>();
    	LOGGER.info("Loading Resource....");    	
    	@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
    	      String CareCaseTaskId;
    	      int counter =1;
    	      while ((CareCaseTaskId = bufferedReader.readLine()) != null) {
			     LOGGER.info(counter+". Fetched Care Case Task Id : "+CareCaseTaskId);
				careCaseTasks.add(CareCaseTaskId);
				counter++;
			}
    	return careCaseTasks;
    }
    
    
    private List<Long> readAllEnrollmentId(String fileLocation) throws IOException {
    	List<Long> enrollments = new ArrayList<Long>();
    	LOGGER.info("Loading Resource....");    	
    	@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
    	      String enrollmentId;
    	      int counter =1;
    	      while ((enrollmentId = bufferedReader.readLine()) != null) {
			     LOGGER.info(counter+". Fetched Enrollment Id : "+enrollmentId);
				enrollments.add(Long.valueOf(enrollmentId));
				counter++;
			}
    	return enrollments;
    }
    
    

    
    private String convertMilliSeconds(long time) {

		 StringBuffer text = new StringBuffer("");
		 if (time > DAY) {
		   text.append(time / DAY).append(" days ");
		   time %= DAY;
		 }
		 if (time > HOUR) {
		   text.append(time / HOUR).append(" hours ");
		   time %= HOUR;
		 }
		 if (time > MINUTE) {
		   text.append(time / MINUTE).append(" minutes ");
		   time %= MINUTE;
		 }
		 if (time > SECOND) {
		   text.append(time / SECOND).append(" seconds ");
		   time %= SECOND;
		 }
		 text.append(time + " ms");
		 
		 return text.toString();
	 }

}
