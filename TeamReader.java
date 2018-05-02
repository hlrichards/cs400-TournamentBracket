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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TeamReader is a class that reads information from a file and creates an ArrayList
 * of team objects from it. TeamReader expects a file with a team of each line and
 * the line number corresponds with the seed of the team.
 * 
 * @author jonahrueb
 *
 */
public class TeamReader {
    ArrayList<String> teamsString = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    
    String team;

    /**
     * Reads a file that contains a team name of each line.
     * Puts each team in an ArrayList according to their line.
     * 
     * @param filepath is the path of the file
     */
    public TeamReader(String filepath) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
            while((team = in.readLine()) != null) {
                teamsString.add(team);
            }
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
    
    /**
     * Iterates through the String ArrayList of teams
     * and transfers them into Team objects then adds them to
     * a Team ArrayList.
     * 
     * @return an ArrayList of Team objects
     */
    public ArrayList<Team> getTeams() {
        for(int i = 0; i < teamsString.size(); i++) {
            Team temp = new Team(teamsString.get(i), i+1);
            teams.add(temp);
        }
        return teams;
    }    
}
