package com.mowitnow.mower.provider;

import com.mowitnow.mower.LawnMowerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileDataProvider implements DataProvider {

    public static final String INPUT_FILE_NAME = "/input.txt";

    public Data loadData() {
        Data data = null;
        try {
            InputStream inputStream = LawnMowerApplication.class.getResourceAsStream(INPUT_FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String[] dimensions = reader.readLine().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);

            data = new Data(maxX, maxY);

            int startIdx = 2;
            while (startIdx < dimensions.length) {
                data.getMowerInputs().add(runSingleLawnMower(dimensions, startIdx));
                startIdx += 4;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private MowerData runSingleLawnMower(String[] dimensions, int startIdx) {
        int x = Integer.parseInt(dimensions[startIdx]);
        int y = Integer.parseInt(dimensions[startIdx + 1]);
        char orientation = dimensions[startIdx + 2].charAt(0);
        String instructions = dimensions[startIdx + 3];

        return new MowerData(x, y, orientation, instructions);
    }
}
