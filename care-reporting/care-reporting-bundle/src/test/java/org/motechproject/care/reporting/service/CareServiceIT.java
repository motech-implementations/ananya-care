package org.motechproject.care.reporting.service;

import static org.junit.Assert.assertEquals;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionContains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
import org.motechproject.mcts.care.common.mds.measure.RegistrationChildForm;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration("classpath:META-INF/motech/applicationCareReportingTest.xml")
// @Transactional
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class CareServiceIT extends BasePaxIT {

    @Autowired
    private Service careService;

    /*@Autowired
    MdsRepository dbRepository;*/

    /*
     * @Autowired
     *
     * @Qualifier("testDataAccessTemplate") protected TestDataAccessTemplate
     * template;
     */

    @Before
    @After
    public void setUp() {
        // template.setAlwaysUseNewSession(false);
        // template.deleteAll(template.loadAll(FlwGroup.class));
    }

    private List<Object> toDelete = new ArrayList<Object>();

    protected void markForDeletion(Object entity) {
        toDelete.add(entity);
    }

    protected void tearDown() {
        // template.deleteAll(toDelete);
    }

    @Test
    public void shouldSearchForExistingGroupBeforeUpdating() throws Exception {
        System.out.println("**************************************!!");
        FlwGroup toBeUpdatedGroup = new FlwGroupBuilder().groupId(
                "5ba9a0928dde95d187544babf6c0ad24").name("afrisis team 1")
                .domain("care-bihar").awcCode("001").caseSharing(true)
                .reporting(true).build();
        FlwGroup notToBeUpdatedGroup = flwGroupWithNameAndId(
                "5ba9a0928dde95d187544babf6c0af36", "ashok team 1");

        /*
         * template.saveOrUpdateAll(Arrays.asList(toBeUpdatedGroup,
         * notToBeUpdatedGroup));
         */

        FlwGroup updatedGroup = updatedGroup();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> checking for care service null " + careService == null);
        /*careService.saveOrUpdateAllByExternalPrimaryKey(FlwGroup.class, Arrays
                .asList(updatedGroup));*/

        // TODO: uncomment below

        /*
         * FlwGroup loadedFlwGroup = template.load(FlwGroup.class,
         * toBeUpdatedGroup.getId()); FlwGroup unchangedFlwGroup =
         * template.load(FlwGroup.class, notToBeUpdatedGroup.getId());
         * assertReflectionEqualsWithIgnore(updatedGroup(), loadedFlwGroup, new
         * String[]{"id", "creationTime", "lastModifiedTime"});
         * assertDateIgnoringSeconds(new Date(),
         * loadedFlwGroup.getCreationTime()); assertDateIgnoringSeconds(new
         * Date(), loadedFlwGroup.getLastModifiedTime());
         * assertEquals("ashok team 1", unchangedFlwGroup.getName());
         */
    }

    /*@Test
    public void shouldSaveNewGroup() throws Exception {
        FlwGroup newGroup = new FlwGroupBuilder().groupId(
                "5ba9a0928dde95d187544babf6c0ad24").name("amir team 1").domain(
                "care-mp").awcCode("007").caseSharing(true).reporting(true)
                .build();

        careService.saveOrUpdateAllByExternalPrimaryKey(FlwGroup.class, Arrays
                .asList(newGroup));

        List<FlwGroup> flwGroupsFromDb = dbRepository
                .retrieveAll(FlwGroup.class);
        assertEquals(1, flwGroupsFromDb.size());
        assertReflectionContains(newGroup, flwGroupsFromDb,
                new String[] { "id" });
    }*/

    /*
     * @Test public void shouldSearchExistingFlwsAndUpdateFlw() { Flw
     * toBeUpdatedFlw = flw("5ba9a0928dde95d187544babf6c0ad24", "FirstName1",
     * flwGroupWithNameAndId( "64a9a0928dde95d187544babf6c0ad38",
     * "oldGroupName")); Flw notToBeUpdateFlw =
     * flw("5ba9a0928dde95d187544babf6c0ad25", "FirstName2", new FlwGroup());
     * template.saveOrUpdateAll(Arrays .asList(toBeUpdatedFlw,
     * notToBeUpdateFlw));
     * 
     * Flw newFlw = flw("5ba9a0928dde95d187544babf6c0ad24", "FirstName3",
     * flwGroupWithNameAndId("38a9a0928dde95d187544babf6c0ad64",
     * "newGroupName")); ArrayList<Flw> flwsToUpdate = new ArrayList<>();
     * flwsToUpdate.add(newFlw);
     * 
     * careService .saveOrUpdateAllByExternalPrimaryKey(Flw.class,
     * flwsToUpdate);
     * 
     * // TODO: uncomment below
     * 
     * 
     * Flw updatedFlw = template.load(Flw.class, toBeUpdatedFlw.getId());
     * assertReflectionEqualsWithIgnore(newFlw, updatedFlw, new String[]{"id",
     * "creationTime", "lastModifiedTime"});
     * 
     * assertDateIgnoringSeconds(new Date(), updatedFlw.getCreationTime());
     * assertDateIgnoringSeconds(new Date(), updatedFlw.getLastModifiedTime());
     * Flw unchangedFlw = template.load(Flw.class, notToBeUpdateFlw.getId());
     * assertEquals("FirstName2", unchangedFlw.getFirstName());
     * 
     * }
     * 
     * @Test public void shouldCreateNewFlw() { Flw newFlw =
     * flw("5ba9a0928dde95d187544babf6c0ad24", "FirstName1",
     * flwGroupWithNameAndId("64a9a0928dde95d187544babf6c0ad38",
     * "oldGroupName"));
     * 
     * careService.saveOrUpdateAllByExternalPrimaryKey(Flw.class, Arrays
     * .asList(newFlw));
     * 
     * List<Flw> flwsFromDb = template.loadAll(Flw.class); assertEquals(1,
     * flwsFromDb.size()); assertReflectionContains(newFlw, flwsFromDb, new
     * String[] { "id" }); }
     * 
     * @Test public void shouldNotSaveMotherOrChildFormsIfNullAndEmpty() {
     * careService.processAndSaveForms(null, new ArrayList<Map<String,
     * String>>());
     * 
     * List<MotherCase> mothers = template.loadAll(MotherCase.class);
     * assertTrue(mothers.isEmpty());
     * 
     * List<ChildCase> children = template.loadAll(ChildCase.class);
     * assertTrue(children.isEmpty()); }
     * 
     * @Test public void shouldSaveMotherFormForExistingCase() { MotherCase
     * motherCase = new MotherCase();
     * motherCase.setCaseId("94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * template.save(motherCase); Flw flw = new Flw();
     * flw.setFlwId("89fda0284e008d2e0c980fb13fa0e5bb"); template.save(flw);
     * Map<String, String> motherForm = motherFormValues(motherCase
     * .getCaseId(), flw.getFlwId());
     * 
     * careService.processAndSaveForms(motherForm, new ArrayList<Map<String,
     * String>>());
     * 
     * List<MotherCase> persistedMotherCases = template
     * .loadAll(MotherCase.class); assertEquals(1, persistedMotherCases.size());
     * List<NewForm> newForms = template.loadAll(NewForm.class); assertEquals(1,
     * newForms.size()); NewForm expectedForm = expectedForm(motherCase, flw);
     * assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0), new
     * String[] { "id", "creationTime", "lastModifiedTime" }); }
     * 
     * @Test public void shouldSaveMotherFormAndCreateNewCase() { Map<String,
     * String> motherForm = motherFormValues(
     * "94d5374f-290e-409f-bc57-86c2e4bcc43f",
     * "89fda0284e008d2e0c980fb13fa0e5bb");
     * 
     * careService.processAndSaveForms(motherForm, new ArrayList<Map<String,
     * String>>());
     * 
     * List<MotherCase> persistedMotherCases = template
     * .loadAll(MotherCase.class); assertEquals(1, persistedMotherCases.size());
     * List<NewForm> newForms = template.loadAll(NewForm.class); assertEquals(1,
     * newForms.size()); NewForm expectedForm = expectedForm(new
     * MotherCaseBuilder().caseId(
     * "94d5374f-290e-409f-bc57-86c2e4bcc43f").build(), new
     * FlwBuilder().flwId("89fda0284e008d2e0c980fb13fa0e5bb") .build());
     * assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0), new
     * String[] { "id", "creationTime", "flw", "motherCase" });
     * assertEquals("94d5374f-290e-409f-bc57-86c2e4bcc43f", newForms.get(0)
     * .getMotherCase().getCaseId());
     * assertEquals("89fda0284e008d2e0c980fb13fa0e5bb", newForms.get(0)
     * .getFlw().getFlwId()); }
     * 
     * @Test public void shouldSaveChildForm() { ArrayList<Map<String, String>>
     * childFormValues = new ArrayList<>(); HashMap<String, String>
     * childFormValue = new HashMap<>(); childFormValue.put("caseId",
     * "94d5374f-290e-409f-bc57-86c2e4bcc43f"); childFormValue.put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/registration");
     * childFormValue.put("childName", "suraj");
     * childFormValue.put("birthStatus", "healthy"); childFormValue
     * .put("instanceId", "ff2eb090-03a9-4f23-afed-cf6012784c55");
     * childFormValue.put("flw", "89fda0284e008d2e0c980fb13fa0e5bb");
     * childFormValue.put("timeStart", "2013-03-03T10:31:51.045+05:30");
     * childFormValue.put("timeEnd", "2013-03-03T10:38:52.804+05:30");
     * childFormValue.put("dateModified", "2013-03-03T10:38:52.804+05:30");
     * 
     * childFormValues.add(childFormValue);
     * 
     * careService.processAndSaveForms(null, childFormValues);
     * 
     * List<RegistrationChildForm> registrationChildForms = template
     * .loadAll(RegistrationChildForm.class); assertEquals(1,
     * registrationChildForms.size());
     * 
     * RegistrationChildForm expectedForm =
     * getExpectedForm("94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * 
     * assertReflectionEqualsWithIgnore(expectedForm, registrationChildForms
     * .get(0), new String[] { "id", "flw", "childCase", "creationTime",
     * "lastModifiedTime" });
     * 
     * List<Flw> flws = template.loadAll(Flw.class); assertEquals(1,
     * flws.size()); assertEquals("89fda0284e008d2e0c980fb13fa0e5bb",
     * flws.get(0).getFlwId()); }
     * 
     * @Test public void shouldIgnoreMotherFormsWithoutXmlns() { Map<String,
     * String> motherFormValuesWithoutXmlns = motherFormValues(
     * "94d5374f-290e-409f-bc57-86c2e4bcc43f",
     * "89fda0284e008d2e0c980fb13fa0e5bb");
     * motherFormValuesWithoutXmlns.remove("xmlns");
     * 
     * try { careService.processAndSaveForms(motherFormValuesWithoutXmlns, new
     * ArrayList<Map<String, String>>()); } catch (Exception e) {
     * fail("The exception should not have been thrown: " + e.getMessage()); } }
     * 
     * @Test public void shouldNotThrowExceptionIfXmlnsNotRecognized() {
     * Map<String, String> motherFormValuesWithoutXmlns = motherFormValues(
     * "94d5374f-290e-409f-bc57-86c2e4bcc43f",
     * "89fda0284e008d2e0c980fb13fa0e5bb");
     * motherFormValuesWithoutXmlns.put("xmlns", "randomurl");
     * 
     * try { careService.processAndSaveForms(motherFormValuesWithoutXmlns, new
     * ArrayList<Map<String, String>>()); } catch (Exception e) {
     * fail("The exception should not have been thrown: " + e.getMessage()); } }
     * 
     * @Test public void
     * shouldInsertAnEntityByExternalPrimaryKeyWhenDoesNotExists() throws
     * Exception { HashMap<String, String> flwValues = new HashMap<String,
     * String>() { { put("flwId", "5ba9a0928dde95d187544babf6c0ad24");
     * put("firstName", "FirstName1"); } };
     * careService.saveByExternalPrimaryKey(Flw.class, flwValues);
     * 
     * List<Flw> flws = template.loadAll(Flw.class);
     * 
     * Flw expectedFlw = flw("5ba9a0928dde95d187544babf6c0ad24", "FirstName1",
     * null); assertEquals(1, flws.size());
     * assertReflectionEqualsWithIgnore(expectedFlw, flws.get(0), new String[] {
     * "id", "flwGroups", "creationTime", "lastModifiedTime" }); }
     * 
     * @Test public void shouldUpdateEntityByExternalPrimaryKeyWhenExists() {
     * String caseId = "94d5374f-290e-409f-bc57-86c2e4bcc43f"; ChildCase
     * existingChild = new ChildCase(); existingChild.setCaseId(caseId);
     * existingChild.setName("old Child name"); template.save(existingChild);
     * 
     * HashMap<String, String> updatedValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f"); put("name",
     * "new child name"); } };
     * 
     * careService.saveByExternalPrimaryKey(ChildCase.class, updatedValues);
     * 
     * List<ChildCase> childCases = template.loadAll(ChildCase.class);
     * Assert.assertEquals(1, childCases.size());
     * 
     * ChildCase expectedChildCase = new ChildCase();
     * expectedChildCase.setCaseId(caseId);
     * expectedChildCase.setName("new child name");
     * assertReflectionEqualsWithIgnore(expectedChildCase, childCases.get(0),
     * new String[] { "id", "creationTime", "lastModifiedTime" }); }
     * 
     * @Test public void
     * shouldDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasNewerDate()
     * { NewForm persistedForm = new NewForm();
     * persistedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
     * final DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-10T12:02:59.923+05:30");
     * persistedForm.setDateModified(oldFormModifiedDate);
     * persistedForm.setServerDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * final String newFormModifiedOn = "2012-07-20T12:02:59.923+05:30"; final
     * Date newFormModifiedDate = DateTime.parse(newFormModifiedOn) .toDate();
     * 
     * Map<String, String> motherFormValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * put("dateModified", newFormModifiedOn); put("serverDateModified",
     * newFormModifiedOn); put("userId", "89fda0284e008d2e0c980fb13fa0e5bb");
     * put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
     * put("instanceId", "e34707f8-80c8-4198-bf99-c11c90ba5c98"); } };
     * 
     * careService.processAndSaveForms(motherFormValues, new
     * ArrayList<Map<String, String>>());
     * 
     * List<NewForm> newFormsFromDb = template.loadAll(NewForm.class);
     * assertEquals(1, newFormsFromDb.size()); assertEquals(newFormModifiedDate,
     * newFormsFromDb.get(0) .getDateModified()); }
     * 
     * @Test public void
     * shouldDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasSameDate() {
     * NewForm persistedForm = new NewForm();
     * persistedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
     * final DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-10T12:02:59.923+05:30");
     * persistedForm.setCaste("OldCaste");
     * persistedForm.setDateModified(oldFormModifiedDate);
     * persistedForm.setServerDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30"; final
     * Date newFormModifiedDate = DateTime.parse(newFormModifiedOn) .toDate();
     * final String newCaste = "NewCaste";
     * 
     * Map<String, String> motherFormValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * put("dateModified", newFormModifiedOn); put("serverDateModified",
     * newFormModifiedOn); put("userId", "89fda0284e008d2e0c980fb13fa0e5bb");
     * put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
     * put("instanceId", "e34707f8-80c8-4198-bf99-c11c90ba5c98"); put("caste",
     * newCaste); } };
     * 
     * careService.processAndSaveForms(motherFormValues, new
     * ArrayList<Map<String, String>>());
     * 
     * List<NewForm> newFormsFromDb = template.loadAll(NewForm.class);
     * assertEquals(1, newFormsFromDb.size()); assertEquals(newFormModifiedDate,
     * newFormsFromDb.get(0) .getDateModified()); assertEquals(newCaste,
     * newFormsFromDb.get(0).getCaste()); }
     * 
     * @Test public void
     * shouldDeleteEarlierFormIfBothNewerAndOlderMotherFormWithSameInstanceIdHasNullDate
     * () { NewForm persistedForm = new NewForm();
     * persistedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
     * 
     * persistedForm.setCaste("OldCaste");
     * persistedForm.setServerDateModified(null); template.save(persistedForm);
     * 
     * final String newCaste = "NewCaste";
     * 
     * Map<String, String> motherFormValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * put("serverDateModified", null); put("userId",
     * "89fda0284e008d2e0c980fb13fa0e5bb"); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/new"); put("instanceId",
     * "e34707f8-80c8-4198-bf99-c11c90ba5c98"); put("caste", newCaste); } };
     * 
     * careService.processAndSaveForms(motherFormValues, new
     * ArrayList<Map<String, String>>());
     * 
     * List<NewForm> newFormsFromDb = template.loadAll(NewForm.class);
     * assertEquals(1, newFormsFromDb.size());
     * assertNull(newFormsFromDb.get(0).getDateModified());
     * assertEquals(newCaste, newFormsFromDb.get(0).getCaste()); }
     * 
     * @Test public void
     * shouldNotDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasNullDate
     * () { NewForm persistedForm = new NewForm();
     * persistedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
     * final DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-20T12:02:59.923+05:30");
     * persistedForm.setServerDateModified(oldFormModifiedDate);
     * persistedForm.setDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * Map<String, String> motherFormValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * put("dateModified", null); put("serverDateModified", null); put("userId",
     * "89fda0284e008d2e0c980fb13fa0e5bb"); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/new"); put("instanceId",
     * "e34707f8-80c8-4198-bf99-c11c90ba5c98"); } };
     * 
     * careService.processAndSaveForms(motherFormValues, new
     * ArrayList<Map<String, String>>());
     * 
     * List<NewForm> newFormsFromDb = template.loadAll(NewForm.class);
     * assertEquals(1, newFormsFromDb.size()); assertEquals(oldFormModifiedDate,
     * newFormsFromDb.get(0) .getDateModified()); }
     * 
     * @Test public void
     * shouldNotDeleteEarlierFormIfNewerMotherFormWithSameInstanceIdHasOldDate()
     * { NewForm persistedForm = new NewForm();
     * persistedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
     * final DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-20T12:02:59.923+05:30");
     * persistedForm.setDateModified(oldFormModifiedDate);
     * persistedForm.setDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30";
     * 
     * Map<String, String> motherFormValues = new HashMap<String, String>() { {
     * put("caseId", "94d5374f-290e-409f-bc57-86c2e4bcc43f");
     * put("dateModified", newFormModifiedOn); put("serverDateModified",
     * newFormModifiedOn); put("userId", "89fda0284e008d2e0c980fb13fa0e5bb");
     * put("xmlns", "http://bihar.commcarehq.org/pregnancy/new");
     * put("instanceId", "e34707f8-80c8-4198-bf99-c11c90ba5c98"); } };
     * 
     * careService.processAndSaveForms(motherFormValues, new
     * ArrayList<Map<String, String>>());
     * 
     * List<NewForm> newFormsFromDb = template.loadAll(NewForm.class);
     * assertEquals(1, newFormsFromDb.size()); assertEquals(oldFormModifiedDate,
     * newFormsFromDb.get(0) .getDateModified()); }
     * 
     * @Test public void
     * shouldSaveChildFormByDeletingOlderFormIfFormWithSameInstanceIdAndCaseIdExistsAlready
     * () { final String instanceId = "e34707f8-80c8-4198-bf99-c11c90ba5c98";
     * final String caseId = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf"; final
     * DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-10T12:02:59.923+05:30");
     * 
     * ChildCase persistedChildCase = new ChildCase();
     * persistedChildCase.setCaseId(caseId);
     * 
     * final DeathChildForm persistedForm = new DeathChildForm();
     * persistedForm.setInstanceId(instanceId);
     * persistedForm.setChildCase(persistedChildCase);
     * persistedForm.setDateModified(oldFormModifiedDate);
     * persistedForm.setServerDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * final String newFormModifiedOn = "2012-07-20T12:02:59.923+05:30"; final
     * Date newFormModifiedDate = DateTime.parse(newFormModifiedOn) .toDate();
     * final HashMap<String, String> deathChildFormValues = new HashMap<String,
     * String>() { { put("caseId", caseId); put("dateModified",
     * newFormModifiedOn); put("serverDateModified", newFormModifiedOn);
     * put("userId", "89fda0284e008d2e0c980fb13fa0e5bb"); put("close", "true");
     * put("instanceId", instanceId); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/death"); } };
     * 
     * careService.processAndSaveForms(null, new ArrayList<Map<String,
     * String>>() { { add(deathChildFormValues); } });
     * 
     * List<DeathChildForm> deathChildForms = template
     * .loadAll(DeathChildForm.class); assertEquals(1, deathChildForms.size());
     * assertEquals(newFormModifiedDate, deathChildForms.get(0)
     * .getDateModified()); }
     * 
     * @Test public void
     * shouldNotDeleteEarlierFormIfNewerChildFormWithSameInstanceIdAndCaseIdHasOldDate
     * () { final String instanceId = "e34707f8-80c8-4198-bf99-c11c90ba5c98";
     * final String caseId = "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf"; final
     * DateTime oldFormModifiedDate = DateTime
     * .parse("2012-07-20T12:02:59.923+05:30");
     * 
     * ChildCase persistedChildCase = new ChildCase();
     * persistedChildCase.setCaseId(caseId);
     * 
     * final DeathChildForm persistedForm = new DeathChildForm();
     * persistedForm.setInstanceId(instanceId);
     * persistedForm.setChildCase(persistedChildCase);
     * persistedForm.setDateModified(oldFormModifiedDate);
     * persistedForm.setServerDateModified(oldFormModifiedDate);
     * template.save(persistedForm);
     * 
     * final String newFormModifiedOn = "2012-07-10T12:02:59.923+05:30"; final
     * HashMap<String, String> deathChildFormValues = new HashMap<String,
     * String>() { { put("caseId", caseId); put("dateModified",
     * newFormModifiedOn); put("serverDateModified", newFormModifiedOn);
     * put("userId", "89fda0284e008d2e0c980fb13fa0e5bb"); put("close", "true");
     * put("instanceId", instanceId); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/death"); } };
     * 
     * careService.processAndSaveForms(null, new ArrayList<Map<String,
     * String>>() { { add(deathChildFormValues); } });
     * 
     * List<DeathChildForm> deathChildForms = template
     * .loadAll(DeathChildForm.class); assertEquals(1, deathChildForms.size());
     * assertEquals(oldFormModifiedDate, deathChildForms.get(0)
     * .getDateModified()); }
     * 
     * @Test public void shouldSaveFlwOnceForMotherAndChild() { final String
     * flwId = "89fda0284e008d2e0c980fb13fa0e5bb"; Flw flw = new
     * FlwBuilder().flwId(flwId).build(); final String instanceId =
     * "e34707f8-80c8-4198-bf99-c11c90ba5c98"; HashMap<String, String>
     * motherCase = new HashMap<String, String>() { { put("caseId",
     * "3e8998ce-b19f-4fa7-b1a1-721b6951e3cf"); put("userId", flwId); put("flw",
     * flwId); put("instanceId", instanceId); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/registration"); } };
     * 
     * final HashMap<String, String> child1 = new HashMap<String, String>() { {
     * put("caseId", "3e8998ce-b19f-4fa7-b1a1-721b6951e3c1"); put("userId",
     * flwId); put("flw", flwId); put("instanceId", instanceId); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/registration"); } };
     * 
     * final HashMap<String, String> child2 = new HashMap<String, String>() { {
     * put("caseId", "3e8998ce-b19f-4fa7-b1a1-721b6951e3c2"); put("userId",
     * flwId); put("flw", flwId); put("instanceId", instanceId); put("xmlns",
     * "http://bihar.commcarehq.org/pregnancy/registration"); } };
     * 
     * careService.processAndSaveForms(motherCase, new ArrayList<Map<String,
     * String>>() { { add(child1); add(child2); } });
     * 
     * List<Flw> actualFlws = template.loadAll(Flw.class); assertEquals(1,
     * actualFlws.size());
     * 
     * assertReflectionEqualsWithIgnore(flw, actualFlws.get(0), new String[] {
     * "id", "creationTime", "lastModifiedTime" }); }
     */

    private RegistrationChildForm getExpectedForm(String caseId) {
        ChildCase expectedChildCase = new ChildCase();
        expectedChildCase.setCaseId(caseId);

        Flw expectedFlw = new Flw();
        expectedFlw.setFlwId("89fda0284e008d2e0c980fb13fa0e5bb");

        RegistrationChildForm expectedChildForm = new RegistrationChildForm();
        expectedChildForm.setChildCase(expectedChildCase);
        expectedChildForm.setFlw(expectedFlw);
        expectedChildForm.setDateModified(new DateTime(2013, 3, 3, 10, 38, 52,
                804, DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedChildForm.setChildName("suraj");
        expectedChildForm.setBirthStatus("healthy");
        expectedChildForm.setInstanceId("ff2eb090-03a9-4f23-afed-cf6012784c55");
        expectedChildForm.setTimeStart(new DateTime(2013, 3, 3, 10, 31, 51, 45,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedChildForm.setTimeEnd(new DateTime(2013, 3, 3, 10, 38, 52, 804,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));

        return expectedChildForm;
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
        motherForm.put("instanceId", "e34707f8-80c8-4198-bf99-c11c90ba5c98");
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
        expectedForm.setInstanceId("e34707f8-80c8-4198-bf99-c11c90ba5c98");
        expectedForm.setMotherCase(motherCase);
        expectedForm.setFlw(flw);
        expectedForm.setTimeStart(new DateTime(2012, 7, 21, 11, 59, 31, 76,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        expectedForm.setTimeEnd(new DateTime(2012, 7, 21, 12, 2, 59, 923,
                DateTimeZone.forOffsetHoursMinutes(5, 30)));
        return expectedForm;
    }

    private Flw flw(String flwId, String firstName, final FlwGroup flwGroup) {
        return new FlwBuilder().flwId(flwId).firstName(firstName)
        // TODO: uncomment below
                /*
                 * .flwGroups(new HashSet<FlwGroup>() {{ add(flwGroup); }})
                 */
                .build();
    }

    private FlwGroup updatedGroup() {
        return new FlwGroupBuilder()
                .groupId("5ba9a0928dde95d187544babf6c0ad24").name(
                        "danny team 1").domain("care-orrisa").awcCode("002")
                .caseSharing(false).reporting(false).build();
    }

    private FlwGroup flwGroupWithNameAndId(String groupId, String name) {
        return new FlwGroupBuilder().groupId(groupId).name(name).build();
    }
}
