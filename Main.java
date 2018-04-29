///////////////////////////////////////////////////////////////////////////////
//                   
// Title:            P5 - Tournament Bracket
// Files:            Main.java, Bracket.java, Game.java, Team.java, 
// 						TeamReader.java
//
// Semester:         Spring 2018
//
// Authors:          Jonah Rueb, jrueb@wisc.edu; 
//		     Haley Richards, hlrichards@wisc.edu;
//		     Sam Ramakrishnan, sramakrishn8@wisc.edu 
// Lecturer's Name:  Debra Deppeler CS400
//
///////////////////////////////////////////////////////////////////////////////

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	static ArrayList<Team> teamsList;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
		
			// This section initializes each game to be played in each round, starting with the
			// round of 16, then quarter finals, then semi finals, then finals. This code correctly
			// seeds teams read in from the file (supports sizes 16, 8, 4, 2, 1, and 0) 
			// Each game is a vertical box with 2 horizontal boxes (each with a Label and TextField)
			// and a submit button. Each round of games is then put into its own vertical box 
			
			VBox game1 = new VBox();
			Label team1 = new Label("Team 1");
			Label team16 = new Label("Team 16");
			// checks if there are enough teams to hold the round of 16, 
			// if so, it seeds them
			if(teamsList.size() == 16) {
				team1.setText(teamsList.get(0).getName());
				team16.setText(teamsList.get(15).getName());
			}
			HBox hbox1 = new HBox();
			TextField score1 = new TextField();
			score1.setPromptText("score");
			hbox1.getChildren().addAll(team1,score1);
			hbox1.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox16 = new HBox();
			TextField score16 = new TextField();
			score16.setPromptText("score");
			hbox16.getChildren().addAll(team16,score16);
			hbox16.setAlignment(Pos.CENTER_RIGHT);
			Button game1submit = new Button("Submit Score");
			game1.getChildren().addAll(hbox1,game1submit,hbox16);
			game1.setAlignment(Pos.CENTER_RIGHT);
			
			
			VBox game2 = new VBox();
			Label team8 = new Label("Team 8");
			Label team9 = new Label("Team 9");
			if(teamsList.size() == 16) {
				team8.setText(teamsList.get(7).getName());
				team9.setText(teamsList.get(8).getName());
			}
			HBox hbox8 = new HBox();
			TextField score8 = new TextField();
			score8.setPromptText("score");
			hbox8.getChildren().addAll(team8,score8);
			hbox8.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox9 = new HBox();
			TextField score9 = new TextField();
			score9.setPromptText("score");
			hbox9.getChildren().addAll(team9,score9);
			hbox9.setAlignment(Pos.CENTER_RIGHT);
			Button game2submit = new Button("Submit Score");
			game2.getChildren().addAll(hbox8,game2submit,hbox9);
			game2.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game3 = new VBox();
			Label team4 = new Label("Team 4");
			Label team13 = new Label("Team 13");
			if(teamsList.size() == 16) {
				team4.setText(teamsList.get(3).getName());
				team13.setText(teamsList.get(12).getName());
			}
			HBox hbox4 = new HBox();
			TextField score4 = new TextField();
			score4.setPromptText("score");
			hbox4.getChildren().addAll(team4,score4);
			hbox4.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox13 = new HBox();
			TextField score13 = new TextField();
			score13.setPromptText("score");
			hbox13.getChildren().addAll(team13,score13);
			hbox13.setAlignment(Pos.CENTER_RIGHT);
			Button game3submit = new Button("Submit Score");
			game3.getChildren().addAll(hbox4,game3submit,hbox13);
			game3.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game4 = new VBox();
			Label team5 = new Label("Team 5");
			Label team12 = new Label("Team 12");
			if(teamsList.size() == 16) {
				team5.setText(teamsList.get(4).getName());
				team12.setText(teamsList.get(11).getName());
			}
			HBox hbox5 = new HBox();
			TextField score5 = new TextField();
			score5.setPromptText("score");
			hbox5.getChildren().addAll(team5,score5);
			hbox5.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox12 = new HBox();
			TextField score12 = new TextField();
			score12.setPromptText("score");
			hbox12.getChildren().addAll(team12,score12);
			hbox12.setAlignment(Pos.CENTER_RIGHT);
			Button game4submit = new Button("Submit Score");
			game4.getChildren().addAll(hbox5,game4submit,hbox12);
			game4.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game5 = new VBox();
			Label team2 = new Label("Team 2");
			Label team15 = new Label("Team 15");
			if(teamsList.size() == 16) {
				team2.setText(teamsList.get(1).getName());
				team15.setText(teamsList.get(14).getName());
			}
			HBox hbox2 = new HBox();
			TextField score2 = new TextField();
			score2.setPromptText("score");
			hbox2.getChildren().addAll(team2,score2);
			hbox2.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox15 = new HBox();
			TextField score15 = new TextField();
			score15.setPromptText("score");
			hbox15.getChildren().addAll(team15,score15);
			hbox15.setAlignment(Pos.CENTER_RIGHT);
			Button game5submit = new Button("Submit Score");
			game5.getChildren().addAll(hbox2,game5submit,hbox15);
			game5.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game6 = new VBox();
			Label team7 = new Label("Team 7");
			Label team10 = new Label("Team 10");
			if(teamsList.size() == 16) {
				team7.setText(teamsList.get(6).getName());
				team10.setText(teamsList.get(9).getName());
			}
			HBox hbox7 = new HBox();
			TextField score7 = new TextField();
			score7.setPromptText("score");
			hbox7.getChildren().addAll(team7,score7);
			hbox7.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox10 = new HBox();
			TextField score10 = new TextField();
			score10.setPromptText("score");
			hbox10.getChildren().addAll(team10,score10);
			hbox10.setAlignment(Pos.CENTER_RIGHT);
			Button game6submit = new Button("Submit Score");
			game6.getChildren().addAll(hbox7,game6submit,hbox10);
			game6.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game7 = new VBox();
			Label team3 = new Label("Team 3");
			Label team14 = new Label("Team 14");
			if(teamsList.size() == 16) {
				team3.setText(teamsList.get(2).getName());
				team14.setText(teamsList.get(13).getName());
			}
			HBox hbox3 = new HBox();
			TextField score3 = new TextField();
			score3.setPromptText("score");
			hbox3.getChildren().addAll(team3,score3);
			hbox3.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox14 = new HBox();
			TextField score14 = new TextField();
			score14.setPromptText("score");
			hbox14.getChildren().addAll(team14,score14);
			hbox14.setAlignment(Pos.CENTER_RIGHT);
			Button game7submit = new Button("Submit Score");
			game7.getChildren().addAll(hbox3,game7submit,hbox14);
			game7.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game8 = new VBox();
			Label team6 = new Label("Team 6");
			Label team11 = new Label("Team 11");
			if(teamsList.size() == 16) {
				team6.setText(teamsList.get(5).getName());
				team11.setText(teamsList.get(10).getName());
			}
			HBox hbox6 = new HBox();
			TextField score6 = new TextField();
			score6.setPromptText("score");
			hbox6.getChildren().addAll(team6,score6);
			hbox6.setAlignment(Pos.CENTER_RIGHT);
			HBox hbox11 = new HBox();
			TextField score11 = new TextField();
			score11.setPromptText("score");
			hbox11.getChildren().addAll(team11,score11);
			hbox11.setAlignment(Pos.CENTER_RIGHT);
			Button game8submit = new Button("Submit Score");
			game8.getChildren().addAll(hbox6,game8submit,hbox11);
			game8.setAlignment(Pos.CENTER_RIGHT);
			
			VBox round1 = new VBox();
			round1.getChildren().addAll(game1, new Label(" "),game2,new Label(" "),game3,new Label(" "),game4,
					new Label(" "),game5,new Label(" "),game6,new Label(" "),game7,new Label(" "),game8);	

			
			// This section begins the quarter final games
			
			VBox quarter1 = new VBox();
			Label teamq1 = new Label("TBD");
			Label teamq2 = new Label("TBD");
			// checks to see if the quarter finals is the first round,
			// if so, it seeds the teams
			if(teamsList.size() == 8) {
				teamq1.setText(teamsList.get(0).getName());
				teamq2.setText(teamsList.get(7).getName());
			}
			HBox hboxq1 = new HBox();
			TextField scoreq1 = new TextField();
			scoreq1.setPromptText("score");
			hboxq1.getChildren().addAll(teamq1,scoreq1);
			hboxq1.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxq2 = new HBox();
			TextField scoreq2 = new TextField();
			scoreq2.setPromptText("score");
			hboxq2.getChildren().addAll(teamq2,scoreq2);
			hboxq2.setAlignment(Pos.CENTER_RIGHT);
			Button quarter1submit = new Button("Submit Score");
			// disables the button if there are enough teams to hold a round of 16
			if(teamsList.size() > 8)
				quarter1submit.setDisable(true);
			quarter1.getChildren().addAll(hboxq1,quarter1submit,hboxq2);
			quarter1.setAlignment(Pos.CENTER_RIGHT);
			
			VBox quarter2 = new VBox();
			Label teamq3 = new Label("TBD");
			Label teamq4 = new Label("TBD");
			if(teamsList.size() == 8) {
				teamq3.setText(teamsList.get(3).getName());
				teamq4.setText(teamsList.get(4).getName());
			}
			HBox hboxq3 = new HBox();
			TextField scoreq3 = new TextField();
			scoreq3.setPromptText("score");
			hboxq3.getChildren().addAll(teamq3,scoreq3);
			hboxq3.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxq4 = new HBox();
			TextField scoreq4 = new TextField();
			scoreq4.setPromptText("score");
			hboxq4.getChildren().addAll(teamq4,scoreq4);
			hboxq4.setAlignment(Pos.CENTER_RIGHT);
			Button quarter2submit = new Button("Submit Score");
			if(teamsList.size() > 8)
				quarter2submit.setDisable(true);
			quarter2.getChildren().addAll(hboxq3,quarter2submit,hboxq4);
			quarter2.setAlignment(Pos.CENTER_RIGHT);
			
			VBox quarter3 = new VBox();
			Label teamq5 = new Label("TBD");
			Label teamq6 = new Label("TBD");
			if(teamsList.size() == 8) {
				teamq5.setText(teamsList.get(1).getName());
				teamq6.setText(teamsList.get(6).getName());
			}
			HBox hboxq5 = new HBox();
			TextField scoreq5 = new TextField();
			scoreq5.setPromptText("score");
			hboxq5.getChildren().addAll(teamq5,scoreq5);
			hboxq5.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxq6 = new HBox();
			TextField scoreq6 = new TextField();
			scoreq6.setPromptText("score");
			hboxq6.getChildren().addAll(teamq6,scoreq6);
			hboxq6.setAlignment(Pos.CENTER_RIGHT);
			Button quarter3submit = new Button("Submit Score");
			if(teamsList.size() > 8)
				quarter3submit.setDisable(true);
			quarter3.getChildren().addAll(hboxq5,quarter3submit,hboxq6);
			quarter3.setAlignment(Pos.CENTER_RIGHT);
			
			VBox quarter4 = new VBox();
			Label teamq7 = new Label("TBD");
			Label teamq8 = new Label("TBD");
			if(teamsList.size() == 8) {
				teamq7.setText(teamsList.get(2).getName());
				teamq8.setText(teamsList.get(5).getName());
			}
			HBox hboxq7 = new HBox();
			TextField scoreq7 = new TextField();
			scoreq7.setPromptText("score");
			hboxq7.getChildren().addAll(teamq7,scoreq7);
			hboxq7.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxq8 = new HBox();
			TextField scoreq8 = new TextField();
			scoreq8.setPromptText("score");
			hboxq8.getChildren().addAll(teamq8,scoreq8);
			hboxq8.setAlignment(Pos.CENTER_RIGHT);
			Button quarter4submit = new Button("Submit Score");
			if(teamsList.size() > 8)
				quarter4submit.setDisable(true);
			quarter4.getChildren().addAll(hboxq7,quarter4submit,hboxq8);
			quarter4.setAlignment(Pos.CENTER_RIGHT);
			
			// adds all of the quarter final games to a VBox and adds blank labels for spacing on the GUI
			VBox quarters = new VBox();
			quarters.getChildren().addAll(new Label("  "),new Label("  "),new Label("  "), quarter1, new Label("  "), 
					new Label("  "),new Label("  "),new Label("  "),new Label("  "),new Label("  "),quarter2, 
					new Label("  "),new Label("  "),new Label("  "),new Label("  "),
					new Label("  "),new Label("  "),new Label("  "),quarter3, 
					new Label("  "),new Label("  "),new Label("  "),new Label("  "),
					new Label("  "),new Label("  "),new Label("  "), quarter4);
			
			VBox semi1 = new VBox();
			Label teamSemi1 = new Label("TBD");
			Label teamSemi2 = new Label("TBD");
			// Checks if there are only 4 teams (the bracket begins with
			// semis) and seeds the four teams if that is true
			if(teamsList.size() == 4) {
				teamSemi1.setText(teamsList.get(0).getName());
				teamSemi2.setText(teamsList.get(3).getName());
			}
			HBox hboxSemi1 = new HBox();
			TextField scoreSemi1 = new TextField();
			scoreSemi1.setPromptText("score");
			hboxSemi1.getChildren().addAll(teamSemi1,scoreSemi1);
			hboxSemi1.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxSemi2 = new HBox();
			TextField scoreSemi2 = new TextField();
			scoreSemi2.setPromptText("score");
			hboxSemi2.getChildren().addAll(teamSemi2,scoreSemi2);
			hboxSemi2.setAlignment(Pos.CENTER_RIGHT);
			Button semi1submit = new Button("Submit Score");
			if(teamsList.size() > 4)
				semi1submit.setDisable(true);
			semi1.getChildren().addAll(hboxSemi1,semi1submit,hboxSemi2);
			semi1.setAlignment(Pos.CENTER_RIGHT);
			
			VBox semi2 = new VBox();
			Label teamSemi3 = new Label("TBD");
			Label teamSemi4 = new Label("TBD");
			if(teamsList.size() == 4) {
				teamSemi3.setText(teamsList.get(1).getName());
				teamSemi4.setText(teamsList.get(2).getName());
			}
			HBox hboxSemi3 = new HBox();
			TextField scoreSemi3 = new TextField();
			scoreSemi3.setPromptText("score");
			hboxSemi3.getChildren().addAll(teamSemi3,scoreSemi3);
			hboxSemi3.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxSemi4 = new HBox();
			TextField scoreSemi4 = new TextField();
			scoreSemi4.setPromptText("score");
			hboxSemi4.getChildren().addAll(teamSemi4,scoreSemi4);
			hboxSemi4.setAlignment(Pos.CENTER_RIGHT);
			Button semi2submit = new Button("Submit Score");
			if(teamsList.size() > 4)
				semi2submit.setDisable(true);
			semi2.getChildren().addAll(hboxSemi3,semi2submit,hboxSemi4);
			semi2.setAlignment(Pos.CENTER_RIGHT);
			
			VBox semis = new VBox();
			semis.getChildren().addAll(new Label(" "),new Label(" "),new Label(" "), 
					new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),semi1,
					new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "), 
					new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),
					new Label(" "),new Label(" "),new Label(" "),new Label(" "),
					new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "), semi2);
			
			VBox finals = new VBox();
			Label teamFinal1 = new Label("TBD");
			Label teamFinal2 = new Label("TBD");
			if(teamsList.size() == 2) {
				teamFinal1.setText(teamsList.get(0).getName());
				teamFinal2.setText(teamsList.get(1).getName());
			}
			HBox hboxFinal1 = new HBox();
			TextField scoreFinal1 = new TextField();
			scoreFinal1.setPromptText("score");
			hboxFinal1.getChildren().addAll(teamFinal1,scoreFinal1);
			hboxFinal1.setAlignment(Pos.CENTER_RIGHT);
			HBox hboxFinal2 = new HBox();
			TextField scoreFinal2 = new TextField();
			scoreFinal2.setPromptText("score");
			hboxFinal2.getChildren().addAll(teamFinal2,scoreFinal2);
			hboxFinal2.setAlignment(Pos.CENTER_RIGHT);
			Button finalSubmit = new Button("Submit Score");
			if(teamsList.size() > 2)
				finalSubmit.setDisable(true);
			finals.getChildren().addAll(hboxFinal1,finalSubmit,hboxFinal2);
			finals.setAlignment(Pos.CENTER_RIGHT);
			
			
			// adds the team names to an ArrayList so that they may be 
			// put into an ObservableList and displayed in order on the GUI
			ArrayList<String> teamNames = new ArrayList<String>();
			for(int x = 0; x < teamsList.size(); x++) {
				teamNames.add(teamsList.get(x).getName());
			}
			
			// puts the team names into an ObservableList
			ListView<String> list = new ListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList(teamNames);
			list.setItems(items);
			
			// adds the rounds to the GUI as necessary, depending on the number
			// of teams in the tournament
			GridPane gPane = new GridPane();
			if(teamsList.size() == 16)
				gPane.add(round1, 0, 0);
			if(teamsList.size() >= 8)
				gPane.add(quarters, 1, 0);
			if(teamsList.size() >= 4)
				gPane.add(semis, 2, 0);
			if(teamsList.size() >= 2)
				gPane.add(finals, 3, 0);
			
			// handles the GUI if there's only one team in the tournament, since 
			// no game can be played
			// We decided just to display the name of the team rather than creating 
			// a game display
			if(teamsList.size() == 1) {
				Label onlyTeam = new Label(teamsList.get(0).getName());
				gPane.add(onlyTeam, 0, 1);
			}
			
			
			
			// This section displays the top 3 teams from the tournament
			Label top = new Label("Leaderboard");
			top.setStyle("-fx-font: 40 arial;");
			
			Label firstPlace = new Label("First Place:");
			firstPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0) // handles the case where there are 0 teams
				firstPlace.setText("No winner");
			else if(teamsList.size() == 1) // handles the case where there's only 1 team
				firstPlace.setText(teamsList.get(0).getName());
			
			Label secondPlace = new Label("Second Place:");
			secondPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0)
				secondPlace.setText("No runner-up");
			else if(teamsList.size() == 1)
				secondPlace.setText("No runner-up");
			
			Label thirdPlace = new Label("Third Place:");
			thirdPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0)
				thirdPlace.setText("No third place");
			else if(teamsList.size() == 1) 
				thirdPlace.setText("No third place");
			else if(teamsList.size() == 2) // handles the case where there are only 2 teams
				thirdPlace.setText("No third place");
			
			VBox topTeams = new VBox();
			topTeams.setAlignment(Pos.CENTER);
			topTeams.getChildren().addAll(top,firstPlace,secondPlace,thirdPlace);
			
		    BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("CS400 Tournament Bracket");
			root.setLeft(list);
			root.setCenter(gPane);
			root.setRight(topTeams);
			primaryStage.setWidth(1450);
 			primaryStage.setHeight(1000);
			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TeamReader read = new TeamReader("src/16Teams.txt"); // (args[0]);
        teamsList = read.getTeams();
        Bracket bracket = new Bracket(teamsList);
        
		launch(args);
	}
	
}
