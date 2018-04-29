///////////////////////////////////////////////////////////////////////////////
//                   
// Title:            P5 - Tournament Bracket
// Files:            Main.java, Bracket.java, Game.java, Team.java, 
// 						TeamReader.java
//
// Semester:         Spring 2018
//
// Authors:          Jonah Rueb, jrueb@wisc.edu; 
//						Haley Richards, hlrichards@wisc.edu;
//						Sam Ramakrishnan, sramakrishn8@wisc.edu 
// Lecturer's Name:  Debra Deppeler CS400
//
///////////////////////////////////////////////////////////////////////////////

package application; 

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
        createBlankBracket(num);

        
        for(int i = 0; i < num/2; i++) {
            getRound(0).get(i).setTeam1(teams.get(i));
            getRound(0).get(i).setTeam2(teams.get(num-i-1));
        }
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
}
