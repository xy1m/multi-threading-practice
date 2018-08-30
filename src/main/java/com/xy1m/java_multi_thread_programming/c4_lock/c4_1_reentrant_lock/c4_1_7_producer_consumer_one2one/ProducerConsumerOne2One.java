package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_7_producer_consumer_one2one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class ProducerConsumerOne2One {
    static class MyService {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private boolean available = false;
        private int index = 0;

        public void produce() {
            try {
                lock.lock();
                while (available == true) {
                    condition.await();
                }
                //Thread.sleep(1000);
                System.out.println("produce apple " + (++index));
                available = true;
                condition.signal();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void consume() {
            try {
                lock.lock();
                while (available == false) {
                    condition.await();
                }
                //Thread.sleep(1000);
                System.out.println("consume apple " + index);
                available = false;
                condition.signal();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

    }

    static class ProducerThread extends Thread {
        private MyService service;

        public ProducerThread(MyService service) {
            this.service = service;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                service.produce();
            }
        }
    }

    static class ConsumerThread extends Thread {
        private MyService service;

        public ConsumerThread(MyService service) {
            this.service = service;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                service.consume();
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        MyService myService = new MyService();
        ProducerThread producerThread = new ProducerThread(myService);
        ConsumerThread consumerThread = new ConsumerThread(myService);
        producerThread.start();
        consumerThread.start();

        ProducerThread[] producers = new ProducerThread[10];
        ConsumerThread[] consumers = new ConsumerThread[10];
        for (int i = 0; i < 10; i++) {
            producers[i] = new ProducerThread(myService);
            consumers[i] = new ConsumerThread(myService);

            producers[i].start();
            consumers[i].start();
        }
    }
}
