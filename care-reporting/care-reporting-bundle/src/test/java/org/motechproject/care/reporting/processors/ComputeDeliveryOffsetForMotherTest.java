package org.motechproject.care.reporting.processors;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.care.reporting.service.ICareService;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class ComputeDeliveryOffsetForMotherTest {

    @Mock
    private ICareService careService;

    private ComputeDeliveryOffsetForMother computeDeliveryOffsetForMother;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        computeDeliveryOffsetForMother = new ComputeDeliveryOffsetForMother(
                careService);
    }

    @Test
    public void testComputeDeliveryOffsetWhenMapIsNull() throws Exception {
        computeDeliveryOffsetForMother.compute(null);
        verify(careService, never()).getMotherCase(null);
    }

    @Test
    public void testComputeDeliveryOffsetWhenCaseIdDoesnotExist()
            throws Exception {

        final String caseId = "12345";

        Map<String, String> formInfoMap = new HashMap<>();

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService, never()).getMotherCase(caseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetWhenCaseIdIsNull() throws Exception {

        final String caseId = null;

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService, never()).getMotherCase(caseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetWhenServerModifiedIsNull()
            throws Exception {

        final String caseId = "12345";

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", null);

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService, never()).getMotherCase(caseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetWhenBothEddAndAddAreNull()
            throws Exception {

        final String caseId = "12345";
        final String serverModified = DateTime.now().toString();

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", serverModified);

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService).getMotherCase(caseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetUsingEDDForMother() throws Exception {

        final String caseId = "12345";
        final String serverModified = DateTime.now().toString();

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", serverModified);

        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId(caseId);
        motherCase.setEdd(new DateTime().plusDays(10));
        motherCase.setActualDeliveryDate(null);

        when(careService.getMotherCase(caseId)).thenReturn(motherCase);

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService).getMotherCase(caseId);
        assertEquals("-10", formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetUsingADDForMother() throws Exception {

        final String caseId = "12345";
        final String serverModified = DateTime.now().toString();

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", serverModified);

        MotherCase motherCase = new MotherCase();
        motherCase.setCaseId(caseId);
        motherCase.setEdd(null);
        motherCase.setActualDeliveryDate(new DateTime().minusDays(10));

        when(careService.getMotherCase(caseId)).thenReturn(motherCase);

        computeDeliveryOffsetForMother.compute(formInfoMap);

        verify(careService).getMotherCase(caseId);
        assertEquals("10", formInfoMap.get("deliveryOffsetDays"));
    }
}
