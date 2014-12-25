package org.motechproject.care.reporting.migration;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.migration.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommcareSyncValidatorArguments {
    private static final Logger logger = LoggerFactory
            .getLogger(CommcareSyncValidatorArguments.class);

    private final String[] arguments;
    private HashMap<String, Object> optionsMap = new HashMap<>();

    public CommcareSyncValidatorArguments(String[] arguments) {
        this.arguments = arguments;
        validateArgumentsLength();
        populateArguments();
        logArguments();
    }

    private void logArguments() {
        logger.info("Arguments:");
        for (Map.Entry<String, Object> optionEntry : optionsMap.entrySet()) {
            logger.info(String.format("%s: %s", optionEntry.getKey(),
                    optionEntry.getValue()));
        }
    }

    public static String usage() {
        return "CommcareSyncValidator -c <case-type> - <date-modified-start>\n"
                + "Eg:\n" + "CommcareSyncValidator -c mother -d 2014-12-25\n"
                + "CommcareSyncValidator -c child -d 2014-12-25\n";
    }

    public Map<String, Object> getOptions() {
        return optionsMap;
    }

    private void populateArguments() {
        populateStringOption(NamedArgument.CASETYPE, Constants.CASE_TYPE);
        populateDateOption(NamedArgument.DATE_MODIFIED_START,
                Constants.DATE_MODIFIED_START);
    }

    private void populateStringOption(NamedArgument namedArgument,
            String optionName) {
        String value = getOptionValueFor(namedArgument);
        if (value != null) {
            optionsMap.put(optionName, value);
        }
    }

    private void populateDateOption(NamedArgument argumentName,
            String optionName) {
        String value = getOptionValueFor(argumentName);
        if (value != null) {
            optionsMap.put(optionName, getFormattedDate(value));
        }
    }

    private String getFormattedDate(String date) {
        return DateTime.parse(date).toString("yyyy-MM-dd");
    }

    private String getOptionValueFor(NamedArgument parameter) {
        int foundIndex = -1;
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].startsWith(parameter.option)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1)
            return null;

        if (arguments.length > (foundIndex + 1))
            return arguments[foundIndex + 1];

        throw new IllegalArgumentException(String.format(
                "Invalid %s. Provide value as %s option.", parameter.name,
                parameter.option));
    }

    private void validateArgumentsLength() {
        if (arguments.length == 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }

    private enum NamedArgument {
        CASETYPE("-c", "case type"), DATE_MODIFIED_START("-d",
                "start date modified");
        private final String option;
        private final String name;

        NamedArgument(String option, String name) {
            this.option = option;
            this.name = name;
        }
    }
}
