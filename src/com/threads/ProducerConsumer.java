package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.threads.ProducerConsumer.EOF;

public class ProducerConsumer {
    static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(
                                buffer, ThreadColor.ANSI_BLACK, bufferLock);
        MyConsumer consumer1 = new MyConsumer(
                                buffer, ThreadColor.ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(
                                buffer, ThreadColor.ANSI_BLUE, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private final List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    MyProducer(List<String> b, String c, ReentrantLock bl) {
        this.buffer = b;
        this.color = c;
        this.bufferLock = bl;
    }

    @Override
    public void run() {
        Random rand = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(rand.nextInt(1000));
            } catch(InterruptedException ie) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private String color;
    private int total;
    private ReentrantLock bufferLock;

    MyConsumer(List<String> b, String c, ReentrantLock bl) {
        this.buffer = b;
        this.color = c;
        this.bufferLock = bl;
    }

    @Override
    public void run() {

        int counter = 0;

        while(true) {
            if(bufferLock.tryLock()) { // make sure lock is available
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "Counter = " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        System.out.println("Total times executed: " + total);
                        break;
                    } else {
                        System.out.println(color + "Removed "
                                + buffer.remove(0));
                        total++;
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}
