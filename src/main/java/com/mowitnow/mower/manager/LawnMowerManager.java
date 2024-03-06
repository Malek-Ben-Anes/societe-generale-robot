package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructionList;
import com.mowitnow.mower.model.enums.OrientationEnum;
import com.mowitnow.mower.provider.MowerData;

import java.util.LinkedHashMap;
import java.util.Map;

public class LawnMowerManager {
    private final Lawn lawn;
    private final Map<LawnMower, LawnMowerInstructionList> lawnMowersInstructionsMap;

    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowersInstructionsMap = new LinkedHashMap<>();
    }

    public void creatLawnMowerInstruction(MowerData mower) {
        var instructions = new LawnMowerInstructionList(mower.getInstructions());
        var lawnMower = new LawnMower(mower.getX(), mower.getY(),
                OrientationEnum.fromValue(mower.getOrientation()));
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

    public Map<LawnMower, LawnMowerInstructionList> getLawnMowersInstructionsMap() {
        return lawnMowersInstructionsMap;
    }
}