package IO;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputFromFile {
    public String fileReader(String fileName) {
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), StandardCharsets.UTF_8));
            //
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                text = text + currentLine;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
