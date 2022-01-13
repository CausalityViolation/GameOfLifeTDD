package game;

public class Cell {

    private stateOfCell state;

    public Cell(stateOfCell state) {
        this.state = state;
    }

    public void update(int numberOfNeighbors) {

        if (state == stateOfCell.ALIVE) {

            if (numberOfNeighbors < 2 || numberOfNeighbors > 3) {
                state = stateOfCell.DEAD;
            }
        } else {
            if (numberOfNeighbors == 3) {
                state = stateOfCell.ALIVE;
            } else {
                state = stateOfCell.DEAD;
            }
        }
    }

    public stateOfCell getState() {
        return state;
    }

    public enum stateOfCell {
        ALIVE, DEAD
    }

}
