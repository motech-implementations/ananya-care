package org.motechproject.care.reporting.processors;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.CaseEventBuilder;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.care.reporting.builder.MotherCaseBuilder;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
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
public class MotherCaseProcessorIT extends BasePaxIT {

    public static final DateTime JAN_01 = DateTime.parse("2013-01-01T02:10:23.923Z");

    private final String caseId = "97e56523-5820-414a-83c2-bfcb6dcf4db3";
    private final String userId = "89fda0284e008d2e0c980fb13f989136";
    private final String ownerId = "89fda0284e008d2e0c980fb13fbb49e6";

    @Inject
    private MotherCaseProcessor motherCaseProcessor;
    private FlwGroup flwGroup;
    private Flw flw;
    @Inject
    MdsRepository dbRepository;

    @Before
    public void setUp() {
        flwGroup = new FlwGroup();
        flwGroup.setGroupId(ownerId);
        flw = new Flw();
        flw.setFlwId(userId);

        flwGroup.getFlws().add(flw);
        dbRepository.save(flwGroup);
    }

    @Test
    public void shouldParseMotherCase() {
        String dateModified = "2013-01-01T12:00:23.923Z";
        String serverDateModified = "2013-02-01T12:00:23.923Z";
        CaseEvent caseEvent = new CaseEventBuilder(caseId)
                .withUserId(userId)
                .withCaseType("cc_bihar_pregnancy")
                .withOwnerId(ownerId)
                .withServerModifiedOn(serverDateModified)
                .withDateModified(dateModified)
                .build();

        motherCaseProcessor.process(caseEvent);

        List<MotherCase> motherCases = dbRepository.retrieveAll(MotherCase.class);
        assertEquals(1, motherCases.size());
        MotherCase expectedMotherCase = new MotherCaseBuilder()
                .clear()
                .caseId(caseId)
                .flw(new FlwBuilder().flwId(userId).build())
                .flwGroup(new FlwGroupBuilder().groupId(ownerId).build())
                .dateModified(DateTime.parse(dateModified))
                .serverDateModified(DateTime.parse(serverDateModified))
                .build();

        assertReflectionEqualsWithIgnore(expectedMotherCase, motherCases.get(0), "id", "flw", "flwGroup", "creationTime", "lastModifiedTime");
        assertReflectionEqualsWithIgnore(flw, motherCases.get(0).getFlw(), "id", "flwGroup", "creationTime", "lastModifiedTime");
        assertReflectionEqualsWithIgnore(flwGroup, motherCases.get(0).getFlwGroup(), "id", "flws", "creationTime", "lastModifiedTime");
    }

    @Test
    public void shouldNotUpdateCloseFieldsOnSubsequentUpdates() {
        MotherCase motherCase = new MotherCaseBuilder()
                .caseId(caseId)
                .caseName("User 1")
                .flw(userId)
                .serverDateModified(JAN_01)
                .close()
                .build();
        dbRepository.save(motherCase);

        CaseEvent updatedCase = new CaseEventBuilder(caseId)
                .withCaseName("User 2")
                .withCaseType("cc_bihar_pregnancy")
                .withServerModifiedOn("2013-01-02T12:00:23.923Z")
                .build();

        motherCaseProcessor.process(updatedCase);

        List<MotherCase> motherCases = dbRepository.retrieveAll(MotherCase.class);
        assertEquals(1, motherCases.size());
        MotherCase updatedMotherCase = motherCases.get(0);
        assertTrue(updatedMotherCase.getClosed());
        assertEquals(userId, updatedMotherCase.getClosedBy().getFlwId());
        assertEquals(JAN_01, updatedMotherCase.getClosedOn());
        assertEquals("User 2", updatedCase.getCaseName());
    }
}
