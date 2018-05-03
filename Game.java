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

/**
 * This class simulates each game in the tournament and creates
 * the controls to be displayed on the GUI for each game
 * @author Haley, Jonah, Sam
 *
 */
public class Game {
    Team team1, team2, winner, loser;
    int scoreTeam1, scoreTeam2;
    GameUI gameUI;
       
    /**
     * This constructor initializes the fields corresponding to the
     * Teams passed in through parameters to begin the game
     * @param team1
     * @param team2
     */
    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        gameUI = new GameUI(team1.getName(),team2.getName());
        winner = null; loser = null;       
    }
    
    /**
     * This method returns the gameUI field to be displayed
     * @return
     */
    public GameUI getGameUI() {
        return gameUI;
    }

    /**
     * This method allows the gameUI to be set 
     * @param gameUI the controls to be shown
     */
    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }
    
    /**
     * This method returns the score of the loser of the game
     * @return score of loser
     */
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

    /**
     * This method returns the Team object for team1
     * @return
     */
    public Team getTeam1() {
        return team1;
    }
    
    /**
     * This method returns the Team object for team2
     * @return
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * This method allows the team1 field to be changed
     * @param team1 is the new Team object
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
        this.gameUI.lbl_team1.setText(team1.getName());
    }

    /**
     * This method allows the team2 field to be changed
     * @param team2 is the new Team object
     */
    public void setTeam2(Team team2) {
        this.team2 = team2;
        this.gameUI.lbl_team2.setText(team2.getName());
    }

    /**
     * Allows the winner of the game to be set
     * @param winner
     */
    public void setWinner(Team winner) {
        this.winner = winner;
    }

    /**
     * Allows the loser of the game to be set
     * @param loser
     */
    public void setLoser(Team loser) {
        this.loser = loser;
    }

    /**
     * Allows team 1's score to be set
     * @param scoreTeam1
     */
    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    /**
     * Allows team 2's score to be set
     * @param scoreTeam2
     */
    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    /**
     * Returns the winner of the game
     * @return
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * Returns the loser of the game
     * @return
     */
    public Team getLoser() {
        return loser;
    }

    /**
     * Returns team 1's score
     * @return
     */
    public int getScoreTeam1() {
        return scoreTeam1;
    }
    
    /**
     * Returns team 2's score
     * @return
     */
    public int getScoreTeam2() {
        return scoreTeam2;
    }

    /**
     * This method takes in the strings from the textfields
     * and updates the game fields according to which team 
     * wins and which team loses
     * @param score1 team1's score
     * @param score2 team2's score
     * @return the winning Team
     */
    public Team playGame(String score1, String score2) {
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
    
    /**
     * This class sets up the controls for the GUI for each game according
     * to the fields in the Game class
     * @author Haley, Jonah, Sam
     */
    class GameUI {
        VBox ui;
        Label lbl_team1, lbl_team2;
        TextField txt_score1, txt_score2;
        HBox hbox1, hbox2;
        Button btn_submit;
        
        
        /**
         * This constructor initializes the controls according to the 
         * team names passed in and adds each team to a HBox which is later 
         * added to the game VBox
         * @param team1
         * @param team2
         */
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
        
        /**
         * Returns the completed UI
         * @return
         */
        public VBox getUi() {
            return ui;
        }
        
        /**
         * Allows the ui field to be set to an existing UI
         * @param ui
         */
        public void setUi(VBox ui) {
            this.ui = ui;
        }
        
        /**
         * Returns the label for team1
         * @return
         */
        public Label getLbl_team1() {
            return lbl_team1;
        }
        
        /**
         * Allows the label for team1 to be set to an existing label
         * @param lbl_team1
         */
        public void setLbl_team1(Label lbl_team1) {
            this.lbl_team1 = lbl_team1;
        }
        
        /**
         * Returns the label for team2
         * @return
         */
        public Label getLbl_team2() {
            return lbl_team2;
        }
        
        /**
         * Allows the label for team2 to be set to an existing label
         * @param lbl_team2
         */
        public void setLbl_team2(Label lbl_team2) {
            this.lbl_team2 = lbl_team2;
        }
        
        /**
         * Returns the Textfield for team1's score
         * @return
         */
        public TextField getTxt_score1() {
            return txt_score1;
        }
        
        /**
         * Allows the TextField for team1 to be set to an existing TextField
         * @param txt_score1
         */
        public void setTxt_score1(TextField txt_score1) {
            this.txt_score1 = txt_score1;
        }
        
        /**
         * Returns the TextField for team2's score
         * @return
         */
        public TextField getTxt_score2() {
            return txt_score2;
        }
        
        /**
         * Allows the TextField for team2 to be set to an existing TextField
         * @param txt_score2
         */
        public void setTxt_score2(TextField txt_score2) {
            this.txt_score2 = txt_score2;
        }
        
        /**
         * Returns the submit button for the game
         * @return
         */
        public Button getBtn_submit() {
            return btn_submit;
        }
        
        /**
         * Allows the submit button to be set to an existing button
         * @param btn_submit
         */
        public void setBtn_submit(Button btn_submit) {
            this.btn_submit = btn_submit;
        }

    }
}


