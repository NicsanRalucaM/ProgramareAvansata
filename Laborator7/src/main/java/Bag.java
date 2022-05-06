import java.util.*;

public class Bag {

    private final Queue<Tile> letters = new LinkedList<>();

    public Bag() {
        int points=0, nr=0;
        char a = 0;
        for (char c = 'a'; c < 'z'; c++) {
        switch (c) {
            case 'a':
                nr = 9;
                points = 1;
                break;
            case 'b':
                nr = 2;
                points = 3;
                break;
            case 'c':
                nr = 2;
                points = 3;
                break;
            case 'd':
                nr = 4;
                points = 2;
                break;
            case 'e':
                nr = 12;
                points = 1;
                break;
            case 'f':
                nr = 2;
                points = 4;
                break;
            case 'g':
                nr = 3;
                points = 2;
                break;
            case 'h':
                nr = 2;
                points = 4;
                break;
            case 'i':
                nr = 9;
                points = 1;
                break;
            case 'j':
                nr = 1;
                points = 8;
                break;
            case 'k':
                nr = 1;
                points = 5;
                break;
            case 'l':
                nr = 4;
                points = 1;
                break;
            case 'm':
                nr = 2;
                points = 3;
                break;
            case 'n':
                nr = 6;
                points = 1;
                break;
            case 'o':
                nr = 8;
                points = 1;
                break;
            case 'p':
                nr = 2;
                points = 3;
                break;
            case 'q':
                nr = 1;
                points = 10;
                break;
            case 'r':
                nr = 6;
                points = 1;
                break;
            case 's':
                nr = 4;
                points = 1;
                break;
            case 't':
                nr = 6;
                points = 1;
                break;
            case 'u':
                nr = 4;
                points = 1;
                break;
            case 'v':
                nr = 2;
                points = 4;
                break;
            case 'w':
                nr = 2;
                points = 4;
                break;
            case 'x':
                nr = 1;
                points = 8;
                break;
            case 'y':
                nr = 2;
                points = 4;
                break;
            case 'z':
                nr = 1;
                points = 10;
                break;
        }
            for (int i = 0; i < nr; i++) {
                letters.add(new Tile(c, points));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.poll());
        }
        return extracted;
    }

}
