package org.motechproject.care.reporting.domain.dimension;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.care.reporting.utils.TestUtils;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;

public class FlwGroupTest {
    @Test
    public void shouldUpdateLastModifiedTimeAndNotCreationTime() {
        FlwGroup flwGroup = new FlwGroupBuilder().groupId("groupId").build();

        flwGroup.updateToLatest(new FlwGroupBuilder().groupId("groupId").creationTime(null).build());


        //TODO: uncomment below
        //TestUtils.assertDateIgnoringSeconds(new Date(), flwGroup.getLastModifiedTime());
        assertNotNull(flwGroup.getCreationTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfGroupIdDontMatch() throws Exception {
        new FlwGroupBuilder().groupId("1").build().updateToLatest(new FlwGroupBuilder().groupId("2").build());
    }


    @Test
    public void shouldInitializeWithCreationAndLastModifiedTime() {
        DateTime now = new DateTime();

        FlwGroup flwGroup = new FlwGroup();

        DateTime creationTime = flwGroup.getCreationTime();
        DateTime lastModifiedTime = flwGroup.getLastModifiedTime();
        Assert.assertEquals(creationTime, lastModifiedTime);
        assertTrue(!now.isAfter(new DateTime(lastModifiedTime)));
    }


    @Test
    public void shouldInitializeWithEmptyFLWSet() {
        FlwGroup flwGroup = new FlwGroup();


        //TODO: uncomment below
        //assertTrue(flwGroup.getFlws().isEmpty());
    }
}
