package org.motechproject.carereporting.utils.date;

import org.apache.commons.lang.time.DateUtils;
import org.motechproject.carereporting.domain.FrequencyEntity;

import java.util.Calendar;
import java.util.Date;

public final class DateResolver {

    private DateResolver() {

    }

    public static Date[] resolveDates(FrequencyEntity frequencyEntity, Date date) {
        Date end = null;
        Date start = null;

        switch (frequencyEntity.getFrequencyName()) {
            case "daily":
                end = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
                start = DateUtils.addDays(end, -1);
                break;
            case "weekly":
                int dayOfWeek = DateUtils.toCalendar(date).get(Calendar.DAY_OF_WEEK);
                end = DateUtils.addDays(date, 2 - dayOfWeek);
                end = DateUtils.truncate(end, Calendar.DAY_OF_MONTH);
                start = DateUtils.addWeeks(end, -1);
                break;
            case "monthly":
                end = DateUtils.truncate(date, Calendar.MONTH);
                start = DateUtils.addMonths(end, -1);
                break;
            case "quarterly":
                int monthOfYear = DateUtils.toCalendar(date).get(Calendar.MONTH);
                end = DateUtils.addMonths(date, -(monthOfYear % 3));
                end = DateUtils.truncate(end, Calendar.MONTH);
                start = DateUtils.addMonths(end, -3);
                break;
            case "yearly":
                end = DateUtils.truncate(date, Calendar.YEAR);
                start = DateUtils.addYears(end, -1);
                break;
            default:
                break;
        }
        return new Date[] {start, end};
    }

    public static Date[] resolveDates(FrequencyEntity frequencyEntity, Date startDate, Date endDate) {
        Date start = null;
        Date end = null;

        switch (frequencyEntity.getFrequencyName()) {
            case "daily":
                start = DateUtils.truncate(startDate, Calendar.DAY_OF_MONTH);
                end = DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH);
                end = DateUtils.addDays(end, 1);
                break;
            case "weekly":
                int dayOfStartWeek = DateUtils.toCalendar(startDate).get(Calendar.DAY_OF_WEEK);
                start = DateUtils.addDays(startDate, 2 - dayOfStartWeek);
                int dayOfEndWeek = DateUtils.toCalendar(endDate).get(Calendar.DAY_OF_WEEK);
                end = DateUtils.addDays(endDate, 2 - dayOfEndWeek);
                start = DateUtils.truncate(start, Calendar.DAY_OF_MONTH);
                end = DateUtils.truncate(end, Calendar.DAY_OF_MONTH);
                end = DateUtils.addWeeks(end, 1);
                break;
            case "monthly":
                start = DateUtils.truncate(startDate, Calendar.MONTH);
                end = DateUtils.truncate(endDate, Calendar.MONTH);
                end = DateUtils.addMonths(end, 1);
                break;
            case "quarterly":
                int monthOfStartYear = DateUtils.toCalendar(startDate).get(Calendar.MONTH);
                start = DateUtils.addMonths(startDate, -(monthOfStartYear % 3));
                int monthOfEndYear = DateUtils.toCalendar(endDate).get(Calendar.MONTH);
                end = DateUtils.addMonths(endDate, -(monthOfEndYear % 3));
                start = DateUtils.truncate(start, Calendar.MONTH);
                end = DateUtils.truncate(end, Calendar.MONTH);
                end = DateUtils.addMonths(end, 3);
                break;
            case "yearly":
                start = DateUtils.truncate(startDate, Calendar.YEAR);
                end = DateUtils.truncate(endDate, Calendar.YEAR);
                end = DateUtils.addYears(end, 1);
                break;
            default:
                break;
        }
        return new Date[] {start, end};
    }

}
