package com.mowitnow.mower;

public class LawnMower {
    private int x;
    private int y;
    private char orientation;

    public LawnMower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void move(String instructions, int maxX, int maxY) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'A' -> {
                    switch (orientation) {
                        case 'N' -> { if (y < maxY) y++; }
                        case 'E' -> { if (x < maxX) x++; }
                        case 'S' -> { if (y > 0) y--; }
                        case 'W' -> { if (x > 0) x--; }
                    }
                }
                case 'D' -> {
                    switch (orientation) {
                        case 'N' -> orientation = 'E';
                        case 'E' -> orientation = 'S';
                        case 'S' -> orientation = 'W';
                        case 'W' -> orientation = 'N';
                    }
                }
                case 'G' -> {
                    switch (orientation) {
                        case 'N' -> orientation = 'W';
                        case 'E' -> orientation = 'N';
                        case 'S' -> orientation = 'E';
                        case 'W' -> orientation = 'S';
                    }
                }
            }
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}