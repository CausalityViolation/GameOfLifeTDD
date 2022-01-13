import game.Board;
import game.Cell.stateOfCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BoardTest {

    public static final stateOfCell O = stateOfCell.ALIVE;
    public static final stateOfCell X = stateOfCell.DEAD;

    @Test
    void boardShouldSaveItsInitialState() {
        stateOfCell[][] initialStateOfThePlayingField = {
                {O, X, O, X},
                {X, X, X, O},
                {O, X, O, O},
                {X, X, O, O},
        };
        Board playingField = new Board(initialStateOfThePlayingField);

        stateOfCell[][] actual = playingField.getState();
        assertArrayEquals(initialStateOfThePlayingField, actual);

    }

}
