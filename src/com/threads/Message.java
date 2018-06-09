package com.threads;

import java.util.Random;

class Main2 {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;

    Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                "Humpty Dumpty",
                "sat on a wall",
                "All the king's horses",
                "And all the king's men"
        };

        Random random = new Random();

        for (String message1 : messages) {
            message.write(message1);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");
            latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}
