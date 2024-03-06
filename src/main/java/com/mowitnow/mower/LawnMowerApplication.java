package com.mowitnow.mower;

import com.mowitnow.mower.manager.LawnMowerManager;
import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.provider.*;

import java.util.Scanner;

public class LawnMowerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        DataProvider dataProvider = null;

        // User menu for selecting data source
        do {
            printMenu(); // Print menu options
            choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume the newline character after reading the integer

            // Select data provider based on user choice
            switch (choice) {
                case 1 -> dataProvider = new FileDataProvider(); // Read data from input.txt file
                case 2 -> dataProvider = new MockDataProvider(); // Use static data from java code
                case 0 -> System.out.println("Exiting the program."); // Exit program
                default -> System.out.println("Invalid choice. Please try again."); // Invalid choice
            }
        } while (choice != 0 && choice != 1 && choice != 2); // Repeat until valid choice is made

        // Execute program if data provider is selected
        if (dataProvider != null) {
            executeLawnMowerProgram(dataProvider.loadData()); // Execute program with loaded data
        }
    }

    // Print menu options
    private static void printMenu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1. Read Inputs from input.txt file");
        System.out.println("2. Retrieve data from static java code");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Execute lawn mower program with given data
    public static void executeLawnMowerProgram(final Data data) {
        // Create lawn with dimensions from data
        Lawn lawn = new Lawn(data.getMaxX(), data.getMaxY());
        // Create lawn mower manager
        LawnMowerManager manager = new LawnMowerManager(lawn);

        // Create lawn mowers with their instructions
        for (final MowerData mower : data.getMowerInputs()) {
            manager.createLawnMowerInstruction(mower);
        }

        // Run all lawn mowers and print final positions
        System.out.println("----------- Print final result -----------");
        manager.runAllMowers();
    }
}
