package org.motechproject.care.reporting.migration.common;

public class Constants {
    public static final String TYPE = "type";
    public static final String FORM_NAMESPACE = "xmlns";
    public static final String CASE_TYPE = "case_type";
    public static final String VERSION = "version";
    public static final String FORM_VERSION = "appVersion";
    public static final String CASE_VERSION = "appVersion";
    public static final String START_DATE = "start_date";
    public static final String FORM_START_DATE = "received_on_start";
    public static final String CASE_START_DATE = "server_date_modified_start";
    public static final String END_DATE = "end_date";
    public static final String FORM_END_DATE = "received_on_end";
    public static final String CASE_END_DATE = "server_date_modified_end";

    public static final String OFFSET = "offset";
    public static final String LIMIT = "limit";

    public static final int DEFAULT_PAGE_LIMIT = 100;
    public static final int DEFAULT_INITIAL_PAGE_OFFSET = 0;

    // Commcare sync validator constants
    public static final String DATE_MODIFIED_START = "date_modified_start";
    public static final String FORMAT = "format";
    public static final int DEFAULT_OFFSET_SYNC_VALIDATION = 1;
    public static final int DEFAULT_LIMIT_SYNC_VALIDATION = 1;
    public static final String DEFAULT_FORMAT_SYNC_VALIDATION = "json";

}
