package org.motechproject.care.reporting.utils;

import static junit.framework.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;
import org.motechproject.mcts.care.common.domain.annotations.ExternalPrimaryKey;
import org.motechproject.mcts.care.common.mds.measure.PncChildForm;

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

    private class TestClass {
        @ExternalPrimaryKey
        private String field = "value";
    }
}
