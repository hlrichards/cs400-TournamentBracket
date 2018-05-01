package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
