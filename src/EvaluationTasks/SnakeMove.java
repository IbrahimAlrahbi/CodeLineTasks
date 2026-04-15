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
    }
}