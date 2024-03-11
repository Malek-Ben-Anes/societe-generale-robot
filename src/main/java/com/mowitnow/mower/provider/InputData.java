package com.mowitnow.mower.provider;

import java.util.List;

public record InputData(int maxX, int maxY, List<MowerInputData> mowerInputs) {
}
