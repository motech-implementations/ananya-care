package org.motechproject.care.reporting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.care.reporting.builder.FlwBuilder;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.care.reporting.builder.MotherCaseBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
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

    @Test
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

    @Test
    public void shouldNotSaveMotherOrChildFormsIfNullAndEmpty() {
        careService.processAndSaveForms(null,
                new ArrayList<Map<String, String>>());

        List<MotherCase> mothers = dbRepository.retrieveAll(MotherCase.class);
        assertTrue(mothers.isEmpty());

        List<ChildCase> children = dbRepository.retrieveAll(ChildCase.class);
        assertTrue(children.isEmpty());
    }

    @Test
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
        assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0),
                new String[] { "id", "creationTime", "lastModifiedTime" });

        dbRepository.delete(motherCase);
        dbRepository.delete(flw);
        dbRepository.delete(newForms.get(0));

    }

    @Test
    public void shouldSaveMotherFormAndCreateNewCase() {
        Map<String, String> motherForm = motherFormValues("case_id", "flw_id");

        careService.processAndSaveForms(motherForm,
                new ArrayList<Map<String, String>>());

        List<MotherCase> persistedMotherCases = dbRepository
                .retrieveAll(MotherCase.class);
        assertEquals(1, persistedMotherCases.size());
        List<NewForm> newForms = dbRepository.retrieveAll(NewForm.class);
        assertEquals(1, newForms.size());
        NewForm expectedForm = expectedForm(new MotherCaseBuilder().caseId(
                "case_id").build(), new FlwBuilder().flwId("flw_id").build());
        /*assertReflectionEqualsWithIgnore(expectedForm, newForms.get(0),
                new String[] { "id", "creationTime", "flw", "motherCase" });*/
        assertEquals("case_id", newForms.get(0).getMotherCase().getCaseId());
        assertEquals("flw_id", newForms.get(0).getFlw().getFlwId());

        dbRepository.delete(persistedMotherCases);
        dbRepository.delete(newForms.get(0));
        dbRepository.delete(newForms.get(0).getFlw());
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

}
