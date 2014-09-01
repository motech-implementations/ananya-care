package org.motechproject.care.reporting.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.motechproject.care.reporting.repository.SpringIntegrationTest;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildCaseConverterIT extends SpringIntegrationTest {

    @Autowired
    private ChildCaseConverter childCaseConverter;
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void shouldGetANewChildIfDoesNotExists() throws Exception {
        Object convertedChildCase = childCaseConverter.convert(ChildCase.class, "123456789");
        boolean isPersisted = sessionFactory.getCurrentSession().contains(convertedChildCase);
        assertFalse(isPersisted);
        assertEquals("123456789", ((ChildCase) convertedChildCase).getCaseId());
    }

    @Test
    public void shouldGetPersistedObjectIfChildCaseExists() throws Exception {
        ChildCase childCaseCase = new ChildCase();
        childCaseCase.setCaseId("123456789");
        template.save(childCaseCase);

        Object convertedObject = childCaseConverter.convert(ChildCase.class, "123456789");
        boolean isPersisted = sessionFactory.getCurrentSession().contains(convertedObject);
        assertTrue(isPersisted);
    }

    @Test
    public void shouldReturnNullIfPassedValueIsNullOrNotOfTypeString() {
        Object convertedValue = childCaseConverter.convert(ChildCase.class, null);
        assertNull(convertedValue);

        convertedValue = childCaseConverter.convert(ChildCase.class, new Object());
        assertNull(convertedValue);
    }
}
