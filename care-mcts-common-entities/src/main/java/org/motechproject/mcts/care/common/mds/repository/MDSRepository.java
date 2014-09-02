package org.motechproject.mcts.care.common.mds.repository;

import static org.motechproject.mcts.care.common.utils.AnnotationUtils.getExternalPrimaryKeyField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jdo.Query;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.motechproject.mds.query.Property;
import org.motechproject.mds.query.PropertyBuilder;
import org.motechproject.mds.query.QueryExecution;
import org.motechproject.mds.query.QueryExecutor;
import org.motechproject.mds.query.SetProperty;
import org.motechproject.mds.service.DefaultMotechDataService;
import org.motechproject.mds.util.InstanceSecurityRestriction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public  class MDSRepository<T> extends DefaultMotechDataService<T> {
   
    public Integer save(T instance) {

        T created = create((T)instance);
        Integer id = (int) (long) getDetachedField(created, "id");
        return id;
    }

   
    public void saveOrUpdateAll(List<T> instances) {
        for (T instance : instances) {
            update(instance);
        }
    }

    @Override
    public T update(T instance) {
        return update(instance);
    }

   
    public void delete(T instance) {
        delete(instance);
    }

   
    //TODO: change the implementation
    public Object execute(final String query) {
        executeQuery(new QueryExecution<List>() {
            @Override
            public List execute(Query query, InstanceSecurityRestriction restriction) {
                query.setFilter("someString == param0");
                query.declareParameters("java.lang.String param0");
                return (List) QueryExecutor.execute(query, "anotherString", restriction);
            }
        });
        final ResultSet[] resultSet = new ResultSet[1];
        /*final Object result = template
                .executeWithNativeSession(new HibernateCallback<Object>() {
                   
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        session.doWork(new Work() {
                           
                            public void execute(Connection connection)
                                    throws SQLException {
                                resultSet[0] = connection.prepareCall(query)
                                        .executeQuery();
                            }
                        });
                        return resultSet[0] == null || !resultSet[0].next() ? null
                                : resultSet[0].getObject(1);
                    }
                });
        template.flush();
        return result;*/
        return null;

    }

   
    public <T> List<T> findAllByField(Class<T> clazz, List<String> values,
            String fieldName) {
        
        SetProperty<T> setProperty = (SetProperty<T>) PropertyBuilder.create(fieldName, values);
        List<Property> properties = new ArrayList<>();
        properties.add(setProperty);
        List<T> results = (List<T>) retrieveAll(properties);
        return results;
    }

   
    public <T> T findByExternalPrimaryKey(Class<T> clazz, Object value) {
        T result = (T) retrieve(getExternalPrimaryKeyField(clazz)
                .getName(), value);
        return result;
    }

   
    public T get(Class<T> entityClass, String fieldName, Object value) {
        return retrieve(fieldName, value);
    }

   //TODO: change the implementation
    public <T> T get(Class<T> entityClass, Map<String, Object> fieldMap,
            Map<String, String> aliasMapping) {
        /*DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

        if(MapUtils.isNotEmpty(aliasMapping)) {
            for (Map.Entry<String, String> alias : aliasMapping.entrySet()) {
                criteria.createAlias(alias.getKey(), alias.getValue());
            }
        }

        for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
            criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        }

        @SuppressWarnings("unchecked")
        List<T> resultFromDb = template.findByCriteria(criteria);
        return CollectionUtils.isEmpty(resultFromDb) ? null : resultFromDb.get(0);*/
        return null;
    }
}
