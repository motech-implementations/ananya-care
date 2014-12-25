package org.motechproject.care.reporting.query;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryExecutor {

    private ConnectionUtil connection;

    @Autowired
    public QueryExecutor(ConnectionUtil connection) {
        this.connection = connection;
    }

    public Map<String, Object> execute(String sql, Map<String, Object> params) {
        PreparedStatementFactory sqlFactory = new PreparedStatementFactory(
                connection.getConnection(), sql);
        Map<String, Object> result = sqlFactory.executeQuery(params);
        sqlFactory.close();
        return result;
    }

}
