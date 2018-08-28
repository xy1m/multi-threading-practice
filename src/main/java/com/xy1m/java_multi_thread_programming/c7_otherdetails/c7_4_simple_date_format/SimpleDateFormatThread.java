package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_4_simple_date_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class SimpleDateFormatThread extends Thread {
    private SimpleDateFormat sdf;
    private String dateString;

    public SimpleDateFormatThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    public void run() {
        try {
            Date dateRef = sdf.parse(dateString);
            String newDateString = sdf.format(dateRef).toString();
            if (!dateString.equals(newDateString)) {
                System.out.println("ThreadName=" + this.getName() + " error dateString=" + dateString + " newDateString=" + newDateString);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
