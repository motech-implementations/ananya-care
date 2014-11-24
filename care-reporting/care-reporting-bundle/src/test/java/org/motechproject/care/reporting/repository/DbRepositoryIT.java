package org.motechproject.care.reporting.repository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionContains;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionDoesNotContains;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.unitils.reflectionassert.ReflectionAssert;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class DbRepositoryIT  extends BasePaxIT {

    @Autowired
    private Repository dbRepository;

    @Before
    @After
    public void setUp() {
        dbRepository.deleteAll(NewForm.class);
        dbRepository.deleteAll(ChildCase.class);
        dbRepository.deleteAll(MotherCase.class);
        dbRepository.deleteAll(Flw.class);
        dbRepository.deleteAll(FlwGroup.class);
    }

    @Test
    public void shouldGetByMatchingCriteria() {
        NewForm form = new NewForm();
        form.setCaseName("mother");
        form.setInstanceId("abcd");
        dbRepository.save(form);

        NewForm newForm = dbRepository.get(NewForm.class, "caseName", "mother");

        assertEquals("abcd", newForm.getInstanceId());
        assertEquals("mother", newForm.getCaseName());
    }

    @Test
    public void shouldGetByNonMatchingCriteria(){

        NewForm newForm = dbRepository.get(NewForm.class, "caseName", "father");

        assertNull(newForm);
    }

    @Test
    public void shouldPerformCascadeSaveOnFlw(){
        Flw flw = new Flw();
        HashSet<FlwGroup> flwGroups = new HashSet<>();
        flwGroups.add(new FlwGroup());
        flwGroups.add(new FlwGroup());

        flw.setFlwGroups(flwGroups);

        dbRepository.save(flw);

        List<Flw> savedFlws = dbRepository.retrieveAll(Flw.class);
        List<FlwGroup> savedFlwGroups = dbRepository.retrieveAll(FlwGroup.class);
        assertEquals(1, savedFlws.size());
        assertEquals(2, savedFlwGroups.size());
        assertEquals(flw, savedFlws.get(0));

        assertEquals(flwGroups, savedFlws.get(0).getFlwGroups());
    }

    @Test
    public void shouldSaveOrUpdateAll(){
        final FlwGroup existingFlwGroup = new FlwGroup();
        existingFlwGroup.setName("group1");
        final FlwGroup newFlwGroup = new FlwGroup();
        newFlwGroup.setName("group2");
        List<FlwGroup> flwGroups = new ArrayList<FlwGroup>() {{
            add(existingFlwGroup);
            add(newFlwGroup);
        }};
        dbRepository.save(existingFlwGroup);
        existingFlwGroup.setName("changedGroupName");

        dbRepository.saveOrUpdateAll(flwGroups);

        List<FlwGroup> flwGroupsFromDb = dbRepository.retrieveAll(FlwGroup.class);
        assertEquals(2, flwGroupsFromDb.size());
        assertTrue(flwGroupsFromDb.contains(existingFlwGroup));
        assertTrue(flwGroupsFromDb.contains(newFlwGroup));
    }

    @Test
    public void shouldFindAllGroupsByGroupId(){
        FlwGroup flwGroup1 = flwGroupWithId("5ba9a0928dde95d187544babf6c0ad24");
        FlwGroup flwGroup2 = flwGroupWithId("5ba9a0928dde95d187544babf6c0af36");
        FlwGroup flwGroup3 = flwGroupWithId("5ba9a0928dde95d187544babf6c0ag48");
        dbRepository.saveOrUpdateAll(Arrays.asList(
                flwGroup1,
                flwGroup2,
                flwGroup3));

        List<FlwGroup> groupsFromDb = dbRepository.findAllByField(FlwGroup.class, Arrays.asList("5ba9a0928dde95d187544babf6c0ad24","5ba9a0928dde95d187544babf6c0af36"), "groupId");

        assertEquals(2, groupsFromDb.size());
        assertReflectionContains(flwGroup1, groupsFromDb);
        assertReflectionContains(flwGroup2, groupsFromDb);
        assertReflectionDoesNotContains(flwGroup3, groupsFromDb);
    }

    private FlwGroup flwGroupWithId(String groupId) {
        return new FlwGroupBuilder().groupId(groupId).build();
    }

    @Test
    public void shouldSaveCase() {
        String flwId = "flwId";
        String groupId = "groupId";
        String caseId = "caseId";
        Flw flw = new Flw();
        flw.setFlwId(flwId);
        FlwGroup flwGroup = new FlwGroup();
        flwGroup.setGroupId(groupId);
        MotherCase expectedMother = new MotherCase();
        expectedMother.setCaseId(caseId);
        expectedMother.setFlw(flw);
        expectedMother.setFlwGroup(flwGroup);

        dbRepository.save(expectedMother);

        List<MotherCase> motherCases = dbRepository.retrieveAll(MotherCase.class);
        assertEquals(1, motherCases.size());
        MotherCase actualMother = motherCases.get(0);
        assertEquals(caseId, actualMother.getCaseId());
        assertEquals(flwId, actualMother.getFlw().getFlwId());
        assertEquals(groupId, actualMother.getFlwGroup().getGroupId());
    }

    @Test
    public void shouldFindByExternalPrimaryKey() throws Exception {
        Flw flw = new FlwBuilder().flwId("5ba9a0928dde95d187544babf6c0ad24").build();
        dbRepository.save(flw);

        Flw flwFromDb = dbRepository.findByExternalPrimaryKey(Flw.class, "5ba9a0928dde95d187544babf6c0ad24");

        assertReflectionEqualsWithIgnore(flw, flwFromDb);
    }

    @Test
    public void shouldReturnNullIfCannotFindByExternalPrimaryKey() throws Exception {
        assertNull(dbRepository.findByExternalPrimaryKey(Flw.class, "5ba9a0928dde95d187544babf6c0ad00"));
    }

    @Test
    public void shouldFetchFromDbGivenBasedOnMultipleNestedFields(){
        final String caseId = "myCaseId";
        final String instanceId = "myInstanceId";
        NewForm form = new NewForm();
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId(caseId);
        form.setMotherCase(motherCase);
        form.setInstanceId(instanceId);
        dbRepository.save(form);
        Map<String, Object> fieldMap = new HashMap<String, Object>() {{
            put("mc.caseId", caseId);
            put("instanceId", instanceId);
        }};
        Map<String, String> aliasMapping = new HashMap<String, String>() {{
            put("motherCase", "mc");
        }};

        NewForm actualFormFromDb = dbRepository.get(NewForm.class, fieldMap, aliasMapping);

        assertEquals(instanceId, actualFormFromDb.getInstanceId());
        assertEquals(caseId, actualFormFromDb.getMotherCase().getCaseId());
    }

    @Test
    public void shouldDeleteForm(){
        NewForm form = new NewForm();
        form.setCaseName("mother");
        form.setInstanceId("abcd");
        dbRepository.save(form);

        NewForm newFormBeforeDelete = dbRepository.get(NewForm.class, "caseName", "mother");
        assertNotNull(newFormBeforeDelete);

        dbRepository.delete(form);

        NewForm newFormAfterDelete = dbRepository.get(NewForm.class, "caseName", "mother");
        assertNull(newFormAfterDelete);
    }


    @Test
    public void shouldExecuteSQL(){
        Object result = dbRepository.execute("Select 10");
        ReflectionAssert.assertReflectionEquals(10, result);
    }

}
