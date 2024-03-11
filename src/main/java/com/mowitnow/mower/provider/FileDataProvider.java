package com.mowitnow.mower.provider;

import com.mowitnow.mower.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileDataProvider.class);

    // File name for input data
    public static final String INPUT_FILE_NAME = "/data/input.txt";

    /**
     * Load data from input file.
     *
     * @return InputData object containing lawn dimensions and mower inputs
     * @throws RuntimeException if there is an error while loading or parsing the data
     */
    public InputData loadData() {
        LOGGER.info("----------- Retrieving Data from '{}' File -----------", INPUT_FILE_NAME);

        List<String> fileContent;
        try {
            // Read input file
            fileContent = FileUtils.readFileLines(INPUT_FILE_NAME);
        } catch (IOException e) {
            String errorMessage = "Error reading file: " + INPUT_FILE_NAME;
            LOGGER.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }

        if (fileContent == null || fileContent.isEmpty()) {
            throw new RuntimeException("File content is empty: " + INPUT_FILE_NAME);
        }

        String firstLine = fileContent.get(0);
        return parseData(firstLine);
    }

    private InputData parseData(String fileLine) {
        String[] dimensions = fileLine.split(" ");
        if (dimensions.length < 2) {
            throw new IllegalArgumentException("Invalid dimensions format: " + fileLine);
        }

        int maxX = Integer.parseInt(dimensions[0]);
        int maxY = Integer.parseInt(dimensions[1]);

        List<MowerInputData> mowerInputs = IntStream.range(2, dimensions.length)
                .filter(i -> i % 4 == 2) // Filter indices for mower inputs
                .mapToObj(i -> runSingleLawnMower(dimensions, i))
                .collect(Collectors.toList());

        return new InputData(maxX, maxY, mowerInputs);
    }

    /**
     * Parse single lawn mower input from dimensions array.
     *
     * @param dimensions   The array containing mower input data
     * @param startIndex   The starting index of the mower input data in the array
     * @return MowerInputData object representing a single mower input
     */
    private MowerInputData runSingleLawnMower(String[] dimensions, int startIndex) {
        if (startIndex + 3 >= dimensions.length) {
            throw new IllegalArgumentException("Incomplete mower input data.");
        }
        int initialX = Integer.parseInt(dimensions[startIndex]);
        int initialY = Integer.parseInt(dimensions[startIndex + 1]);
        char initialOrientation = dimensions[startIndex + 2].charAt(0);
        String instructions = dimensions[startIndex + 3];
        return new MowerInputData(initialX, initialY, initialOrientation, instructions);
    }
}
