package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;

import java.util.Objects;

/**
 * Represents a lawn mower with a position and orientation
 */
public class LawnMower {

    /**
     * X coordinate of the lawn mower
     */
    private int x;
    /**
     * Y coordinate of the lawn mower
     */
    private int y;

    /**
     * Orientation of the lawn mower
     */
    private OrientationEnum orientationEnum;

    // Constructor to initialize the lawn mower with coordinates and orientation
    public LawnMower(int x, int y, OrientationEnum orientationEnum) {
        this.x = x;
        this.y = y;
        this.orientationEnum = orientationEnum;
    }

    /**
     * Move the lawn mower according to the instructions provided
     */
    public void move(Lawn lawn, LawnMowerInstructionList instructions) {
        if (instructions == null) {
            return;
        }

        // Iterate through each instruction and execute the corresponding action
        instructions.getInstructions().forEach(instruction -> {
            switch (instruction) {
                case FORWARD -> {
                    // Move forward based on the current orientation, ensuring it stays within the lawn boundaries
                    switch (orientationEnum) {
                        case NORTH -> y = Math.min(y + 1, lawn.height());
                        case EAST -> x = Math.min(x + 1, lawn.width());
                        case SOUTH -> y = Math.max(y - 1, 0);
                        case WEST -> x = Math.max(x - 1, 0);
                    }
                }
                case RIGHT -> orientationEnum = orientationEnum.turnRight(); // Turn the lawn mower right
                case LEFT -> orientationEnum = orientationEnum.turnLeft(); // Turn the lawn mower left
            }
        });
    }

    // Get the position of the lawn mower as a formatted string
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
