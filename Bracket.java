package application;

import java.util.ArrayList;


public class Bracket {
    ArrayList<ArrayList<Game>> bracket = new ArrayList<>();


    
    /**
     * Given an ArrayList of teams in seeded order it creates an ArrayList of Games
     * with the highest seeded teams playing its corresponding lower seeded teams
     * @param teams
     */
    public Bracket(ArrayList<Team> teams){
        int num = teams.size();
        createBlankBracket(num);
        

        // puts games in order of 1 to 8 seed. This order is incorrect but fixed with
        // setFirstRound
        for(int i = 0; i < num/2; i++) {
            getRound(0).get(i).setTeam1(teams.get(i));
            getRound(0).get(i).setTeam2(teams.get(num-i-1));
        }
        
        setFirstRound(teams);
        
    }
    
    
    
    /**
     * Creates the shell for the bracket with Games that contain Teams with
     * the name "TBD" and seeded 0.
     * @param size is the number of teams in the round
     */
    public void createBlankBracket(int size) {
        ArrayList<Game> round = new ArrayList<>();
        if(size == 1 || size == 0) return;
        else {
            for(int i = 0; i < size/2; i++) {
                round.add(new Game(new Team("TBD", 0), new Team("TBD", 0)));
            }
            bracket.add(round);
            size = size / 2;
        }
        createBlankBracket(size);
    }
    
    
    /**
     * @return ArrayList os Games for the given round
     */
    public ArrayList<Game> getRound(int round){
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
    
    public int getNumberOfRounds() {
        return bracket.size();
    }
    
    /**
     * Hard code for setting the first round of the bracket
     * @param teams are put into the first round in correct order
     */
    private void setFirstRound(ArrayList<Team> teams) {
        int size = teams.size();
        
        if(size == 2) {
            getRound(0).get(0).setTeam1(teams.get(0));
            getRound(0).get(0).setTeam2(teams.get(1));
        }
        if(size == 4) {
            getRound(0).get(0).setTeam1(teams.get(0));
            getRound(0).get(0).setTeam2(teams.get(3));
            
            getRound(0).get(1).setTeam1(teams.get(1));
            getRound(0).get(1).setTeam2(teams.get(2));
        }
        
        if(size == 8) {
            getRound(0).get(0).setTeam1(teams.get(0));
            getRound(0).get(0).setTeam2(teams.get(7));
            
            getRound(0).get(1).setTeam1(teams.get(3));
            getRound(0).get(1).setTeam2(teams.get(4));
            
            
            getRound(0).get(2).setTeam1(teams.get(1));
            getRound(0).get(2).setTeam2(teams.get(6));   
            
            getRound(0).get(3).setTeam1(teams.get(2));
            getRound(0).get(3).setTeam2(teams.get(5));
                      
        }
        
        if(size == 16) {
            getRound(0).get(0).setTeam1(teams.get(0));
            getRound(0).get(0).setTeam2(teams.get(15));
            
            getRound(0).get(1).setTeam1(teams.get(7));
            getRound(0).get(1).setTeam2(teams.get(8));
            
            getRound(0).get(2).setTeam1(teams.get(3));
            getRound(0).get(2).setTeam2(teams.get(12));
            
            getRound(0).get(3).setTeam1(teams.get(4));
            getRound(0).get(3).setTeam2(teams.get(11));  
            
            getRound(0).get(4).setTeam1(teams.get(1));
            getRound(0).get(4).setTeam2(teams.get(14));
            
            getRound(0).get(5).setTeam1(teams.get(6));
            getRound(0).get(5).setTeam2(teams.get(9));
            
            getRound(0).get(6).setTeam1(teams.get(2));
            getRound(0).get(6).setTeam2(teams.get(13));
            
            getRound(0).get(7).setTeam1(teams.get(5));
            getRound(0).get(7).setTeam2(teams.get(10));  
        }
    }
}
