package org.motechproject.care.reporting.job;

import java.lang.reflect.InvocationTargetException;

import org.motechproject.care.reporting.service.ICareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComputeFieldsJob implements Job {

    ICareService careService;

    @Autowired
    public ComputeFieldsJob(ICareService careService) {
        this.careService = careService;
    }

    private static final Logger logger = LoggerFactory
            .getLogger("commcare-reporting-mapper");

    @Override
    public void run() throws IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        logger.info("Starting Computed Fields Population");
        long startTime = System.currentTimeMillis();
        careService.computeFieldsJob();
        long endTime = System.currentTimeMillis();
        logger.info(String.format(
                "Completed Computed Fields Population in %s seconds",
                ((endTime - startTime) / 1000)));
    }
}
