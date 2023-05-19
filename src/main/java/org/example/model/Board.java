package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int size;
    List<Ladder> ladders;
    List<Snake> snakes;
    ArrayList<Player> users;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Player> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Player> users) {
        this.users = users;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }


    public Board(int size, List<Ladder> ladders, List<Snake> snakes, ArrayList<Player> users) {
        this.size = size;
        this.ladders = ladders;
        this.snakes = snakes;
        this.users = users;
    }
}
