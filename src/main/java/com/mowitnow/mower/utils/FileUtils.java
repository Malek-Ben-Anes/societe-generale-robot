package com.mowitnow.mower.utils;

import com.mowitnow.mower.LawnMowerApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * Reads all lines from a file.
     *
     * @param relativePath the path to the file relative to the resources directory
     * @return a list containing all lines from the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static List<String> readFileLines(String relativePath) throws IOException {
        try (InputStream inputStream = getResourceStream(relativePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        }
    }

    /**
     * Gets the input stream for a resource.
     *
     * @param relativePath the path to the resource relative to the resources directory
     * @return an input stream for the resource
     * @throws IOException if the resource is not found
     */
    private static InputStream getResourceStream(String relativePath) throws IOException {
        InputStream inputStream = LawnMowerApplication.class.getResourceAsStream(relativePath);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + relativePath);
        }
        return inputStream;
    }
}
