package org.example.util;

import org.example.model.Ladder;
import org.example.model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class LadderUtilTest {

    private LadderUtil ladderUtil;

    @Mock
    private Scanner scanner;

    @Before
    public void setUp() {
        scanner = new Scanner(System.in);
        ladderUtil = new LadderUtil();
    }

    @Test
    public void testGetLadderIfLadderIsPresentOnNextStep_LadderFound() {
        ArrayList<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(5, 1));
        ladders.add(new Ladder(8, 4));
        ladders.add(new Ladder(12, 9));

        Optional<Ladder> result = ladderUtil.getLadderIfLadderIsPresentOnNextStep(ladders, 9);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(12, result.get().getTop());
    }

    @Test
    public void testGetLadderIfLadderIsPresentOnNextStep_LadderNotFound() {
        ArrayList<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(5, 1));
        ladders.add(new Ladder(8, 4));
        ladders.add(new Ladder(12, 9));

        Optional<Ladder> result = ladderUtil.getLadderIfLadderIsPresentOnNextStep(ladders, 6);

        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void testHandleLadderOnNextStep_LadderFound() {
        Optional<Ladder> ladder = Optional.of(new Ladder(10, 5));
        Player player = new Player("John");

        ladderUtil.handleLadderOnNextStep(ladder, player, 5);

        Assert.assertEquals(10, player.getCurrentNumber());
    }

    @Test
    public void testHandleLadderOnNextStep_LadderNotFound() {
        Optional<Ladder> ladder = Optional.of(new Ladder(5, 20));
        Player player = new Player("John");

        ladderUtil.handleLadderOnNextStep(ladder, player, 5);

        Assert.assertEquals(5, player.getCurrentNumber());
    }

    @Test
    public void testValidLadder_ValidLadder() {
        boolean result = ladderUtil.validLadder(10, 5, 15);

        Assert.assertTrue(result);
    }

    @Test
    public void testValidLadder_InvalidLadder_TooLarge() {
        boolean result = ladderUtil.validLadder(20, 5, 15);

        Assert.assertFalse(result);
    }

    @Test
    public void testValidLadder_InvalidLadder_NegativeBottom() {
        boolean result = ladderUtil.validLadder(10, -5, 15);

        Assert.assertFalse(result);
    }

    @Test
    public void testValidLadder_InvalidLadder_TopEqualToSize() {
        boolean result = ladderUtil.validLadder(15, 10, 15);

        Assert.assertFalse(result);
    }
}
