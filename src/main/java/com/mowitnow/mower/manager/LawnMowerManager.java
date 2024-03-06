package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructionList;
import com.mowitnow.mower.model.enums.OrientationEnum;
import com.mowitnow.mower.provider.MowerData;

import java.util.LinkedHashMap;
import java.util.Map;

public class LawnMowerManager {
    // Represents the lawn where lawn mowers move
    private final Lawn lawn;
    // Map to store lawn mowers with their respective instructions
    private final Map<LawnMower, LawnMowerInstructionList> lawnMowersInstructionsMap;

    // Constructor to initialize the LawnMowerManager with a lawn
    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowersInstructionsMap = new LinkedHashMap<>();
    }

    // Method to create a new lawn mower with its instructions
    public void createLawnMowerInstruction(MowerData mower) {
        // Create instructions for the mower
        var instructions = new LawnMowerInstructionList(mower.getInstructions());
        // Create a new lawn mower instance
        var lawnMower = new LawnMower(mower.getX(), mower.getY(), OrientationEnum.fromValue(mower.getOrientation()));
        // Add the lawn mower and its instructions to the map
        lawnMowersInstructionsMap.put(lawnMower, instructions);
    }

    // Method to run all lawn mowers and print their final positions
    public void runAllMowers() {
        for (Map.Entry<LawnMower, LawnMowerInstructionList> entry : lawnMowersInstructionsMap.entrySet()) {
            LawnMower lawnMower = entry.getKey();
            LawnMowerInstructionList instructions = entry.getValue();
            // Move the lawn mower according to its instructions
            lawnMower.move(lawn, instructions);
            // Print the final position of the lawn mower
            System.out.println(lawnMower.getPosition());
        }
    }

    // Getter method to access the lawn mowers instructions map
    public Map<LawnMower, LawnMowerInstructionList> getLawnMowersInstructionsMap() {
        return lawnMowersInstructionsMap;
    }
}
