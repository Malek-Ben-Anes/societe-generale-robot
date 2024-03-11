package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;

import java.util.Objects;

import static java.lang.Math.*;

/**
 * Represents a lawn mower with a position and orientation
 */
public class LawnMower {

    /**
     * X coordinate of the lawn mower
     */
    private int positionX;
    /**
     * Y coordinate of the lawn mower
     */
    private int positionY;

    /**
     * Orientation of the lawn mower
     */
    private OrientationEnum orientationEnum;

    // Constructor to initialize the lawn mower with coordinates and orientation
    public LawnMower(int positionX, int positionY, OrientationEnum orientationEnum) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientationEnum = orientationEnum;
    }

    /**
     * Move the lawn mower according to the instructions provided
     */
    public void executeProgram(Lawn lawn, LawnMowerInstructions instructions) {
        if (instructions == null || instructions.getList().isEmpty()) {
            return;
        }

        // Iterate through each instruction and execute the corresponding action
        for(var instruction: instructions.getList()) {
            switch (instruction) {
                case FORWARD -> moveForward(lawn);
                case RIGHT -> orientationEnum = orientationEnum.turnRight();
                case LEFT -> orientationEnum = orientationEnum.turnLeft();
            }
        }
    }

    private void moveForward(Lawn lawn) {
        switch (orientationEnum) {
            case NORTH -> positionY = min(positionY + 1, lawn.height());
            case EAST -> positionX = min(positionX + 1, lawn.width());
            case SOUTH -> positionY = max(positionY - 1, 0);
            case WEST -> positionX = max(positionX - 1, 0);
        }
    }

    // Get the position of the lawn mower as a formatted string
    public String getPosition() {
        return String.format("%d %d %c", positionX, positionY, orientationEnum.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawnMower lawnMower = (LawnMower) o;
        return positionX == lawnMower.positionX && positionY == lawnMower.positionY && orientationEnum == lawnMower.orientationEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY, orientationEnum);
    }
}
