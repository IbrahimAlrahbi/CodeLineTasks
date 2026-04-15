package EvaluationTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SnakeMove {
    public static void main(String[] argumentsInput) throws IOException {

        //  Part 1. Validate CLI user input

        //  Validate Arguments
        if (argumentsInput.length == 0) {
            System.out.println("Error: Must run via command line with: java MoveSnake.java <direction> <steps> ");
            return;
        }

        if (argumentsInput.length > 2) {
            System.out.println("Error: Input Must Be java MoveSnake <direction> <steps>");
            return;
        }
        //  Validate Direction
        String direction = argumentsInput[0].toLowerCase(); // So That it Can Read Any Letter
        if (!direction.equals("up") &&
                !direction.equals("down") &&
                !direction.equals("left") &&
                !direction.equals("right")) {
            System.out.println("Error: Invalid Direction.");
            return;
        }
        //  Validate Steps
        int steps = 1; // Default if User Don't Specify
        if (argumentsInput.length == 2) {
            try {
                steps = Integer.parseInt(argumentsInput[1]);

                if (steps <= 0) {
                    System.out.println("Error: Steps Must be a Positive Integer.");
                    return;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Steps Must be a Valid Integer.");
                return;
            }
        }
        //  Printing Direction and Steps
        System.out.println("Direction: " + direction);
        System.out.println("Steps: \n" + steps);

        //  Part 2. Read file and split each row immediately

        ArrayList<String[]> rowsData = new ArrayList<>();
        // [ADDED] A variable to store the snake order line if it exists in the file
        String snakeOrderLine = null;

        File mapFile = new File("src/main/java/com/agileoracleseval/slitheringeval/ibrahim_alrahbi/SnakeMove/map");
        System.out.println(mapFile.getAbsolutePath());

        try {
            Scanner fileReader = new Scanner(mapFile);

            //  looping as long as there is another line in the file
            while (fileReader.hasNextLine()) {
                //  removes extra spaces at the beginning and end of the line
                String line = fileReader.nextLine().trim();
                // This checks if line is not empty
                if (!line.isEmpty()) {
                    // [ADDED] Check if this line is the snake order line (starts with "(")
                    // If yes, save it separately instead of adding it to the map rows
                    if (line.startsWith("(")) {
                        snakeOrderLine = line;
                    } else {
                        String[] parts = line.split(" "); // Split lines by spaces; ease to access
                        rowsData.add(parts);
                    }
                }
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: map.txt file not found.");
            return;
        }

        //  Part 2: Validate map.txt content & Create 2D Array
        int rows = rowsData.size();
        if (rows == 0) {
            System.out.println("Error: Map file is empty.");
            return;
        }

        int columns = rowsData.get(0).length;
        //  Check if n*n & n>=15
        if (rows < 15 || columns < 15) {
            System.out.println("Error: Map must be at least 15x15.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            if (rowsData.get(i).length != columns) {
                System.out.println("Error: Invalid map.txt format.");
                return;
            }
        }

        //  Validate symbols - & o if there are another symbols
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String cell = rowsData.get(row)[col];
                if (!cell.equals("-") && !cell.equals("o")) {
                    System.out.println("Error: Invalid symbol found in the map.txt.");
                    return;
                }
            }
        }

        //  Create 2D Array & filling
        char[][] map = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                map[row][col] = rowsData.get(row)[col].charAt(0);
            }
        }

        //  Printing the grid map.txt
        System.out.println("\nThe map:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }

        //  Locating the Snake in the Grid
        LinkedList<int[]> snake = new LinkedList<>();

    }
}