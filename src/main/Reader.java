import java.io.FileNotFoundException;

public interface Reader {
    String[][] readFile(String filePath) throws FileNotFoundException;
}
