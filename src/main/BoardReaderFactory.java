public class BoardReaderFactory {
    public static Reader fileType(String filePath){
        if (filePath.endsWith("sdk")) {
            return new BoardReaderSDK();
        } else if (filePath.endsWith("ss")) {
            return new BoardReaderSS();
        }
        throw new IllegalArgumentException(filePath + " is not supported.");
    }
}
