package attendance.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {
    private ResourceReader () {}

    public static List<String> readFile(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = readLines(bufferedReader);
            closeReader(bufferedReader, fileReader);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(ErrorMessage.FILE_READ_EXCEPTION.getMessage());
        }
    }

    private static List<String> readLines(BufferedReader bufferedReader) throws IOException {
        String line = "";
        List<String> lines = new ArrayList<>();
        bufferedReader.readLine(); // 첫 줄 읽기

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    private static void closeReader(BufferedReader bufferedReader, FileReader fileReader) throws IOException {
        bufferedReader.close();
        fileReader.close();
    }
}
