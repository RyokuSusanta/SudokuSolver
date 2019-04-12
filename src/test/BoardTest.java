import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class BoardTest {

    @Test
    public void boardReadCorrectly() throws FileNotFoundException {
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
        Board testBoard = new Board("src/scratch.txt");

        Assert.assertEquals(correctBoard, testBoard.getBoard());
    }

    @Test(expected = ArithmeticException.class)
    public void boardReadEmpty() throws FileNotFoundException {
        Board testBoard = new Board("src/emptyFile.txt");
    }

    @Test(expected = ArithmeticException.class)
    public void boardReadIncorrectFile() throws FileNotFoundException {
        Board testBoard = new Board("src/incorrectFile.txt");
    }

}
