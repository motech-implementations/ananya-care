package org.motechproject.mcts.care.common.mds.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.jdo.Query;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.motechproject.commons.api.Range;
import org.motechproject.mcts.care.common.mds.service.MdsServiceFactory;
import org.motechproject.mcts.care.common.utils.AnnotationUtils;
import org.motechproject.mds.query.EqualProperty;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.PropertyBuilder;
import org.motechproject.mds.query.QueryExecution;
import org.motechproject.mds.query.QueryExecutor;
import org.motechproject.mds.query.RangeProperty;
import org.motechproject.mds.query.SetProperty;
import org.motechproject.mds.query.SqlQueryExecution;
import org.motechproject.mds.service.MotechDataService;
import org.motechproject.mds.util.InstanceSecurityRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "dbRepository")
public class MdsRepository implements
		org.motechproject.mcts.care.common.mds.repository.Repository {

	@Autowired
	private MdsServiceFactory mdsServiceFactory;

	@SuppressWarnings("unchecked")
	@Override
	public <T> Integer save(T instance) {
		if (instance == null) {
			return -1;
		}
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(instance.getClass());
		if (service == null) {
			return null;
		}
		T created = service.create(instance);
		return (int) (long) service.getDetachedField(created, "id");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObjectByPrimaryKey(Class<T> clazz, Integer primaryId) {
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(clazz);
		if (service == null) {
			return null;
		}
		T entity = (T) service.retrieve("id", primaryId);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Integer getDetachedFieldId(T instance) {
		if (instance == null) {
			return -1;
		}
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(instance.getClass());
		if (service == null) {
			return null;
		}
		return (int) (long) service.getDetachedField(instance, "id");
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> entityClass, String fieldName, Object value) {
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(entityClass);
		if (service == null) {
			return null;
		}
		T entity = (T) service.retrieve(fieldName, value);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <T> List<T> findListOfEntitiesByField(Class<T> entityClass,
			final String fieldName, final Object fieldValue) {
		@SuppressWarnings("unchecked")
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(entityClass);

		if (service == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		EqualProperty<T> rp = (EqualProperty<T>) PropertyBuilder.create(
				fieldName, fieldValue);
		List<Property> proeprties = new ArrayList<Property>();
		proeprties.add(rp);
		final List<T> results = service.retrieveAll(proeprties);

		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> void saveOrUpdateAll(List<T> instances) {
		MotechDataService<T> service;

		if (instances != null && instances.size() > 0) {
			service = (MotechDataService<T>) mdsServiceFactory
					.fetchServiceInterface(instances.get(0).getClass());
			if (service == null) {
				return;
			}
			for (T instance : instances) {
				service.create(instance);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> void update(T instance) {
		if (instance != null) {
			MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
					.fetchServiceInterface(instance.getClass());
			if (service == null) {
				return;
			}
			service.update(instance);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public <T> List<T> findEntityByFieldWithConstarint(Class<T> entityClass,
			final String fieldName, final Object lowerFieldValue,
			final Object higherFieldValue) {
		@SuppressWarnings("unchecked")
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(entityClass);

		if (service == null) {
			return null;
		}
		@SuppressWarnings("unchecked")
		RangeProperty<Object> rp = (RangeProperty<Object>) PropertyBuilder
				.create(fieldName, new Range<Object>(lowerFieldValue,
						higherFieldValue));
		List<Property> proeprties = new ArrayList<Property>();
		proeprties.add(rp);
		final List<T> results = service.retrieveAll(proeprties);

		return results;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> List<T> findAllByField(Class<T> clazz,
			final List<String> values, final String fieldName) {
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(clazz);

		if (service == null) {
			return null;
		}
		final List<T> results = service
				.executeQuery(new QueryExecution<List>() {
					@Override
					public List execute(javax.jdo.Query query,
							InstanceSecurityRestriction restriction) {
						List<Property> properties = new ArrayList<Property>();
						SetProperty<T> setProperty = (SetProperty<T>) PropertyBuilder
								.create(fieldName, new HashSet<>(values));
						properties.add(setProperty);
						return (List) QueryExecutor.executeWithArray(query,
								properties);
					}
				});
		return results;
	}

	@Override
	public <T> T findByExternalPrimaryKey(Class<T> clazz, Object value) {
		return (T) get(clazz, AnnotationUtils.getExternalPrimaryKeyField(clazz)
				.getName(), value);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> List<T> getListOfObject(Class<T> entityClass, final Map<String, Object> fieldMap) {
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(entityClass);

		if (service == null) {
			return null;
		}
		final List<T> results = service
				.executeQuery(new QueryExecution<List>() {
					@Override
					public List execute(javax.jdo.Query query,
							InstanceSecurityRestriction restriction) {
						List<Property> properties = new ArrayList<Property>();
						if (MapUtils.isNotEmpty(fieldMap)) {
							for (Map.Entry<String, Object> entry : fieldMap
									.entrySet()) {
								EqualProperty<T> equalProperty = (EqualProperty<T>) PropertyBuilder
										.create(entry.getKey(),
												entry.getValue());
								properties.add(equalProperty);
							}
						}
						return (List) QueryExecutor.executeWithArray(query,
								properties);
					}
				});
		return CollectionUtils.isEmpty(results) ? null : results;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> T get(Class<T> entityClass, final Map<String, Object> fieldMap,
			final Map<String, String> aliasMapping) {
		MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
				.fetchServiceInterface(entityClass);

		if (service == null) {
			return null;
		}
		final List<T> results = service
				.executeQuery(new QueryExecution<List>() {
					@Override
					public List execute(javax.jdo.Query query,
							InstanceSecurityRestriction restriction) {
						List<Property> properties = new ArrayList<Property>();
						if (MapUtils.isNotEmpty(fieldMap)) {
							for (Map.Entry<String, Object> entry : fieldMap
									.entrySet()) {
								EqualProperty<T> equalProperty = (EqualProperty<T>) PropertyBuilder
										.create(entry.getKey(),
												entry.getValue());
								properties.add(equalProperty);
							}
						}
						if (MapUtils.isNotEmpty(aliasMapping)) {
							for (Map.Entry<String, String> entry : aliasMapping
									.entrySet()) {
								EqualProperty<T> equalProperty = (EqualProperty<T>) PropertyBuilder
										.create(entry.getKey(),
												entry.getValue());
								properties.add(equalProperty);
							}
						}
						return (List) QueryExecutor.executeWithArray(query,
								properties);
					}
				});
		return CollectionUtils.isEmpty(results) ? null : results.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> void delete(T instance) {
		if (instance != null) {
			MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory
					.fetchServiceInterface(instance.getClass());
			if (service == null) {
				return;
			}
			service.delete(instance);
		}
	}

	@Override
	public Object execute(final String query) {
		MotechDataService<?> service = (MotechDataService<?>) mdsServiceFactory
				.fetchDefaultServiceInterface();
		service.executeSQLQuery(new SqlQueryExecution<List<String>>() {
			@Override
			public List<String> execute(Query query) {
				query.execute();
				return null;
			}

			@Override
			public String getSqlQuery() {
				return query;
			}
		});
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> executeJDO(Class<T> clazz, QueryExecution<?> query) {
		MotechDataService<?> service = mdsServiceFactory
				.fetchServiceInterface(clazz);
		if (service == null) {
			return null;
		}
		List<T> list = (List<T>) service.executeQuery(query);

		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> executeJDO(Class<T> clazz, List<Property> properties) {
		MotechDataService<?> service = mdsServiceFactory
				.fetchServiceInterface(clazz);
		if (service == null) {
			return null;
		}
		
		List<T> list = (List<T>) service.retrieveAll(properties);
		return list;
	}

}
