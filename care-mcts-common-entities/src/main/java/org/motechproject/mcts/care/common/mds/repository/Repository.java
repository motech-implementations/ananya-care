package org.motechproject.mcts.care.common.mds.repository;

import java.util.List;
import java.util.Map;

import org.motechproject.mds.query.QueryExecution;

public interface Repository {
    <T> Integer save(T instance);

    <T> T get(Class<T> entityClass, String fieldName, Object value);

    <T> void saveOrUpdateAll(List<T> instances);

    <T> void update(T instance);

    <T> List<T> findAllByField(Class<T> clazz, List<String> values, String fieldName);

    <T> T findByExternalPrimaryKey(Class<T> clazz, Object value);

    <T> T get(Class<T> entityClass, Map<String, Object> fieldMap, Map<String, String> aliasMapping);

    <T> void delete(T instance);

    Object execute(String query);

    <T> Object executeJDO(Class<T> clazz, QueryExecution<?> query);
    
    <T> List<T> findListOfEntitiesByField(Class<T> entityClass,
			String fieldName, Object fieldValue);
    
    <T> T getObjectByPrimaryKey(Class<T> clazz, Integer primaryId);
    
    <T> Integer getDetachedFieldId(T instance);
    
    <T> List<T> findEntityByFieldWithConstarint(Class<T> entityClass,
			String fieldName, Object lowerFieldValue,
			Object higherFieldValue);
}
