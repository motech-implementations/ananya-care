package org.motechproject.care.reporting.utils;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.motechproject.mcts.care.common.mds.measure.PncChildForm;

public class ReflectionUtilsTest {
    @Test
    public void shouldUpdateValueOfAField(){
        TestClass toBeUpdated = new TestClass("oldValue");
        ReflectionUtils.updateValue("field", new TestClass("newValue"), toBeUpdated);

        assertEquals("newValue", toBeUpdated.getField());
    }

    @Test
    public void shouldTrySuperClassFieldsIfFieldIsNotFoundInSubClass(){
        PncChildForm pncChildForm = new PncChildForm();
        pncChildForm.setInstanceId("myInstanceId");

        assertEquals("myInstanceId", ReflectionUtils.getValue(pncChildForm, "instanceId"));
    }

    private class TestClass {
        private String field;

        public TestClass(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }
    }
}
