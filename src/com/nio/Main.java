package com.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("res/data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // fill the buffer with strings and ints
            ByteBuffer bb = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            bb.put(outputBytes); // input
            long int1Pos = outputBytes.length;
            bb.putInt(245); // int1
            long int2Pos = int1Pos + Integer.BYTES;
            bb.putInt(-98765); // int2
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            bb.put(outputBytes2); // input2
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            bb.putInt(1000); // int3
            bb.flip();

            binChannel.write(bb); // <---- write buffer contents to channel

            RandomAccessFile ra = new RandomAccessFile(
                    "res/data.dat", "rwd");
            FileChannel fc = ra.getChannel();

            ByteBuffer rb = ByteBuffer.allocate(Integer.BYTES);
            fc.position(int3Pos); // position at end of data to begin reading it back
            fc.read(rb);
            rb.flip();

            System.out.println("int3 = " + rb.getInt());
            rb.flip();
            fc.position(int2Pos);
            fc.read(rb);
            rb.flip();

            System.out.println("int2 = " + rb.getInt());
            fc.position(int1Pos);
            rb.flip();
            fc.read(rb);
            rb.flip();

            System.out.println("int1 = " + rb.getInt());

            // copy to another file
            RandomAccessFile copy = new RandomAccessFile(
                    "res/datacopy.dat", "rw");
            FileChannel cc = copy.getChannel();
            fc.position(0); // <---- transferFrom() uses relative position, must set pos before
            long numTransferred = cc.transferFrom(fc, 0, fc.size());
            System.out.println("num transferred: " + numTransferred);

            fc.close();
            ra.close();
            cc.close();

            // write data to file
//            byte[] outputString = "Hello, World!".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer ib = ByteBuffer.allocate(Integer.BYTES);
//            ib.putInt(245);
//            ib.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(ib);
//
//            ib.flip();
//            ib.putInt(-98765);
//            ib.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(ib);
//
//            ib.flip();
//            ib.putInt(1000);
//            ib.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(ib);
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));

//            // wrap array of bytes, changes when byte array changes
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes); // <---- write to buffer
//            buffer.flip(); // <---- need to flip in between write/read
//            int numBytes = binChannel.write(buffer); // <---- read from buffer
//            System.out.println("bytes written: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("bytes written: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("bytes written: " + numBytes);
//
//            RandomAccessFile ra = new RandomAccessFile("res/data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if(buffer.hasArray()) {
//                System.out.println("byte buffer = " + new String(buffer.array()));
//            }
//
//            // relative read
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
//
//            // absolute read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0)); // abs read doesn't move buffer
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//
//            channel.close();
//            ra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
