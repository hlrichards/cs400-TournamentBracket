import java.util.ArrayList;
import java.util.TreeSet;

public class Bracket {
    ArrayList<ArrayList<Game>> bracket = new ArrayList<>();


    
    /**
     * Given an ArrayList of teams in seeded order it creates an ArrayList of Games
     * with the highest seeded teams playing its corresponding lower seeded teams
     * @param teams
     */
    public Bracket(ArrayList<Team> teams){
        int num = teams.size();
        createBracket(num);
    }
    
    /**
     * Creates the shell for the bracket with Games that contain Teams with
     * the name "TBD" and seeded 0.
     * @param size
     */
    public void createBracket(int size) {
        ArrayList<Game> round = new ArrayList<>();
        if(size == 1) return;
        else {
            for(int i = 0; i < size/2; i++) {
                round.add(new Game(new Team("TBD", 0), new Team("TBD", 0)));
            }
            bracket.add(round);
            size = size / 2;
        }
        createBracket(size);
    }
    
    
    /**
     * @return the given round
     */
    public ArrayList<Game> getRound(int round){
        // added 1 for idexing
        return bracket.get(round);
    }
    
    /**
     * Adds previous round to the bracket
     * Assumes all games have a winner and loser.
     * Creates the next round of Games
     * @return true if the next round was created false if it couldn't
     */
    public boolean nextRound() {
        return true;
    }
}
