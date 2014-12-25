package org.motechproject.care.reporting.query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class RowMapper {

    private static final Logger LOGGER = Logger.getLogger(RowMapper.class);

    public static Map<String, Object> convertRow(ResultSet rs) {
        Map<String, Object> rows = new HashMap<>();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int columnIndex = 1; columnIndex < rsmd.getColumnCount(); columnIndex++) {
                while (rs.next()) {
                    rows.put(rsmd.getColumnName(columnIndex), rs
                            .getObject(columnIndex));
                }
            }
        } catch (SQLException sqle) {
            LOGGER.error(sqle.getMessage());
        }
        return rows;
    }

}
