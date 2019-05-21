import java.io.IOException;
import java.util.Stack;

public class IterativeSolver extends SudokuSolver {

    public IterativeSolver(String filePath) throws IOException {
        super(filePath);
    }

    public Board solve() {
        if (board.isSolved()) {
            return board;
        }

        Stack<Board> boardStack = new Stack<>();
        boardStack.push(board);
        while (!boardStack.isEmpty()) {
            Board check = boardStack.pop();
            for (Board option : Board.getNeighbors(check)) {
                if (option.isSolved()) {
                    return option;
                } else {
                    boardStack.push(option);
                }
            }
        }

        return null;
    }
}
