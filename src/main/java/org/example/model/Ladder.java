package org.example.model;

public class Ladder implements Props {

    private int topNumber, bottomNumber;

    public Ladder(int topNumber, int bottomNumber) {
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
    }


    @Override
    public int getTop() {
        return this.topNumber;
    }

    @Override
    public int getBottom() {
        return this.bottomNumber;
    }

    @Override
    public void setTop(int top) {
        this.topNumber = top;
    }

    @Override
    public void setBottom(int bottom) {
        this.bottomNumber = bottom;
    }
}
