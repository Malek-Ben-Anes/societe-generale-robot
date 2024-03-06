package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;

public class LawnMower {
    private int x;
    private int y;
    private OrientationEnum orientationEnum;

    public LawnMower(int x, int y, OrientationEnum orientationEnum) {
        this.x = x;
        this.y = y;
        this.orientationEnum = orientationEnum;
    }

    public void move(Lawn lawn, LawnMowerInstructionList instructions) {
        if (instructions == null) {
            return;
        }

        for (var instruction : instructions.getInstructions()) {
            switch (instruction) {
                case FORWARD -> {
                    switch (orientationEnum) {
                        case NORTH -> { if (y < lawn.height()) y++; }
                        case EAST -> { if (x < lawn.width()) x++; }
                        case SOUTH -> { if (y > 0) y--; }
                        case WEST -> { if (x > 0) x--; }
                    }
                }
                case RIGHT -> orientationEnum = orientationEnum.turnRight();
                case LEFT -> orientationEnum = orientationEnum.turnLeft();
            }
        }
    }

    public String getPosition() {
        return "%d %d %c".formatted(x, y, orientationEnum.getValue());
    }
}