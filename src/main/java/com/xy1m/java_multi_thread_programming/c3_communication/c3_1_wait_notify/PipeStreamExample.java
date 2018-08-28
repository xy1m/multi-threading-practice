package com.xy1m.java_multi_thread_programming.c3_communication.c3_1_wait_notify;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by gzhenpeng on 7/1/18
 */
public class PipeStreamExample {

    class WriteData {
        public void writeMethod(PipedOutputStream out) {
            System.out.println("write:");
            try {
                for (int i = 0; i < 10; i++) {
                    String outdata = "" + i;
                    out.write(outdata.getBytes());
                    System.out.print(outdata);
                }
                System.out.println();
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {

    }
}
