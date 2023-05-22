package org.example.model;

public class Snake implements Props{

    private int headNumber, tailNumber;

    public Snake(int headNumber, int tailNumber) {
        this.headNumber = headNumber;
        this.tailNumber = tailNumber;
    }

    @Override
    public int getTop() {
        return headNumber;
    }

    @Override
    public int getBottom() {
        return tailNumber;
    }

    @Override
    public void setTop(int headNumber) {
        this.headNumber = headNumber;
    }

    @Override
    public void setBottom(int tailNumber) {
        this.tailNumber = tailNumber;
    }
}
