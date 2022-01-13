import game.Board;
import game.Cell;
import org.junit.jupiter.api.Test;

class BoardTest {

    public static final Cell.stateOfCell O = Cell.stateOfCell.ALIVE;
    public static final Cell.stateOfCell X = Cell.stateOfCell.DEAD;

    @Test
    void boardShouldSaveItsInitialState() {
        new Board(new Cell.stateOfCell[][]{
                {O, X, O},
                {X, X, X},
                {O, X, O},
        });
    }

}
