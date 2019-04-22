import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoardReaderSDK implements Reader {
    public String[][] readFile(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        String[][] board = new String[9][9];

        int row = 0;
        try {
            while (input.hasNextLine()) {
                char[] line = input.nextLine().toCharArray();
                for (int col = 0; col < line.length; col++) {
                    board[row][col] = String.valueOf(line[col]);
                }
                row++;
            }
        } catch (Exception e) {
            throw new ArithmeticException("Error! .sdk file input contain less than 9 rows or column");
        }

        if (row != 9) {
            throw new ArithmeticException("Error! .sdk file input contain more than 9 rows or column");
        }

        return board;
    }
}
