package com.mowitnow.mower.provider;

public class MockDataProvider implements DataProvider {

    public InputData loadData() {
        System.out.println("----------- Retrieve Data from Mock Data Provider -----------");

        var data = new InputData(5, 5);
        data.mowerInputs().add(new MowerInputData(1, 2, 'N', "GAGAGAGAA"));
        data.mowerInputs().add(new MowerInputData(3, 3, 'E', "AADAADADDA"));

        return data;
    }

}
