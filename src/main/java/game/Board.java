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
            int rowAbove = row - 1;
            if (column > 0) {
                if (state[rowAbove][column - 1] == stateOfCell.ALIVE) {

                    numberOfAliveNeighbors++;
                }
                if (state[rowAbove][column] == stateOfCell.ALIVE) {
                    numberOfAliveNeighbors++;
                }

                if (column < state[row].length - 1) {
                    if (state[rowAbove][column + 1] == stateOfCell.ALIVE) {
                        numberOfAliveNeighbors++;
                    }
                }
            }
        }


        if (column > 0) {
            if (state[row][column - 1] == stateOfCell.ALIVE) {

                numberOfAliveNeighbors++;
            }

            if (column < state[row].length - 1) {
                if (state[row][column + 1] == stateOfCell.ALIVE) {
                    numberOfAliveNeighbors++;
                }
            }
        }


        if (row < state.length - 1) {
            int rowBelow = row + 1;
            if (column > 0) {
                if (state[rowBelow][column - 1] == stateOfCell.ALIVE) {

                    numberOfAliveNeighbors++;
                }
                if (state[rowBelow][column] == stateOfCell.ALIVE) {
                    numberOfAliveNeighbors++;
                }

                if (column < state[row].length - 1) {
                    if (state[rowBelow][column + 1] == stateOfCell.ALIVE) {
                        numberOfAliveNeighbors++;
                    }
                }
            }
        }

        return numberOfAliveNeighbors;
    }
}
