import game.Cell;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

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
    void cellWithTwoNeighborsSurvive() {

        Cell cell = new Cell(Cell.stateOfCell.ALIVE);
        Cell.stateOfCell actual = cell.getNextState(2);

        assertEquals(Cell.stateOfCell.ALIVE, actual);

    }

    @Test
    void cellWithExactlyThreeNeighborsRevives() {

        Cell cell = new Cell(Cell.stateOfCell.DEAD);
        Cell.stateOfCell actual = cell.getNextState(3);

        assertEquals(Cell.stateOfCell.ALIVE, actual);

    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void cellWithMoreThanThreeNeighborsDieDueToOverpopulation(int numberOfNeighbors) {

        Cell cell = new Cell(Cell.stateOfCell.ALIVE);
        Cell.stateOfCell actual = cell.getNextState(numberOfNeighbors);

        assertEquals(Cell.stateOfCell.DEAD, actual);
    }

}
