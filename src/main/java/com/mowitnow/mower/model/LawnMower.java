package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.InstructionEnum;
import com.mowitnow.mower.model.enums.OrientationEnum;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import static java.lang.Math.*;

/**
 * Represents a lawn mower with a position and orientation
 */
public class LawnMower {

    private final Map<OrientationEnum, Consumer<Lawn>> movesActions = Map.of(
            OrientationEnum.NORTH, this::moveNorth,
            OrientationEnum.EAST, this::moveEast,
            OrientationEnum.SOUTH, this::moveSouth,
            OrientationEnum.WEST, this::moveWest
    );

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
            if (instruction == InstructionEnum.FORWARD) {
                movesActions.get(orientationEnum).accept(lawn);
            } else if (instruction == InstructionEnum.RIGHT) {
                orientationEnum = orientationEnum.turnRight();
            } else if (instruction == InstructionEnum.LEFT) {
                orientationEnum = orientationEnum.turnLeft();
            }
        }
    }

    private void moveNorth(Lawn lawn) {
        positionY = min(positionY + 1, lawn.height());
    }

    private void moveEast(Lawn lawn) {
        positionX = min(positionX + 1, lawn.width());
    }

    private void moveSouth(Lawn lawn) {
        positionY = max(positionY - 1, 0);
    }

    private void moveWest(Lawn lawn) {
        positionX = max(positionX - 1, 0);
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
