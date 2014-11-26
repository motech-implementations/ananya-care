package org.motechproject.care.service;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.care.request.CaseType;
import org.motechproject.care.service.builder.ChildBuilder;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.repository.Repository;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ChildServiceTest {

    @Mock
    private Repository dbRepository;

    @Mock
    private VaccinationProcessor vaccinationProcessor;
    private ChildService childService;
    private String caseId="caseId";

    @Before
    public void setUp(){
        initMocks(this);
        childService = new ChildService(vaccinationProcessor);
    }

    @Test
    public void shouldSaveChildIfDoesNotExist_AgeLessThanAYear() {
        String caseId = "caseId";
        DateTime dobOfChild = DateTime.now().minusMonths(1);
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dobOfChild).withMeaslesDate(new DateTime(2012, 2, 1, 0, 0, 0)).withVitamin1Date(new DateTime(2012, 8, 7, 0, 0, 0)).build();
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);
        ArgumentCaptor<ChildCase> captor = ArgumentCaptor.forClass(ChildCase.class);
        childService.process(child);
        verify(dbRepository).save(captor.capture());
        ChildCase actualChild = captor.getValue();
        Assert.assertEquals(caseId, actualChild.getCaseId());
        Assert.assertEquals(CaseType.Child.getType(), actualChild.getCaseType());
        Assert.assertNull(actualChild.getCreationTime());
        Assert.assertEquals(DateTime.parse("2012-02-01"), actualChild.getMeaslesDate());
        Assert.assertEquals(DateTime.parse("2012-08-07"),actualChild.getVitA1Date());
        verify(vaccinationProcessor).enrollUpdateVaccines(actualChild);
        verify(vaccinationProcessor, never()).closeSchedules(any(ChildCase.class));
    }

    @Test
    public void shouldSaveChildIfAgeMoreThanAYearButShouldNotEnrollForAnySchedules() {
        String caseId = "caseId";
        DateTime dob = new DateTime(2011, 4, 13, 0, 0);
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withCaseId(caseId).build();
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);
        childService.process(child);
        verify(dbRepository).save((ChildCase) Matchers.any());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(ChildCase.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(ChildCase.class));
    }

    @Test
    public void shouldNotEnrollForAnySchedulesIfDOBIsNull() {
        String caseId = "caseId";
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(null).withCaseId(caseId).build();
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);
        childService.process(child);
        verify(dbRepository).save((ChildCase) Matchers.any());
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(ChildCase.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(ChildCase.class));
    }

    @Test
    public void shouldUpdateChildIfAgeMoreThanAYear() {
        String oldName = "Aryan";
        DateTime newBcgDate = new DateTime(2012, 5, 4, 0, 0, 0);
        String newName = "Vijay";
        DateTime docCreateTime = DateTime.now().minus(1);
        DateTime dob = DateTime.now().plusMonths(5);
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dob).withCaseId(caseId).withCaseName(newName).withBcgDate(newBcgDate).build();
        ChildCase childInDb = childWithCaseId(caseId);
        childInDb.setName(oldName);
        childInDb.setCreationTime(docCreateTime);
        childInDb.setChildAlive("yes");
        ArgumentCaptor<ChildCase> captor = ArgumentCaptor.forClass(ChildCase.class);

        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(childInDb);
        childService.process(child);

        verify(dbRepository,never()).save((ChildCase) Matchers.any());
        verify(dbRepository).update(captor.capture());
        ChildCase childUpdated = captor.getValue();
        Assert.assertEquals(newName,childUpdated.getName());
        Assert.assertEquals(docCreateTime,childUpdated.getCreationTime());
        Assert.assertEquals(newBcgDate,childUpdated.getBcgDate());
        Assert.assertTrue(childUpdated.isActive());
        verify(vaccinationProcessor).enrollUpdateVaccines(childInDb);
        verify(vaccinationProcessor, never()).closeSchedules(any(ChildCase.class));
    }

    @Test
    public void shouldSaveChildAsInactiveIfItDoesNotExistAndIsDead() throws IOException {
        String caseId = "caseId";
        DateTime dobOfChild = DateTime.now().minusMonths(1);
        ChildCase child = new ChildBuilder().withCaseId(caseId).withDOB(dobOfChild).withMeaslesDate(new DateTime(2012, 2, 1, 0, 0, 0)).withVitamin1Date(new DateTime(2012, 8, 7, 0, 0, 0)).withAlive("no").build();
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);

        childService.process(child);

        ArgumentCaptor<ChildCase> captor=ArgumentCaptor.forClass(ChildCase.class);
        verify(dbRepository).save(captor.capture());

        ChildCase childInDb  = captor.getValue();


        org.junit.Assert.assertFalse(childInDb.isActive());
        org.junit.Assert.assertFalse(childInDb.getChildAlive()=="yes");
        verify(vaccinationProcessor, never()).enrollUpdateVaccines(any(ChildCase.class));
        verify(vaccinationProcessor, never()).closeSchedules(any(ChildCase.class));
    }

   /* @Test
    public void shouldSetChildCaseAsExpired_WhenChildCaseIsExpired(){
        ChildCase childFromDb = childWithCaseId(caseId);
        childFromDb.setExpired(false);
        childFromDb.setChildAlive("yes");
        childFromDb.setClosed(false);

        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(childFromDb);
        boolean wasExpired = childService.expireCase(caseId);

        assertTrue(wasExpired);

        verify(dbRepository, times(1)).update(childFromDb);

        ArgumentCaptor<ChildCase> captor = ArgumentCaptor.forClass(ChildCase.class);
        verify(dbRepository).update(captor.capture());
        ChildCase child = captor.getValue();
        assertTrue(child.getExpired());
    }*/

    @Test
    public void shouldSetChildCaseAsClosedByCommcareAndCloseSchedulesIfExists_WhenChildCaseIsClosed(){
        ChildCase childFromDb = childWithCaseId(caseId);
        childFromDb.setClosed(false);
        childFromDb.setChildAlive("yes");

        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(childFromDb);
        boolean wasClosed = childService.closeCase(caseId);

        org.junit.Assert.assertTrue(wasClosed);

        verify(dbRepository, times(1)).update(childFromDb);
        verify(vaccinationProcessor).closeSchedules(childFromDb);

        ArgumentCaptor<ChildCase> captor = ArgumentCaptor.forClass(ChildCase.class);
        verify(dbRepository).update(captor.capture());
        ChildCase child = captor.getValue();
        assertFalse(child.isActive());
        assertTrue(child.getClosed());
    }

    @Test
    public void shouldReturnFalseIfMotherCaseDoesNotExists(){
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = childService.closeCase(caseId);

        org.junit.Assert.assertFalse(wasClosed);
    }

   /* @Test
    public void shouldReturnTrueIfChildInactiveWhileExpiringChild(){
        ChildCase childFromDb = childWithCaseId(caseId);
        childFromDb.setExpired(true);
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(childFromDb);
        boolean wasClosed = childService.expireCase(caseId);
        assertTrue(wasClosed);
    }
*/
    /*@Test
    public void shouldReturnFalseIfChildCaseDoesNotExistsWhileExpiringCase(){
        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(null);
        boolean wasClosed = childService.expireCase(caseId);
        assertFalse(wasClosed);
    }*/

    @Test(expected = RuntimeException.class)
    public void testToCheckThatClientIsAlwaysSavedFirstBeforeSchedulingHerForVaccinations(){

        ChildCase childFromDb = childWithCaseId(caseId);
        childFromDb.setClosed(false);
        childFromDb.setChildAlive("yes");

        when(dbRepository.get(ChildCase.class, "caseId", caseId)).thenReturn(childFromDb);

        doThrow(new RuntimeException()).when(dbRepository).update(Matchers.<ChildCase>any());

        ChildCase child = new ChildBuilder().withCaseId(caseId).build();
        childService.process(child);

        verify(dbRepository).update(any(ChildCase.class));
        verify(vaccinationProcessor,never()).enrollUpdateVaccines(Matchers.<ChildCase>any());

    }

    private ChildCase childWithCaseId(String caseId) {
        ChildCase child = new ChildCase();
        child.setCaseId(caseId);
        return child;
    }

}
