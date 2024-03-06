package com.mowitnow.mower.model.enums;

import java.util.Arrays;

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

    public static OrientationEnum fromValue(char value) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant found for value: " + value));
    }

    public OrientationEnum turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public OrientationEnum turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }
}
