package org.motechproject.care.reporting.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class FlwConverterIT  {
    @Autowired
    private FlwConverter flwConverter;

    private SessionFactory sessionFactory;
    private HibernateTemplate template;

    @Test
    public void shouldGetANewFlwIfDoesNotExist() throws Exception {
        Object convertedObject = flwConverter.convert(Flw.class, "89fda0284e008d2e0c980fb13f96c45a");
        boolean isPersisted = sessionFactory.getCurrentSession().contains(convertedObject);
        assertFalse(isPersisted);
        assertEquals("89fda0284e008d2e0c980fb13f96c45a", ((Flw) convertedObject).getFlwId());
    }

    @Test
    public void shouldGetPersistedObjectIfFlwExists() throws Exception {
        Flw flw = new Flw();
        flw.setFlwId("89fda0284e008d2e0c980fb13f96c45a");
        template.save(flw);

        Object convertedObject = flwConverter.convert(Flw.class, "89fda0284e008d2e0c980fb13f96c45a");
        boolean isPersisted = sessionFactory.getCurrentSession().contains(convertedObject);
        assertTrue(isPersisted);
    }
}
