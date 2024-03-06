package com.mowitnow.mower.provider;

public class MockDataProvider implements DataProvider {

    public Data loadData() {

        var data = new Data(5, 5);
        data.getMowerInputs().add(new MowerData(1, 2, 'N', "GAGAGAGAA"));
        data.getMowerInputs().add(new MowerData(3, 3, 'E', "AADAADADDA"));

        return data;
    }

}
