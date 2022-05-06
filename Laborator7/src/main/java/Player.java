import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable, Comparable<Player> {
    private String name;
    private Game game;
    private MockDictionary dictionary;
    private boolean running;
    private int points;
    private List<Tile> tileExtracted = new ArrayList<>();

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    private List<Tile> extractWord(int howMany) {
        List<Tile> extracted = game.getBag().extractTiles(howMany);
        if (extracted.isEmpty()) {
            return null;
        }
        return extracted;
    }

    private boolean submitWord(String extracted) throws InterruptedException {

        // tileExtracted.addAll(extracted);
        //String word = extracted.toString();
        game.getBoard().addWord(this, extracted);
        sleep(50);
        return true;
    }
    // private verifyLetters()

    public String getName() {
        return name;
    }

    @Override
    public void run() {

        List<Tile> extracted =extractWord(7);

        String word = null;
        int pointsWord = 0;
        while (extracted != null) {
            synchronized (extracted){

                // System.out.println(extracted);
            // System.out.println(dictionary.isWord(String.valueOf(extracted), word));
            word = dictionary.isWord(String.valueOf(extracted));
            if (word != null) {

                try {
                    pointsWord = 0;
                    for (Tile i : extracted) {
                        if (word.indexOf(i.getLetter()) != -1) {
                            pointsWord += i.getPoints();
                        }

                    }
                    points = points + (pointsWord * word.length());
                    submitWord(dictionary.isWord(String.valueOf(extracted)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + extracted);
            extracted = extractWord(7);

           // notify();
            }

        }

        System.out.println(getName() + ": " + getPoints());
        //System.out.println(dictionary);
        this.game.setBestPoints(points);

        if (points == this.game.getBestPoints()) System.out.println(getName() + " is the Winner - score: " + points);

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPoints() {
        return points;
    }

    public void setDictionary(MockDictionary dictionary) {
        this.dictionary = dictionary;
    }


    @Override
    public int compareTo(Player o) {
        return o.getPoints() - this.getPoints();
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + ": " + points + '\'' + '}';
    }
}
