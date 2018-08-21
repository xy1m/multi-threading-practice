package com.xy1m.concurrent.otherdetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class SimpleDateFormatNonSingletonThread extends Thread {
    private SimpleDateFormat sdf;
    private String dateString;

    public SimpleDateFormatNonSingletonThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    public void run() {
        String pattern = "yyyy-MM-dd";
        try {
            Date dateRef = DateTools.parse(pattern, dateString);
            String newDateString = DateTools.format(pattern, dateRef);
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
