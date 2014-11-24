package org.motechproject.care.reporting.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class ChildCaseConverterIT extends BasePaxIT {

    @Inject
    private ChildCaseConverter childCaseConverter;

    @Inject
    MdsRepository dbRepository;

    @Test
    public void shouldGetANewChildIfDoesNotExists() throws Exception {
        Object convertedChildCase = childCaseConverter.convert(ChildCase.class,
                "123456789");
        boolean isPersisted = dbRepository.get(ChildCase.class, "caseId",
                "123456789") == null ? false : true;
        assertFalse(isPersisted);
        assertEquals("123456789", ((ChildCase) convertedChildCase).getCaseId());
    }

    @Test
    public void shouldGetPersistedObjectIfChildCaseExists() throws Exception {
        ChildCase childCaseCase = new ChildCase();
        childCaseCase.setCaseId("123456789");
        dbRepository.save(childCaseCase);

        childCaseConverter.convert(ChildCase.class, "123456789");
        boolean isPersisted = dbRepository.get(ChildCase.class, "caseId",
                "123456789") == null ? false : true;
        assertTrue(isPersisted);
        dbRepository.delete(childCaseCase);
    }

    @Test
    public void shouldReturnNullIfPassedValueIsNullOrNotOfTypeString() {
        Object convertedValue = childCaseConverter.convert(ChildCase.class,
                null);
        assertNull(convertedValue);

        convertedValue = childCaseConverter.convert(ChildCase.class,
                new Object());
        assertNull(convertedValue);
    }
}
