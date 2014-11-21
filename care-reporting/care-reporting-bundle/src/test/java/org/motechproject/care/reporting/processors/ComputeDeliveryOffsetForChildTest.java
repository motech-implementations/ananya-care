package org.motechproject.care.reporting.processors;

import static org.junit.Assert.assertEquals;
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
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public class ComputeDeliveryOffsetForChildTest {

    @Mock
    private ICareService careService;

    private ComputeDeliveryOffsetForChild computeDeliveryOffsetForChild;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        computeDeliveryOffsetForChild = new ComputeDeliveryOffsetForChild(
                careService);
    }

    @Test
    public void testComputeDeliveryOffsetWhenMapIsNull() throws Exception {
        computeDeliveryOffsetForChild.compute(null);
        verify(careService, never()).getChildCase(null);
    }

    @Test
    public void testComputeDeliveryOffsetWhenCaseIdDoesnotExist()
            throws Exception {

        final String childCaseId = "12345";

        Map<String, String> formInfoMap = new HashMap<>();

        computeDeliveryOffsetForChild.compute(formInfoMap);

        verify(careService, never()).getChildCase(childCaseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetWhenChildCaseIdIsNull()
            throws Exception {

        final String childCaseId = null;

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", childCaseId);

        computeDeliveryOffsetForChild.compute(formInfoMap);

        verify(careService, never()).getChildCase(childCaseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetWhenServerModifiedIsNull()
            throws Exception {

        final String caseId = "12345";

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", null);

        computeDeliveryOffsetForChild.compute(formInfoMap);

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

        computeDeliveryOffsetForChild.compute(formInfoMap);

        verify(careService).getChildCase(caseId);
        assertEquals(null, formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetUsingEDDOfMother() throws Exception {

        final String caseId = "12345";
        final String serverModified = DateTime.now().toString();

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", serverModified);

        MotherCase motherCase = new MotherCase();
        motherCase.setEdd(new DateTime().plusDays(10));
        motherCase.setActualDeliveryDate(null);

        ChildCase childCase = new ChildCase();
        childCase.setCaseId(caseId);
        childCase.setMotherCase(motherCase);

        when(careService.getChildCase(caseId)).thenReturn(childCase);

        computeDeliveryOffsetForChild.compute(formInfoMap);

        verify(careService).getChildCase(caseId);
        assertEquals("-10", formInfoMap.get("deliveryOffsetDays"));
    }

    @Test
    public void testComputeDeliveryOffsetUsingADDOfMother() throws Exception {

        final String caseId = "12345";
        final String serverModified = DateTime.now().toString();

        Map<String, String> formInfoMap = new HashMap<>();
        formInfoMap.put("caseId", caseId);
        formInfoMap.put("serverDateModified", serverModified);

        MotherCase motherCase = new MotherCase();
        motherCase.setEdd(null);
        motherCase.setActualDeliveryDate(new DateTime().minusDays(10));

        ChildCase childCase = new ChildCase();
        childCase.setCaseId(caseId);
        childCase.setMotherCase(motherCase);

        when(careService.getChildCase(caseId)).thenReturn(childCase);

        computeDeliveryOffsetForChild.compute(formInfoMap);

        verify(careService).getChildCase(caseId);
        assertEquals("10", formInfoMap.get("deliveryOffsetDays"));
    }
}
