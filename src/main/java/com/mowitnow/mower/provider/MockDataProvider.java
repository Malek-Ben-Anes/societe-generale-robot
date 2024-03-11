package com.mowitnow.mower.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MockDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockDataProvider.class);

    public InputData loadData() {
        LOGGER.info("\n----------- Retrieve Data from Mock Data Provider -----------");

        var mowerInputs = List.of(
                new MowerInputData(1, 2, 'N', "GAGAGAGAA"),
                new MowerInputData(3, 3, 'E', "AADAADADDA"));

        return new InputData(5, 5, mowerInputs);
    }

}
