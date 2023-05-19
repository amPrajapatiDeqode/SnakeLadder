package org.example.model;

public class Snake {

    private int headNumber, tailNumber;

    public int getHeadNumber() {
        return headNumber;
    }

    public void setHeadNumber(int headNumber) {
        this.headNumber = headNumber;
    }

    public int getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    public Snake(int headNumber, int tailNumber) {
        this.headNumber = headNumber;
        this.tailNumber = tailNumber;
    }
}
