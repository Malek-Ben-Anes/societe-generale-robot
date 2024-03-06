package com.mowitnow.mower.model;

public record Lawn(int width, int height) {
    public Lawn {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be non-negative");
        }
    }
}