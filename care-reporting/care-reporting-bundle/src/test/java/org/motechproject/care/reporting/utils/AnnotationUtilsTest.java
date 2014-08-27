package org.motechproject.care.reporting.utils;

import static junit.framework.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;
import org.motechproject.care.reporting.domain.measure.PncChildForm;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;

public class AnnotationUtilsTest {
    @Test
    public void shouldGetExternalPrimaryKeyValue(){
        assertEquals("value", (String) AnnotationUtils.getExternalPrimaryKeyValue(new TestClass()));
    }

    @Test
    public void shouldGetExternalPrimayKeyField() throws NoSuchFieldException {
        Field expectedField = new TestClass().getClass().getDeclaredField("field");

        assertEquals(expectedField, AnnotationUtils.getExternalPrimaryKeyField(TestClass.class));
    }

    @Test
    public void shouldConsiderSuperClassFieldsAlso(){
        PncChildForm pncChildForm = new PncChildForm();
        pncChildForm.setInstanceId("myInstanceId");

        assertEquals("myInstanceId", AnnotationUtils.getExternalPrimaryKeyValue(pncChildForm));
    }

    private class TestClass {
        @ExternalPrimaryKey
        private String field = "value";
    }
}
