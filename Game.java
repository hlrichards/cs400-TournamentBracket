
public class Game {
    Team team1, team2, winner, loser;
    int scoreTeam1, scoreTeam2;
       
    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        winner = null; loser = null;       
    }
    
    /**
     * Sets the winner and loser based on scores given.
     * If there is a tie, team1 advances.
     * 
     * @param scoreTeam1 is the first team's score
     * @param scoreTeam2 is the sconde team's score
     */
    public void playGame(int scoreTeam1, int scoreTeam2) {
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        if(scoreTeam1 >= scoreTeam2) {          
            winner = team1;
            loser = team2;          
        } else {
            winner = team2;
            loser = team2;
        }
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getWinner() {
        return winner;
    }

    public Team getLoser() {
        return loser;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }
    
    
}
