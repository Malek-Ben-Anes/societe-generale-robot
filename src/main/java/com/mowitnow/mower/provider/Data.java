package com.mowitnow.mower.provider;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private int maxX;
    private int maxY;
    private List<MowerData> mowerInputs;

    public Data(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.mowerInputs = new ArrayList<>();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public List<MowerData> getMowerInputs() {
        return mowerInputs;
    }
}
