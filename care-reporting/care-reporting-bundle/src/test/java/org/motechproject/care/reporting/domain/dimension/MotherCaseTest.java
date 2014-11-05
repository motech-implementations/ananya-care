package org.motechproject.care.reporting.domain.dimension;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.MotherCaseBuilder;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class MotherCaseTest {

    public static final DateTime JAN_01 = DateTime.parse("2012-01-01");
    public static final DateTime DEC_01 = DateTime.parse("2012-12-01");

    @Test
    public void shouldUpdateUpdatableFields() throws Exception {
        DateTime jan01 = DateTime.parse("2012-01-01");
        DateTime dec01 = DateTime.parse("2012-12-01");
        MotherCase oldMother = new MotherCaseBuilder().caseId("01").caseName("durga").dateModified(jan01).alive("no").build();
        MotherCase updatedMother = new MotherCaseBuilder().caseId("01").caseName("devi").dateModified(dec01).alive("yes").build();

        oldMother.updateToLatest(updatedMother);

        assertEquals("devi", oldMother.getCaseName());
        assertEquals(dec01, updatedMother.getDateTimeModified());
        assertEquals("yes", oldMother.getMotherAlive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCaseIdMismatch() {
        new MotherCaseBuilder().caseId("01").build().updateToLatest(new MotherCaseBuilder().caseId("02").build());
    }

    @Test
    public void shouldNotUpdateIfServerDateModifiedOlderThanPresent() throws Exception {
        MotherCase oldMother = new MotherCaseBuilder().caseId("01").caseName("durga").serverDateModified(DEC_01).alive("no").build();
        MotherCase updatedMother = new MotherCaseBuilder().caseId("01").caseName("devi").serverDateModified(JAN_01).alive("yes").build();

        oldMother.updateToLatest(updatedMother);

        assertEquals("durga", oldMother.getCaseName());
    }

    @Test
    public void shouldUpdateTheLastModifiedTimeToCurrentTime() {
        MotherCase motherCase = new MotherCaseBuilder().caseId("01").build();

        motherCase.updateToLatest(new MotherCaseBuilder().caseId("01").build());


        //TODO: uncomment below
        //TestUtils.assertDateIgnoringSeconds(new Date(), motherCase.getLastModifiedTime());
    }

    @Test
    public void shouldNotUpdateTheCreationTime() {
        MotherCase motherCase = new MotherCaseBuilder().caseId("01").build();

        motherCase.updateToLatest(new MotherCaseBuilder().caseId("01").creationTime(null).build());

        assertNotNull(motherCase.getCreationTime());
    }

    @Test
    public void shouldNotUpdateTheCloseCaseFields() {
        Flw oldFlw = new FlwBuilder().flwId("flw id1").build();
        Flw newFlw = new FlwBuilder().flwId("flw id2").build();
        MotherCase motherCase = new MotherCaseBuilder()
                .flw(oldFlw)
                .serverDateModified(JAN_01)
                .caseName("old Name").close().build();
        MotherCase newMother = new MotherCaseBuilder()
                .closedBy(newFlw)
                .serverDateModified(DEC_01)
                .closedDate(DEC_01)
                .closed(false)
                .caseName("new Name").build();

        motherCase.updateToLatest(newMother);

        assertEquals("new Name",motherCase.getCaseName());
        assertEquals(JAN_01, motherCase.getClosedOn());
        assertEquals(oldFlw, motherCase.getClosedBy());
        assertTrue(motherCase.getClosed());
    }

    @Test
    public void shouldInitializeWithCreationAndLastModifiedTime() {
        DateTime now = new DateTime();

        MotherCase motherCase = new MotherCase();

        DateTime creationTime = motherCase.getCreationTime();
        DateTime lastModifiedTime = motherCase.getLastModifiedTime();
        Assert.assertEquals(creationTime, lastModifiedTime);
        assertTrue(!now.isAfter(new DateTime(lastModifiedTime)));
    }
}
