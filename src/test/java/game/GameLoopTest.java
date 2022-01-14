package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GameLoopTest {

    @Test
    void doesNothingIfGameIsNotRunning() {

        TestGame testGame = new TestGame();
        testGame.setIsRunning(false);
        GameLoop gameLoop = new GameLoop(testGame);

        gameLoop.run();

        Assertions.assertFalse(testGame.isUpdated);
    }

    @Test
    void updatesOnceIfGameIsRunning() {

        TestGame testGame = new TestGame();
        testGame.setIsRunning(true, false);
        GameLoop gameLoop = new GameLoop(testGame);

        gameLoop.run();

        assertTrue(testGame.isUpdated);

    }

    @Test
    void updatesAsLongAsGameIsRunning() {

        TestGame testGame = new TestGame();
        testGame.setIsRunning(true, true, true, false);
        GameLoop loop = new GameLoop(testGame);

        loop.run();

        assertEquals(3, testGame.numerOfIterations);

    }


    public static class TestGame implements Game {

        public int numerOfIterations;
        private boolean isUpdated;
        private Queue<Boolean> isRunning;

        public void setIsRunning(Boolean... isRunningValues) {
            List<Boolean> values = Arrays.asList(isRunningValues);
            this.isRunning = new LinkedList<>(values);
        }

        public void update() {
            isUpdated = true;
            numerOfIterations++;
        }

        public boolean isRunning() {
            return isRunning.poll();
        }
    }
}
