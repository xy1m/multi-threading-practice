package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_4_simple_date_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class SimpleDateFormatThreadLocalThread extends Thread {
    private SimpleDateFormat sdf;
    private String dateString;

    public SimpleDateFormatThreadLocalThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    public void run() {
        String pattern = "yyyy-MM-dd";
        try {
            Date dateRef = DateToolsThreadLocalmpl.getSimpleDateFormat(pattern).parse(dateString);
            String newDateString = DateToolsThreadLocalmpl.getSimpleDateFormat(pattern).format(dateRef);
            if (!dateString.equals(newDateString)) {
                System.out.println("ThreadName=" + this.getName() + " error dateString=" + dateString + " newDateString=" + newDateString);
            }
            else {
                System.out.println("ThreadName=" + this.getName() + " DONE");
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
