package org.motechproject.mcts.care.common.mds.repository;

import java.util.List;
import java.util.Map;

import org.motechproject.mcts.care.common.mds.measure.DomainMetadata;
import org.motechproject.mds.query.QueryExecution;

public interface Repository {

	/**
	 * This creates a new entity T
	 * 
	 * @param instance
	 *            - object of the entity to be created
	 * @return
	 */
	<T> Integer save(T instance);

	/**
	 * This fetches the entityClass object with fieldName = value. If multiple
	 * such records exist, this returns the first one.
	 * 
	 * @param entityClass
	 * @param fieldName
	 * @param value
	 * @return
	 */
	<T> T get(Class<T> entityClass, String fieldName, Object value);

	/**
	 * Receives a list of Object if the object already exist it updates and if
	 * it doesn't it creates a new one
	 * 
	 * @param instances
	 */
	<T> void saveOrUpdateAll(List<T> instances);

	/**
	 * Updates the instance received
	 * 
	 * @param instance
	 */
	<T> T update(T instance);

	/**
	 * Deletes the instance received
	 * 
	 * @param instance
	 */

	<T> void delete(T instance);

	/**
	 * Receives a list of values and a field. Return all the instances which
	 * have those values for the field
	 * 
	 * @param clazz
	 * @param values
	 * @param fieldName
	 * @return
	 */
	<T> List<T> findAllByField(Class<T> clazz, List<String> values,
			String fieldName);

	/**
	 * 
	 * @param clazz
	 * @param value
	 * @return
	 */
	<T> T findByExternalPrimaryKey(Class<T> clazz, Object value);

	/**
	 * Receives the class name and field map which contains field name and field
	 * value and returns a single object
	 * 
	 * @param entityClass
	 * @param fieldMap
	 * @param aliasMapping
	 * @return
	 */
	<T> T get(Class<T> entityClass, Map<String, Object> fieldMap,
			Map<String, String> aliasMapping);

	/**
	 * Receives a query and executes it
	 * 
	 * @param query
	 * @return
	 */
	Object execute(String query);

	/**
	 * Receives a query and the on which it needs to execute and executes the
	 * query
	 * 
	 * @param clazz
	 * @param query
	 * @return
	 */
	<T> Object executeJDO(Class<T> clazz, QueryExecution<?> query);

	/**
	 * Receives a field name and a value and the class. Gets all the object
	 * which have value for the field name
	 * 
	 * @param entityClass
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	<T> List<T> findEntitiesByField(Class<T> entityClass, String fieldName,
			Object fieldValue);

	/**
	 * Receives the primary Id and returns the id which has the same primary Id
	 * 
	 * @param clazz
	 * @param primaryId
	 * @return
	 */
	<T> T getObjectByPrimaryKey(Class<T> clazz, Integer primaryId);

	/**
	 * Gets the primary key of that object
	 * 
	 * @param instance
	 * @return
	 */
	<T> Integer getDetachedFieldId(T instance);

	/**
	 * Gets the list of objects which field value lies between lowerFieldValue
	 * and higherFieldValue
	 * 
	 * @param entityClass
	 * @param fieldName
	 * @param lowerFieldValue
	 * @param higherFieldValue
	 * @return
	 */
	<T> List<T> findEntitiesByFieldWithConstraint(Class<T> entityClass,
			String fieldName, Object lowerFieldValue, Object higherFieldValue);

	/**
	 * 
	 * @param entityClass
	 * @param fieldMap
	 * @return
	 */
	<T> List<T> getListOfObjects(Class<T> entityClass,
			final Map<String, Object> fieldMap);
}
