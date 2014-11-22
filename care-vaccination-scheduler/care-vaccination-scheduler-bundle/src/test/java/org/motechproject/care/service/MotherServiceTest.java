package org.motechproject.care.service;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.motechproject.care.service.builder.MotherBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.Repository;

import java.io.IOException;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class MotherServiceTest {
    @Mock
    private Repository dbRepository;
    @Mock
    private VaccinationProcessor vaccinationProcessor;

    private MotherService motherService;
    private String caseId="caseId";

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        motherService = new MotherService(vaccinationProcessor);
    }

    @Test
    public void shouldSaveMotherCaseIfItDoesNotExists() throws IOException {
        MotherCase mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive("yes").build();
        when(dbRepository.get(MotherCase.class, "caseId", mother.getCaseId())).thenReturn(null);

        motherService.process(mother);

        ArgumentCaptor<MotherCase> captor=ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).save(captor.capture());

        MotherCase motherInDb  = captor.getValue();

        Assert.assertEquals(caseId,motherInDb.getCaseId());
        Assert.assertEquals("Aparna",motherInDb.getCaseName());
        DateTime expectedEdd = new DateTime(2012, 1, 2, 0, 0);
        Assert.assertEquals(expectedEdd,motherInDb.getEdd());
        Assert.assertTrue(motherInDb.getIsAlive()=="yes");
        Assert.assertNull(motherInDb.getCreationTime());
        verify(vaccinationProcessor).enrollUpdateVaccines(motherInDb);
        verify(vaccinationProcessor, never()).closeSchedules(any(MotherCase.class));
    }

    @Test
    public void shouldSaveMotherAsInactiveIfItDoesNotExistAndSheIsDead() throws IOException {
        MotherCase mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive("no").build();
        when(dbRepository.get(MotherCase.class, "caseId", mother.getCaseId())).thenReturn(null);

        motherService.process(mother);

        ArgumentCaptor<MotherCase> captor=ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).save(captor.capture());

        MotherCase motherInDb  = captor.getValue();


        Assert.assertFalse(motherInDb.isActive());
        Assert.assertFalse(motherInDb.getIsAlive()=="yes");
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(MotherCase.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(MotherCase.class));
    }

    @Test
    public void shouldUpdateMotherCaseIfItExists(){
        MotherCase mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive("yes").build();
        DateTime now = DateTime.now();
        DateTime docCreateTime = DateTime.now().minusDays(1);
        MotherCase motherInDb = motherWithCaseId(caseId);
        motherInDb.setEdd(now);
        motherInDb.setCreationTime(docCreateTime);
        motherInDb.setCaseName("Seema");
        motherInDb.setIsAlive("yes");
        motherInDb.setClosedByCommcare(false);
        motherInDb.setActualDeliveryDate(null);

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(motherInDb);

        motherService.process(mother);

        verify(dbRepository, never()).save(motherInDb);
        ArgumentCaptor<MotherCase> captor = ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).update(captor.capture());

        MotherCase motherToBeUpdated = captor.getValue();
        assertEquals(DateTime.parse("2012-01-02"), motherToBeUpdated.getEdd());
        assertEquals(motherToBeUpdated.getCaseId(), motherInDb.getCaseId());
        assertEquals(motherToBeUpdated.getCaseId(), motherInDb.getCaseId());
        assertEquals(motherToBeUpdated.getCreationTime(), docCreateTime);
        assertEquals(mother.getCaseName(), motherToBeUpdated.getCaseName());
        verify(vaccinationProcessor).enrollUpdateVaccines(motherToBeUpdated);
    }

    @Test
    public void shouldSetMotherCaseAsClosedByCommcareAndCloseSchedulesIfExists_WhenMotherCaseIsClosed(){
        MotherCase motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setClosedByCommcare(false);
        motherFromDb.setActualDeliveryDate(null);
        motherFromDb.setIsAlive("yes");

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasClosed = motherService.closeCase(caseId);

        Assert.assertTrue(wasClosed);

        verify(dbRepository, times(1)).update(motherFromDb);
        verify(vaccinationProcessor).closeSchedules(motherFromDb);

        ArgumentCaptor<MotherCase> captor = ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).update(captor.capture());
        MotherCase mother = captor.getValue();
        assertFalse(mother.isActive());
        assertTrue(mother.getClosedByCommcare());
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExists(){
        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = motherService.closeCase(caseId);

        Assert.assertFalse(wasClosed);
    }

    @Test
    public void shouldSetMotherCaseAsExpired_WhenMotherCaseIsExpired(){
        MotherCase motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setExpired(false);
        motherFromDb.setClosedByCommcare(false);
        motherFromDb.setActualDeliveryDate(null);
        motherFromDb.setIsAlive("yes");

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasExpired = motherService.expireCase(caseId);

        Assert.assertTrue(wasExpired);

        verify(dbRepository, times(1)).update(motherFromDb);

        ArgumentCaptor<MotherCase> captor = ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).update(captor.capture());
        MotherCase mother = captor.getValue();
        assertTrue(mother.getExpired());
    }

    @Test
    public void shouldReturnTrueIfMotherInactiveWhileExpiringMother(){
        MotherCase motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setExpired(true);
        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasClosed = motherService.expireCase(caseId);
        Assert.assertTrue(wasClosed);
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExistsWhileExpiringCase(){
        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = motherService.expireCase(caseId);
        Assert.assertFalse(wasClosed);
    }

    @Test
    public void shouldCloseMotherCaseIfMotherIsDead(){
        MotherCase mother = new MotherBuilder().withAlive("no").withCaseId(caseId).build();

        MotherCase existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setActualDeliveryDate(null);
        existingMother.setIsAlive("yes");

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository, times(1)).update(existingMother);
        verify(vaccinationProcessor).closeSchedules(existingMother);

        ArgumentCaptor<MotherCase> captor = ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).update(captor.capture());
        MotherCase motherFromDb = captor.getValue();
        assertFalse(motherFromDb.isActive());
        assertFalse(motherFromDb.getIsAlive()=="yes");
    }

    @Test
    public void shouldCloseMotherSchedulesIfADDIsGiven(){
        MotherCase mother = new MotherBuilder().withAlive("yes").withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        MotherCase existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setActualDeliveryDate(null);
        existingMother.setIsAlive("yes");

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository, times(1)).update(existingMother);
        verify(vaccinationProcessor).closeSchedules(existingMother);

        ArgumentCaptor<MotherCase> captor = ArgumentCaptor.forClass(MotherCase.class);
        verify(dbRepository).update(captor.capture());
        MotherCase motherFromDb = captor.getValue();
        assertFalse(motherFromDb.isActive());
        assertNotNull(motherFromDb.getActualDeliveryDate());
    }

    @Test
    public void shouldUpdateIrrespectiveOfWhetherMotherIsAlreadyInactiveOrNotButShouldNotScheduleVaccinations(){
        MotherCase mother = new MotherBuilder().withAlive("yes").withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        MotherCase existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setActualDeliveryDate(null);
        existingMother.setIsAlive("no");
        existingMother.setExpired(false);

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository).update(any(MotherCase.class));
        verify(vaccinationProcessor).closeSchedules(any(MotherCase.class));
    }

    @Test(expected = RuntimeException.class)
    public void testToCheckThatClientIsAlwaysSavedFirstBeforeSchedulingHerForVaccinations(){

        MotherCase mother = new MotherBuilder().withAlive("yes").withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        MotherCase existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setActualDeliveryDate(null);
        existingMother.setIsAlive("yes");
        existingMother.setExpired(false);
        existingMother.setCaseName("Hannah Montana");

        when(dbRepository.get(MotherCase.class, "caseId", caseId)).thenReturn(existingMother);
        doThrow(new RuntimeException()).when(dbRepository).update(Matchers.<MotherCase>any());

        motherService.process(mother);

        verify(dbRepository).update(any(MotherCase.class));
        verify(vaccinationProcessor,never()).enrollUpdateVaccines(Matchers.<MotherCase>any());

    }

    private MotherCase motherWithCaseId(String caseId) {
        MotherCase mother = new MotherCase();
        mother.setCaseId(caseId);
        return mother;
    }



}