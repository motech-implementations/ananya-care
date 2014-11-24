package org.motechproject.care.domain;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class MotherTest {

    @Test
    public void shouldBeSetToActiveIfAliveAndNoADDIsPresentAndNotClosedByCommcare() {
        MotherCase mother = new MotherCase();
        mother.setIsAlive("yes");
        Assert.assertTrue(mother.isActive());
    }

    @Test
    public void shouldBeSetToInActiveIfNotAlive() {
        MotherCase mother = new MotherCase();
        mother.setIsAlive("no");
        Assert.assertFalse(mother.isActive());
    }

    @Test
    public void shouldBeSetToInActiveIfNoADDIsPresent() {
        MotherCase mother = new MotherCase();
        mother.setIsAlive("yes");
        mother.setActualDeliveryDate(new DateTime());
        Assert.assertFalse(mother.isActive());
    }

    @Test
    public void shouldBeSetToInActiveIfCaseClosedByCommCare() {
        MotherCase mother = new MotherCase();
        mother.setIsAlive("yes");
        mother.setClosedByCommcare(true);
        Assert.assertFalse(mother.isActive());
    }

    @Test
    public void shouldNotCopyNullPropertiesFromAnotherMotherObject()  {
        Flw flw = new Flw();
        flw.setFlwId("flwid");
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupid2");
        MotherCase mother = new MotherCase("caseId", null,flw,"name",null,null, DateTime.parse("2010-04-03"),null,null,"no",null,null,null,null,null,"yes");
        MotherCase motherFromDb = new MotherCase("caseId", DateTime.parse("2010-01-01"), null, "name2", flwGroup, null, null,null,null,"no",null,null,null,null,null,"no");
        motherFromDb.valuesSetFrom(mother);
        Assert.assertEquals(DateTime.parse("2010-01-01"), motherFromDb.getDateModified());
        Assert.assertEquals("flwid", motherFromDb.getFlw().getFlwId());
        Assert.assertEquals("name", motherFromDb.getCaseName());
        Assert.assertEquals("groupid2", motherFromDb.getFlwGroup().getGroupId());
        Assert.assertEquals(DateTime.parse("2010-04-03"), motherFromDb.getActualDeliveryDate());
    }

    @Test
    public void shouldNotCopyEmptyPropertiesFromAnotherMotherObject()  {
        Flw flw = new Flw();
        flw.setFlwId("flwid");
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        MotherCase mother = new MotherCase("caseId", null,null,"arpan",flwGroup,null, DateTime.parse("2010-04-03"),null,null,"no",null,null,null,null,null,"no");
        MotherCase motherFromDb = new MotherCase("caseId", DateTime.parse("2010-01-01"), flw, "arpana",null, null, null,null,null,"no",null,null,null,null,null,"yes");
        motherFromDb.valuesSetFrom(mother);
        Assert.assertEquals(DateTime.parse("2010-01-01"), motherFromDb.getDateModified());
        Assert.assertEquals("flwid", motherFromDb.getFlw().getFlwId());
        Assert.assertEquals("arpan", motherFromDb.getCaseName());
        Assert.assertEquals("groupId", motherFromDb.getFlwGroup().getGroupId());
        Assert.assertEquals(DateTime.parse("2010-04-03"), motherFromDb.getActualDeliveryDate());
    }
}
