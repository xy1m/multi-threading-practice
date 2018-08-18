package com.xy1m.concurrent.communication;

/**
 * Created by gzhenpeng on 7/1/18
 */
public class ProducerAndConsumerExample {
    static class ValueValue {
        static String value = "";
    }

    static class Producer {
        private String lock;

        public Producer(String lock) {
            this.lock = lock;
        }

        public void setValue() {
            try {
                synchronized (lock) {
                    if (!ValueValue.value.equals("")) {
                        lock.wait();
                    }
                    String value = "" + System.currentTimeMillis();
                    ValueValue.value = value;
                    System.out.println("set value=" + value);
                    lock.notify();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer {
        private String lock;

        public Consumer(String lock) {
            this.lock = lock;
        }

        public void getValue() {
            try {
                synchronized (lock) {
                    if (ValueValue.value.equals("")) {
                        lock.wait();
                    }
                    System.out.println("get value=" + ValueValue.value);
                    ValueValue.value = "";
                    lock.notify();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {
        String lock = "";
        new Thread(() -> {
            Producer p = new Producer(lock);
            while (true) {
                p.setValue();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Consumer c = new Consumer(lock);
            while (true) {
                c.getValue();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
