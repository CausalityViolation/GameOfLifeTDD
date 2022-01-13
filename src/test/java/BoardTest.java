import game.Board;
import game.Cell.stateOfCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    public static final stateOfCell O = stateOfCell.ALIVE;
    public static final stateOfCell X = stateOfCell.DEAD;

    @Test
    void boardShouldSaveItsInitialState() {
        stateOfCell[][] initialStateOfThePlayingField = {
                {O, X, O},
                {X, X, X},
                {O, X, O},

        };
        Board playingField = new Board(initialStateOfThePlayingField);

        stateOfCell[][] actual = playingField.getState();
        assertArrayEquals(initialStateOfThePlayingField, actual);

    }

    @Test
    void shouldUpdateCell() {
        Board playingField = new Board(new stateOfCell[][]{{O}});
        playingField.update();

        stateOfCell[][] actual = playingField.getState();

        assertEquals(stateOfCell.DEAD, actual[0][0]);
    }

    @Test
    void shouldUpdateAllCells() {
        Board playingField = new Board(new stateOfCell[][]{
                {X, O, O},
                {O, X, O},
                {X, X, O}
        });

        stateOfCell[][] expected = new stateOfCell[][]{
                {X, O, O},
                {X, X, O},
                {X, O, X}
        };

        playingField.update();
        stateOfCell[][] actual = playingField.getState();

        assertArrayEquals(expected, actual);

    }
}
