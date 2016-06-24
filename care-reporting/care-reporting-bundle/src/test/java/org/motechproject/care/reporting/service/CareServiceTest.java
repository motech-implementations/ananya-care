package org.motechproject.care.reporting.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.motechproject.care.reporting.utils.TestUtils.assertReflectionEqualsWithIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.reporting.builder.FlwGroupBuilder;
import org.motechproject.event.listener.EventRelay;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.LocationDimension;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.mcts.care.common.mds.measure.PncChildForm;
import org.motechproject.mcts.care.common.mds.repository.Repository;
import org.motechproject.mcts.care.common.mds.service.JobMetadataMDSService;
import org.unitils.reflectionassert.ReflectionAssert;

@RunWith(MockitoJUnitRunner.class)
public class CareServiceTest {
    @Mock
    private Repository dbRepository;
    @Mock
    private JobMetadataMDSService jobMetadataMDSService;
    @Mock
    private EventRelay eventRelay;

    private CareService careService;

    @Before
    public void setUp() {
        initMocks(this);
        careService = new CareService(dbRepository, jobMetadataMDSService,eventRelay);
    }

    @Test
    public void shouldExecuteInRepository() {
        when(dbRepository.execute("query")).thenReturn(10);

        Object output = careService.execute("query");

        assertEquals(10, output);
    }

    @Test
    public void shouldReturnMotherIfExistsInRepository() {
        MotherCase expectedMotherCase = new MotherCase();
        expectedMotherCase.setCaseId("1");

        when(dbRepository.get(MotherCase.class, "caseId", "1")).thenReturn(
                expectedMotherCase);

        MotherCase actualMotherCase = careService.getOrCreateMotherCase("1");

        assertEquals(expectedMotherCase, actualMotherCase);
    }

    @Test
    public void shouldReturnNewMotherIfNotExistsInRepository() {
        MotherCase expectedMotherCase = new MotherCase();
        expectedMotherCase.setCaseId("1");

        when(dbRepository.get(MotherCase.class, "caseId", "1"))
                .thenReturn(null);

        MotherCase actualMotherCase = careService.getOrCreateMotherCase("1");

        assertReflectionEqualsWithIgnore(expectedMotherCase, actualMotherCase,
                new String[] { "creationTime", "lastModifiedTime" });
    }

    @Test
    public void shouldReturnChildIfExistsInRepository() {
        ChildCase expectedChildCase = new ChildCase();
        expectedChildCase.setCaseId("1");

        when(dbRepository.get(ChildCase.class, "caseId", "1")).thenReturn(
                expectedChildCase);

        ChildCase actualChildCase = careService.getOrCreateChildCase("1");

        assertEquals(expectedChildCase, actualChildCase);
    }

    @Test
    public void shouldReturnNewChildIfNotExistsInRepository() {
        ChildCase expectedChildCase = new ChildCase();
        expectedChildCase.setCaseId("1");

        when(dbRepository.get(MotherCase.class, "caseId", "1"))
                .thenReturn(null);

        ChildCase actualChildCase = careService.getOrCreateChildCase("1");

        assertReflectionEqualsWithIgnore(expectedChildCase, actualChildCase,
                new String[] { "creationTime", "lastModifiedTime" });
    }

    @Test
    public void shouldReturnFlwIfExistsInRepository() {
        Flw expectedFlw = new Flw();
        expectedFlw.setFlwId("1");

        when(dbRepository.get(Flw.class, "flwId", "1")).thenReturn(expectedFlw);

        Flw actualFlw = careService.getOrCreateFlw("1");

        assertEquals(expectedFlw, actualFlw);
    }

    @Test
    public void shouldReturnNewFlwIfNotExistsInRepository() {
        Flw expectedFlw = new Flw();
        expectedFlw.setFlwId("1");

        when(dbRepository.get(Flw.class, "flwId", "1")).thenReturn(null);

        Flw actualFlw = careService.getOrCreateFlw("1");

        assertReflectionEqualsWithIgnore(expectedFlw, actualFlw, new String[] {
                "creationTime", "lastModifiedTime" });
    }

    @Test
    public void shouldSaveInstance() {
        NewForm newForm = new NewForm();
        newForm.setFullName("fullName");

        careService.save(newForm);

        verify(dbRepository).save(newForm);
    }

    @Test
    public void shouldGetGroupIfExists() {
        String fieldName = "groupId";
        String fieldValue = "groupId";
        FlwGroup flwGroup = new FlwGroup();
        when(dbRepository.get(FlwGroup.class, fieldName, fieldValue))
                .thenReturn(flwGroup);

        FlwGroup actualGroup = careService.getOrCreateGroup(fieldValue);

        verify(dbRepository).get(FlwGroup.class, fieldName, fieldValue);
        assertEquals(flwGroup, actualGroup);
    }

    @Test
    public void shouldGetNewGroupIfItDoesNotExist() {
        String fieldName = "groupId";
        String fieldValue = "groupId";
        when(dbRepository.get(FlwGroup.class, fieldName, fieldValue))
                .thenReturn(null);

        FlwGroup actualGroup = careService.getOrCreateGroup(fieldValue);

        verify(dbRepository).get(FlwGroup.class, fieldName, fieldValue);
        assertEquals(fieldValue, actualGroup.getGroupId());
    }

    @Test
    public void shouldGetACaseIfExists() {
        String fieldName = "fieldName";
        String fieldValue = "fieldValue";
        MotherCase motherCase = new MotherCase();
        when(dbRepository.get(MotherCase.class, fieldName, fieldValue))
                .thenReturn(motherCase);

        MotherCase actualMotherCase = (MotherCase) careService.getOrCreateNew(
                MotherCase.class, fieldName, fieldValue);

        verify(dbRepository).get(MotherCase.class, fieldName, fieldValue);
        assertEquals(motherCase, actualMotherCase);
    }

    @Test
    public void shouldGetANewCaseIfItDoesNotExist() {
        String fieldName = "caseId";
        String fieldValue = "fieldValue";
        when(dbRepository.get(MotherCase.class, fieldName, fieldValue))
                .thenReturn(null);

        MotherCase actualMotherCase = (MotherCase) careService.getOrCreateNew(
                MotherCase.class, fieldName, fieldValue);

        verify(dbRepository).get(MotherCase.class, fieldName, fieldValue);
        assertEquals(fieldValue, actualMotherCase.getCaseId());
    }

    @Test
    public void shouldFetchEntityGivenMultipleFieldsAndHibernateCriteriaAliases() {
        final PncChildForm pncChildForm = new PncChildForm();
        pncChildForm.setInstanceId("myInstanceId");
        ChildCase childCase = new ChildCase();
        childCase.setCaseId("myCaseId");
        pncChildForm.setChildCase(childCase);
        HashMap<String, Object> fieldMap = new HashMap<String, Object>() {
            {
                put("instanceId", pncChildForm.getInstanceId());
                put("cc.caseId", pncChildForm.getChildCase());
            }
        };
        HashMap<String, String> aliasMapping = new HashMap<>();
        aliasMapping.put("childCase", "cc");
        when(dbRepository.get(PncChildForm.class, fieldMap, aliasMapping))
                .thenReturn(pncChildForm);

        PncChildForm actualPncChildForm = (PncChildForm) careService.get(
                PncChildForm.class, fieldMap, aliasMapping);

        ReflectionAssert.assertReflectionEquals(pncChildForm,
                actualPncChildForm);
    }

    @Test
    public void shouldReturnLocationDimensionIfExistsInRepository() {
        LocationDimension expectedLocation = new LocationDimension();

        // TODO: uncomment below
        // expectedLocation.setId(1);

        Map<String, Object> fieldMaps = new HashMap<>();
        fieldMaps.put("state", "BIHAR");
        fieldMaps.put("district", "ARARIA");
        fieldMaps.put("block", "BHARGAMA");

        when(dbRepository.get(LocationDimension.class, fieldMaps, null))
                .thenReturn(expectedLocation);

        LocationDimension actualLocationDimension = careService.getLocation(
                "BIHAR", "ARARIA", "BHARGAMA");

        assertEquals(expectedLocation, actualLocationDimension);
    }

    @Test
    public void shouldReturnUnknownLocationDimensionIfNotExistsInRepository() {
        LocationDimension expectedUnknown = new LocationDimension();

        // TODO: uncomment below
        // expectedUnknown.setId(1);
        final String unknown = "UNKNOWN";
        expectedUnknown.setBlock(unknown);
        expectedUnknown.setDistrict(unknown);
        expectedUnknown.setState(unknown);

        Map<String, Object> fieldMaps = new HashMap<>();
        fieldMaps.put("state", "BIHAR");
        fieldMaps.put("district", "ARARIA");
        fieldMaps.put("block", "BHARGAMA");

        Map<String, Object> unknownFieldMaps = new HashMap<>();
        unknownFieldMaps.put("state", unknown);
        unknownFieldMaps.put("district", unknown);
        unknownFieldMaps.put("block", unknown);

        when(dbRepository.get(LocationDimension.class, fieldMaps, null))
                .thenReturn(null);
        when(dbRepository.get(LocationDimension.class, unknownFieldMaps, null))
                .thenReturn(expectedUnknown);

        LocationDimension actualLocationDimension = careService.getLocation(
                "BIHAR", "ARARIA", "BHARGAMA");

        assertEquals(expectedUnknown, actualLocationDimension);
    }

    @Test
    public void shouldReturnLocationDimensionIfExistsInRepositoryByIgnoringCase() {
        LocationDimension expectedLocation = new LocationDimension();

        // TODO: uncomment below
        // expectedLocation.setId(1);
        expectedLocation.setBlock("BIHAR");
        expectedLocation.setDistrict("ARARIA");
        expectedLocation.setState("BHARGAMA");

        Map<String, Object> fieldMaps = new HashMap<>();
        fieldMaps.put("state", "BIHAR");
        fieldMaps.put("district", "ARARIA");
        fieldMaps.put("block", "BHARGAMA");

        when(dbRepository.get(LocationDimension.class, fieldMaps, null))
                .thenReturn(expectedLocation);

        LocationDimension actualLocationDimension = careService.getLocation(
                "bihar", "araria", "bhargama");

        assertEquals(expectedLocation, actualLocationDimension);
    }

    @Test
    public void shouldReturnUnknownLocationDimensionIfNotExistsInRepositoryAndAnyArgumentIsNullOrEmpty() {
        LocationDimension expectedUnknown = new LocationDimension();

        // TODO: uncomment below
        // expectedUnknown.setId(1);
        final String unknown = "UNKNOWN";
        expectedUnknown.setBlock(unknown);
        expectedUnknown.setDistrict(unknown);
        expectedUnknown.setState(unknown);

        Map<String, Object> fieldMaps = new HashMap<>();
        fieldMaps.put("state", "BIHAR");
        fieldMaps.put("district", null);
        fieldMaps.put("block", StringUtils.EMPTY);

        Map<String, Object> unknownFieldMaps = new HashMap<>();
        unknownFieldMaps.put("state", unknown);
        unknownFieldMaps.put("district", unknown);
        unknownFieldMaps.put("block", unknown);

        when(dbRepository.get(LocationDimension.class, fieldMaps, null))
                .thenReturn(null);
        when(dbRepository.get(LocationDimension.class, unknownFieldMaps, null))
                .thenReturn(expectedUnknown);

        LocationDimension actualLocationDimension = careService.getLocation(
                "BIHAR", null, StringUtils.EMPTY);

        assertEquals(expectedUnknown, actualLocationDimension);
        verify(dbRepository, times(0)).get(LocationDimension.class, fieldMaps,
                null);
    }

    @Test
    public void shouldProcessAndSaveForms() {
        Map<String, String> motherFormValues = new HashMap<>();
        motherFormValues.put("xmlns",
                "http://bihar.commcarehq.org/pregnancy/new");
        List<Map<String, String>> childFormValues = new ArrayList<Map<String, String>>();
        Map<String, String> childFormValue = new HashMap<>();
        childFormValue.put("xmlns",
                "http://bihar.commcarehq.org/pregnancy/registration");
        childFormValues.add(childFormValue);
        careService.processAndSaveForms(motherFormValues, childFormValues);
        verify(dbRepository, times(2)).save(anyObject());

    }

    @Test
    public void shouldProcessAndSaveManyToManyForm() {
        Map<String, String> motherFormValues = new HashMap<>();
        motherFormValues.put("xmlns",
                "http://bihar.commcarehq.org/pregnancy/new");
        List<Map<String, String>> childFormValues = new ArrayList<Map<String, String>>();
        Map<String, String> childFormValue = new HashMap<>();
        childFormValue.put("xmlns",
                "http://bihar.commcarehq.org/pregnancy/registration");
        childFormValues.add(childFormValue);
        careService.processAndSaveManyToManyForm(motherFormValues, childFormValues);
    }

    @Test
    public void shouldSaveByExternalPrimaryKey() {
        HashMap<String, String> flwValues = new HashMap<String, String>() {
            {
                put("flwId", "5ba9a0928dde95d187544babf6c0ad24");
                put("firstName", "FirstName1");
            }
        };
        careService.saveByExternalPrimaryKey(Flw.class, flwValues);
        verify(dbRepository).save(anyObject());
    }

    @Test
    public void shouldCloseCase() {
        MotherCase motherCase = new MotherCase();
        when(dbRepository.get(MotherCase.class, "caseId", "123")).thenReturn(
                motherCase);
        ChildCase childCase = new ChildCase();
        when(dbRepository.get(ChildCase.class, "caseId", "123")).thenReturn(
                childCase);
        Map<String, String> updatedValues = new HashMap<>();
        DateTime dateTime = new DateTime();
        String date = "12-04-1999";
        updatedValues.put("closed", "true");
        updatedValues.put("closedOn", date);
        careService.closeCase("123", updatedValues);
    }

    @Test
    public void shouldSaveOrUpdateAllByExternalPrimaryKey() {
        FlwGroup updatedGroup = updatedGroup();
        careService.saveOrUpdateAllByExternalPrimaryKey(FlwGroup.class, Arrays
                .asList(updatedGroup));
        verify(dbRepository).saveOrUpdateAll(Matchers.anyListOf(Class.class));
    }

    @Test
    public void shouldGetLocationWithUnknownLocation() {
        when(
                dbRepository.get(any(Class.class), (Map) anyObject(),
                        (Map) anyObject())).thenReturn(null);
        LocationDimension location = careService.getLocation("bihar", "saharsa",
                "xyz");
    }

    private FlwGroup updatedGroup() {
        return new FlwGroupBuilder()
                .groupId("5ba9a0928dde95d187544babf6c0ad24").name(
                        "danny team 1").domain("care-orrisa").awcCode("002")
                .caseSharing(false).reporting(false).build();
    }

}
