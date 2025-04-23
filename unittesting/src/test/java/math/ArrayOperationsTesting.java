package math;

import io.FileIO;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayOperationsTesting {
    FileIO fileIO = new FileIO();
    MyMath myMath = new MyMath();
    ArrayOperations arrayOperations = new ArrayOperations();

    @Test()
    public void largeNumber() {
        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/highNumbers.txt", myMath);
        int expected[] = {11, 13, 2, 103};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void smallNumber() {
        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/lowNumbers.txt", myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumber() {
        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/grades_valid.txt", myMath);
    }
}
