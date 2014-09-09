package org.motechproject.mcts.care.common.mds.repository;

import java.util.List;
import java.util.Map;

import org.motechproject.mds.query.QueryExecution;

public interface Repository {
    
    /**
     * This creates a new entity T
     * @param instance - object of the entity to be created
     * @return
     */
    <T> Integer save(T instance);

    /**
     * This fetches the entityClass object with fieldName = value.
     * If multiple such records exist, this returns the first one.
     * @param entityClass
     * @param fieldName
     * @param value
     * @return
     */
    <T> T get(Class<T> entityClass, String fieldName, Object value);

    <T> void saveOrUpdateAll(List<T> instances);

    <T> void update(T instance);

    <T> void delete(T instance);

    <T> List<T> findAllByField(Class<T> clazz, List<String> values, String fieldName);

    <T> T findByExternalPrimaryKey(Class<T> clazz, Object value);

    <T> T get(Class<T> entityClass, Map<String, Object> fieldMap, Map<String, String> aliasMapping);

    Object execute(String query);

    <T> Object executeJDO(Class<T> clazz, QueryExecution<?> query);
    
    <T> List<T> findEntitiesByField(Class<T> entityClass,
			String fieldName, Object fieldValue);
    
    <T> T getObjectByPrimaryKey(Class<T> clazz, Integer primaryId);
    
    <T> Integer getDetachedFieldId(T instance);
    
    <T> List<T> findEntitiesByFieldWithConstraint(Class<T> entityClass,
			String fieldName, Object lowerFieldValue,
			Object higherFieldValue);
    
    <T> List<T> getListOfObjects(Class<T> entityClass, final Map<String, Object> fieldMap);
}
