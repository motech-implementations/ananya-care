package org.motechproject.care.reporting.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class FlwConverterIT extends BasePaxIT {
    @Inject
    private FlwConverter flwConverter;

    @Inject
    MdsRepository dbRepository;

    @Test
    public void shouldGetANewFlwIfDoesNotExist() throws Exception {
        Object convertedObject = flwConverter.convert(Flw.class,
                "89fda0284e008d2e0c980fb13f96c45a");
        boolean isPersisted = dbRepository.get(Flw.class, "flwId",
                "89fda0284e008d2e0c980fb13f96c45a") == null ? false : true;
        assertFalse(isPersisted);
        assertEquals("89fda0284e008d2e0c980fb13f96c45a",
                ((Flw) convertedObject).getFlwId());
    }

    @Test
    public void shouldGetPersistedObjectIfFlwExists() throws Exception {
        Flw flw = new Flw();
        flw.setFlwId("89fda0284e008d2e0c980fb13f96c45a");
        dbRepository.save(flw);

        Object convertedObject = flwConverter.convert(Flw.class,
                "89fda0284e008d2e0c980fb13f96c45a");
        boolean isPersisted = dbRepository.get(Flw.class, "flwId",
                "89fda0284e008d2e0c980fb13f96c45a") == null ? false : true;
        assertTrue(isPersisted);
        dbRepository.delete(flw);
    }
}
