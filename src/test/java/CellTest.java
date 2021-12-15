import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    /*
    <RULES>

    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by overcrowding.
    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */

    @Test
    void cellWithFewerThanTwoLiveNeighboursDie() {

        Cell cell = new Cell(Cell.stateOfCell.ALIVE);
        Cell.stateOfCell actual = cell.getNextState(1);

        assertEquals(Cell.stateOfCell.DEAD, actual);
    }

    @Test
    void cellWithThreeOrFourNeighborsSurvive() {

        Cell cell = new Cell(Cell.stateOfCell.ALIVE);
        Cell.stateOfCell actual = cell.getNextState(2);

        assertEquals(Cell.stateOfCell.ALIVE, actual);

    }

}
