package org.motechproject.care.reporting.factory;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.motechproject.care.reporting.enums.CaseType;
import org.motechproject.mcts.care.common.mds.measure.DeliveryChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryMotherForm;
import org.motechproject.mcts.care.common.mds.measure.MotherEditForm;

public class FormFactoryTest{

    @Test
    public void testGetDeliveryForm() throws Exception {
        assertEquals(DeliveryMotherForm.class, FormFactory.getForm("http://bihar.commcarehq.org/pregnancy/del", CaseType.MOTHER));
        assertEquals(DeliveryChildForm.class, FormFactory.getForm("http://bihar.commcarehq.org/pregnancy/del", CaseType.CHILD));
    }

    @Test
    public void shouldGetTheMotherEditForm(){
        assertEquals(MotherEditForm.class, FormFactory.getForm("http://bihar.commcarehq.org/pregnancy/mother_edit", CaseType.MOTHER));
    }
}
