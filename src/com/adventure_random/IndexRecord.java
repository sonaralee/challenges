package com.adventure_random;

public class IndexRecord {
    private int startByte, length;

    public IndexRecord(int sb, int l) {
        this.startByte = sb;
        this.length = l;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
