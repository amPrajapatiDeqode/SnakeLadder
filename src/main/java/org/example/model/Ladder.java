package org.example.model;

public class Ladder {

    private int topNumber, bottomNumber;

    public Ladder(int topNumber, int bottomNumber) {
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
    }

    public int getTopNumber() {
        return this.topNumber;
    }

    public int getBottomNumber() {
        return this.bottomNumber;
    }
}
