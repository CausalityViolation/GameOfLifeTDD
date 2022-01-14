package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class GameLoopTest {

    @Test
    void doesNothingIfGameIsNotRunning() {

        TestGame testGame = new TestGame();
        GameLoop gameLoop = new GameLoop(testGame);

        gameLoop.run();

        Assertions.assertFalse(testGame.isUpdated);
    }

    @Test
    void updatesOnceIfGameIsRunning() {

        TestGame testGame = new TestGame();
        GameLoop gameLoop = new GameLoop(testGame);

        gameLoop.run();

        assertTrue(testGame.isUpdated);

    }


    public static class TestGame implements Game {

        public boolean isUpdated;
    }
}
