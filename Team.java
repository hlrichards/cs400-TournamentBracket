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

/**
 * This class  holds all the data for each team including their wins, losses
 * name, and seed
 * @author Haley, Jonah, Sam
 *
 */
public class Team {
    String name;
    int seed, wins, loses;
    
    /**
     * This constructor initializes the team name, seed, number of wins, and 
     * number of losses
     * @param name is the team name
     * @param seed is the seed number
     */
    public Team(String name, int seed) {
        this.name = name;
        this.seed = seed;
        wins = 0;
        loses = 0;
    }

    /**
     * Returns the number of wins
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets the number of wins
     * @param wins number of wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Returns the number of losses
     * @return losses
     */
    public int getLoses() {
        return loses;
    }

    /**
     * Sets the number of losses
     * @param loses number of loses
     */
    public void setLoses(int loses) {
        this.loses = loses;
    }

    /**
     * Returns the team name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the team seed number
     * @return seed
     */
    public int getSeed() {
        return seed;
    }
    

}
