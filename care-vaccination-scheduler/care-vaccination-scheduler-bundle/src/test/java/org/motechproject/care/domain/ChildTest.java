package org.motechproject.care.domain;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.mcts.care.common.mds.domain.Child;

public class ChildTest {

    @Test
    public void shouldBeSetToIsActiveByDefault() {
        Child child = new Child();
        child.setIsAlive(true);
        Assert.assertTrue(child.isActive());
    }

    @Test
    public void shouldBeSetToInActiveIfNotAlive() {
        Child child = new Child();
        child.setIsAlive(false);
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldBeInactiveIfClosedByCommcare() {
        Child child = new Child();
        child.setIsAlive(true);
        child.setClosedByCommcare(true);
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldBeInactiveIfExpired() {
        Child child = new Child();
        child.setExpired(true);
        Assert.assertFalse(child.isActive());
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldSetEnrollForSchedulesToFalseIfChildIsOlderThanAYearOrHasNoDOB(){
        Child child = new Child();
        child.setDob(DateTime.now().minusYears(2));
        Assert.assertFalse(child.shouldEnrollForSchedules());

        child.setDob(null);
        Assert.assertFalse(child.shouldEnrollForSchedules());
    }

    @Test
    public void shouldSetEnrollForSchedulesToTrueIfChildIsNotOlderThanAYearAndIsActive(){
        Child child = new Child();
        child.setDob(DateTime.now());
        child.setIsAlive(true);
        Assert.assertTrue(child.shouldEnrollForSchedules());
    }
}
