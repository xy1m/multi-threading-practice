package com.xy1m.concurrent.otherdetails.threadgroup;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class ThreadGroupOneLevel {
    public static void main(String... args) {
        ThreadGroup group = new ThreadGroup("George's thread group");
        Thread a = new Thread(group, () -> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread b = new Thread(group, () -> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        b.start();
        System.out.println("group active count:" + group.activeCount());
        System.out.println("group name:" + group.getName());
    }
}
