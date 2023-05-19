package org.example.model;

public class Player {

    private String id;
    private int currentNumber;

    public Player() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Player(String id) {
        this.id = id;
        this.currentNumber = 1;
    }
}
