package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static java.sql.Date utilDateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Date sqlDateToUtilDate(java.sql.Date date) {
        return new Date(date.getTime());
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
