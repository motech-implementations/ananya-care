package org.motechproject.care.reporting.processors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.CommcareFormBuilder;
import org.motechproject.care.reporting.builder.FormValueElementBuilder;
import org.motechproject.commcare.domain.CommcareForm;
import org.motechproject.commcare.domain.FormValueElement;
import org.motechproject.mcts.care.common.mds.measure.MotherEditForm;
import org.motechproject.mcts.care.common.mds.measure.MoveBeneficiaryForm;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class FormProcessorIT extends BasePaxIT {

    @Inject
    private FormProcessor formProcessor;

    @Inject
    MdsRepository dbRepository;
    
    @Test
    public void shouldSaveMotherEditForm() {
        String motherCaseId = "94d5374f-290e-409f-bc57-86c2e4bcc43f";
        String flwId = "89fda0284e008d2e0c980fb13fa0e5bb";

        String dateModified = "2012-07-21T12:02:59.923+05:30";
        FormValueElement motherCaseData = new FormValueElementBuilder()
                .addAttribute("case_id", motherCaseId)
                .addAttribute("date_modified", dateModified)
                .addAttribute("user_id", flwId)
                .addSubElement("case_name", "Devi")
                .addSubElement("mother_name", "MotherName")
                .addSubElement("hh_number", "11")
                .addSubElement("mother_dob", "2012-07-21")
                .addSubElement("husband_name", "HusbandName")
                .addSubElement("family_number", "12")
                .addSubElement("mobile_number", "1111111111")
                .addSubElement("ward_number", "42")
                .addSubElement("age", "11")
                .build();
        DateTime receivedOn = DateTime.now();
        CommcareForm newFormData = new CommcareFormBuilder()
                .addMetadata("deviceID", "IUFN6IXAIV7Z1OKJBIWV7WY3C")
                .addMetadata("time_start", "2012-07-21T11:59:31.076+05:30")
                .addMetadata("time_end", "2012-07-21T12:02:59.923+05:30")
                .addMetadata("username", "username")
                .addMetadata("userID", flwId)
                .addMetadata("instanceId", "e34707f8-80c8-4198-bf99-c11c90ba5c98")
                .addMetadata("appVersion", "validVersion")
                .addAttribute("uiVersion", "1")
                .addAttribute("version", "1")
                .addAttribute("name", "Mother Edit")
                .addAttribute("xmlns", "http://bihar.commcarehq.org/pregnancy/mother_edit")
                .addSubElement("case", motherCaseData)
                .addSubElement("update_mother_name", "yes")
                .addSubElement("update_hh_number", "no")
                .addSubElement("update_family_number", "yes")
                .addSubElement("update_ward_number", "no")
                .addSubElement("update_husband_name", "yes")
                .addSubElement("update_mother_dob", "no")
                .addSubElement("update_mobile_number", "no")
                .addSubElement("update_mobile_number_whose", "yes")
                .withReceivedOn(receivedOn.toString())
                .build();

        formProcessor.process(newFormData);

        List<MotherEditForm> motherEditForms = dbRepository.retrieveAll(MotherEditForm.class);
        assertEquals(1, motherEditForms.size());
        MotherEditForm motherEditForm = motherEditForms.get(0);
        assertEquals(receivedOn.toDate(), motherEditForm.getServerDateModified());
        assertEquals(DateTime.parse(dateModified).toDate(), motherEditForm.getDateModified());
        assertEquals("Devi", motherEditForm.getCaseName());
        assertEquals(motherCaseId,motherEditForm.getMotherCase().getCaseId());
        assertEquals(flwId, motherEditForm.getFlw().getFlwId());
        assertEquals("MotherName", motherEditForm.getMotherName());
        assertEquals(DateTime.parse("2012-07-21").toDate(), motherEditForm.getMotherDob());
        assertEquals("1111111111", motherEditForm.getMobileNumber());
        assertEquals(new Integer(42), motherEditForm.getWardNumber());
        assertEquals(new Integer(11), motherEditForm.getAge());
        assertEquals("e34707f8-80c8-4198-bf99-c11c90ba5c98", motherEditForm.getInstanceId());
        assertEquals(DateTime.parse("2012-07-21T11:59:31.076+05:30").toDate(), motherEditForm.getTimeStart());
        assertEquals(DateTime.parse("2012-07-21T12:02:59.923+05:30").toDate(), motherEditForm.getTimeEnd());
        assertEquals("yes", motherEditForm.getUpdateMotherName());
        assertEquals("no", motherEditForm.getUpdateHhNumber());
        assertEquals("yes", motherEditForm.getUpdateFamilyNumber());
        assertEquals("no", motherEditForm.getUpdateWardNumber());
        assertEquals("yes", motherEditForm.getUpdateHusbandName());
        assertEquals("no", motherEditForm.getUpdateMotherDob());
        assertEquals("no", motherEditForm.getUpdateMobileNumber());
        assertEquals("yes", motherEditForm.getUpdateMobileNumberWhose());
    }

    @Test
    public void shouldSaveMotherForMoveBeneficiaryForm() {
        String motherCaseId = "11d5374f-290e-409f-bc57-86c2e4bcc43f";
        String flwId = "12fda0284e008d2e0c980fb13fa0e5bb";

        String dateModified = "2012-07-21T12:04:00.923+05:30";
        FormValueElement motherCaseData = new FormValueElementBuilder()
                .addAttribute("case_id", motherCaseId)
                .addAttribute("date_modified", dateModified)
                .addAttribute("user_id", flwId)
                .build();

        String instanceId = "194707f8-80c8-4198-bf99-c11c90ba5c98";
        DateTime receivedOn = DateTime.now();
        CommcareForm moveBeneficiaryForm = new CommcareFormBuilder()
                .withReceivedOn(receivedOn.toString())
                .addMetadata("deviceID", "AUFN6IXAIV7Z1OKJBIWV7WY3C")
                .addMetadata("time_start", "2012-07-21T11:59:31.076+05:30")
                .addMetadata("time_end", "2012-07-21T12:02:59.923+05:30")
                .addMetadata("username", "username")
                .addMetadata("userID", flwId)
                .addMetadata("instanceId", instanceId)
                .addMetadata("appVersion", "validVersion")

                .addAttribute("uiVersion", "1")
                .addAttribute("version", "1")
                .addAttribute("name", "Move Beneficiary")
                .addAttribute("xmlns", "http://bihar.commcarehq.org/tools/move_beneficiary")

                .addSubElement("confirm_move", "yes")
                .addSubElement("new_ward", "123")
                .addSubElement("new_awcc", "1000")
                .addSubElement("confirm_again", "no")
                .addSubElement("case", motherCaseData)
                .build();

        formProcessor.process(moveBeneficiaryForm);

        List<MoveBeneficiaryForm> forms = dbRepository.retrieveAll(MoveBeneficiaryForm.class);
        assertEquals(1, forms.size());
        MoveBeneficiaryForm moveForm = forms.get(0);

        assertEquals("yes", moveForm.getConfirmMove());
        assertEquals(new Integer(123), moveForm.getNewWard());
        assertEquals(new Integer(1000), moveForm.getNewAwcc());
        assertEquals("no", moveForm.getConfirmAgain());
        assertEquals(motherCaseId, moveForm.getMotherCase().getCaseId());
        assertEquals(instanceId, moveForm.getInstanceId());
        assertEquals(flwId, moveForm.getFlw().getFlwId());
        assertEquals(DateTime.parse("2012-07-21T11:59:31.076+05:30").toDate(), moveForm.getTimeStart());
        assertEquals(DateTime.parse("2012-07-21T12:02:59.923+05:30").toDate(), moveForm.getTimeEnd());
        assertEquals(DateTime.parse(dateModified).toDate(), moveForm.getDateModified());
        assertEquals(receivedOn.toDate(), moveForm.getServerDateModified());
        assertNotNull(moveForm.getCreationTime());

    }
}
