package com.example;

import junit.framework.*;

public class BowlingGameTest extends TestCase{
    
    private BowlingGame bowlingGame;

    protected void setUp() {
        bowlingGame = new BowlingGame();
    } 

    public void testGutterGame() {
        rollMany(20, 0);

        assertEquals(0, bowlingGame.score());
    }

    public void testAllOnes() {
        rollMany(20, 1);

        assertEquals(20, bowlingGame.score());
    }

    public void testOneSpare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17, 0);

        assertEquals(16, bowlingGame.score());
    }

    public void testOneStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);

        assertEquals(24, bowlingGame.score());
    }

    public void testPerfectGame() {
        rollMany(12, 10);

        assertEquals(300, bowlingGame.score());
    }

    private void rollMany(int limit, int pins) {
        for(int i=0; i<limit; i++) {
            bowlingGame.roll(pins);
        }
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }
}
