import java.io.*;
import java.util.*;

public class Board {
    private String[][] board = new String[9][9];

    public Board(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));

        try {
            for (int row = 0; row < 9; row++) {
                Scanner line = new Scanner(input.nextLine());
                for (int col = 0; col < 9; col++) {
                    board[row][col] = line.next();
                }
            }
        } catch (Exception e) {
            throw new ArithmeticException("Error - Board input doesn't contain exactly 9 rows or column");
        }

    }

    public String[][] getBoard() {
        return this.board;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                result.append(board[row][col]);
            }
            result.append("\n");
        }

        return result.toString();
    }
}
