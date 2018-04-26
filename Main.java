import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TeamReader read = new TeamReader("src/4Teams.txt");
        ArrayList<Team> teams = read.getTeams();
        Bracket bracket = new Bracket(teams);
        ArrayList<Game> round1 = bracket.getRound(1);
        for(Game game : round1) {
            System.out.println(game.getTeam1().getName() + " verse: " + game.getTeam2().getSeed());
        }
    }
}
