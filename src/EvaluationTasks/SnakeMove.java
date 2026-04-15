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

    }
}