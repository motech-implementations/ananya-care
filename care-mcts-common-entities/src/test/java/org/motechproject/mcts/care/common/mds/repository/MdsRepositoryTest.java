package org.motechproject.mcts.care.common.mds.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.motechproject.mcts.care.common.mds.model.MctsPregnantMother;
import org.motechproject.mcts.care.common.mds.service.MctsPregnantMotherMDSService;
import org.motechproject.mcts.care.common.mds.service.MdsServiceFactory;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.QueryExecution;
import org.motechproject.mds.query.SqlQueryExecution;
import org.motechproject.mds.service.MotechDataService;

@RunWith(MockitoJUnitRunner.class)
public class MdsRepositoryTest {

	@InjectMocks
	MdsRepository dbRepository = new MdsRepository();

	@Mock
	private MctsPregnantMotherMDSService mctsPregnantMotherMDSService;

	@Mock
	private MdsServiceFactory mdsServiceFactory;

	List<MctsPregnantMother> motherList = new ArrayList<MctsPregnantMother>();
	MctsPregnantMother mother1 = new MctsPregnantMother();
	
	Map<String, Object> params = new HashMap<String, Object>();
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		params.put("name", "soniya devi");
		params.put("mctsId", "123456789");

		mother1.setName("soniya devi");
		mother1.setFatherHusbandName("Dharmandra Sada");
		mother1.setHindiName("soniya devi");
		mother1.setHindiFatherHusbandName("Dharmandra Sada");

		MctsPregnantMother mother2 = new MctsPregnantMother();
		mother2.setName("Ranju Devi");
		mother2.setFatherHusbandName("Dilkush Kamat");
		mother2.setHindiName("Ranju Devi");
		mother2.setHindiFatherHusbandName("Dilkush Kamat");

		motherList.add(mother1);
		motherList.add(mother2);

		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
				.thenReturn((MotechDataService) mctsPregnantMotherMDSService);
		when(mdsServiceFactory.fetchDefaultServiceInterface())
		.thenReturn((MotechDataService) mctsPregnantMotherMDSService);

	}

	@Test
	public void testSave() {

		when(mctsPregnantMotherMDSService.create(mother1)).thenReturn(mother1);
		when(mctsPregnantMotherMDSService.getDetachedField(mother1, "id"))
				.thenReturn(1l);
		int returned = dbRepository.save(mother1);
		assertEquals(1, returned);
		verify(mdsServiceFactory).fetchServiceInterface(any(Class.class));
		verify(mctsPregnantMotherMDSService).create(mother1);
		verify(mctsPregnantMotherMDSService).getDetachedField(mother1, "id");
	}
	
	@Test
	public void getDetachedFieldIdWithInstanceNull() {
		Integer returned = dbRepository.getDetachedFieldId(null);
		int returnValue = (int) returned;
		assertEquals(-1, returnValue);
	}
	

	@Test
	public void getDetachedFieldIdTest() {
		when(mctsPregnantMotherMDSService.getDetachedField(mother1, "id"))
				.thenReturn(1l);
		int returned = dbRepository.getDetachedFieldId(mother1);
		assertEquals(1, returned);
		verify(mdsServiceFactory).fetchServiceInterface(any(Class.class));
		verify(mctsPregnantMotherMDSService).getDetachedField(mother1, "id");
	}

	@Test
	public void findEntitiesByFieldTest() {
		when(
				mctsPregnantMotherMDSService
						.retrieveAll((List<Property>) anyObject())).thenReturn(
				motherList);
		List<MctsPregnantMother> list = dbRepository.findEntitiesByField(
				MctsPregnantMother.class, "mctsId", "123456");
		verify(mdsServiceFactory).fetchServiceInterface(any(Class.class));
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());
	}
	
	@Test
	public void findEntitiesByFieldWithConstraintWithServiceNullTest() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		List<MctsPregnantMother> list = dbRepository
				.findEntitiesByFieldWithConstraint(MctsPregnantMother.class,
						"creationTime", 123, 456);
		assertEquals(null, list);
		
	}
	
	@Test
	public void findEntitiesByFieldTestWithServiceNull() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		List<MctsPregnantMother> list = dbRepository.findEntitiesByField(
				MctsPregnantMother.class, "mctsId", "123456");
		
		assertEquals(null,list);
	}

	@Test
	public void shouldGet() {
		when(mctsPregnantMotherMDSService.retrieve(anyString(), anyObject()))
				.thenReturn(mother1);
		MctsPregnantMother mother = dbRepository.get(MctsPregnantMother.class,
				"mctsId", "123456");
		verify(mdsServiceFactory).fetchServiceInterface(any(Class.class));
		assertEquals("soniya devi", mother.getName());
	}
	
	@Test
	public void testSaveWithInstanceNull() {
		Integer returned = dbRepository.save(null);
		int reternValue = (int) returned;
		assertEquals(-1, reternValue);
	}
	
	@Test
	public void testSaveWithServiceNull() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		Integer returned = dbRepository.save(mother1);
		assertEquals(null, returned);
	}
	
	@Test
	public void shouldGetWithServiceNull() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		MctsPregnantMother mother = dbRepository.get(MctsPregnantMother.class,
				"mctsId", "123456");
		MctsPregnantMother mother1 = dbRepository.get(MctsPregnantMother.class, params, null);
		assertEquals(null, mother);
		assertEquals(null, mother1);
	}

	@Test
	public void shouldSaveOrUpdateAll() {
		dbRepository.saveOrUpdateAll(motherList);
		verify(mctsPregnantMotherMDSService, times(2)).create(
				(MctsPregnantMother) anyObject());
	}

	@Test
	public void shouldUpdate() {
		dbRepository.update(mother1);
		verify(mctsPregnantMotherMDSService).update(mother1);
	}
	
	@Test
	public void updateWithNullService() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		dbRepository.update(mother1);
		verify(mctsPregnantMotherMDSService, times(0)).update(mother1);
	}
	
	@Test
	public void deleteWithServiceNull() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		dbRepository.delete(mother1);
		verify(mctsPregnantMotherMDSService, times(0)).delete(mother1);
	}

	@Test
	public void findEntitiesByFieldWithConstraintTest() {
		when(
				mctsPregnantMotherMDSService
						.retrieveAll((List<Property>) anyObject())).thenReturn(
				motherList);
		List<MctsPregnantMother> list = dbRepository
				.findEntitiesByFieldWithConstraint(MctsPregnantMother.class,
						"creationTime", 123, 456);
		verify(mctsPregnantMotherMDSService).retrieveAll(
				(List<Property>) anyObject());
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());
	}

	@Test
	public void findAllByFieldTest() {
		List<String> values = new ArrayList<String>();
		values.add("123");
		values.add("456");
		when(
				mctsPregnantMotherMDSService
						.executeQuery((QueryExecution<List>) anyObject()))
				.thenReturn(motherList);
		List<MctsPregnantMother> list = dbRepository.findAllByField(
				MctsPregnantMother.class, values, "mctsId");
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());

	}

	@Test
	public void getListOfObjectsTest() {
		
		when(
				mctsPregnantMotherMDSService
						.executeQuery((QueryExecution<List>) anyObject()))
				.thenReturn(motherList);
		dbRepository.getListOfObjects(MctsPregnantMother.class, params);
		List<MctsPregnantMother> list = dbRepository.getListOfObjects(
				MctsPregnantMother.class, params);
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());

	}
	
	@Test
	public void getListOfObjectsTestWithServiceNull() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "soniya devi");
		params.put("mctsId", "123456789");
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		List<MctsPregnantMother> list = dbRepository.getListOfObjects(MctsPregnantMother.class, params);
		assertEquals(null,list);
	}
	

	@Test
	public void shouldGetWithFieldMap() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "soniya devi");
		params.put("mctsId", "123456789");
		when(
				mctsPregnantMotherMDSService
						.executeQuery((QueryExecution<List>) anyObject()))
				.thenReturn(motherList);
		dbRepository.get(MctsPregnantMother.class, params, null);
		MctsPregnantMother mother = dbRepository.get(MctsPregnantMother.class,
				params, null);
		assertEquals("soniya devi", mother.getName());
	}

	@Test
	public void shouldDelete() {
		dbRepository.delete(mother1);
		verify(mctsPregnantMotherMDSService).delete(
				(MctsPregnantMother) anyObject());
	}

	@Test
	public void shouldExecuteJDOwithProperty() {
		when(
				mctsPregnantMotherMDSService
						.retrieveAll((List<Property>) anyObject())).thenReturn(
				motherList);
		List<MctsPregnantMother> list = dbRepository.executeJDO(
				MctsPregnantMother.class, (List<Property>) anyObject());
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());
		verify(mctsPregnantMotherMDSService).retrieveAll(
				(List<Property>) anyObject());

	}

	@Test
	public void shouldExecuteJDOwithQuery() {
		when(
				mctsPregnantMotherMDSService
						.executeQuery((QueryExecution<List>) anyObject()))
				.thenReturn(motherList);
		List<MctsPregnantMother> list = dbRepository.executeJDO(
				MctsPregnantMother.class, (QueryExecution<List>) anyObject());
		assertEquals(2, list.size());
		assertEquals("soniya devi", list.get(0).getName());
		verify(mctsPregnantMotherMDSService).executeQuery(
				(QueryExecution<List>) anyObject());
	}
	
	@Test
	public void shouldExecuteJDOwithServiceNull() {
		when(mdsServiceFactory.fetchServiceInterface(any(Class.class)))
		.thenReturn(null);
		List<MctsPregnantMother> list = dbRepository.executeJDO(
				MctsPregnantMother.class, (QueryExecution<List>) anyObject());
		List<MctsPregnantMother> list2 = dbRepository.executeJDO(
				MctsPregnantMother.class, (List<Property>) anyObject());
		assertEquals(null, list);
		assertEquals(null, list2);
	}

	@Test
	public void getObjectByPrimaryKeyTest() {
		when(mctsPregnantMotherMDSService.retrieve("id", 11)).thenReturn(
				mother1);
		MctsPregnantMother mother = dbRepository.getObjectByPrimaryKey(
				MctsPregnantMother.class, 11);
		assertEquals("soniya devi", mother.getName());
		verify(mctsPregnantMotherMDSService).retrieve("id", 11);

	}
	
	@Test
	public void executeTest() {
		List<String> values = new ArrayList<String>();
		values.add("123");
		values.add("456");
		when(mctsPregnantMotherMDSService.executeSQLQuery((SqlQueryExecution<List<String>>)anyObject())).thenReturn(values);
		Object returned = dbRepository.execute("asdfg");
		assertEquals(null, returned);
		
	}
	
	
}
