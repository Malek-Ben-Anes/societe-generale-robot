package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;

import java.util.Objects;

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

        instructions.getInstructions().forEach(instruction -> {
            switch (instruction) {
                case FORWARD -> {
                    switch (orientationEnum) {
                        case NORTH -> y = Math.min(y + 1, lawn.height());
                        case EAST -> x = Math.min(x + 1, lawn.width());
                        case SOUTH -> y = Math.max(y - 1, 0);
                        case WEST -> x = Math.max(x - 1, 0);
                    }
                }
                case RIGHT -> orientationEnum = orientationEnum.turnRight();
                case LEFT -> orientationEnum = orientationEnum.turnLeft();
            }
        });
    }

    public String getPosition() {
        return String.format("%d %d %c", x, y, orientationEnum.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnMower lawnMower = (LawnMower) o;
        return x == lawnMower.x && y == lawnMower.y && orientationEnum == lawnMower.orientationEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientationEnum);
    }
}
