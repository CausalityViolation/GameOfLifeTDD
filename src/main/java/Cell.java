public class Cell {

    private stateOfCell state;

    public Cell(stateOfCell state) {
        this.state = state;
    }

    public stateOfCell getNextState(int numberOfNeighbors) {

        if (numberOfNeighbors < 2) {
            return stateOfCell.DEAD;
        }

        if (numberOfNeighbors > 3) {

            return stateOfCell.DEAD;
        }
        else {
            return stateOfCell.ALIVE;
        }


    }

    public enum stateOfCell {
        ALIVE, DEAD
    }

}
