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
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1 -> dataProvider = new FileDataProvider();
                case 2 -> dataProvider = new MockDataProvider();
                case 0 -> System.out.println("Exiting the program.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0 && choice != 1 && choice != 2);

        if (dataProvider != null) {
            executeLawnMowerProgram(dataProvider.loadData());
        }
    }

    private static void printMenu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1. Read Inputs from input.txt file");
        System.out.println("2. Retrieve data from static java code");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void executeLawnMowerProgram(final Data data) {
        Lawn lawn = new Lawn(data.getMaxX(), data.getMaxY());
        LawnMowerManager manager = new LawnMowerManager(lawn);

        for (final MowerData mower : data.getMowerInputs()) {
            manager.creatLawnMowerInstruction(mower);
        }

        System.out.println("----------- Print final result -----------");
        manager.runAllMowers();
    }
}