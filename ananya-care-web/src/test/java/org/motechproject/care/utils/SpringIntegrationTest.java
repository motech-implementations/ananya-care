package org.motechproject.care.utils;

import org.ektorp.BulkDeleteDocument;
import org.ektorp.CouchDbConnector;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.motechproject.scheduletracking.api.service.ScheduleTrackingService;
import org.motechproject.testing.utils.BaseUnitTest;
import org.quartz.utils.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-Web.xml")
public abstract class SpringIntegrationTest extends BaseUnitTest {

    @Qualifier("ananyaCareDbConnector")
    @Autowired
    protected CouchDbConnector ananyaCareDbConnector;

    @Qualifier("ananyaCareProperties")
    @Autowired
    protected Properties ananyaCareProperties;

    @Autowired
    protected ScheduleTrackingService trackingService;

    protected ArrayList<BulkDeleteDocument> toDelete;
    protected ArrayList<Pair> schedulesToDelete;

    @Before
    public void before() {
        toDelete = new ArrayList<BulkDeleteDocument>();
        schedulesToDelete = new ArrayList<Pair>();
    }

    @After
    public void after() {
        ananyaCareDbConnector.executeBulk(toDelete);
        for(int i=0 ;i< schedulesToDelete.size(); i++){
            Pair s = schedulesToDelete.get(i);
            String externalId = s.getFirst().toString();
            String scheduleName = s.getSecond().toString();
            ArrayList<String> scheduleNames = new ArrayList<String>();
            scheduleNames.add(scheduleName);
            trackingService.unenroll(externalId, scheduleNames);
        }
        super.tearDown();
    }


    protected void markForDeletion(Object document) {
        toDelete.add(BulkDeleteDocument.of(document));
    }

    protected void markScheduleForUnEnrollment(String externalId, String scheduleName) {
        schedulesToDelete.add(new Pair(externalId, scheduleName));
    }

    protected String getAppServerPort() {
        return ananyaCareProperties.getProperty("app.server.port");
    }

    protected String getAppServerHostUrl() {
        return "http://localhost:" + getAppServerPort();
    }
}