import java.io.IOException;

public class RecursiveSolver extends SudokuSolver {

    public RecursiveSolver(String filePath) throws IOException {
        super(filePath);
    }

    public Board solve() {
        int unfilled = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getBoard()[i][j].equals(".")) {
                    unfilled++;
                }
            }
        }

        return solveHelper(board, unfilled);
    }

    private static Board solveHelper(Board board, int unfilled) {
        if (unfilled == 0) {
            return board;
        }

        for (Board option : Board.getNeighbors(board)) {
            Board result = solveHelper(option, unfilled - 1);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

}
