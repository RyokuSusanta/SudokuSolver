import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoardReaderSS implements Reader {
    public String[][] readFile(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        String[][] board = new String[9][9];

        int row = 0;
        try {
            while (input.hasNextLine()) {
                int col = 0;
                boolean checkDash = false;
                char[] line = input.nextLine().toCharArray();

                for (char c : line) {
                    checkDash = c == '-';
                }

                if (!checkDash) {
                    for (int lineCol = 0; lineCol < line.length; lineCol++) {
                        if (line[lineCol] != '|') {
                            board[row][col] = String.valueOf(line[lineCol]);
                            col++;
                        }
                    }
                    row++;
                }
            }
        } catch (Exception e) {
            throw new ArithmeticException("Error! .ss file input contain less than 11 rows or column");
        }

        if (row > 9) {
            throw new ArithmeticException("Error! .ss file input contain more than 11 rows or column");
        }

        return board;
    }
}
