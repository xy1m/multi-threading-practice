package com.xy1m.concurrent.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gzhenpeng on 8/15/18
 */
public class TimerExample {
    private static Timer timer = new Timer();

    public static class MyClass extends TimerTask {
        @Override
        public void run() {
            System.out.println("Run at time:" + Calendar.getInstance());
        }
    }

    public static void main(String... args) {

    }
}
