package org.motechproject.care.init;

import org.codehaus.jackson.map.ObjectMapper;
import org.motechproject.commons.couchdb.service.CouchDbManager;
import org.motechproject.commons.couchdb.service.DbConnectionException;
import org.motechproject.commons.couchdb.service.impl.CouchDbManagerImpl;
import org.motechproject.scheduletracking.api.domain.Schedule;
import org.motechproject.scheduletracking.api.domain.ScheduleFactory;
import org.motechproject.scheduletracking.api.domain.json.ScheduleRecord;
import org.motechproject.scheduletracking.api.repository.AllSchedules;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ScheduleInitializer {

    private static final ScheduleFactory SCHEDULE_FACTORY = new ScheduleFactory();
    private static final String DATABASE_NAME = "motech-scheduletracking-api";

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws URISyntaxException, IOException, NullPointerException,
            DbConnectionException {
        CouchDbManager couchDbManager = new CouchDbManagerImpl();
        AllSchedules allSchedules = new AllSchedules(couchDbManager.getConnector(DATABASE_NAME));
        URL schedulesDirectoryUrl = ScheduleInitializer.class.getResource("../../../../schedules");
        File schedulesDirectory = new File(schedulesDirectoryUrl.toURI());
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".json"));
            }
        };

        for (File file : schedulesDirectory.listFiles(filenameFilter)) {
            Schedule schedule = parseScheduleJson(file);
            allSchedules.addOrUpdate(schedule);
        }
    }

    private static Schedule parseScheduleJson(File jsonFile) throws IOException {
        ScheduleRecord scheduleRecord = objectMapper.readValue(jsonFile, ScheduleRecord.class);

        return SCHEDULE_FACTORY.build(scheduleRecord);
    }
}
