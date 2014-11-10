package org.motechproject.care.reporting.job;

import java.lang.reflect.InvocationTargetException;

import org.motechproject.care.reporting.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComputeFieldsJob implements Job {

    Service service;

    @Autowired
    public ComputeFieldsJob(Service service) {
        this.service = service;
    }

    private static final Logger logger = LoggerFactory
            .getLogger("commcare-reporting-mapper");

    @Override
    public void run() throws IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        logger.info("Starting Computed Fields Population");
        long startTime = System.currentTimeMillis();
        service.computeFieldsJob();
        long endTime = System.currentTimeMillis();
        logger.info(String.format(
                "Completed Computed Fields Population in %s seconds",
                ((endTime - startTime) / 1000)));
    }
}
