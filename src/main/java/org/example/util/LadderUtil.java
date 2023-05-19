package org.example.util;

import org.example.model.Ladder;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class LadderUtil {

    public ArrayList<Ladder> getLaddersFromUser(Scanner scanner, int size) {

        System.out.println("Please enter number of ladders");
        int numberOfLadders = scanner.nextInt();
        ArrayList<Ladder> ladders = new ArrayList<>();

        for(int i=1; i<=numberOfLadders;) {
            System.out.println("Please enter top number of ladder " + i);
            int ladderTop = scanner.nextInt();
            System.out.println("Please enter bottom number of ladder " + i);
            int ladderBottom = scanner.nextInt();

            if(!validLadder(ladderTop, ladderBottom, size)) {
                System.out.println("Please enter valid ladder...");
                continue;
            };

            i++;
            ladders.add(new Ladder(ladderTop, ladderBottom));
        }

        return ladders;
    }

    public Optional<Ladder> getLadderIfLadderIsPresentOnNextStep(ArrayList<Ladder> ladders, int userDestination) {
        return ladders.stream().filter(ladder -> ladder.getBottomNumber() == userDestination).findFirst();
    }

    public void handleLadderOnNextStep(Optional<Ladder> ladderOnNextStep, Player currentPlayer, int userDestination) {
        System.out.println("Found ladder at " + userDestination);
        System.out.println("Moving user to top of ladder at " + ladderOnNextStep.get().getTopNumber());
        currentPlayer.setCurrentNumber(ladderOnNextStep.get().getTopNumber());
    }

    private boolean validLadder(int ladderTop, int ladderBottom, int size) {
        return ladderTop>ladderBottom && ladderTop<size && ladderBottom<size && ladderBottom>0 && ladderTop>0;
    }
}
