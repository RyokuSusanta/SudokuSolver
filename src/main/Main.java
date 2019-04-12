import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Board myBoard = new Board("src/scratch.txt");
        System.out.println(myBoard.toString());
    }

}
