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

        assertEquals(0, testGame.numberOfIterations);
    }

    @Test
    void updatesOnceIfGameIsRunning() {

        testGame.setIsRunning(true, false);
        gameLoop.run();

        assertEquals(1, testGame.numberOfIterations);
    }

    @Test
    void updatesAsLongAsGameIsRunning() {

        testGame.setIsRunning(true, true, true, false);
        gameLoop.run();

        assertEquals(3, testGame.numberOfIterations);
    }

    @Test
    void RendersGameAfterUpdate() {
        testGame.setIsRunning(true, false);
        gameLoop.run();

        assertEquals(1, testGame.numberOfRenders);
    }


    public static class TestGame implements Game {

        public int numberOfIterations;
        public int numberOfRenders;
        private Queue<Boolean> isRunning;

        public void setIsRunning(Boolean... isRunningValues) {
            List<Boolean> values = Arrays.asList(isRunningValues);
            this.isRunning = new LinkedList<>(values);
        }

        public void update() {
            numberOfIterations++;
        }

        public boolean isRunning() {
            return isRunning.poll();
        }

        public void render() {
            if (numberOfRenders != numberOfIterations - 1)
                throw new RenderBeforeGameUpdateException();
            numberOfRenders++;

        }
    }
}
