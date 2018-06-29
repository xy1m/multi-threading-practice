package com.xy1m.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Thread=" + Thread.currentThread().getId() + ":" + queue.take());
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
