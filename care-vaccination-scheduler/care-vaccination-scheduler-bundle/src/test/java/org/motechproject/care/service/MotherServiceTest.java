package org.motechproject.care.service;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.motechproject.care.service.builder.MotherBuilder;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.domain.Mother;
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
        Mother mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive(true).build();
        when(dbRepository.get(Mother.class, "caseId", mother.getCaseId())).thenReturn(null);

        motherService.process(mother);

        ArgumentCaptor<Mother> captor=ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).save(captor.capture());

        Mother motherInDb  = captor.getValue();

        Assert.assertEquals(caseId,motherInDb.getCaseId());
        Assert.assertEquals("Aparna",motherInDb.getName());
        DateTime expectedEdd = new DateTime(2012, 1, 2, 0, 0);
        Assert.assertEquals(expectedEdd,motherInDb.getEdd());
        Assert.assertTrue(motherInDb.getIsAlive());
        Assert.assertNull(motherInDb.getDocCreateTime());
        verify(vaccinationProcessor).enrollUpdateVaccines(motherInDb);
        verify(vaccinationProcessor, never()).closeSchedules(any(Mother.class));
    }

    @Test
    public void shouldSaveMotherAsInactiveIfItDoesNotExistAndSheIsDead() throws IOException {
        Mother mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive(false).build();
        when(dbRepository.get(Mother.class, "caseId", mother.getCaseId())).thenReturn(null);

        motherService.process(mother);

        ArgumentCaptor<Mother> captor=ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).save(captor.capture());

        Mother motherInDb  = captor.getValue();


        Assert.assertFalse(motherInDb.isActive());
        Assert.assertFalse(motherInDb.getIsAlive());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(Mother.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(Mother.class));
    }

    @Test
    public void shouldUpdateMotherCaseIfItExists(){
        Mother mother = new MotherBuilder().withName("Aparna").withCaseId(caseId).withEdd(new DateTime(2012, 1, 2, 0, 0, 0)).withAlive(true).build();
        DateTime now = DateTime.now();
        DateTime docCreateTime = DateTime.now().minusDays(1);
        Mother motherInDb = motherWithCaseId(caseId);
        motherInDb.setEdd(now);
        motherInDb.setDocCreateTime(docCreateTime);
        motherInDb.setName("Seema");
        motherInDb.setIsAlive(true);
        motherInDb.setClosedByCommcare(false);
        motherInDb.setAdd(null);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(motherInDb);

        motherService.process(mother);

        verify(dbRepository, never()).save(motherInDb);
        ArgumentCaptor<Mother> captor = ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).update(captor.capture());

        Mother motherToBeUpdated = captor.getValue();
        assertEquals(DateTime.parse("2012-01-02"), motherToBeUpdated.getEdd());
        assertEquals(motherToBeUpdated.getCaseId(), motherInDb.getCaseId());
        assertEquals(motherToBeUpdated.getCaseId(), motherInDb.getCaseId());
        assertEquals(motherToBeUpdated.getDocCreateTime(), docCreateTime);
        assertEquals(mother.getName(), motherToBeUpdated.getName());
        verify(vaccinationProcessor).enrollUpdateVaccines(motherToBeUpdated);
    }

    @Test
    public void shouldSetMotherCaseAsClosedByCommcareAndCloseSchedulesIfExists_WhenMotherCaseIsClosed(){
        Mother motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setClosedByCommcare(false);
        motherFromDb.setAdd(null);
        motherFromDb.setIsAlive(true);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasClosed = motherService.closeCase(caseId);

        Assert.assertTrue(wasClosed);

        verify(dbRepository, times(1)).update(motherFromDb);
        verify(vaccinationProcessor).closeSchedules(motherFromDb);

        ArgumentCaptor<Mother> captor = ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).update(captor.capture());
        Mother mother = captor.getValue();
        assertFalse(mother.isActive());
        assertTrue(mother.getClosedByCommcare());
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExists(){
        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = motherService.closeCase(caseId);

        Assert.assertFalse(wasClosed);
    }

    @Test
    public void shouldSetMotherCaseAsExpired_WhenMotherCaseIsExpired(){
        Mother motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setExpired(false);
        motherFromDb.setClosedByCommcare(false);
        motherFromDb.setAdd(null);
        motherFromDb.setIsAlive(true);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasExpired = motherService.expireCase(caseId);

        Assert.assertTrue(wasExpired);

        verify(dbRepository, times(1)).update(motherFromDb);

        ArgumentCaptor<Mother> captor = ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).update(captor.capture());
        Mother mother = captor.getValue();
        assertTrue(mother.getExpired());
    }

    @Test
    public void shouldReturnTrueIfMotherInactiveWhileExpiringMother(){
        Mother motherFromDb = motherWithCaseId(caseId);
        motherFromDb.setExpired(true);
        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(motherFromDb);
        boolean wasClosed = motherService.expireCase(caseId);
        Assert.assertTrue(wasClosed);
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExistsWhileExpiringCase(){
        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = motherService.expireCase(caseId);
        Assert.assertFalse(wasClosed);
    }

    @Test
    public void shouldCloseMotherCaseIfMotherIsDead(){
        Mother mother = new MotherBuilder().withAlive(false).withCaseId(caseId).build();

        Mother existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setAdd(null);
        existingMother.setIsAlive(true);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository, times(1)).update(existingMother);
        verify(vaccinationProcessor).closeSchedules(existingMother);

        ArgumentCaptor<Mother> captor = ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).update(captor.capture());
        Mother motherFromDb = captor.getValue();
        assertFalse(motherFromDb.isActive());
        assertFalse(motherFromDb.getIsAlive());
    }

    @Test
    public void shouldCloseMotherSchedulesIfADDIsGiven(){
        Mother mother = new MotherBuilder().withAlive(true).withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        Mother existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setAdd(null);
        existingMother.setIsAlive(true);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository, times(1)).update(existingMother);
        verify(vaccinationProcessor).closeSchedules(existingMother);

        ArgumentCaptor<Mother> captor = ArgumentCaptor.forClass(Mother.class);
        verify(dbRepository).update(captor.capture());
        Mother motherFromDb = captor.getValue();
        assertFalse(motherFromDb.isActive());
        assertNotNull(motherFromDb.getAdd());
    }

    @Test
    public void shouldUpdateIrrespectiveOfWhetherMotherIsAlreadyInactiveOrNotButShouldNotScheduleVaccinations(){
        Mother mother = new MotherBuilder().withAlive(true).withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        Mother existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setAdd(null);
        existingMother.setIsAlive(false);
        existingMother.setExpired(false);

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(existingMother);

        motherService.process(mother);

        verify(dbRepository).update(any(Mother.class));
        verify(vaccinationProcessor).closeSchedules(any(Mother.class));
    }

    @Test(expected = RuntimeException.class)
    public void testToCheckThatClientIsAlwaysSavedFirstBeforeSchedulingHerForVaccinations(){

        Mother mother = new MotherBuilder().withAlive(true).withCaseId(caseId).withAdd(new DateTime(2012, 4, 10, 0, 0, 0)).build();

        Mother existingMother = motherWithCaseId(caseId);
        existingMother.setClosedByCommcare(false);
        existingMother.setAdd(null);
        existingMother.setIsAlive(true);
        existingMother.setExpired(false);
        existingMother.setName("Hannah Montana");

        when(dbRepository.get(Mother.class, "caseId", caseId)).thenReturn(existingMother);
        doThrow(new RuntimeException()).when(dbRepository).update(Matchers.<Mother>any());

        motherService.process(mother);

        verify(dbRepository).update(any(Mother.class));
        verify(vaccinationProcessor,never()).enrollUpdateVaccines(Matchers.<Mother>any());

    }

    private Mother motherWithCaseId(String caseId) {
        Mother mother = new Mother();
        mother.setCaseId(caseId);
        return mother;
    }



}