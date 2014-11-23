package org.motechproject.care.service.mapper;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.care.request.CareCase;
import org.motechproject.care.service.builder.ChildCareCaseBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

import static junit.framework.Assert.*;

public class ChildMapperTest {

    @Test
    public void shouldMapToAChildObject(){
        CareCase careCase = new ChildCareCaseBuilder().build();
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("motherCaseId");
        ChildCase child = ChildMapper.map(careCase,flw,flwGroup,motherCase);
        assertEquals("6055b3ec-bec6-46cc-9e72-435ebc4eaec1", child.getCaseId());
        assertEquals(new DateTime(2012, 3, 4, 0, 0), child.getDateModified());
        assertEquals("b823ea3d392a06f8b991e9e4933348bd", child.getFlw().getFlwId());
        assertEquals("Pinky", child.getName());
        assertEquals("112", child.getFlwGroup().getGroupId());
        assertEquals("motherCaseId", child.getMotherCase().getCaseId());
        assertEquals(new DateTime(2012, 1, 1, 0, 0), child.getBcgTime());
        assertEquals(new DateTime(2012, 1, 2, 0, 0), child.getVitA1Time());
        assertEquals(new DateTime(2012, 1, 2, 0, 0), child.getMeaslesTime());
        assertEquals(new DateTime(2012, 1, 2, 0, 0), child.getHepB0Time());
        assertEquals(new DateTime(2012, 2, 2, 0, 0), child.getHepB1Time());
        assertEquals(new DateTime(2012, 3, 2, 0, 0), child.getHepB2Time());
        assertEquals(new DateTime(2012, 4, 2, 0, 0), child.getHepB3Time());
        assertEquals(new DateTime(2012, 8, 2, 0, 0), child.getDpt1Time());
        assertEquals(new DateTime(2012, 9, 2, 0, 0), child.getDpt2Time());
        assertEquals(new DateTime(2012, 10, 2, 0, 0), child.getDpt3Time());
        assertEquals(new DateTime(2012, 11, 2, 0, 0), child.getDptBoosterTime());
        assertEquals(new DateTime(2012, 1, 2, 0, 0), child.getOpv0Time());
        assertEquals(new DateTime(2012, 2, 2, 0, 0), child.getOpv1Time());
        assertEquals(new DateTime(2012, 3, 2, 0, 0), child.getOpv2Time());
        assertEquals(new DateTime(2012, 4, 2, 0, 0), child.getOpv3Time());
        assertEquals(new DateTime(2012, 5, 2, 0, 0), child.getOpvBoosterTime());

    }

    @Test
    public void shouldMapToAChildObjectWithEmptyFields(){
        CareCase careCase = new ChildCareCaseBuilder().withCaseId("").withCaseName("").withCaseType("").withDateModified("").withUserId("").withGroupId("").withBcgDate("").withMeaslesDate("").withVitamin1Date("")
                .withHep0Date("").withHep1Date("").withHep2Date("").withHep3Date("")
                .withDpt1Date("").withDpt2Date("").withDpt3Date("").withDptBoosterDate("").withOPV0Date("").withOPV1Date("").withOPV2Date("").withOPV3Date("").withOPVBoosterDate("").build();
        
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("motherCaseId");
        
        
        ChildCase child = ChildMapper.map(careCase,flw,flwGroup,motherCase);
        assertEquals("", child.getCaseId());
        assertEquals(null, child.getDateModified());
        assertEquals("", child.getFlw().getFlwId());
        assertEquals("", child.getName());
        assertEquals("", child.getFlwGroup().getGroupId());
        assertEquals(null, child.getBcgTime());
        assertEquals(null, child.getMeaslesTime());
        assertEquals(null, child.getVitA1Time());
        assertEquals(null, child.getHepB0Time());
        assertEquals(null, child.getHepB1Time());
        assertEquals(null, child.getHepB2Time());
        assertEquals(null, child.getHepB3Time());
        assertEquals(null, child.getDpt1Time());
        assertEquals(null, child.getDpt2Time());
        assertEquals(null, child.getDpt3Time());
        assertEquals(null, child.getDptBoosterTime());
        assertEquals(null, child.getOpv0Time());
        assertEquals(null, child.getOpv1Time());
        assertEquals(null, child.getOpv2Time());
        assertEquals(null, child.getOpv3Time());
        assertEquals(null, child.getOpvBoosterTime());
    }

    @Test
    public void shouldMapToAMotherObjectWithNullFields(){
        CareCase careCase = new ChildCareCaseBuilder().withCaseId(null).withCaseName(null).withCaseType(null).withBcgDate(null).withMeaslesDate(null).withDateModified(null).withUserId(null).withGroupId(null).withVitamin1Date(null)
                .withHep0Date(null).withHep1Date(null).withHep2Date(null).withHep3Date(null)
                .withDpt1Date(null).withDpt2Date(null).withDpt3Date(null).withDptBoosterDate(null).withOPV0Date(null).withOPV1Date(null).withOPV2Date(null).withOPV3Date(null).withOPVBoosterDate(null).build();

        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("motherCaseId");
        
        ChildCase child = ChildMapper.map(careCase,flw,flwGroup,motherCase);
        assertNull(child.getCaseId());
        assertNull(child.getDateModified());
        assertNull(child.getFlw().getFlwId());
        assertNull(child.getName());
        assertNull(child.getFlwGroup().getGroupId());
        assertNull(child.getBcgTime());
        assertNull(child.getMeaslesTime());
        assertNull(child.getVitA1Time());
        assertNull(child.getHepB0Time());
        assertNull(child.getHepB1Time());
        assertNull(child.getHepB2Time());
        assertNull(child.getHepB3Time());
        assertNull(child.getDpt1Time());
        assertNull(child.getDpt2Time());
        assertNull(child.getDpt3Time());
        assertNull(child.getDptBoosterTime());
        assertNull(child.getOpv0Time());
        assertNull(child.getOpv1Time());
        assertNull(child.getOpv2Time());
        assertNull(child.getOpv3Time());
        assertNull(child.getOpvBoosterTime());
    }

    @Test
    public void shouldInferChildAliveCorrectly(){
        Flw flw = new Flw();
        flw.setFlwId("flwId");
        
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId("groupId");
        
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("motherCaseId");
        ChildCase child = ChildMapper.map(new ChildCareCaseBuilder().withChildAlive("").build(),flw,flwGroup,motherCase);
        assertTrue(child.getIsAlive()=="yes");

        child =ChildMapper.map(new ChildCareCaseBuilder().withChildAlive(null).build(),flw,flwGroup,motherCase);
        assertTrue(child.getIsAlive()=="yes");

        child =ChildMapper.map(new ChildCareCaseBuilder().withChildAlive("yes").build(),flw,flwGroup,motherCase);
        assertTrue(child.getIsAlive()=="yes");

        child =ChildMapper.map(new ChildCareCaseBuilder().withChildAlive("random").build(),flw,flwGroup,motherCase);
        assertTrue(child.getIsAlive()=="yes");

        child =ChildMapper.map(new ChildCareCaseBuilder().withChildAlive("no").build(),flw,flwGroup,motherCase);
        assertFalse(child.getIsAlive()=="yes");
    }


}
