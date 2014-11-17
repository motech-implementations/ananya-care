package org.motechproject.care.reporting.enums;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CaseTypeTest {

    @Test
    public void shouldReturnCaseType() throws Exception {
        assertEquals(CaseType.MOTHER, CaseType.getType("cc_bihar_pregnancy"));
        assertEquals(CaseType.CHILD, CaseType.getType("cc_bihar_newborn"));
        assertEquals(CaseType.TASK, CaseType.getType("task"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfCaseTypeStringIsNotExactMatch() {

        CaseType.getType("cc_Bihar_pregnancy");

        CaseType.getType(" cc_bihar_pregnancy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfCaseTypeIsNotFound() {

        CaseType.getType("unknown");

        CaseType.getType(null);

        CaseType.getType("");

        CaseType.getType("  ");
    }

}
