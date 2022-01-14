package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GameLoopTest {

    private TestGame testGame;
    private GameLoop gameLoop;

    @BeforeEach
    public void setUpGameLoop() {

        testGame = new TestGame();
        gameLoop = new GameLoop(testGame);

    }

    @Test
    void doesNothingIfGameIsNotRunning() {

        testGame.setIsRunning(false);
        gameLoop.run();

        Assertions.assertFalse(testGame.isUpdated);
    }

    @Test
    void updatesOnceIfGameIsRunning() {

        testGame.setIsRunning(true, false);
        gameLoop.run();

        assertTrue(testGame.isUpdated);

    }

    @Test
    void updatesAsLongAsGameIsRunning() {

        testGame.setIsRunning(true, true, true, false);
        gameLoop.run();

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
