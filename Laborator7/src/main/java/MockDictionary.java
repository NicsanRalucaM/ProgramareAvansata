import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MockDictionary {
    private ArrayList<String> dictionary = new ArrayList<String>();

    public MockDictionary() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "C:/Users/raluc/Downloads/scowl-2020.12.07/final/american-words.80"));
            String str;
            while ((str = in.readLine()) != null) {
                dictionary.add(str);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

    public String isWord(String str) {
        for (String word : dictionary) {
            if (word.length() < 7) {
                StringBuilder sb = new StringBuilder(word);
                for (int i = 0; i < sb.length(); i++) {
                    if (str.indexOf(sb.charAt(i)) != -1) {
                        sb.deleteCharAt(i);
                        i--;
                    }
                }
                if (sb.isEmpty()) {
                    return word;
                }
            }
        }
        // System.out.println("=>" + str + " - " + result);
        return null;
    }

    @Override
    public String toString() {
        return "MockDictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}