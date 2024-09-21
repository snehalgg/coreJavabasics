package set;
//Treeset
import java.util.TreeSet;

 

class Player implements Comparable<Player> {

    private String playerName;

    private int score;

 

    public Player(String playerName, int score) {

        this.playerName = playerName;

        this.score = score;

    }

 

    public String getPlayerName() {

        return playerName;

    }

 

    public int getScore() {

        return score;

    }

 

    @Override

    public int compareTo(Player otherPlayer) {

        // Sort players based on their scores in descending order

        return Integer.compare(otherPlayer.score, this.score);

    }

 

    @Override

    public String toString() {

        return playerName + " - Score: " + score;

    }

}

 

public class Leaderboard {

    private TreeSet<Player> leaderboard;

 

    public Leaderboard() {

        // Initialize the TreeSet with the custom comparator for Player objects

        leaderboard = new TreeSet<>();

    }

 

    public void addPlayer(Player player) {

        leaderboard.add(player);

    }

 

    public void displayLeaderboard(int topN) {

        System.out.println("Leaderboard:");

        int rank = 1;

        for (Player player : leaderboard) {

            System.out.println(rank + ". " + player);

            rank++;

            if (rank > topN) {

                break;

            }

        }

    }

 

    public static void main(String[] args) {

        Leaderboard leaderboard = new Leaderboard();

 

        Player player1 = new Player("John", 200);

        Player player2 = new Player("Alice", 300);

        Player player3 = new Player("Bob", 150);

        Player player4 = new Player("Emma", 250);

        Player player5 = new Player("Mike", 180);

 

        leaderboard.addPlayer(player1);

        leaderboard.addPlayer(player2);

        leaderboard.addPlayer(player3);

        leaderboard.addPlayer(player4);

        leaderboard.addPlayer(player5);

 

        leaderboard.displayLeaderboard(3);

    }

}
