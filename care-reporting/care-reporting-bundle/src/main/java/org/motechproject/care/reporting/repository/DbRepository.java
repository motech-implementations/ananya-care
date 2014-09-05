package org.motechproject.care.reporting.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.motechproject.mcts.care.common.mds.service.MdsServiceFactory;
import org.motechproject.mcts.care.common.utils.AnnotationUtils;
import org.motechproject.mds.query.EqualProperty;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.PropertyBuilder;
import org.motechproject.mds.query.QueryExecution;
import org.motechproject.mds.query.QueryExecutor;
import org.motechproject.mds.query.SetProperty;
import org.motechproject.mds.service.MotechDataService;
import org.motechproject.mds.util.InstanceSecurityRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbRepository implements org.motechproject.care.reporting.repository.Repository {
    
    @Autowired
    private MdsServiceFactory mdsServiceFactory;
    
    @Override
    public <T> Integer save(T instance) {
        if (instance == null) {
            return -1;
        }
        MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(instance.getClass());
        if (service == null) {
            return null;
        }
        T created = service.create(instance);
        return (Integer) service.getDetachedField(created, "id");
    }

    @Override
    public <T> T get(Class<T> entityClass, String fieldName, Object value) {
        MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(entityClass);
        if (service == null) {
            return null;
        }
        T entity = (T) service.retrieve(fieldName, value);
        return entity;
    }

    @Override
    public <T> void saveOrUpdateAll(List<T> instances) {
        MotechDataService<T> service;
        
        if (instances != null && instances.size() > 0) {
            service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(instances.get(0).getClass());
            if (service == null) {
                return;
            }
            for (T instance : instances) {
                service.create(instance);
            }
        }
    }

    @Override
    public <T> void update(T instance) {
        if (instance != null) {
            MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(instance.getClass());
            if (service == null) {
                return;
            }
            service.update(instance);
        }
    }

    @Override
    public <T> List<T> findAllByField(Class<T> clazz,
            final List<String> values, final String fieldName) {
        MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(clazz);

        if (service == null) {
            return null;
        }
        final List<T> results = service.executeQuery(new QueryExecution<List>() {
            @Override
            public List execute(javax.jdo.Query query,
                    InstanceSecurityRestriction restriction) {
                List<Property> properties = new ArrayList<Property>();
                SetProperty<T> setProperty = (SetProperty<T>) PropertyBuilder
                        .create(fieldName, new HashSet<>(values));
                properties.add(setProperty);
                return (List) QueryExecutor.executeWithArray(query, properties);
            }
        });
        return results;
    }

    @Override
    public <T> T findByExternalPrimaryKey(Class<T> clazz, Object value) {
        return (T) get(clazz, AnnotationUtils.getExternalPrimaryKeyField(clazz).getName(), value);
    }

    @Override
    public <T> T get(Class<T> entityClass, final Map<String, Object> fieldMap,
            final Map<String, String> aliasMapping) {
        MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(entityClass);

        if (service == null) {
            return null;
        }
        final List<T> results = service.executeQuery(new QueryExecution<List>() {
            @Override
            public List execute(javax.jdo.Query query,
                    InstanceSecurityRestriction restriction) {
                List<Property> properties = new ArrayList<Property>();
                if(MapUtils.isNotEmpty(fieldMap)) {
                    for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
                        EqualProperty<T> equalProperty = (EqualProperty<T>) PropertyBuilder.create(entry.getKey(), entry.getValue());
                        properties.add(equalProperty);
                    }
                }
                if(MapUtils.isNotEmpty(aliasMapping)) {
                    for (Map.Entry<String, String> entry : aliasMapping.entrySet()) {
                        EqualProperty<T> equalProperty = (EqualProperty<T>) PropertyBuilder.create(entry.getKey(), entry.getValue());
                        properties.add(equalProperty);
                    }
                }
                return (List) QueryExecutor.executeWithArray(query, properties);
            }
        });
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    @Override
    public <T> void delete(T instance) {
        if (instance != null) {
            MotechDataService<T> service = (MotechDataService<T>) mdsServiceFactory.fetchServiceInterface(instance.getClass());
            if (service == null) {
                return;
            }
            service.delete(instance);
        }
    }

    @Override
    public Object execute(String query) {
        // TODO Auto-generated method stub
        return null;
    }

    
}

