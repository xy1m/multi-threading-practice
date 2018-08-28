package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_4_simple_date_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class DateTools {
    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }

    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date);
    }
}
