package org.example.util;

import org.example.model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerUtil {

    public ArrayList<Player> getPlayersFromUser(Scanner scanner) {

        int numberOfPlayers = getNumberOfPlayerFromUser(scanner);
        ArrayList<Player> playerList = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers;) {
            System.out.println("Please enter id for " + i + "st user");
            String playerId = scanner.next();

            if (checkIfPlayerAlreadyExist(playerList, playerId)) {
                System.out.println("Player already exists, please enter different id");
                continue;
            }
            i++;
            playerList.add(new Player(playerId));
        }

        return playerList;
    }

    private int getNumberOfPlayerFromUser(Scanner scanner) {
        System.out.println("Please enter number of Players");
        int numberOfPlayers = scanner.nextInt();

        while (numberOfPlayers < 2) {
            System.out.println("Number of Players should be more than 1");
            numberOfPlayers = scanner.nextInt();
        }
        return numberOfPlayers;
    }

    private boolean checkIfPlayerAlreadyExist(ArrayList<Player> players, String playerId) {
        return players.stream().anyMatch(player -> player.getId().equals(playerId));
    }
}
