package io;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FileIOTesting {
    FileIO fileIO = new FileIO();

    @Test
    public void intFileTest() {
        int[] actual = fileIO.readFile("src/test/resources/grades_valid.txt");
        int[] expected = {3, 9, 0, 2, 10, 9, 3, 8, 0, 3};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyFileTest() {
        fileIO.readFile("src/test/resources/empty_file.txt");
    }

    @Test()
    public void invalidFileTest() {
        int[] actual = fileIO.readFile("src/test/resources/grades_invalid.txt");
        int[] expected = {3, 9, 2, 10, 8, 0, 3};
        assertArrayEquals(expected, actual);
    }

}
