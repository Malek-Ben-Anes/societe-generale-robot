package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructions;
import com.mowitnow.mower.model.enums.OrientationEnum;
import com.mowitnow.mower.provider.MowerInputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LawnMowerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LawnMowerManager.class);

    // Represents the lawn where lawn mowers move
    private final Lawn lawn;
    // Map to store lawn mowers with their respective instructions
    private final Map<LawnMower, LawnMowerInstructions> lawnMowersInstructionsMap;

    // Constructor to initialize the LawnMowerManager with a lawn
    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowersInstructionsMap = new LinkedHashMap<>();
    }

    // Method to create a new lawn mower with its instructions
    public void createLawnMowerInstruction(MowerInputData mower) {
        // Create instructions for the mower
        var instructions = new LawnMowerInstructions(mower.instructions());
        // Create a new lawn mower instance
        var lawnMower = new LawnMower(mower.x(), mower.y(), OrientationEnum.fromValue(mower.orientation()));
        // Add the lawn mower and its instructions to the map
        lawnMowersInstructionsMap.put(lawnMower, instructions);
    }

    // Method to run all lawn mowers and print their final positions
    public void runAllMowers() {
        LOGGER.info("\n\n----------- Running All Lawn mowers -----------");
        for (Map.Entry<LawnMower, LawnMowerInstructions> entry : lawnMowersInstructionsMap.entrySet()) {
            LawnMower lawnMower = entry.getKey();
            LawnMowerInstructions instructions = entry.getValue();
            // Move the lawn mower according to its instructions
            lawnMower.move(lawn, instructions);
            // Print the final position of the lawn mower
            LOGGER.info(lawnMower.getPosition());
        }
    }

    // Getter method to access the lawn mowers instructions map
    public Map<LawnMower, LawnMowerInstructions> getLawnMowersInstructionsMap() {
        return lawnMowersInstructionsMap;
    }
}
