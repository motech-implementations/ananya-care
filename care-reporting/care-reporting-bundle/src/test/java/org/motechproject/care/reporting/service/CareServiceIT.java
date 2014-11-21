package org.motechproject.care.reporting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.care.reporting.builder.MotherCaseBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.DeathChildForm;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.mcts.care.common.mds.measure.RegistrationChildForm;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

// @ContextConfiguration("classpath:META-INF/motech/applicationCareReportingTest.xml")
// @Transactional
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class CareServiceIT extends BasePaxIT {

    @Inject
    private ICareService careService;

    @Inject
    MdsRepository dbRepository;

    @After
    public void tearDown() {
        dbRepository.deleteAll(NewForm.class);
        dbRepository.deleteAll(RegistrationChildForm.class);
        dbRepository.deleteAll(DeathChildForm.class);
        dbRepository.deleteAll(MotherCase.class);
        dbRepository.deleteAll(ChildCase.class);
        dbRepository.deleteAll(Flw.class);
        dbRepository.deleteAll(FlwGroup.class);
    }

    @Test//tested
    public void shouldSaveNewGroup() throws Exception {
        FlwGroup newGroup = new FlwGroupBuilder().groupId("group_id").name(
                "amir team 1").domain("care-mp").awcCode("007").caseSharing(
                true).reporting(true).build();
        careService.saveAll(Arrays.asList(newGroup));

        FlwGroup flwGroup = (FlwGroup) dbRepository.findByExternalPrimaryKey(
                FlwGroup.class, "group_id");
        assertNotNull(flwGroup);
        assertEquals("group_id", flwGroup.getGroupId());
        assertEquals("amir team 1", flwGroup.getName());
        assertEquals("care-mp", flwGroup.getDomain());
        assertEquals("007", flwGroup.getAwcCode());
        assertEquals(true, flwGroup.getCaseSharing());
        assertEquals(true, flwGroup.getReporting());

        dbRepository.delete(flwGroup);

        FlwGroup flwGroupAfterDeletion = (FlwGroup) dbRepository
                .findByExternalPrimaryKey(FlwGroup.class, "group_id");
        assertNull(flwGroupAfterDeletion);
    }

    @Test//tested
    public void shouldCreateNewFlw() {
        Flw newFlw = new FlwBuilder().flwId("flw_id").firstName("team 1")
                .build();

        careService.save(newFlw);

        Flw flw = (Flw) dbRepository.findByExternalPrimaryKey(Flw.class,
                "flw_id");
        assertNotNull(flw);
        assertEquals("flw_id", flw.getFlwId());
        assertEquals("team 1", flw.getFirstName());

        dbRepository.delete(flw);

        Flw flwAfterDeletion = (Flw) dbRepository.findByExternalPrimaryKey(
                Flw.class, "flw_id");
        assertNull(flwAfterDeletion);
    }

    @Test//tested
    public void shouldNotSaveMotherOrChildFormsIfNullAndEmpty() {
        careService.processAndSaveForms(null,
                new ArrayList<Map<String, String>>());

        List<MotherCase> mothers = dbRepository.retrieveAll(MotherCase.class);
        assertTrue(mothers.isEmpty());

        List<ChildCase> children = dbRepository.retrieveAll(ChildCase.class);
        assertTrue(children.isEmpty());
    }

    @Test//tested
    public void shouldSaveMotherFormForExistingCase() {
        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId("mother_case_id");
        dbRepository.save(motherCase);
        Flw flw = new Flw();
        flw.setFlwId("flw_id");
        dbRepository.save(flw);
        Map<String, String> motherForm = motherFormValues(motherCase
                .getCaseId(), flw.getFlwId());

        careService.processAndSaveForms(motherForm,
                new ArrayList<Map<String, String>>());

        List<MotherCase> persistedMotherCases = dbRepository
                .retrieveAll(MotherCase.class);
        assertEquals(1, persistedMotherCases.size());
        List<NewForm> newForms = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newForms);
        assertEquals(1, newForms.size());
        NewForm expectedForm = expectedForm(motherCase, flw);
        assertNotNull(expectedForm);

        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0), new
         * String[] { "id", "creationTime", "lastModifiedTime" });
         */

    }

    @Test//tested
    public void shouldSaveMotherFormAndCreateNewCase() {
        Map<String, String> motherForm = motherFormValues("mother_case_id",
                "flw_id");

        careService.processAndSaveForms(motherForm,
                new ArrayList<Map<String, String>>());

        List<MotherCase> persistedMotherCases = dbRepository
                .retrieveAll(MotherCase.class);
        assertNotNull(persistedMotherCases);
        assertEquals(1, persistedMotherCases.size());
        List<NewForm> newForms = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newForms);
        assertEquals(1, newForms.size());
        NewForm expectedForm = expectedForm(new MotherCaseBuilder().caseId(
                "mother_case_id").build(), new FlwBuilder().flwId("flw_id")
                .build());
        assertEquals("mother_case_id", newForms.get(0).getMotherCase()
                .getCaseId());
        assertEquals("flw_id", newForms.get(0).getFlw().getFlwId());
        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0), new
         * String[] { "id", "creationTime", "flw", "motherCase" });
         */

    }

    @Test//tested
    public void shouldSaveChildForm() {
        ArrayList<Map<String, String>> childFormValues = new ArrayList<>();
        HashMap<String, String> childFormValue = new HashMap<>();
        childFormValue.put("caseId", "child_case_id");
        childFormValue.put("xmlns",
                "http://bihar.commcarehq.org/pregnancy/registration");
        childFormValue.put("childName", "suraj");
        childFormValue.put("birthStatus", "healthy");
        childFormValue.put("instanceId", "instance_id");
        childFormValue.put("flw", "flw_id");
        childFormValue.put("timeStart", "2013-03-03T10:31:51.045+05:30");
        childFormValue.put("timeEnd", "2013-03-03T10:38:52.804+05:30");
        childFormValue.put("dateModified", "2013-03-03T10:38:52.804+05:30");

        childFormValues.add(childFormValue);

        careService.processAndSaveForms(null, childFormValues);

        List<RegistrationChildForm> registrationChildForms = dbRepository
                .retrieveAll(RegistrationChildForm.class);
        assertNotNull(registrationChildForms);
        assertEquals(1, registrationChildForms.size());

        RegistrationChildForm expectedForm = getExpectedForm("child_case_id");

        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(expectedForm, registrationChildForms
         * .get(0), new String[] { "id", "flw", "childCase", "creationTime",
         * "lastModifiedTime" });
         */

        List<Flw> flws = dbRepository.retrieveAll(Flw.class);
        assertNotNull(flws);
        assertEquals(1, flws.size());
        assertEquals("flw_id", flws.get(0).getFlwId());

    }

    @Test//tested
    public void shouldIgnoreMotherFormsWithoutXmlns() {
        Map<String, String> motherFormValuesWithoutXmlns = motherFormValues(
                "mother_case_id", "flw_id");
        motherFormValuesWithoutXmlns.remove("xmlns");

        try {
            careService.processAndSaveForms(motherFormValuesWithoutXmlns,
                    new ArrayList<Map<String, String>>());
        } catch (Exception e) {
            fail("The exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test//tested
    public void shouldNotThrowExceptionIfXmlnsNotRecognized() throws Exception {
        Map<String, String> motherFormValuesWithoutXmlns = motherFormValues(
                "mother_case_id", "flw_id");
        motherFormValuesWithoutXmlns.put("xmlns", "randomurl");

        try {
            careService.processAndSaveForms(motherFormValuesWithoutXmlns,
                    new ArrayList<Map<String, String>>());
        } catch (Exception e) {
            fail("The exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    public void shouldInsertAnEntityByExternalPrimaryKeyWhenDoesNotExists()
            throws Exception {
        HashMap<String, String> flwValues = new HashMap<String, String>() {
            {
                put("flwId", "flw_id");
                put("firstName", "FirstName1");
            }
        };
        careService.saveByExternalPrimaryKey(Flw.class, flwValues);

        List<Flw> flws = dbRepository.retrieveAll(Flw.class);

        Flw expectedFlw = new FlwBuilder().flwId("flw_id").firstName(
                "FirstName1").build();
        assertNotNull(flws);
        assertEquals(1, flws.size());
        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(expectedFlw, flws.get(0), new
         * String[] { "id", "flwGroups", "creationTime", "lastModifiedTime" });
         */

    }

    @Test
    public void shouldUpdateEntityByExternalPrimaryKeyWhenExists() {
        String caseId = "child_case_id";
        ChildCase existingChild = new ChildCase();
        existingChild.setCaseId(caseId);
        existingChild.setName("old Child name");
        dbRepository.save(existingChild);

        HashMap<String, String> updatedValues = new HashMap<String, String>() {
            {
                put("caseId", "child_case_id");
                put("name", "new child name");
            }
        };

        careService.saveByExternalPrimaryKey(ChildCase.class, updatedValues);

        List<ChildCase> childCases = dbRepository.retrieveAll(ChildCase.class);
        assertNotNull(childCases);
        assertEquals(1, childCases.size());

        ChildCase expectedChildCase = new ChildCase();
        expectedChildCase.setCaseId(caseId);
        expectedChildCase.setName("new child name");
        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(expectedChildCase,
         * childCases.get(0), new String[] { "id", "creationTime",
         * "lastModifiedTime" });
         */

    }

    @Test
    public void shouldDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasNewerDate() {
        NewForm persistedForm = new NewForm();
        persistedForm.setInstanceId("instance_id");
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-10T12:02:59.923+05:30");
        persistedForm.setDateModified(oldFormModifiedDate);
        persistedForm.setServerDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        final String newFormModifiedOn = "2012-07-20T12:02:59.923+05:30";
        final Date newFormModifiedDate = DateTime.parse(newFormModifiedOn)
                .toDate();

        Map<String, String> motherFormValues = new HashMap<String, String>() {
            {
                put("caseId", "case_id");
                put("dateModified", newFormModifiedOn);
                put("serverDateModified", newFormModifiedOn);
                put("userId", "user_id");
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
                put("instanceId", "instance_id");
            }
        };

        careService.processAndSaveForms(motherFormValues,
                new ArrayList<Map<String, String>>());

        List<NewForm> newFormsFromDb = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newFormsFromDb);
        assertEquals(1, newFormsFromDb.size());
        assertEquals(newFormModifiedDate, newFormsFromDb.get(0)
                .getDateModified());
        //TODO: more asserts

    }

    @Test
    public void shouldDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasSameDate() {
        NewForm persistedForm = new NewForm();
        persistedForm.setInstanceId("instance_id");
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-10T12:02:59.923+05:30");
        persistedForm.setCaste("OldCaste");
        persistedForm.setDateModified(oldFormModifiedDate);
        persistedForm.setServerDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30";
        final Date newFormModifiedDate = DateTime.parse(newFormModifiedOn)
                .toDate();
        final String newCaste = "NewCaste";

        Map<String, String> motherFormValues = new HashMap<String, String>() {
            {
                put("caseId", "case_id");
                put("dateModified", newFormModifiedOn);
                put("serverDateModified", newFormModifiedOn);
                put("userId", "user_id");
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
                put("instanceId", "instance_id");
                put("caste", newCaste);
            }
        };

        careService.processAndSaveForms(motherFormValues,
                new ArrayList<Map<String, String>>());

        List<NewForm> newFormsFromDb = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newFormsFromDb);
        assertEquals(1, newFormsFromDb.size());
        assertEquals(newFormModifiedDate, newFormsFromDb.get(0)
                .getDateModified());
        assertEquals(newCaste, newFormsFromDb.get(0).getCaste());

        dbRepository.delete(newFormsFromDb.get(0));
    }

    @Test
    public void shouldDeleteEarlierFormIfBothNewerAndOlderMotherFormWithSameInstanceIdHasNullDate() {
        NewForm persistedForm = new NewForm();
        persistedForm.setInstanceId("instance_id");

        persistedForm.setCaste("OldCaste");
        persistedForm.setServerDateModified(null);
        dbRepository.save(persistedForm);

        final String newCaste = "NewCaste";

        Map<String, String> motherFormValues = new HashMap<String, String>() {
            {
                put("caseId", "case_id");
                put("serverDateModified", null);
                put("userId", "user_id");
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
                put("instanceId", "instance_id");
                put("caste", newCaste);
            }
        };

        careService.processAndSaveForms(motherFormValues,
                new ArrayList<Map<String, String>>());

        List<NewForm> newFormsFromDb = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newFormsFromDb);
        assertEquals(1, newFormsFromDb.size());
        assertNull(newFormsFromDb.get(0).getDateModified());
        assertEquals(newCaste, newFormsFromDb.get(0).getCaste());

        //TODO: more asserts
    }

    @Test
    public void shouldNotDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasNullDate() {
        NewForm persistedForm = new NewForm();
        persistedForm.setInstanceId("instance_id");
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-20T12:02:59.923+05:30");
        persistedForm.setServerDateModified(oldFormModifiedDate);
        persistedForm.setDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        Map<String, String> motherFormValues = new HashMap<String, String>() {
            {
                put("caseId", "case_id");
                put("dateModified", null);
                put("serverDateModified", null);
                put("userId", "user_id");
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
                put("instanceId", "instance_id");
            }
        };

        careService.processAndSaveForms(motherFormValues,
                new ArrayList<Map<String, String>>());

        List<NewForm> newFormsFromDb = dbRepository.retrieveAll(NewForm.class);
        assertNotNull(newFormsFromDb);
        assertEquals(1, newFormsFromDb.size());
        assertEquals(oldFormModifiedDate, newFormsFromDb.get(0)
                .getDateModified());

        //TODO: more asserts
    }

    @Test
    public void shouldNotDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasOldDate() {
        NewForm persistedForm = new NewForm();
        persistedForm.setInstanceId("instance_id");
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-20T12:02:59.923+05:30");
        persistedForm.setDateModified(oldFormModifiedDate);
        persistedForm.setDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30";

        Map<String, String> motherFormValues = new HashMap<String, String>() {
            {
                put("caseId", "case_id");
                put("dateModified", newFormModifiedOn);
                put("serverDateModified", newFormModifiedOn);
                put("userId", "user_id");
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
                put("instanceId", "instance_id");
            }
        };

        careService.processAndSaveForms(motherFormValues,
                new ArrayList<Map<String, String>>());

        List<NewForm> newFormsFromDb = dbRepository.retrieveAll(NewForm.class);

        assertEquals(1, newFormsFromDb.size());
        assertEquals(oldFormModifiedDate, newFormsFromDb.get(0)
                .getDateModified());
        //TODO: more asserts
    }

    @Test
    public void shouldSaveChildFormByDeletingOlderFormIfFormWithSameInstanceIdAndCaseIdExistsAlready() {
        final String instanceId = "instance_id";
        final String caseId = "case_id";
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-10T12:02:59.923+05:30");

        ChildCase persistedChildCase = new ChildCase();
        persistedChildCase.setCaseId(caseId);

        final DeathChildForm persistedForm = new DeathChildForm();
        persistedForm.setInstanceId(instanceId);
        persistedForm.setChildCase(persistedChildCase);
        persistedForm.setDateModified(oldFormModifiedDate);
        persistedForm.setServerDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        final String newFormModifiedOn = "2012-07-20T12:02:59.923+05:30";
        final Date newFormModifiedDate = DateTime.parse(newFormModifiedOn)
                .toDate();
        final HashMap<String, String> deathChildFormValues = new HashMap<String, String>() {
            {
                put("caseId", caseId);
                put("dateModified", newFormModifiedOn);
                put("serverDateModified", newFormModifiedOn);
                put("userId", "user_id");
                put("close", "true");
                put("instanceId", instanceId);
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/death");
            }
        };

        careService.processAndSaveForms(null,
                new ArrayList<Map<String, String>>() {
                    {
                        add(deathChildFormValues);
                    }
                });

        List<DeathChildForm> deathChildForms = dbRepository
                .retrieveAll(DeathChildForm.class);
        assertNotNull(deathChildForms);
        assertEquals(1, deathChildForms.size());
        assertEquals(newFormModifiedDate, deathChildForms.get(0)
                .getDateModified());
        //TODO: more asserts

    }

    @Test
    public void shouldNotDeleteEarlierFormIfNewerChildFormWithSameInstanceIdAndCaseIdHasOldDate() {
        final String instanceId = "instance_id";
        final String caseId = "case_id";
        final DateTime oldFormModifiedDate = DateTime
                .parse("2012-07-20T12:02:59.923+05:30");

        ChildCase persistedChildCase = new ChildCase();
        persistedChildCase.setCaseId(caseId);

        final DeathChildForm persistedForm = new DeathChildForm();
        persistedForm.setInstanceId(instanceId);
        persistedForm.setChildCase(persistedChildCase);
        persistedForm.setDateModified(oldFormModifiedDate);
        persistedForm.setServerDateModified(oldFormModifiedDate);
        dbRepository.save(persistedForm);

        final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30";
        final HashMap<String, String> deathChildFormValues = new HashMap<String, String>() {
            {
                put("caseId", caseId);
                put("dateModified", newFormModifiedOn);
                put("serverDateModified", newFormModifiedOn);
                put("userId", "user_id");
                put("close", "true");
                put("instanceId", instanceId);
                put("xmlns", "http://bihar.commcarehq.org/pregnancy/death");
            }
        };

        careService.processAndSaveForms(null,
                new ArrayList<Map<String, String>>() {
                    {
                        add(deathChildFormValues);
                    }
                });

        List<DeathChildForm> deathChildForms = dbRepository
                .retrieveAll(DeathChildForm.class);
        assertNotNull(deathChildForms);
        assertEquals(1, deathChildForms.size());
        assertEquals(oldFormModifiedDate, deathChildForms.get(0)
                .getDateModified());
        //TODO: more asserts

    }

    @Test
    public void shouldSaveFlwOnceForMotherAndChild() {
        final String flwId = "flw_id";
        final String instanceId = "instance_id";
        HashMap<String, String> motherCase = new HashMap<String, String>() {
            {
                put("caseId", "mother_case_id");
                put("userId", flwId);
                put("flw", flwId);
                put("instanceId", instanceId);
                put("xmlns",
                        "http://bihar.commcarehq.org/pregnancy/registration");
            }
        };

        final HashMap<String, String> child1 = new HashMap<String, String>() {
            {
                put("caseId", "child_case_id1");
                put("userId", flwId);
                put("flw", flwId);
                put("instanceId", instanceId);
                put("xmlns",
                        "http://bihar.commcarehq.org/pregnancy/registration");
            }
        };

        final HashMap<String, String> child2 = new HashMap<String, String>() {
            {
                put("caseId", "child_case_id2");
                put("userId", flwId);
                put("flw", flwId);
                put("instanceId", instanceId);
                put("xmlns",
                        "http://bihar.commcarehq.org/pregnancy/registration");
            }
        };

        careService.processAndSaveForms(motherCase,
                new ArrayList<Map<String, String>>() {
                    {
                        add(child1);
                        add(child2);
                    }
                });

        List<Flw> actualFlws = dbRepository.retrieveAll(Flw.class);
        assertNotNull(actualFlws);
        assertEquals(1, actualFlws.size());
        //TODO: asserts
       /* assertReflectionEqualsWithIgnore(flw, actualFlws.get(0), new String[] {
                "id", "creationTime", "lastModifiedTime" });*/

    }

    @Test //tested
    public void shouldSearchExistingFlwsAndUpdateFlw() {
        Flw toBeUpdatedFlw = flw("flw_id1", "FirstName1",
                flwGroupWithNameAndId("group_id1", "oldGroupName"));
        Flw notToBeUpdateFlw = flw("flw_id2", "FirstName2", new FlwGroup());
        dbRepository.saveOrUpdateAll(Arrays.asList(toBeUpdatedFlw,
                notToBeUpdateFlw));

        Flw newFlw = flw("flw_id1", "FirstName3", flwGroupWithNameAndId(
                "group_id2", "newGroupName"));
        ArrayList<Flw> flwsToUpdate = new ArrayList<>();
        flwsToUpdate.add(newFlw);

        careService
                .saveOrUpdateAllByExternalPrimaryKey(Flw.class, flwsToUpdate);

        Flw updatedFlw = dbRepository.findByExternalPrimaryKey(Flw.class,
                toBeUpdatedFlw.getFlwId());
        assertNotNull(updatedFlw);
        //TODO: asserts
        /*
         * assertReflectionEqualsWithIgnore(newFlw, updatedFlw, new
         * String[]{"id", "creationTime", "lastModifiedTime"});
         */

        Flw unchangedFlw = dbRepository.findByExternalPrimaryKey(Flw.class,
                notToBeUpdateFlw.getFlwId());
        assertNotNull(unchangedFlw);
        assertEquals("FirstName2", unchangedFlw.getFirstName());

    }

    private Map<String, String> motherFormValues(String caseId, String flwId) {
        Map<String, String> motherForm = new HashMap<>();
        motherForm.put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
        motherForm.put("dateModified", "2012-07-21T12:02:59.923+05:30");
        motherForm
                .put("fullName",
                        "&#2327;&#2366;&#2351;&#2340;&#2381;&#2352;&#2368; &#2342;&#2375;&#2357;&#2368;");
        motherForm
                .put("husbandName",
                        "&#2342;&#2367;&#2344;&#2375;&#2358; &#2350;&#2369;&#2326;&#2367;&#2351;&#2366;");
        motherForm.put("hhNumber", "165");
        motherForm.put("familyNumber", "5");
        motherForm.put("dobKnown", "no");
        motherForm.put("caste", "other");
        motherForm.put("ageCalc", null);
        motherForm.put("instanceId", "instance_id");
        motherForm.put("motherCase", caseId);
        motherForm.put("flw", flwId);
        motherForm.put("timeStart", "2012-07-21T11:59:31.076+05:30");
        motherForm.put("timeEnd", "2012-07-21T12:02:59.923+05:30");
        return motherForm;
    }

    private NewForm expectedForm(MotherCase motherCase, Flw flw) {
        NewForm expectedForm = new NewForm();
        expectedForm.setDateModified(new DateTime(2012, 7, 21, 12, 2, 59, 923,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedForm
                .setFullName("&#2327;&#2366;&#2351;&#2340;&#2381;&#2352;&#2368; &#2342;&#2375;&#2357;&#2368;");
        expectedForm
                .setHusbandName("&#2342;&#2367;&#2344;&#2375;&#2358; &#2350;&#2369;&#2326;&#2367;&#2351;&#2366;");
        expectedForm.setHhNumber(165);
        expectedForm.setFamilyNumber(5);
        expectedForm.setDobKnown("no");
        expectedForm.setCaste("other");
        expectedForm.setAgeCalc(0);
        expectedForm.setInstanceId("instance_id");
        expectedForm.setMotherCase(motherCase);
        expectedForm.setFlw(flw);
        expectedForm.setTimeStart(new DateTime(2012, 7, 21, 11, 59, 31, 76,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedForm.setTimeEnd(new DateTime(2012, 7, 21, 12, 2, 59, 923,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        return expectedForm;
    }

    private RegistrationChildForm getExpectedForm(String caseId) {
        ChildCase expectedChildCase = new ChildCase();
        expectedChildCase.setCaseId(caseId);

        Flw expectedFlw = new Flw();
        expectedFlw.setFlwId("flw_id");

        RegistrationChildForm expectedChildForm = new RegistrationChildForm();
        expectedChildForm.setChildCase(expectedChildCase);
        expectedChildForm.setFlw(expectedFlw);
        expectedChildForm.setDateModified(new DateTime(2013, 3, 3, 10, 38, 52,
                804, DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedChildForm.setChildName("suraj");
        expectedChildForm.setBirthStatus("healthy");
        expectedChildForm.setInstanceId("instance_id");
        expectedChildForm.setTimeStart(new DateTime(2013, 3, 3, 10, 31, 51, 45,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedChildForm.setTimeEnd(new DateTime(2013, 3, 3, 10, 38, 52, 804,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));

        return expectedChildForm;
    }

    private Flw flw(String flwId, String firstName, final FlwGroup flwGroup) {
        return new FlwBuilder().flwId(flwId).firstName(firstName)
                .build();
    }

    private FlwGroup flwGroupWithNameAndId(String groupId, String name) {
        return new FlwGroupBuilder().groupId(groupId).name(name).build();
    }

}
