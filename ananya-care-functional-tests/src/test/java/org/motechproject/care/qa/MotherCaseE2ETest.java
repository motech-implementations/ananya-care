package org.motechproject.care.qa;

import junit.framework.Assert;
import org.junit.Test;
import org.motechproject.care.domain.Mother;
import org.motechproject.care.utils.DbUtils;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.schedule.service.MilestoneType;
import org.motechproject.commcarehq.domain.AlertDocCase;
import org.motechproject.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class MotherCaseE2ETest extends E2EIntegrationTest {

    @Autowired
    private DbUtils dbUtils;

   @Test
    public void shouldSendATT1AlertForAPregnantMother() throws IOException {


       final HashMap<String, String> caseAttributes = createAPregnantMotherCaseInCommCare();
       String caseId = caseAttributes.get("caseId");
       Mother mother= dbUtils.getMotherFromDb(caseId);

        Assert.assertNotNull(mother);
        markForDeletion(mother);
        markScheduleForUnEnrollment(caseId, MilestoneType.TT1.toString());
        Assert.assertEquals(caseAttributes.get("name"), mother.getName());
        Assert.assertEquals("d823ea3d392a06f8b991e9e4933348bd", mother.getFlwId());
        Assert.assertEquals(CaseType.Mother.getType(), mother.getCaseType());

        String instanceId = UUID.randomUUID().toString();
        String edd = DateUtil.now().plusMonths(1).toLocalDate().toString();
        caseAttributes.put("instanceId", instanceId);
        caseAttributes.put("edd", edd);
        postXmlWithAttributes(caseAttributes, "/commCareFormXmls/pregnantmother_register_with_edd.st");

       AlertDocCase alertDocCase = dbUtils.getAlertDocCase(caseId, "tt_1");

       Assert.assertNotNull(alertDocCase);
       markAlertDocCaseForDeletion(alertDocCase);


    }

}


