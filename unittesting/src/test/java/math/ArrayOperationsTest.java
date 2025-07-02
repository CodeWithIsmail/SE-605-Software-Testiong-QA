package math;

import io.FileIO;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayOperationsTest {
    FileIO fileIO = new FileIO();
    MyMath myMath = new MyMath();
    ArrayOperations arrayOperations = new ArrayOperations();

    @Test()
    public void primeCheck() {
        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/highNumbers.txt", myMath);
        int[] expected = {11, 13, 2, 103, 1000000007};
        assertArrayEquals(expected, actual);
    }

//    @Test()
//    public void smallNumber() {
//        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/lowNumbers.txt", myMath);
//        int[] expected = {2};
//        assertArrayEquals(expected, actual);
//    }

//    @Test()
//    public void primeCheck2() {
//        int[] actual = arrayOperations.findPrimesInFile(fileIO, "src/test/resources/grades_valid.txt", myMath);
//        int[] expected = {3, 2, 3, 3};
//        assertArrayEquals(expected, actual);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void noFile(){
       int[] actual= arrayOperations.findPrimesInFile(fileIO, "src/test/resources/nofile.txt", myMath);
    }
}
