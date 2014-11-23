package org.motechproject.care.domain;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;

@RunWith(MockitoJUnitRunner.class)
public class ChildTest {

    @Test
    public void shouldBeSetToIsActiveByDefault() {
        ChildCase child = new ChildCase();
        child.setIsAlive("yes");
        Assert.assertTrue(child.isActive());
    }

    @Test
    public void shouldBeSetToInActiveIfNotAlive() {
        ChildCase child = new ChildCase();
        child.setIsAlive("no");
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldBeInactiveIfClosedByCommcare() {
        ChildCase child = new ChildCase();
        child.setIsAlive("yes");
        child.setClosedByCommcare(true);
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldBeInactiveIfExpired() {
        ChildCase child = new ChildCase();
        child.setExpired(true);
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldSetEnrollForSchedulesToFalseIfChildIsOlderThanAYearOrHasNoDOB(){
        ChildCase child = new ChildCase();
        child.setDob(DateTime.now().minusYears(2));
        Assert.assertFalse(child.shouldEnrollForSchedules());

        child.setDob(null);
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldSetEnrollForSchedulesToTrueIfChildIsNotOlderThanAYearAndIsActive(){
        ChildCase child = new ChildCase();
        child.setDob(DateTime.now());
        child.setIsAlive("yes");
        Assert.assertTrue(child.shouldEnrollForSchedules());
    }
}
