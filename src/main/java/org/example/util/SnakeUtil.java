package org.example.util;

import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class SnakeUtil {

    public ArrayList<Snake> getSnakesFromUser(Scanner scanner, ArrayList<Ladder> ladders, int size) {

        System.out.println("Please enter number of Snakes");
        int numberOfSnakes = scanner.nextInt();

        ArrayList<Snake> snakes = new ArrayList<>();
        for(int i=1; i<=numberOfSnakes;) {
            System.out.println("Please enter number for head of snake " + i);
            int snakeHead = scanner.nextInt();

            System.out.println("Please enter number for tail of snake " + i);
            int snakeTail = scanner.nextInt();

            if(!validSnake(snakeHead, snakeTail, size) || ifSnakeHeadContainsLadderBottom(ladders, snakeHead)) {
                System.out.println("Please enter valid snake...");
                continue;
            }

            i++;
            snakes.add(new Snake(snakeHead, snakeTail));
        }

        return snakes;
    }

    private boolean ifSnakeHeadContainsLadderBottom(ArrayList<Ladder> ladders, int snakeHead) {
        return ladders.stream().anyMatch(ladder -> ladder.getBottom() == snakeHead);
    }

    public Optional<Snake> getSnakeIfSnakeIsPresentOnNextStep(ArrayList<Snake> snakes, int userDestination) {
            return snakes.stream().filter(snake -> snake.getTop() == userDestination).findFirst();
    }

    public void handleSnakeOnNextStep(Optional<Snake> snakeOnNextStep, Player currentPlayer, int userDestination) {
        System.out.println("Found snake at " + userDestination);
        System.out.println("Moving user to snake tail at " + snakeOnNextStep.get().getBottom());
        currentPlayer.setCurrentNumber(snakeOnNextStep.get().getBottom());
    }

    private boolean validSnake(int snakeHead, int snakeTail, int size) {
        return snakeHead>snakeTail && snakeHead<size && snakeTail<size && snakeTail>0 && snakeHead>0;
    }
}
