package org.motechproject.care.reporting.query;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


public class PreparedStatementFactory {
	
	private final static Logger LOGGER = Logger.getLogger(ConnectionUtil.class);
	
	private final static String PARAM_SUFFIX = "=/?";
	
	
	private PreparedStatement statement;
	
	private String query;
	
	private Connection connection;
		
	public PreparedStatementFactory(Connection connection, String query) {
		
		this.connection = connection;
		this.query = query;
	    try {
			this.statement = connection.prepareStatement(this.query);
		} catch (SQLException sqle) {
			LOGGER.error(sqle.getMessage());
		}
	}
	
	
	
	public Map<String,Object> executeQuery(Map<String,Object> params) {
		try {
			buildSQLParameters(params, query);
			return RowMapper.convertRow(this.statement.executeQuery());
		} catch (SQLException sqle) {
			LOGGER.error(sqle.getMessage());
			return null;
		}
		
	}
	
	public void buildSQLParameters(Map<String, Object> params, String query) throws SQLException {
		Map<Integer, Object> orderedParams = arrangeParamtersInOrder(params);
		int paramCounter =1;
		for(Integer key:  orderedParams.keySet()) {
			this.statement.setObject(paramCounter,orderedParams.get(key));
			paramCounter++;
		}
	}
	
	
	private Map<Integer,Object> arrangeParamtersInOrder(Map<String, Object> params) {
		
		Map<Integer, Object> orderedParams = new TreeMap<>();
		for(String param : params.keySet()) {
			Pattern pattern = Pattern.compile(param+PARAM_SUFFIX);
			Matcher matcher = pattern.matcher(query);
			while(matcher.find()) {
				orderedParams.put(query.indexOf(matcher.group()),params.get(param));
			}
		}
		return orderedParams;
	}
	
	
	
	public void close() {
		 try {
			statement.close(); 
			connection.close();
		} catch (SQLException sqle) {
			LOGGER.error(sqle.getMessage());
		}
	}
	

}
