import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> words=new ArrayList<>();
    public synchronized  void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
        notify();
    }
    @Override
    public String toString() {
        return words.toString();
    }

    public List<String> getWords() {
        return words;
    }
}
