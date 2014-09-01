package org.motechproject.care.reporting.domain.dimension;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.motechproject.care.reporting.utils.TestUtils.assertDateIgnoringSeconds;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.mcts.care.common.mds.dimension.Flw;

public class FlwTest {
    @Test
    public void shouldUpdateFlwFieldsAndNotCreationTime() {
        Flw flw = new FlwBuilder().flwId("flwId").firstName("oldName").build();

        flw.updateToLatest(new FlwBuilder().flwId("flwId").firstName("newName").creationTime(null).build());

        assertEquals("newName", flw.getFirstName());
        

        //TODO: uncomment below
        //assertDateIgnoringSeconds(new Date(), flw.getLastModifiedTime());
        assertNotNull(flw.getCreationTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfFlwIdDontMatch() throws Exception {
        new FlwBuilder().flwId("1").build().updateToLatest(new FlwBuilder().flwId("2").build());
    }

    @Test
    public void shouldInitializeWithCreationAndLastModifiedTime() {
        DateTime now = new DateTime();

        Flw flw = new Flw();

        DateTime creationTime = flw.getCreationTime();
        DateTime lastModifiedTime = flw.getLastModifiedTime();
        assertEquals(creationTime, lastModifiedTime);
        assertTrue(!now.isAfter(new DateTime(lastModifiedTime)));
    }

    @Test
    public void shouldInitializeWithEmptyFLWGroupSet() {
        Flw flw = new Flw();


        //TODO: uncomment below
        //assertTrue(flw.getFlwGroups().isEmpty());
    }
}
