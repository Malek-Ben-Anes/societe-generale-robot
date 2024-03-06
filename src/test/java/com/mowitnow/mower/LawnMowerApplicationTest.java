package com.mowitnow.mower;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LawnMowerApplicationTest {

    @Test
    public void testRunSingleLawnMower() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.runSingleLawnMower("1 2 N GAGAGAGAA", 5, 5);
        assertEquals("1 3 N\r\n", outContent.toString());
    }

    @Test
    public void testRunLawnMowersFromInput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.runLawnMowersFromInput();
        assertEquals("1 3 N\r\n5 1 E\r\n", outContent.toString());
    }

}