package com.mowitnow.mower.model.enums;

public enum OrientationEnum {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char value;

    OrientationEnum(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    // Optional: Get the next orientation when turning right
    public OrientationEnum turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }

    // Optional: Get the next orientation when turning left
    public OrientationEnum turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }
}