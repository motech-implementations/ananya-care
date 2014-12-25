package org.motechproject.care.reporting.migration;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.motechproject.care.reporting.migration.service.CommcareSyncValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommcareSyncValidator {

    private static final Logger logger = LoggerFactory
            .getLogger(CommcareSyncValidator.class);

    private CommcareSyncValidatorService commcareSyncValidatorService;

    @Autowired
    public CommcareSyncValidator(
            CommcareSyncValidatorService commcareSyncValidatorService) {
        this.commcareSyncValidatorService = commcareSyncValidatorService;
    }

    public static void main(String[] args) {
        DateTime startTime = DateTime.now();

        logger.info("Running Commcare sync validation ...");
        boolean success = true;

        Exception exception = null;
        try {
            execute(args);
        } catch (IllegalArgumentException e) {
            exception = e;
            System.out.println("Error: " + e.getMessage());
            System.out.println("Usage: "
                    + CommcareSyncValidatorArguments.usage());
            success = false;
        } catch (RuntimeException e) {
            exception = e;
            System.out.print("Error: " + e.getMessage());
            System.out.println("Commcare sync validation Failed");
            success = false;
        }

        if (success) {
            logger.info("Commcare sync validation ended.");
        } else {
            logger.error(
                    "Exception occurred while running Commcare sync validation",
                    exception);
            logger.error("Commcare sync validation failed.");
        }

        System.out.printf(
                "Total time taken for Commcare sync validation: %d mins %n",
                new Duration(startTime, DateTime.now()).getStandardMinutes());
        System.exit(success ? 0 : 1);

    }

    private static void execute(final String[] args) {
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationCareMigration.xml");

        final CommcareSyncValidatorArguments commcareSyncValidatorArguments = new CommcareSyncValidatorArguments(
                args);

        final CommcareSyncValidator commcareSyncValidator = applicationContext
                .getBean(CommcareSyncValidator.class);
        commcareSyncValidator.validate(commcareSyncValidatorArguments);
        applicationContext.destroy();
    }

    private void validate(
            CommcareSyncValidatorArguments commcareSyncValidatorArguments) {
        commcareSyncValidatorService.validate(commcareSyncValidatorArguments);
        ;
    }

}
