package org.motechproject.care.reporting.processors;

import static junit.framework.Assert.assertEquals;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.care.reporting.builder.CaseEventBuilder;
import org.motechproject.care.reporting.builder.ChildCaseBuilder;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.care.reporting.repository.SpringIntegrationTest;
import org.motechproject.commcare.events.CaseEvent;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.springframework.beans.factory.annotation.Autowired;

public class ChildCaseProcessorIT extends SpringIntegrationTest {
    private final String caseId = "97e56523-5820-414a-83c2-bfcb6dcf4db3";
    private final String userId = "89fda0284e008d2e0c980fb13f989136";
    private final String ownerId = "89fda0284e008d2e0c980fb13fbb49e6";

    @Autowired
    private ChildCaseProcessor childCaseProcessor;

    private FlwGroup flwGroup;
    private Flw flw;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        flwGroup = new FlwGroup();
        flwGroup.setGroupId(ownerId);
        flw = new Flw();
        flw.setFlwId(userId);

        //TODO: uncomment below
        //flwGroup.getFlws().add(flw);
        template.save(flwGroup);
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

        List<ChildCase> childCases = template.loadAll(ChildCase.class);
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
