package org.motechproject.care.reporting.domain.measure;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mcts.care.common.mds.measure.NewForm;

public class FormToStringTest {
    @Test
    public void shouldGenerateToStringForNwForm() throws Exception {
        NewForm newForm = new NewForm();
        newForm.setInstanceId("foobar");
        String toString = FormToString.toString(newForm);
        assertEquals("NewForm{instanceId=foobar}", toString);
    }
}
