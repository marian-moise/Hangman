import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HangmanUtils {

    public static List<Words> readFileToWordsList (File file) {
        List<Words> listWords = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String fileLine;

            while ((fileLine = br.readLine()) != null) {
                String[] wordsArray = fileLine.split(" ");
                for (int i = 0; i < wordsArray.length ; i++) {
                    Words temp = new Words(wordsArray[0]);
                    listWords.add(temp);
                }
            }
            return listWords;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
