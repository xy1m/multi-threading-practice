package com.xy1m.concurrent.otherdetails;

import java.text.SimpleDateFormat;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class SimpleDateFormatRun {
    public static void main(String... args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{
                "2001-02-12",
                "2003-03-13",
                "2004-04-14",
                "2005-05-15",
                "2012-12-11",
                "2001-02-12",
                "2001-02-12",
                "2015-03-16"};
        for (int i = 0; i < dateStringArray.length; i++) {
            new SimpleDateFormatThread(sdf, dateStringArray[i]).start();
        }

        for (int i = 0; i < dateStringArray.length; i++) {
            new SimpleDateFormatNonSingletonThread(sdf, dateStringArray[i]).start();
        }
        for (int i = 0; i < dateStringArray.length; i++) {
            new SimpleDateFormatThreadLocalThread(sdf, dateStringArray[i]).start();
        }
    }
}
