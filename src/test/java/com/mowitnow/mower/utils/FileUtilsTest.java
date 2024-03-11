package com.mowitnow.mower.utils;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileUtilsTest {

    @Test
    void testReadFileLines_Success() throws IOException {
        // Test readFileLines method
        List<String> lines = FileUtils.readFileLines("/data/file.txt");

        // Verify the result
        assertAll(
                () -> assertEquals(3, lines.size()),
                () -> assertEquals("line1", lines.get(0)),
                () -> assertEquals("line2", lines.get(1)),
                () -> assertEquals("line3", lines.get(2))
        );
    }

    @Test
    void testReadFileLines_ResourceNotFound() {
        // Test readFileLines method and assert that it throws IOException
        assertThrows(IOException.class, () -> FileUtils.readFileLines("nonexistentfile.txt"));
    }

    @Test
    void testReadFileLines_IOError() {
        // Test readFileLines method and assert that it throws IOException
        assertThrows(IOException.class, () -> FileUtils.readFileLines("testfile.txt"));
    }
}
