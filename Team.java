///////////////////////////////////////////////////////////////////////////////
//                   
// Title:            P5 - Tournament Bracket
// Files:            Main.java, Bracket.java, Game.java, Team.java, 
//                      TeamReader.java
//
// Semester:         Spring 2018
//
// Authors:          Jonah Rueb, jrueb@wisc.edu; 
//                      Haley Richards, hlrichards@wisc.edu;
//                      Sam Ramakrishnan, sramakrishn8@wisc.edu 
// Lecturer's Name:  Debra Deppeler CS400
//
///////////////////////////////////////////////////////////////////////////////

package application;

/**
 * Team objects contain a name and a seed. The represent a team playing in the
 * tournament. They are generated by reading through a file given at the beginning
 * of the program. You can access there seed and name from public methods
 * 
 * @author jonahrueb
 *
 */
public class Team {
    String name;
    int seed;
    
    /**
     * Constucts a new Team object
     * @param name of the team
     * @param seed of the team
     */
    public Team(String name, int seed) {
        this.name = name;
        this.seed = seed;

    }

    /**
     * @return the Team's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the Team's seed
     */
    public int getSeed() {
        return seed;
    }
}
