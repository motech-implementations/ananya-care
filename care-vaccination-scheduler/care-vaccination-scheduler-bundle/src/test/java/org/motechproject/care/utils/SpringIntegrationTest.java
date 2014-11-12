package org.motechproject.care.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.motechproject.care.service.util.PeriodUtil;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.scheduletracking.domain.EnrollmentStatus;
import org.motechproject.scheduletracking.service.EnrollmentRecord;
import org.motechproject.scheduletracking.service.EnrollmentsQuery;
import org.motechproject.scheduletracking.service.ScheduleTrackingService;

import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
@ContextConfiguration("classpath*:META-INF/motech/applicationAnanyaCareTest.xml")
public abstract class SpringIntegrationTest extends BasePaxIT {

    @Qualifier("dbRepository")
    @Autowired
    protected MdsRepository dbRepository;

    @Qualifier("ananyaCareProperties")
    @Autowired
    protected Properties ananyaCareProperties;

    @Autowired
    protected ScheduleTrackingService trackingService;

    @Autowired
    protected PeriodUtil periodUtil;

    protected ArrayList<Object> toDelete;
    protected ArrayList<Pair> schedulesToDelete;

    @Before
    public void before() {
        toDelete = new ArrayList<Object>();
        schedulesToDelete = new ArrayList<Pair>();
    }

    @After
    public void after() {
        for(Object obj : toDelete){
        	dbRepository.delete(obj);
        }
        for(int i=0 ;i< schedulesToDelete.size(); i++){
            Pair s = schedulesToDelete.get(i);
            String externalId = s.getFirst().toString();
            String scheduleName = s.getSecond().toString();
            ArrayList<String> scheduleNames = new ArrayList<String>();
            scheduleNames.add(scheduleName);
            trackingService.unenroll(externalId, scheduleNames);
        }
    }


    protected <T> void markForDeletion(T object) {
        toDelete.add(object);
    }

    protected void markScheduleForUnEnrollment(String externalId, String scheduleName) {
        schedulesToDelete.add(new Pair(externalId, scheduleName));
    }

    protected EnrollmentRecord getEnrollmentRecord(String scheduleName, String externalId, EnrollmentStatus status) {
        EnrollmentsQuery query = new EnrollmentsQuery()
                .havingExternalId(externalId)
                .havingState(status)
                .havingSchedule(scheduleName);

        List<EnrollmentRecord> enrollmentRecords = trackingService.searchWithWindowDates(query);
        return enrollmentRecords.isEmpty() ? null : enrollmentRecords.get(0);
    }

    private class Pair {
        private final String first;
        private final String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }
}