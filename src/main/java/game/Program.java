package game;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static final Cell.stateOfCell O = Cell.stateOfCell.ALIVE;
    public static final Cell.stateOfCell X = Cell.stateOfCell.DEAD;
    static Scanner input = new Scanner(System.in);
    static int numberOfIterations = 1;

    public static void main(String[] args) {

        Cell.stateOfCell[][] playingField = new Cell.stateOfCell[][]{
                {O, O, O},
                {O, O, O},
                {O, X, O},
        };

        while (true) {

            System.out.println("Iteration " + numberOfIterations + "\n======================");
            for (Cell.stateOfCell[] row : playingField) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("======================\nPress Enter To Iterate Again. Type EXIT to exit.");
            numberOfIterations++;


            if (input.nextLine().equalsIgnoreCase("exit")) {
                System.exit(0);
            }

        }
    }
}