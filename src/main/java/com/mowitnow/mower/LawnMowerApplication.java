package com.mowitnow.mower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LawnMowerApplication {

    public static void main(String[] args) {

        System.out.println("Hello from Lawn Mower Program!");

        // read file
        runLawnMowersFromInput();

        // read dimension

        // detect 3 lawn mowers to program

        // move each lawn mower

        // final result

        System.out.println("END of Lawn Mower Program!");
    }

    public static void runLawnMowersFromInput() {
        String[] dimensions = {"5", "5"}; // Default dimensions
        int maxX = Integer.parseInt(dimensions[0]);
        int maxY = Integer.parseInt(dimensions[1]);

        String[] lines = {"1 2 N GAGAGAGAA", "3 3 E AADAADADDA"}; // Default mower instructions
        for (var line: lines) {
            runSingleLawnMower(line, maxX, maxY);
        }
    }

    public static void runSingleLawnMower(String input, int maxX, int maxY) {
        String[] parts = input.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        char orientation = parts[2].charAt(0);
        String instructions = parts[3];

        LawnMower lawnMower = new LawnMower(x, y, orientation);
        lawnMower.move(instructions, maxX, maxY);
        System.out.println(lawnMower.getPosition());
    }

    public static void runLawnMowersFromFile() {
        try {
            InputStream inputStream = LawnMowerApplication.class.getResourceAsStream("/input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String[] dimensions = reader.readLine().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);

            String line;
            while ((line = reader.readLine()) != null) {
                runSingleLawnMower(line, maxX, maxY);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}