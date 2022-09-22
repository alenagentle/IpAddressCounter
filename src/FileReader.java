import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Closeable {

    static int position = 0;
    BufferedReader reader = null;

    public FileReader(String fileName) {
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try {
            reader = Files.newBufferedReader(path, charset);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Ip> readFile(int bufferSize) throws IOException {
        String s;
        int linesCounter = 1;
        List<Ip> list = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            if (linesCounter < bufferSize) {
                list.add(new Ip(s, position++));
                linesCounter++;
            } else break;
        }
        return list;
    }

    @Override
    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}
