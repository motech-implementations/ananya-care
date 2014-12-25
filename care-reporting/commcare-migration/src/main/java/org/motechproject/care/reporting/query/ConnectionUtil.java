package org.motechproject.care.reporting.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {

    private final static Logger LOGGER = Logger.getLogger(ConnectionUtil.class);

    private Properties jdbcProperties;

    private Properties messageProperties;

    public ConnectionUtil(
            @Qualifier("jdbcProperties") Properties jdbcProperties,
            @Qualifier("messageProperties") Properties messageProperties) {
        this.jdbcProperties = jdbcProperties;
        this.messageProperties = messageProperties;
    }

    public Connection getConnection() {
        try {
            Class.forName(jdbcProperties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            LOGGER.error(printMessage("driver.class.not.found"));
        }
        LOGGER.info(printMessage("driver.registered"));
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcProperties
                    .getProperty("url"),
                    jdbcProperties.getProperty("username"), jdbcProperties
                            .getProperty("password"));
        } catch (SQLException e) {
            LOGGER.error(printMessage("connection.failed"));
        }
        if (connection != null) {
            LOGGER.info(printMessage("connection.established"));
            return connection;
        } else {
            LOGGER.error(printMessage("connection.failed"));
            return null;
        }
    }

    private String printMessage(String key) {
        return messageProperties.getProperty(key);
    }

}
