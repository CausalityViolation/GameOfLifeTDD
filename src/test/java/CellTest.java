import game.Cell;
import game.Cell.stateOfCell;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    <RULES>

    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by overcrowding.
    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */

@RunWith(JUnitParamsRunner.class)
public class CellTest {

    @Test
    @Parameters({
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD",
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE",
            "ALIVE, 4, DEAD",
            "ALIVE, 5, DEAD",
            "ALIVE, 6, DEAD",
            "ALIVE, 7, DEAD",
            "ALIVE, 8, DEAD",
            "DEAD, 0, DEAD",
            "DEAD, 1, DEAD",
            "DEAD, 2, DEAD",
            "DEAD, 3, ALIVE",
            "DEAD, 4, DEAD",
            "DEAD, 5, DEAD",
            "DEAD, 6, DEAD",
            "DEAD, 7, DEAD",
            "DEAD, 8, DEAD"
    })
    public void shouldFulfillTransition(String initialState, int numberOfNeighbors, String expectedState) {

        Cell cell = new Cell(stateOfCell.valueOf(initialState));

        stateOfCell actual = cell.getNextState(numberOfNeighbors);
        stateOfCell expected = stateOfCell.valueOf(expectedState);

        assertEquals(expected, actual);
    }
}
