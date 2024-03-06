package com.mowitnow.mower;

import com.mowitnow.mower.provider.FileDataProvider;
import com.mowitnow.mower.provider.MockDataProvider;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LawnMowerApplicationTest {

    @Test
    void testExecuteLawnMowerProgramFromFile() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.executeLawnMowerProgram(new FileDataProvider().loadData());
        var result = outContent.toString().replaceAll("[\\r\\n\\s]", "");
        assertTrue(result.contains("13N"));
        assertTrue(result.contains("51E"));
    }

    @Test
    void testExecuteLawnMowerProgramFromMockData() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.executeLawnMowerProgram(new MockDataProvider().loadData());
        var result = outContent.toString().replaceAll("[\\r\\n\\s]", "");

        assertTrue(result.contains("13N"));
        assertTrue(result.contains("51E"));
    }

}