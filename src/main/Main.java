import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Board myBoardSDK = new Board("src/resources/scratch.sdk");
        System.out.println(myBoardSDK.toString());

        Board myBoardSS = new Board("src/resources/scratch.ss");
        System.out.println(myBoardSS.toString());
        System.out.println(myBoardSS.isValid());
        System.out.println(myBoardSS.isSolved());
    }

}
