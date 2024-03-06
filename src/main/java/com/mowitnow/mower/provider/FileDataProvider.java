package com.mowitnow.mower.provider;

import com.mowitnow.mower.LawnMowerApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileDataProvider implements DataProvider {

    // File name for input data
    public static final String INPUT_FILE_NAME = "/input.txt";

    /**
     * Load data from input file.
     *
     * @return InputData object containing lawn dimensions and mower inputs
     */
    public InputData loadData() {
        System.out.println("----------- Retrieve Data from 'input.txt' File -----------");

        try (InputStream inputStream = LawnMowerApplication.class.getResourceAsStream(INPUT_FILE_NAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            // Read dimensions of the lawn
            String[] dimensions = reader.readLine().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);

            // Create data object with lawn dimensions
            InputData inputData = new InputData(maxX, maxY);
            int startIdx = 2;

            // Read mower inputs and add to data object
            while (startIdx < dimensions.length) {
                inputData.mowerInputs().add(runSingleLawnMower(dimensions, startIdx));
                startIdx += 4; // Increment index by 4 to skip to next mower input
            }
            return inputData;

        } catch (IOException e) {
            e.printStackTrace(); // Handle IO exception
        }
        return null;
    }

    /**
     * Parse single lawn mower input from dimensions array.
     *
     * @param dimensions The array containing mower input data
     * @param startIdx   The starting index of the mower input data in the array
     * @return MowerInputData object representing a single mower input
     */
    private MowerInputData runSingleLawnMower(String[] dimensions, int startIdx) {
        int x = Integer.parseInt(dimensions[startIdx]);
        int y = Integer.parseInt(dimensions[startIdx + 1]);
        char orientation = dimensions[startIdx + 2].charAt(0);
        String instructions = dimensions[startIdx + 3];

        return new MowerInputData(x, y, orientation, instructions);
    }
}
