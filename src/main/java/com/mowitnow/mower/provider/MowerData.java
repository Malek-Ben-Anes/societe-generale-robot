package com.mowitnow.mower.provider;

public class MowerData {
    private int x;
    private int y;
    private char orientation;
    private String instructions;

    public MowerData(int x, int y, char orientation, String instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation() {
        return orientation;
    }

    public String getInstructions() {
        return instructions;
    }
}
