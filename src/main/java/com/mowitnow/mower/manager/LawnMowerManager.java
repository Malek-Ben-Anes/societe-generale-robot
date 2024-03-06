package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructionList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LawnMowerManager {
    private final Lawn lawn;
    private final Map<LawnMower, LawnMowerInstructionList> lawnMowersInstructionsMap;

    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowersInstructionsMap = new LinkedHashMap<>();
    }

    public void addLawnMower(LawnMower lawnMower, LawnMowerInstructionList instructions) {
        lawnMowersInstructionsMap.put(lawnMower, instructions);
    }

    public void runAllMowers() {
        for (Map.Entry<LawnMower, LawnMowerInstructionList> entry : lawnMowersInstructionsMap.entrySet()) {
            LawnMower lawnMower = entry.getKey();
            LawnMowerInstructionList instructions = entry.getValue();
            lawnMower.move(lawn, instructions);
            System.out.println(lawnMower.getPosition());
        }
    }
}