package com.mowitnow.mower.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockDataProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockDataProvider.class);

    public InputData loadData() {
        LOGGER.info("\n----------- Retrieve Data from Mock Data Provider -----------");

        var data = new InputData(5, 5);
        data.mowerInputs().add(new MowerInputData(1, 2, 'N', "GAGAGAGAA"));
        data.mowerInputs().add(new MowerInputData(3, 3, 'E', "AADAADADDA"));

        return data;
    }

}
