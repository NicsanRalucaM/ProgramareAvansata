import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private int bestPoints;
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        player.setDictionary(dictionary);
    }

    public int getBestPoints() {
        return bestPoints;
    }

    public void setBestPoints(int bestPoints) {
        if(bestPoints>this.bestPoints)
        this.bestPoints = bestPoints;
    }

    public  void getWinner(){
        Collections.sort(players);
        System.out.println(players);
        System.out.println("laaaa");
    }
    public MockDictionary getDictionary() {
        return dictionary;
    }

    public void play() {
        for (Player player : players) {
           Thread t=new Thread(player);
           t.start();
        }

    }
    public static void main(String args[]) {
        Game game = new Game();
        game.bestPoints=0;
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

        game.getWinner();
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }
}
