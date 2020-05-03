package com.xy1m.concurrent;

/**
 * Created by gzhenpeng on 10/4/18
 */
public class SlowTask implements Runnable {
    private String name;

    public SlowTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + name + " begin " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(name + " DONE");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Task " + name + " end " + System.currentTimeMillis());
        }
    }
}
