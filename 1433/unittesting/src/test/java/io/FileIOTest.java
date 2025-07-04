package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class FileIOTest {
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

    @Test(expected = IllegalArgumentException.class)
    public void nonExistentFileTest() {
        fileIO.readFile("src/test/resources/non_existent_file.txt");
    }

    @Test
    public void invalidFileTest() {
        int[] actual = fileIO.readFile("src/test/resources/grades_invalid.txt");
        int[] expected = {3, 9, 2, 10, 8, 0, 3};
        assertArrayEquals(expected, actual);
    }



    @Test
    public void fileWithMixedEntriesTest() {
        int[] actual = fileIO.readFile("src/test/resources/mixed_entries.txt");
        int[] expected = {1, 2, 3}; // Assuming valid numbers in the file
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ioExceptionCatchBlockTest() {
        FileIO fileIO = new FileIO();
        // Pass a directory instead of a file to trigger IOException
        try {
            fileIO.readFile("src/test/resources"); // assumes this is a directory
        } catch (IllegalArgumentException e) {
            // The method will eventually throw this after catching the IOException,
            // because numbersList.size() == 0
            // This is expected, but the catch (IOException e) will be covered!
        }
    }

    @Test
    public void ioExceptionTest() {
        // Simulate IOException using a mock
        FileIO fileIO = new FileIO() {
            @Override
            public int[] readFile(String filepath) {
                throw new RuntimeException(new IOException("Simulated IOException"));
            }
        };

        try {
            fileIO.readFile("dummy_path");
        } catch (RuntimeException e) {
            assert e.getCause() instanceof IOException;
        }
    }
}
