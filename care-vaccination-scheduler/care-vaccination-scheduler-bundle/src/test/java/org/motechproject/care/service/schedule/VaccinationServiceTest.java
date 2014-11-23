package org.motechproject.care.service.schedule;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.care.schedule.service.ScheduleService;
import org.motechproject.care.service.CareCaseTaskService;
import org.motechproject.mcts.care.common.mds.domain.Client;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.scheduletracking.service.EnrollmentRecord;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VaccinationServiceTest {
    @Mock
    private ScheduleService schedulerService;
    @Mock
    CareCaseTaskService careCaseTaskService;


    private String scheduleName = "scheduleName";

    private VaccinationService vaccinationService;


    @Before
    public void setUp(){
        vaccinationService = new VaccinationService(schedulerService, scheduleName, careCaseTaskService) {
            @Override
            public void process(Client client) {

            }

            @Override
            public void fulfillMilestone(Client client, MilestoneType milestoneType, DateTime fulfillmentDate) {
                super.fulfillMilestone(client, milestoneType, fulfillmentDate);
            }
        };
    }

    @Test
    public void shouldUnenrollAndReturnCurrentEnrollmentRecord() {
        String caseId = "caseId";
        String milestoneName = "milestoneName";
        Client client = new MotherCase();
        client.setCaseId(caseId);

        EnrollmentRecord expectedEnrollmentRecord = enrollmentRecordForMilestone(milestoneName);
        when(schedulerService.unenroll(caseId, scheduleName)).thenReturn(expectedEnrollmentRecord);

        vaccinationService.close(client);
        verify(schedulerService, only()).unenroll(caseId, scheduleName);
        verify(careCaseTaskService, only()).close(client, milestoneName);
    }

    @Test
    public void shouldCloseTheCaseDuringFulfillment() {
        Client client = new Client();
        String caseId = "mycaseid";
        client.setCaseId(caseId);
        MilestoneType milestone = MilestoneType.Anc3;
        DateTime fulfillmentDate = DateTime.now();

        vaccinationService.fulfillMilestone(client, milestone, fulfillmentDate);

        verify(schedulerService).fulfillMilestone(caseId, milestone.toString(), fulfillmentDate, scheduleName);
        verify(careCaseTaskService).close(client, milestone.toString());
    }

    private EnrollmentRecord enrollmentRecordForMilestone(String currentMilestoneName) {
        EnrollmentRecord enrollmentRecord = new EnrollmentRecord();
        enrollmentRecord.setCurrentMilestoneName(currentMilestoneName);
        return enrollmentRecord;
    }
}
