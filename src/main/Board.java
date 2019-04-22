import java.io.*;

public class Board {
    private String[][] board;

    public Board(String filePath) throws FileNotFoundException {
        Reader newFile = BoardReaderFactory.fileType(filePath);
        this.board = newFile.readFile(filePath);
    }

    public String[][] getBoard() { return this.board; }

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
