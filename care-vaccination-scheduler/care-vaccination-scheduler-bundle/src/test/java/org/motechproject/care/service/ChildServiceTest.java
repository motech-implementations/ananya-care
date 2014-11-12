package org.motechproject.care.service;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.service.builder.ChildBuilder;
import org.motechproject.mcts.care.common.mds.domain.Child;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;

@RunWith(MockitoJUnitRunner.class)
public class ChildServiceTest {

    @Mock
    private MdsRepository dbRepository;

    @Mock
    private VaccinationProcessor vaccinationProcessor;
    @InjectMocks
    private ChildService childService= new ChildService(vaccinationProcessor);
    private String caseId="caseId";

    @Before
    public void setUp(){
        initMocks(this);
        childService.setDbRepository(dbRepository);
    }

    @Test
    public void shouldSaveChildIfDoesNotExist_AgeLessThanAYear() {
        String caseId = "caseId";
        DateTime dobOfChild = DateTime.now().minusMonths(1);
        Child child = new ChildBuilder().withCaseId(caseId).withDOB(dobOfChild).withMeaslesDate(new DateTime(2012, 2, 1, 0, 0, 0)).withVitamin1Date(new DateTime(2012, 8, 7, 0, 0, 0)).build();
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);
        ArgumentCaptor<Child> captor = ArgumentCaptor.forClass(Child.class);
        childService.process(child);
        verify(dbRepository).save(captor.capture());
        Child actualChild = captor.getValue();
        Assert.assertEquals(caseId, actualChild.getCaseId());
        Assert.assertEquals(CaseType.Child.getType(), actualChild.getCaseType());
        Assert.assertNull(actualChild.getDocCreateTime());
        Assert.assertEquals(DateTime.parse("2012-02-01"), actualChild.getMeaslesDate());
        Assert.assertEquals(DateTime.parse("2012-08-07"),actualChild.getVitamin1Date());
        verify(vaccinationProcessor).enrollUpdateVaccines(actualChild);
        verify(vaccinationProcessor, never()).closeSchedules(any(Child.class));
    }

    @Test
    public void shouldSaveChildIfAgeMoreThanAYearButShouldNotEnrollForAnySchedules() {
        String caseId = "caseId";
        DateTime dob = new DateTime(2011, 4, 13, 0, 0);
        Child child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withCaseId(caseId).build();
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);
        childService.process(child);
        verify(dbRepository).save((Child) Matchers.any());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(Child.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(Child.class));
    }

    @Test
    public void shouldNotEnrollForAnySchedulesIfDOBIsNull() {
        String caseId = "caseId";
        Child child = new ChildBuilder().withCaseId(caseId).withDOB(null).withCaseId(caseId).build();
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);
        childService.process(child);
        verify(dbRepository).save((Child) Matchers.any());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(Child.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(Child.class));
    }

    @Test
    public void shouldUpdateChildIfAgeMoreThanAYear() {
        String oldName = "Aryan";
        DateTime newBcgDate = new DateTime(2012, 5, 4, 0, 0, 0);
        String newName = "Vijay";
        DateTime docCreateTime = DateTime.now().minus(1);
        DateTime dob = DateTime.now().plusMonths(5);
        Child child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withCaseId(caseId).withCaseName(newName).withBcgDate(newBcgDate).build();
        Child childInDb = childWithCaseId(caseId);
        childInDb.setName(oldName);
        childInDb.setDocCreateTime(docCreateTime);
        childInDb.setIsAlive(true);
        ArgumentCaptor<Child> captor = ArgumentCaptor.forClass(Child.class);

        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(childInDb);
        childService.process(child);

        verify(dbRepository,never()).save((Child) Matchers.any());
        verify(dbRepository).update(captor.capture());
        Child childUpdated = captor.getValue();
        Assert.assertEquals(newName,childUpdated.getName());
        Assert.assertEquals(docCreateTime,childUpdated.getDocCreateTime());
        Assert.assertEquals(newBcgDate,childUpdated.getBcgDate());
        Assert.assertTrue(childUpdated.isActive());
        verify(vaccinationProcessor).enrollUpdateVaccines(childInDb);
        verify(vaccinationProcessor, never()).closeSchedules(any(Child.class));
    }

    @Test
    public void shouldSaveChildAsInactiveIfItDoesNotExistAndIsDead() throws IOException {
        String caseId = "caseId";
        DateTime dobOfChild = DateTime.now().minusMonths(1);
        Child child = new ChildBuilder().withCaseId(caseId).withDOB(dobOfChild).withMeaslesDate(new DateTime(2012, 2, 1, 0, 0, 0)).withVitamin1Date(new DateTime(2012, 8, 7, 0, 0, 0)).withAlive(false).build();
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);

        childService.process(child);

        ArgumentCaptor<Child> captor=ArgumentCaptor.forClass(Child.class);
        verify(dbRepository).save(captor.capture());

        Child childInDb  = captor.getValue();


        org.junit.Assert.assertFalse(childInDb.isActive());
        org.junit.Assert.assertFalse(childInDb.getIsAlive());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(Child.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(Child.class));
    }

    @Test
    public void shouldSetChildCaseAsExpired_WhenChildCaseIsExpired(){
        Child childFromDb = childWithCaseId(caseId);
        childFromDb.setExpired(false);
        childFromDb.setIsAlive(true);
        childFromDb.setClosedByCommcare(false);

        when(dbRepository.get(any(Class.class), anyString(), anyString())).thenReturn(childFromDb);
        boolean wasExpired = childService.expireCase(caseId);

        assertTrue(wasExpired);

        verify(dbRepository, times(1)).update(childFromDb);

        ArgumentCaptor<Child> captor = ArgumentCaptor.forClass(Child.class);
        verify(dbRepository).update(captor.capture());
        Child child = captor.getValue();
        assertTrue(child.getExpired());
    }

    @Test
    public void shouldSetChildCaseAsClosedByCommcareAndCloseSchedulesIfExists_WhenChildCaseIsClosed(){
        Child childFromDb = childWithCaseId(caseId);
        childFromDb.setClosedByCommcare(false);
        childFromDb.setIsAlive(true);

        when(dbRepository.get(any(Class.class), anyString(), anyString())).thenReturn(childFromDb);
        boolean wasClosed = childService.closeCase(caseId);

        org.junit.Assert.assertTrue(wasClosed);

        verify(dbRepository, times(1)).update(childFromDb);
        verify(vaccinationProcessor).closeSchedules(childFromDb);

        ArgumentCaptor<Child> captor = ArgumentCaptor.forClass(Child.class);
        verify(dbRepository).update(captor.capture());
        Child child = captor.getValue();
        assertFalse(child.isActive());
        assertTrue(child.getClosedByCommcare());
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExists(){
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = childService.closeCase(caseId);

        org.junit.Assert.assertFalse(wasClosed);
    }

    @Test
    public void shouldReturnTrueIfChildInactiveWhileExpiringChild(){
        Child childFromDb = childWithCaseId(caseId);
        childFromDb.setExpired(true);
        when(dbRepository.get(any(Class.class), anyString(), anyString())).thenReturn(childFromDb);
        boolean wasClosed = childService.expireCase(caseId);
        assertTrue(wasClosed);
    }

    @Test
    public void shouldReturnFalseIfChildCaseDoesNotExistsWhileExpiringCase(){
        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = childService.expireCase(caseId);
        assertFalse(wasClosed);
    }

    @Test(expected = RuntimeException.class)
    public void testToCheckThatClientIsAlwaysSavedFirstBeforeSchedulingHerForVaccinations(){

        Child childFromDb = childWithCaseId(caseId);
        childFromDb.setClosedByCommcare(false);
        childFromDb.setIsAlive(true);

        when(dbRepository.get(Child.class, "caseId", caseId)).thenReturn(childFromDb);

        doThrow(new RuntimeException()).when(dbRepository).update(Matchers.<Child>any());

        Child child = new ChildBuilder().withCaseId(caseId).build();
        childService.process(child);

        verify(dbRepository).update(any(Child.class));
        verify(vaccinationProcessor,never()).enrollUpdateVaccines(Matchers.<Child>any());

    }

    private Child childWithCaseId(String caseId) {
        Child child = new Child();
        child.setCaseId(caseId);
        return child;
    }

}
