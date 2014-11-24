package org.motechproject.care.reporting.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
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
public class MotherCaseConverterIT extends BasePaxIT {
    @Inject
    private MotherCaseConverter motherCaseConverter;

    @Inject
    MdsRepository dbRepository;

    @Test
    public void shouldGetANewMotherIfDoesNotExists() throws Exception {
        Object convertedMotherCase = motherCaseConverter.convert(
                MotherCase.class, "123456789");
        boolean isPersisted = dbRepository.get(MotherCase.class, "caseId",
                "123456789") == null ? false : true;
        assertFalse(isPersisted);
        assertEquals("123456789",
                ((MotherCase) convertedMotherCase).getCaseId());
    }

    @Test
    public void shouldGetPersistedObjectIfMotherCaseExists() throws Exception {
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("123456789");
        dbRepository.save(motherCase);

        Object convertedObject = motherCaseConverter.convert(MotherCase.class,
                "123456789");
        boolean isPersisted = dbRepository.get(MotherCase.class, "caseId",
                "123456789") == null ? false : true;
        assertTrue(isPersisted);
    }
}
