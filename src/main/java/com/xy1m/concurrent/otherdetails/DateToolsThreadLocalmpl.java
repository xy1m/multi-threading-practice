package com.xy1m.concurrent.otherdetails;

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
