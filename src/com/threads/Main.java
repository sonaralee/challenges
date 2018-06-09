package com.threads;

import static com.threads.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        Thread at = new AnotherThread();
        at.setName("-- Another Thread --");
        at.start();

        new Thread(() ->
                System.out.println(ANSI_RED + "Hello from anon class thread"))
                .start();

        StringBuilder sb = new StringBuilder();
        sb.append("/----------\\\n")
          .append("|    Hi    |\n")
          .append("|   From   |\n")
          .append("|   Main   |\n")
          .append("|  Thread  |\n")
          .append("\\----------/");
        System.out.println(ANSI_PURPLE + sb);

        Thread rt = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anon class run");
                try {
                    at.join(2000);
                    System.out.println(ANSI_GREEN + "AnotherThread terminated/timed out, so I'm running again");
                } catch(InterruptedException ie) {
                    System.out.println(ANSI_GREEN + "I couldn't wait after all! I was interrupted");
                }
            }
        });

        rt.start();

//        if((new Random().nextInt()) % 2 == 0) {
//            at.interrupt();
//        }
    }
}
