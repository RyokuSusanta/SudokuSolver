import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SudokuSolver recursive = new RecursiveSolver("src/resources/scratch.sdk");
        SudokuSolver iterative = new IterativeSolver("src/resources/scratch.sdk");

        // The recursive approach solved in Time: 8806863646, while the Iterative or DFS approach solved
        // In Time: 3875642785. I believe the DFS or iterative approach is faster due to its efficient memory
        // management and Faster return if the option are founded to be solved.
        long t1 = System.nanoTime();
        System.out.println(recursive.solve());
        long t2 = System.nanoTime();
        System.out.println("Time: " + String.valueOf(t2 - t1));
        long a1 = System.nanoTime();
        System.out.println(iterative.solve());
        long a2 = System.nanoTime();
        System.out.println("Time: " + String.valueOf(a2 - a1));

    }

}
