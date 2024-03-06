package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LawnMowerManager {
    private final Lawn lawn;
    private final Map<LawnMower, LawnMowerInstructions> lawnMowersInstructionsMap;

    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowersInstructionsMap = new LinkedHashMap<>();
    }

    public void addLawnMower(LawnMower lawnMower, LawnMowerInstructions instructions) {
        lawnMowersInstructionsMap.put(lawnMower, instructions);
    }

    public void runAllMowers() {
        for (Map.Entry<LawnMower, LawnMowerInstructions> entry : lawnMowersInstructionsMap.entrySet()) {
            LawnMower lawnMower = entry.getKey();
            LawnMowerInstructions instructions = entry.getValue();
            lawnMower.move(lawn, instructions);
            System.out.println(lawnMower.getPosition());
        }
    }
}