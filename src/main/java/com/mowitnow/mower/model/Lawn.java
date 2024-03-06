package com.mowitnow.mower.model;

public class Lawn {
    private final int width;
    private final int height;

    public Lawn(int maxX, int height) {
        this.width = maxX;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}