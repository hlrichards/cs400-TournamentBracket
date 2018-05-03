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

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Game {
    Team team1, team2, winner, loser;
    int scoreTeam1, scoreTeam2;
    GameUI gameUI;
       
    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        gameUI = new GameUI(team1.getName(),team2.getName());
        winner = null; loser = null;       
    }
    
    public GameUI getGameUI() {
        return gameUI;
    }

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
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
    
    public int getLoserScore() {
        if(loser != null) {
            if(team1.equals(loser)) {
                return getScoreTeam1();
            } else {
                return getScoreTeam2();
            }
        } else {
            return 0;
        }
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
        this.gameUI.lbl_team1.setText(team1.getName());
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
        this.gameUI.lbl_team2.setText(team2.getName());
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public void setLoser(Team loser) {
        this.loser = loser;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
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

    public Team playGame(String score1, String score2) {
        // TODO Auto-generated method stub
        this.scoreTeam1 = Integer.parseInt(score1);
        this.scoreTeam2 = Integer.parseInt(score2);
        if(scoreTeam1 >= scoreTeam2) {          
            winner = team1;
            loser = team2;          
        } else {
            winner = team2;
            loser = team1;
        }
        return winner;
    }
    class GameUI{
        VBox ui;
        public VBox getUi() {
            return ui;
        }
        public void setUi(VBox ui) {
            this.ui = ui;
        }
        Label lbl_team1, lbl_team2;
        public Label getLbl_team1() {
            return lbl_team1;
        }
        public void setLbl_team1(Label lbl_team1) {
            this.lbl_team1 = lbl_team1;
        }
        public Label getLbl_team2() {
            return lbl_team2;
        }
        public void setLbl_team2(Label lbl_team2) {
            this.lbl_team2 = lbl_team2;
        }
        TextField txt_score1, txt_score2;
        HBox hbox1, hbox2;
        public TextField getTxt_score1() {
            return txt_score1;
        }
        public void setTxt_score1(TextField txt_score1) {
            this.txt_score1 = txt_score1;
        }
        public TextField getTxt_score2() {
            return txt_score2;
        }
        public void setTxt_score2(TextField txt_score2) {
            this.txt_score2 = txt_score2;
        }
        public Button getBtn_submit() {
            return btn_submit;
        }
        public void setBtn_submit(Button btn_submit) {
            this.btn_submit = btn_submit;
        }
        Button btn_submit;
        public GameUI(String team1, String team2) {
            super();
            ui = new VBox();
            lbl_team1 = new Label(team1);
            lbl_team2 = new Label(team2);

             hbox1 = new HBox();
             txt_score1 = new TextField();
            txt_score1.setPromptText("score");
            hbox1.getChildren().addAll(lbl_team1,txt_score1);
            hbox1.setAlignment(Pos.CENTER_RIGHT);
             hbox2 = new HBox();
            txt_score2 = new TextField();
            txt_score2.setPromptText("score");
            hbox2.getChildren().addAll(lbl_team2,txt_score2);
            hbox2.setAlignment(Pos.CENTER_RIGHT);
            btn_submit = new Button("Submit Score");
            ui.getChildren().addAll(hbox1,btn_submit,hbox2);
            ui.setAlignment(Pos.CENTER_RIGHT);
        }
     
    }
    

    
}


