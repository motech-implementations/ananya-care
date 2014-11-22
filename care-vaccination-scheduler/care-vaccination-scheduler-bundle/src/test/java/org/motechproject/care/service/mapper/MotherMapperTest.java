package org.motechproject.care.service.mapper;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.care.request.CareCase;
import org.motechproject.care.service.builder.MotherCareCaseBuilder;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

import static junit.framework.Assert.*;

public class MotherMapperTest {

    @Test
    public void shouldMapToAMotherObject(){
        
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        CareCase careCase = new MotherCareCaseBuilder().withLastPregTT("yes").withAdd("2012-10-04").build();
        MotherCase mother = MotherMapper.map(careCase,flw,flwGroup);
        assertEquals("6055b3ec-bec6-46cc-9e72-435ebc4eaec1", mother.getCaseId());
        assertEquals(new DateTime(2012, 3, 4, 0, 0), mother.getDateModified());
        assertEquals("b823ea3d392a06f8b991e9e4933348bd", mother.getFlw().getFlwId());
        assertEquals("Vanaja", mother.getCaseName());
        assertEquals("112", mother.getFlwGroup().getGroupId());
        assertEquals(new DateTime(2012, 10, 2, 0, 0), mother.getEdd());
        assertEquals(new DateTime(2012, 10, 4, 0, 0), mother.getActualDeliveryDate());
        assertEquals(new DateTime(2012, 1, 1, 0, 0), mother.getTt1Date());
        assertEquals(new DateTime(2012, 1, 2, 0, 0), mother.getTt2Date());
        assertEquals(new DateTime(2012, 1, 3, 0, 0), mother.getAnc1Date());
        assertEquals(new DateTime(2012, 1, 4, 0, 0), mother.getAnc2Date());
        assertEquals(new DateTime(2012, 1, 5, 0, 0), mother.getAnc3Date());
        assertEquals(new DateTime(2012, 1, 6, 0, 0), mother.getAnc4Date());
        assertEquals(new DateTime(2012, 1, 7, 0, 0), mother.getTtBoosterDate());
        assertTrue(mother.getLastPregTt()=="yes");

    }

    @Test
    public void shouldMapToAMotherObjectWithEmptyFields(){
        CareCase careCase = new MotherCareCaseBuilder().withCaseId("").withCaseName("").withCaseType("").withAdd("").withEdd("").withDateModified("").withUserId("").withGroupId("").build();
        
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase mother = MotherMapper.map(careCase,flw,flwGroup);
        Assert.assertEquals("",mother.getCaseId());
        Assert.assertEquals(null,mother.getDateModified());
        Assert.assertEquals("",mother.getFlw().getFlwId());
        Assert.assertEquals("",mother.getCaseName());
        Assert.assertEquals("",mother.getFlwGroup().getGroupId());
        Assert.assertEquals(null,mother.getEdd());
        Assert.assertEquals(null,mother.getActualDeliveryDate());
    }

    @Test
    public void shouldMapToAMotherObjectWithNullFields(){
        CareCase careCase = new MotherCareCaseBuilder().withCaseId(null).withCaseName(null).withCaseType(null).withAdd(null).withEdd(null).withDateModified(null).withUserId(null).withGroupId(null).build();
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase mother = MotherMapper.map(careCase,flw,flwGroup);
        Assert.assertNull(mother.getCaseId());
        Assert.assertNull(mother.getDateModified());
        Assert.assertNull(mother.getFlw().getFlwId());
        Assert.assertNull(mother.getCaseName());
        Assert.assertNull(mother.getFlwGroup().getGroupId());
        Assert.assertNull(mother.getEdd());
        Assert.assertNull(mother.getActualDeliveryDate());
    }

    @Test
    public void shouldInferMotherAliveCorrectly(){
        
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase mother = MotherMapper.map(new MotherCareCaseBuilder().withMotherAlive("").build(),flw,flwGroup);
        assertTrue(mother.getIsAlive()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withMotherAlive(null).build(),flw,flwGroup);
        assertTrue(mother.getIsAlive()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withMotherAlive("yes").build(),flw,flwGroup);
        assertTrue(mother.getIsAlive()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withMotherAlive("random").build(),flw,flwGroup);
        assertTrue(mother.getIsAlive()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withMotherAlive("no").build(),flw,flwGroup);
        assertFalse(mother.getIsAlive()=="yes");
    }

    @Test
    public void shouldInferLastPregnancyCorrectly(){
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase mother = MotherMapper.map(new MotherCareCaseBuilder().withLastPregTT("").build(),flw,flwGroup);
        assertFalse(mother.getLastPregTt()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withLastPregTT(null).build(),flw,flwGroup);
        assertFalse(mother.getLastPregTt()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withLastPregTT("no").build(),flw,flwGroup);
        assertFalse(mother.getLastPregTt()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withLastPregTT("random").build(),flw,flwGroup);
        assertFalse(mother.getLastPregTt()=="yes");

        mother = MotherMapper.map(new MotherCareCaseBuilder().withLastPregTT("yes").build(),flw,flwGroup);
        assertTrue(mother.getLastPregTt()=="yes");
    }
}
