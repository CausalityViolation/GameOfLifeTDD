package game;

import game.Cell.stateOfCell;

public class Board {

    private final Cell[][] state;

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

    public void update() {

        stateOfCell[][] cellStates = getState();

        for (int row = 0; row < state.length; row++) {
            for (int column = 0; column < state[row].length; column++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(cellStates, row, column);
                state[row][column].update(numberOfAliveNeighbors);
            }
        }
    }

    private int getNumberOfAliveNeighbors(stateOfCell[][] state, int row, int column) {
        int numberOfAliveNeighbors = 0;

        if (row > 0) {
            numberOfAliveNeighbors += getNumberOfAliveNeighborsInARow(state, row - 1, column);
        }

        numberOfAliveNeighbors += getAliveNumberOfNeighborsLeftCell(state, row, column - 1);
        numberOfAliveNeighbors += getAliveNumberOfNeighborsLeftCell(state, row, column + 1);


        if (row < state.length - 1) {
            numberOfAliveNeighbors += getNumberOfAliveNeighborsInARow(state, row + 1, column);
        }

        return numberOfAliveNeighbors;
    }


    private int getNumberOfAliveNeighborsInARow(stateOfCell[][] state, int row, int column) {

        int numberOfAliveNeighbors = 0;

        numberOfAliveNeighbors += getAliveNumberOfNeighborsLeftCell(state, row, column - 1);
        numberOfAliveNeighbors += getAliveNumberOfNeighborsLeftCell(state, row, column);
        numberOfAliveNeighbors += getAliveNumberOfNeighborsLeftCell(state, row, column + 1);

        return numberOfAliveNeighbors;
    }


    private int getAliveNumberOfNeighborsLeftCell(stateOfCell[][] state, int row, int column) {

        if (column >= 0 && column < state[row].length) {
            if (state[row][column] == stateOfCell.ALIVE) {
                return 1;
            }
        }
        return 0;
    }
}
