package org.motechproject.care.init;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
//import org.motechproject.commons.couchdb.service.impl.CouchDbManagerImpl;
import org.motechproject.scheduletracking.domain.Schedule;
import org.motechproject.scheduletracking.domain.ScheduleFactory;
import org.motechproject.scheduletracking.domain.json.ScheduleRecord;
import org.motechproject.scheduletracking.repository.dataservices.ScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleInitializer {

    private static final ScheduleFactory SCHEDULE_FACTORY = new ScheduleFactory();
    private static final String DATABASE_NAME = "motech-scheduletracking-api";

    private static ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    ScheduleDataService scheduleDataService;
    public static void main(String[] args) throws URISyntaxException, IOException, NullPointerException
         {
    	
       // CouchDbManager couchDbManager = new CouchDbManagerImpl();
       // TODO change to MDS
        //AllSchedules allSchedules = new AllSchedules(couchDbManager.getConnector(DATABASE_NAME));
        URL schedulesDirectoryUrl = ScheduleInitializer.class.getResource("/schedules");
        File schedulesDirectory = new File(schedulesDirectoryUrl.toURI());
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".json"));
            }
        };
         MdsRepository repo = new MdsRepository();
        for (File file : schedulesDirectory.listFiles(filenameFilter)) {
            Schedule schedule = parseScheduleJson(file);
           repo.save(schedule);
            //TODO MDS
            //allSchedules.addOrUpdate(schedule);
        }
    }
    
    public void addSchedules() throws URISyntaxException, IOException {
      //  URL schedulesDirectoryUrl = ScheduleInitializer.class.getResource("/schedules/");
        //URL schedulesDirectoryUrl = Thread.currentThread().getContextClassLoader()
         //       .getResource("/schedules");
        //String schedulePath = "schedules";
        //try (URL is = Thread.currentThread().getContextClassLoader()
             //   .getResource(schedulePath)) {}
        
        
        //File schedulesDirectory = new File(schedulesDirectoryUrl.toURI());
        //FilenameFilter filenameFilter = new FilenameFilter() {
        //    @Override
         //   public boolean accept(File dir, String name) {
         //       return (name.endsWith(".json"));
          //  }
        //};
        List<String> vaccinationList = new ArrayList<String>();
        vaccinationList.add("mother-tt.json");
        vaccinationList.add("mother-tt-booster.json");
        vaccinationList.add("mother-care.json");
        vaccinationList.add("mother-anc4.json");
        vaccinationList.add("mother-anc.json");
        vaccinationList.add("child-vita.json");
        vaccinationList.add("child-opvbooster.json");
        vaccinationList.add("child-opv0.json");
        vaccinationList.add("child-opv.json");
        vaccinationList.add("child-measles.json");
        vaccinationList.add("child-hep0.json");
        vaccinationList.add("child-hep.json");
        vaccinationList.add("child-dptbooster.json");
        vaccinationList.add("child-dpt.json");
        vaccinationList.add("child-care.json");
        vaccinationList.add("child-bcg.json");
        for(String vaccinationName : vaccinationList) {
            String homePath = System.getProperty("user.home");
        File file = new File(homePath+"/schedules/"+vaccinationName);
         //MdsRepository repo = new MdsRepository();
      //  for (File file : schedulesDirectory.listFiles(filenameFilter)) {
            Schedule schedule = parseScheduleJson(file);
            scheduleDataService.update(schedule);
           //repo.save(schedule);
            //TODO MDS
            //allSchedules.addOrUpdate(schedule);
       }
    }

    private static Schedule parseScheduleJson(File jsonFile) throws IOException {
        ScheduleRecord scheduleRecord = objectMapper.readValue(jsonFile, ScheduleRecord.class);

        return SCHEDULE_FACTORY.build(scheduleRecord);
    }
}
