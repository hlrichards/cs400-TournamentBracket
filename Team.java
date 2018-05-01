package application;


public class Team {
    String name;
    int seed, wins, loses;
    
    public Team(String name, int seed) {
        this.name = name;
        this.seed = seed;
        wins = 0;
        loses = 0;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public String getName() {
        return name;
    }

    public int getSeed() {
        return seed;
    }
    
    

}
