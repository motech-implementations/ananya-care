package org.motechproject.care.reporting.processors;

import static junit.framework.Assert.assertEquals;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.CaseEventBuilder;
import org.motechproject.care.reporting.builder.ChildCaseBuilder;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
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
public class ChildCaseProcessorIT extends BasePaxIT {
    private final String caseId = "97e56523-5820-414a-83c2-bfcb6dcf4db3";
    private final String userId = "89fda0284e008d2e0c980fb13f989136";
    private final String ownerId = "89fda0284e008d2e0c980fb13fbb49e6";

    @Inject
    private ChildCaseProcessor childCaseProcessor;

    @Inject
    MdsRepository dbRepository;

    private FlwGroup flwGroup;
    private Flw flw;

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
    public void shouldParseChildCase() {
        String dateModified = "2013-01-01T12:00:23.923Z";
        DateTime serverModifiedOn = DateTime.now();
        CaseEvent caseEvent = new CaseEventBuilder(caseId)
                .withUserId(userId)
                .withCaseType("cc_bihar_newborn")
                .withDateModified(dateModified)
                .withServerModifiedOn(serverModifiedOn.toString())
                .withOwnerId(ownerId)
                .build();

        childCaseProcessor.process(caseEvent);

        List<ChildCase> childCases = dbRepository.retrieveAll(ChildCase.class);
        assertEquals(1, childCases.size());
        ChildCase expectedChildCase = new ChildCaseBuilder()
                .clear()
                .caseId(caseId)
                .flw(new FlwBuilder().flwId(userId).build())
                .flwGroup(new FlwGroupBuilder().groupId(ownerId).build())
                .dateModified(DateTime.parse(dateModified))
                .serverDateModified(serverModifiedOn)
                .build();

        assertReflectionEqualsWithIgnore(expectedChildCase, childCases.get(0), "id", "flw", "flwGroup", "creationTime", "lastModifiedTime");
        assertReflectionEqualsWithIgnore(flw, childCases.get(0).getFlw(), "id", "flwGroup", "creationTime", "lastModifiedTime");
        assertReflectionEqualsWithIgnore(flwGroup, childCases.get(0).getFlwGroup(), "id", "flws", "creationTime", "lastModifiedTime");
    }
}
