package com.mowitnow.mower.provider;

import java.util.ArrayList;
import java.util.List;

public record InputData(int maxX, int maxY, List<MowerInputData> mowerInputs) {
    public InputData(int maxX, int maxY) {
        this(maxX, maxY, new ArrayList<>());
    }
}
