import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        }
    }
}

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CS400 Tournament Bracket");
			primaryStage.show();
			
			
			GridPane gPane = new GridPane();
			root.setCenter(gPane);
			
			VBox game1 = new VBox();
			Label team1 = new Label("Team 1");
			Label team2 = new Label("Team 2");
			HBox hbox1 = new HBox();
			TextField score1 = new TextField();
			score1.setPromptText("score");
			hbox1.getChildren().addAll(team1,score1);
			HBox hbox2 = new HBox();
			TextField score2 = new TextField();
			score2.setPromptText("score");
			hbox2.getChildren().addAll(team2,score2);
			Button game1submit = new Button("Submit Score");
			game1.getChildren().addAll(hbox1,game1submit,hbox2);
			game1.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game2 = new VBox();
			Label team3 = new Label("Team 3");
			Label team4 = new Label("Team 4");
			HBox hbox3 = new HBox();
			TextField score3 = new TextField();
			score3.setPromptText("score");
			hbox3.getChildren().addAll(team3,score3);
			HBox hbox4 = new HBox();
			TextField score4 = new TextField();
			score4.setPromptText("score");
			hbox4.getChildren().addAll(team4,score4);
			Button game2submit = new Button("Submit Score");
			game2.getChildren().addAll(hbox3,game2submit,hbox4);
			game2.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game3 = new VBox();
			Label team5 = new Label("Team 5");
			Label team6 = new Label("Team 6");
			HBox hbox5 = new HBox();
			TextField score5 = new TextField();
			score5.setPromptText("score");
			hbox5.getChildren().addAll(team5,score5);
			HBox hbox6 = new HBox();
			TextField score6 = new TextField();
			score6.setPromptText("score");
			hbox6.getChildren().addAll(team6,score6);
			Button game3submit = new Button("Submit Score");
			game3.getChildren().addAll(hbox5,game3submit,hbox6);
			game3.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game4 = new VBox();
			Label team7 = new Label("Team 7");
			Label team8 = new Label("Team 8");
			HBox hbox7 = new HBox();
			TextField score7 = new TextField();
			score7.setPromptText("score");
			hbox7.getChildren().addAll(team7,score7);
			HBox hbox8 = new HBox();
			TextField score8 = new TextField();
			score8.setPromptText("score");
			hbox8.getChildren().addAll(team8,score8);
			Button game4submit = new Button("Submit Score");
			game4.getChildren().addAll(hbox7,game4submit,hbox8);
			game4.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game5 = new VBox();
			Label teamSemi1 = new Label("TBD");
			Label teamSemi2 = new Label("TBD");
			HBox hboxSemi1 = new HBox();
			TextField scoreSemi1 = new TextField();
			scoreSemi1.setPromptText("score");
			hboxSemi1.getChildren().addAll(teamSemi1,scoreSemi1);
			HBox hboxSemi2 = new HBox();
			TextField scoreSemi2 = new TextField();
			scoreSemi2.setPromptText("score");
			hboxSemi2.getChildren().addAll(teamSemi2,scoreSemi2);
			Button game5submit = new Button("Submit Score");
			game5submit.setDisable(true);
			game5.getChildren().addAll(hboxSemi1,game5submit,hboxSemi2);
			game5.setAlignment(Pos.CENTER_RIGHT);
			
			VBox game6 = new VBox();
			Label teamSemi3 = new Label("TBD");
			Label teamSemi4 = new Label("TBD");
			HBox hboxSemi3 = new HBox();
			TextField scoreSemi3 = new TextField();
			scoreSemi3.setPromptText("score");
			hboxSemi3.getChildren().addAll(teamSemi3,scoreSemi3);
			HBox hboxSemi4 = new HBox();
			TextField scoreSemi4 = new TextField();
			scoreSemi4.setPromptText("score");
			hboxSemi4.getChildren().addAll(teamSemi4,scoreSemi4);
			Button game6submit = new Button("Submit Score");
			game6submit.setDisable(true);
			game6.getChildren().addAll(hboxSemi3,game6submit,hboxSemi4);
			game6.setAlignment(Pos.CENTER_RIGHT);
			
			VBox finals = new VBox();
			Label teamFinal1 = new Label("TBD");
			Label teamFinal2 = new Label("TBD");
			HBox hboxFinal1 = new HBox();
			TextField scoreFinal1 = new TextField();
			scoreFinal1.setPromptText("score");
			hboxFinal1.getChildren().addAll(teamFinal1,scoreFinal1);
			HBox hboxFinal2 = new HBox();
			TextField scoreFinal2 = new TextField();
			scoreFinal2.setPromptText("score");
			hboxFinal2.getChildren().addAll(teamFinal2,scoreFinal2);
			Button finalSubmit = new Button("Submit Score");
			finalSubmit.setDisable(true);
			finals.getChildren().addAll(hboxFinal1,finalSubmit,hboxFinal2);
			finals.setAlignment(Pos.CENTER_RIGHT);
			
			ListView<String> list = new ListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList (
			    "Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8");
			list.setItems(items);
			root.setLeft(list);
			gPane.add(game1, 0, 0);
			gPane.add(new Label("        "), 0, 1);
			gPane.add(game2, 0, 2);
			gPane.add(new Label("      "), 0, 3);
			gPane.add(game3, 0, 4);
			gPane.add(new Label("      "), 0, 5);
			gPane.add(game4, 0, 6);
			gPane.add(new Label("        "), 1, 0);
			gPane.add(game5, 1, 1);
			gPane.add(new Label("      "), 1, 2);
			gPane.add(new Label("      "), 1, 3);
			gPane.add(new Label("      "), 1, 4);
			gPane.add(game6, 1, 5);
			gPane.add(new Label("      "), 2, 0);
			gPane.add(new Label("      "), 2, 1);
			gPane.add(new Label("      "), 2, 2);
			gPane.add(finals, 2, 3);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			String filePath = "./" + args[0];
//			File file = new File(filePath);
//			Scanner scan = new Scanner(file);
//			ArrayList<String> teamNames = new ArrayList<String>();
//			while(scan.hasNextLine()) {
//				teamNames.add(scan.nextLine());
//			}
			/* 
			 * ArrayList<Team> teams = new ArrayList<Team>();
			 * for(String t: teamNames) {
			 * 		teams.add(new Team(t);
=			 * }
			 *teams list holds all of the Team objects
			 */
//		} catch(FileNotFoundException e) {
//			//may need to edit this message to show up on GUI
//			System.out.println("This program operates using a file with team names. You have either"
//					+ "not specified a file or you have entered an invalid file name. Please try again");
//		}

        TeamReader read = new TeamReader("src/4Teams.txt"); // (args[0]);
        ArrayList<Team> teams = read.getTeams();
        Bracket bracket = new Bracket(teams);
        ArrayList<Game> round1 = bracket.getRound(1);
        for(Game game : round1) {
            System.out.println(game.getTeam1().getName() + " verse: " + game.getTeam2().getSeed());
		
		launch(args);
	}
}


