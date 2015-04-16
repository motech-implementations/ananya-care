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
import org.motechproject.scheduletracking.domain.Schedule;
import org.motechproject.scheduletracking.domain.ScheduleFactory;
import org.motechproject.scheduletracking.domain.json.ScheduleRecord;
import org.motechproject.scheduletracking.repository.dataservices.ScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleInitializer {

    private static final ScheduleFactory SCHEDULE_FACTORY = new ScheduleFactory();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ScheduleDataService scheduleDataService;

    public void addSchedules() throws URISyntaxException, IOException, InterruptedException {
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
        vaccinationList.add("child-measles-booster.json");
        for (String vaccinationName : vaccinationList) {
            String homePath = System.getProperty("user.home");
            File file = new File(homePath + "/schedules/" + vaccinationName);
            Schedule schedule = parseScheduleJson(file);
            scheduleDataService.update(schedule);
            Thread.sleep(2000);
        }
    }

    private static Schedule parseScheduleJson(File jsonFile) throws IOException {
        ScheduleRecord scheduleRecord = objectMapper.readValue(jsonFile,
                ScheduleRecord.class);

        return SCHEDULE_FACTORY.build(scheduleRecord);
    }
}
