package com.mowitnow.mower.model;

public class LawnMower {
    private int x;
    private int y;
    private OrientationEnum orientationEnum;
    private LawnMowerInstructions instructions;

    public LawnMower(int x, int y, OrientationEnum orientationEnum, LawnMowerInstructions instructions) {
        this.x = x;
        this.y = y;
        this.orientationEnum = orientationEnum;
        this.instructions = instructions;
    }

    public void move(Lawn lawn) {
        if (instructions == null) {
            return;
        }

        for (var instruction : instructions.getInstructions()) {
            switch (instruction) {
                case FORWARD -> {
                    switch (orientationEnum) {
                        case NORTH -> { if (y < lawn.getHeight()) y++; }
                        case EAST -> { if (x < lawn.getWidth()) x++; }
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
        return "%d %d %c".formatted(x, y, orientationEnum.getSymbol());
    }
}