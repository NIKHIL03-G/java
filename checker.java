import java.util.*;
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (b.score != a.score) {
            return Integer.compare(b.score, a.score);
        }
      return a.name.compareTo(b.name);
    }
}

class Player{
