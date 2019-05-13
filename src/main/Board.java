import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Board {
    private String[][] board;

    public Board(String filePath) throws FileNotFoundException {
        Reader newFile = BoardReaderFactory.fileType(filePath);
        this.board = newFile.readFile(filePath);
    }

    public Board(String[][] board) {
        this.board = new String[9][9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = Arrays.copyOf(board[i], 9);
        }

    }

    public boolean isValid() {
        // Check the row
        for (int i = 0; i < 9; i++) {
            HashSet<String> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!board[i][j].equals(".")) {
                    if (row.contains(board[i][j])) {
                        return false;
                    } else if (!board[i][j].matches("[1-9]")) {
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            HashSet<String> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (!board[j][i].equals(".")) {
                    if (column.contains(board[j][i])) {
                        return false;
                    } else {
                        column.add(board[j][i]);
                    }
                }
            }
        }

        // Check the 3x3 Grid
        int mulI = 0;
        while (mulI < 3) {
            int mulJ = 0;
            while (mulJ < 3) {
                HashSet<String> grid = new HashSet<>();
                for (int i = mulI * 3; i < 3 + mulI * 3; i++) {
                    for (int j = mulJ * 3; j < 3 + mulJ * 3; j++) {
                        if (!board[i][j].equals(".")) {
                            if (grid.contains(board[i][j])) {
                                return false;
                            } else {
                                grid.add(board[i][j]);
                            }
                        }
                    }
                }
                mulJ++;
            }
            mulI++;
        }

        return true;
    }

    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(".")) {
                    return false;
                }
            }
        }
        return isValid();
    }

    // Before I pass the "real" part of the helper function on solving the sudoku solver. I first make sure to find
    // how many unfilled parts are in the sudoku and then use those to find all of the possible solution until the unfilled
    // part is non-existent.
    public void solve() {
        int unfilled = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(".")) {
                    unfilled++;
                }
            }
        }

        this.board = solveHelper(this.board, unfilled);
    }

    private static String[][] solveHelper(String[][] board, int unfilled) {
        if (unfilled == 0) {
            return board;
        }

        for (String[][] option : getNeighbors(board)) {
            String[][] result = solveHelper(option, unfilled - 1);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // I've decided to create a static method on getNeighbors that takes in a Board parameter. Because in my perspective
    // This is the most straight-forward method for this specific method, and the one where it is easiest to be understood.
    // By first check whether a "spot" is empty or not, then creating a new class to try out all the possible numbers before
    // checking if its valid or not to add the possible solutions to the lists of options. I've also created a new constructor
    // and getters to fully able to use the class in this method.
    private static List<String[][]> getNeighbors(String[][] board) {
        List<String[][]> options = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(".")) {
                    for (int k = 1; k < 10; k++) {
                        board[i][j] = Integer.toString(k);
                        Board classBoard = new Board(board);
                        if (classBoard.isValid()) {
                            String[][] possibleBoard = new String[9][9];
                            for (int l = 0; l < 9; l++) {
                                possibleBoard[l] = Arrays.copyOf(classBoard.getRow(l), 9);
                            }
                            options.add(possibleBoard);
                        }
                    }
                }
            }
        }

        return options;
    }

    public String[][] getBoard() {
        return this.board;
    }

    public String[] getRow(int row) {
        return this.board[row];
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
