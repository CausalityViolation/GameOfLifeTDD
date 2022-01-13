import game.Board;
import game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BoardTest {

    public static final Cell.stateOfCell O = Cell.stateOfCell.ALIVE;
    public static final Cell.stateOfCell X = Cell.stateOfCell.DEAD;

    @Test
    void boardShouldSaveItsInitialState() {
        Cell.stateOfCell[][] initialStateOfThePlayingField = {
                {O, X, O, X},
                {X, X, X, O},
                {O, X, O, O},
                {X, X, O, O},
        };
        Board playingField = new Board(initialStateOfThePlayingField);

        Cell.stateOfCell[][] actual = playingField.getState();
        assertArrayEquals(initialStateOfThePlayingField, actual);

    }

}
