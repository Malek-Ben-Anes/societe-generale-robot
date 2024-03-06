/**
 * This class represents the entry point for the Lawn Mower application.
 * It provides a user interface to select the data provider and execute the lawn mower program.
 */
package com.mowitnow.mower;

import com.mowitnow.mower.manager.LawnMowerManager;
import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.provider.*;

import java.util.Scanner;

public class LawnMowerApplication {

    /**
     * The main method of the application. It starts the application, selects the data provider,
     * and executes the lawn mower program.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        DataProvider dataProvider = selectDataProvider();
        if (dataProvider != null) {
            executeLawnMowerProgram(dataProvider.loadData());
        }
    }

    /**
     * Allows the user to select the data provider for the lawn mower program.
     *
     * @return The selected DataProvider instance.
     */
    private static DataProvider selectDataProvider() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        DataProvider dataProvider;

        // User menu for selecting data source
        do {
            printMenu(); // Print menu options
            choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume the newline character after reading the integer
            dataProvider = null;

            // Select data provider based on user choice
            switch (choice) {
                case 1 -> dataProvider = new FileDataProvider(); // Read data from input.txt file
                case 2 -> dataProvider = new MockDataProvider(); // Use static data from java code
                case 0 -> System.out.println("Exiting the program."); // Exit program
                default -> System.out.println("Invalid choice. Please try again."); // Invalid choice
            }
        } while (choice != 0 && choice != 1 && choice != 2); // Repeat until valid choice is made

        return dataProvider;
    }

    /**
     * Prints the menu for selecting the data provider.
     */
    private static void printMenu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1. Read Inputs from input.txt file");
        System.out.println("2. Retrieve data from static java code");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Executes the lawn mower program with the provided input data.
     *
     * @param inputData The input data for the lawn mower program.
     */
    public static void executeLawnMowerProgram(final InputData inputData) {
        Lawn lawn = new Lawn(inputData.maxX(), inputData.maxY());
        LawnMowerManager manager = new LawnMowerManager(lawn);

        for (final MowerInputData mower : inputData.mowerInputs()) {
            manager.createLawnMowerInstruction(mower);
        }

        System.out.println("----------- Print final result -----------");
        manager.runAllMowers();
    }
}
