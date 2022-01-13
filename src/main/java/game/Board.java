package game;

import game.Cell.stateOfCell;

public class Board {

    private Cell[][] state;

    public Board(stateOfCell[][] stateOfCells) {
        state = new Cell[stateOfCells.length][];

        for (int row = 0; row < stateOfCells.length; row++) {
            state[row] = new Cell[stateOfCells[row].length];
            for (int column = 0; column < stateOfCells[row].length; column++) {
                state[row][column] = new Cell(stateOfCells[row][column]);
            }
        }
    }

    public stateOfCell[][] getState() {

        stateOfCell[][] stateOfCells = new stateOfCell[state.length][];

        for (int row = 0; row < state.length; row++) {
            stateOfCells[row] = new stateOfCell[state[row].length];
            for (int column = 0; column < state[row].length; column++) {
                stateOfCells[row][column] = state[row][column].getState();
            }
        }

        return stateOfCells;
    }
}
