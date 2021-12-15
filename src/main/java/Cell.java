public class Cell {

    private stateOfCell state;

    public Cell(stateOfCell state) {
        this.state = state;
    }

    public stateOfCell getNextState(int i) {

        if (i < 2) {
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
