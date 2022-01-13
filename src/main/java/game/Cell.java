package game;

public class Cell {

    private stateOfCell state;

    public Cell(stateOfCell state) {
        this.state = state;
    }

    public stateOfCell getNextState(int numberOfNeighbors) {

        if (numberOfNeighbors < 2) {
            return stateOfCell.DEAD;
        } else if (numberOfNeighbors == 2 || numberOfNeighbors == 3) {
            return stateOfCell.ALIVE;
        } else {
            return stateOfCell.DEAD;
        }
    }

    public stateOfCell getState() {
        return state;
    }

    public enum stateOfCell {
        ALIVE, DEAD
    }

}
