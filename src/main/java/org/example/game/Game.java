package org.example.game;

import org.example.model.Board;
import org.example.model.Ladder;
import org.example.model.Snake;
import org.example.model.Player;
import org.example.util.LadderUtil;
import org.example.util.PlayerUtil;
import org.example.util.SnakeUtil;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Scanner scanner = new Scanner(System.in);
    private static LadderUtil ladderUtil = new LadderUtil();
    private static SnakeUtil snakeUtil = new SnakeUtil();
    private static PlayerUtil playerUtil = new PlayerUtil();

    public static void startGame() {

        System.out.println("Welcome to application...");
        System.out.println("Please enter the size of board");
        int size = scanner.nextInt();

        ArrayList<Ladder> ladders = ladderUtil.getLaddersFromUser(scanner, size);
        ArrayList<Snake> snakes = snakeUtil.getSnakesFromUser(scanner, ladders, size);
        ArrayList<Player> playerList = playerUtil.getPlayersFromUser(scanner);

        Board board = new Board(size, ladders, snakes, playerList);

        System.out.println("You are all set starting game now...");
        playGame(board, playerList, snakes, ladders, size);
    }

    private static void playGame(Board board, ArrayList<Player> playerList, ArrayList<Snake> snakes, ArrayList<Ladder> ladders, int size) {
        int rank = 1;
        while (board.getUsers().size() > 1) {
            for (int i=0; i<playerList.size(); i++) {
                Player currentPlayer = playerList.get(i);

                int steps = getNextMove();
                System.out.println(
                        "User has got " + steps + " points, users current position is " + currentPlayer.getCurrentNumber());

                int userDestination = currentPlayer.getCurrentNumber() + steps;
                if (userDestination > size) {
                    System.out.println("Users next step is crossing the board");
                    continue;
                } else if (userDestination == size) {
                    handleUserWonOperation(currentPlayer, playerList, rank);
                    rank++;
                    continue;
                } else {
                    Optional<Snake> snakeOnNextStep = snakeUtil.getSnakeIfSnakeIsPresentOnNextStep(snakes, userDestination);
                    Optional<Ladder> ladderOnNextStep = ladderUtil.getLadderIfLadderIsPresentOnNextStep(ladders, userDestination);

                    if (snakeOnNextStep.isPresent()) {
                        snakeUtil.handleSnakeOnNextStep(snakeOnNextStep, currentPlayer, userDestination);
                    } else if (ladderOnNextStep.isPresent()) {
                        ladderUtil.handleLadderOnNextStep(ladderOnNextStep, currentPlayer, userDestination);
                    } else {
                        System.out.println("Moving player to " + userDestination);
                        currentPlayer.setCurrentNumber(userDestination);
                    }
                }

                if (currentPlayer.getCurrentNumber() == size) {
                    handleUserWonOperation(currentPlayer, playerList, rank);
                    rank++;
                }
            }
            System.out.println("===========================");
        }
        System.out.println("\n\nEnding game now as only player " + playerList.get(0).getId() + " is left");
    }

    private static void handleUserWonOperation(Player currentPlayer, ArrayList<Player> playerList, int rank) {
        System.out.println("Congratulations user " + currentPlayer.getId() + " has got rank : " + rank++);
        playerList.remove(currentPlayer);
    }

    private static int getNextMove() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
