package game;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static final Cell.stateOfCell O = Cell.stateOfCell.ALIVE;
    public static final Cell.stateOfCell X = Cell.stateOfCell.DEAD;
    static Scanner input = new Scanner(System.in);
    static int numberOfIterations = 1;

    public static void main(String[] args) {

        Board playingField = new Board(new Cell.stateOfCell[][]{
                {O, O, X},
                {X, O, O},
                {O, X, X}
        });

        while (true) {

            playingField.update();
            Cell.stateOfCell[][] updated = playingField.getState();

            enterPrompt();

            System.out.println("Iteration " + numberOfIterations + "\n======================");
            for (Cell.stateOfCell[] row : updated) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("======================");
            numberOfIterations++;

        }
    }

    private static void enterPrompt() {

        String next = "";

        if (numberOfIterations > 1) {
            next = " Next";
        }

        System.out.println("Press Enter To Iterate" + next + " Cycle.");

        if (input.nextLine().equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }
}