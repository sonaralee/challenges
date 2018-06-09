package com.threads;

import static com.threads.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from "
                            + currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ie) {
            System.out.println(ANSI_BLUE + "Another thread woke me up! >:O");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake.");
    }
}
