import org.junit.Test;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    @Test
    public void boardReadSDKCorrectly() throws FileNotFoundException {
        String[][] correctBoard = {
                {"2", ".", ".", "1", ".", "5", ".", "3", "."},
                {".", "5", "4", ".", ".", ".", "7", "1", "."},
                {".", "1", ".", "2", ".", "3", ".", "8", "."},
                {"6", ".", "2", "8", ".", "7", "3", ".", "4"},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"1", ".", "5", "3", ".", "9", "8", ".", "6"},
                {".", "2", ".", "7", ".", "1", ".", "6", "."},
                {".", "8", "1", ".", ".", ".", "2", "4", "."},
                {"7", ".", ".", "4", ".", "2", ".", ".", "1"}
        };
        Board testBoard = new Board("src/resources/scratch.sdk");

        assertArrayEquals(correctBoard, testBoard.getBoard());
        System.out.println(testBoard.toString());
    }

    @Test
    public void boardReadSSCorrectly() throws FileNotFoundException {
        String[][] correctBoard = {
                {"1", ".", ".", ".", ".", ".", "7", ".", "."},
                {".", "2", ".", ".", ".", ".", "5", ".", "."},
                {"6", ".", ".", "3", "8", ".", ".", ".", "."},
                {".", "7", "8", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "6", ".", "9", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", "1", "4", "."},
                {".", ".", ".", ".", "2", "5", ".", ".", "9"},
                {".", ".", "3", ".", ".", ".", ".", "6", "."},
                {".", ".", "4", ".", ".", ".", ".", ".", "2"}
        };
        Board testBoard = new Board("src/resources/scratch.ss");

        assertArrayEquals(correctBoard, testBoard.getBoard());
        System.out.println(testBoard.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void boardReadEmpty() throws FileNotFoundException {
        Board testBoard = new Board("src/resources/emptyFile.sdk");
        System.out.println(testBoard.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void boardReadIncorrectFile() throws FileNotFoundException {
        Board testBoard = new Board("src/resources/incorrectFile.sdk");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongFileFormat() throws FileNotFoundException {
        Board testBoard = new Board("src/resources/scratch.txt");
    }

}
