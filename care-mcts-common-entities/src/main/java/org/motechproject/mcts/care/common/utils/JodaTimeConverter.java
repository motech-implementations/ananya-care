package org.motechproject.mcts.care.common.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.beanutils.converters.AbstractConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Util Class which receives date in format of either Timestamp or String and
 * convert it to DateTime format
 *
 * @author aman
 */
public class JodaTimeConverter extends AbstractConverter {

    public JodaTimeConverter() {
        super();
    }

    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if (type == null) {
            type = getDefaultType();
        }
        if (value == null) {
            return null;
        }
        if (value instanceof Timestamp) {
            Long milli = ((Timestamp) value).getTime();
            Date normalDate = new Date(milli);
            DateTime dt = new DateTime(normalDate);
            return (Object) dt;
        }

        if (value instanceof String) {
            String dateInString = value.toString().trim();
            String format = DateUtil.determineDateFormat(dateInString); // Gets
                                                                        // the
                                                                        // format
                                                                        // of
                                                                        // date
                                                                        // in
                                                                        // string.
            if (format == null) { // If the date does not have a known format it
                                  // returns null
                return null;
            }
            if ("yyyy-MM-dd'T'HH:mm:ss.XXX+HH:mm".equals(format)) {
                DateTime dt = DateTime.parse(value.toString());
                return dt;
            }
            DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
            DateTime dt = formatter.parseDateTime(dateInString);
            return dt;
        }

        return null;
    }

    @Override
    protected Class getDefaultType() {
        return DateTime.class;
    }

}