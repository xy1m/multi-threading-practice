package com.xy1m.java_multi_thread_programming.c6_singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonRun {
    private static long cap = 5;

    private static void execEager() {
        System.out.println("===== SingletonEager =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonEager.getInstance().hashCode())).start();
        }
    }

    private static void execLazy() {
        System.out.println("===== SingletonEager =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonLazy.getInstance().hashCode())).start();
        }
    }

    private static void execStaticClass() {
        System.out.println("===== SingletonStaticClass =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonStaticClass.getInstance().hashCode())).start();
        }
    }

    private static void execSerializable() {
        System.out.println("===== SingletonSerializable =====" + System.nanoTime());

        try {
            SingletonSerializable obj = SingletonSerializable.getInstance();
            FileOutputStream fos = new FileOutputStream("SingletonSerializable.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            System.out.println(obj.hashCode());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("SingletonSerializable.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SingletonSerializable obj = (SingletonSerializable) ois.readObject();
            ois.close();
            fis.close();
            System.out.println(obj.hashCode());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void execStaticBlock() {
        System.out.println("===== SingletonStaticBlock =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonStaticBlock.getInstance().hashCode())).start();
        }
    }

    private static void execEnum() {
        System.out.println("===== SingletonEnum =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonEnum.connectionFactory.getConnection().hashCode())).start();
        }
    }

    private static void execEnum2() {
        System.out.println("===== SingletonEnum =====" + System.nanoTime());

        for (int i = 0; i < cap; i++) {
            new Thread(() -> System.out.println(SingletonEnum2.getConnection().hashCode())).start();
        }
    }

    public static void main(String... args) throws InterruptedException {
        execEager();
        Thread.sleep(500);
        execLazy();
        Thread.sleep(500);
        execStaticClass();
        Thread.sleep(500);
        execStaticClass();
        Thread.sleep(500);
        execSerializable();
        Thread.sleep(500);
        execStaticBlock();
        Thread.sleep(500);
        execEnum();
        Thread.sleep(500);
        execEnum2();
    }

}
