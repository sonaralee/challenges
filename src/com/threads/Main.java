package com.threads;

public class Main {
    public static void main(String[] args) {
        Countdown cd = new Countdown();

        CountdownThread t1 = new CountdownThread(cd);
        t1.setName("Thread 1");

        CountdownThread t2 = new CountdownThread(cd);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

    static class Countdown {
        public void doCountdown() {
            String color;

            switch(Thread.currentThread().getName()) {
                case "Thread 1":
                    color = ThreadColor.ANSI_CYAN;
                    break;
                case "Thread 2":
                    color = ThreadColor.ANSI_PURPLE;
                    break;
                default:
                    color = ThreadColor.ANSI_GREEN;
            }

            synchronized(this) {
                for (int i = 10; i > 0; i--) {
                    System.out.println(color
                            + Thread.currentThread().getName()
                            + ": i =" + i);
                }
            }
        }
    }

    static class CountdownThread extends Thread {
        private Countdown threadCountdown;

        public CountdownThread(Countdown cd) {
            threadCountdown = cd;
        }

        public void run() {
            threadCountdown.doCountdown();
        }
    }
}

