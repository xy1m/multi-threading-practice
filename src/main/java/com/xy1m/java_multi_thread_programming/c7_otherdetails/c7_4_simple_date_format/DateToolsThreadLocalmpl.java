package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_4_simple_date_format;

import java.text.SimpleDateFormat;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class DateToolsThreadLocalmpl {
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(String formatPattern) {
        SimpleDateFormat sdf = null;
        sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(formatPattern);
            local.set(sdf);
        }
        return sdf;
    }

}
