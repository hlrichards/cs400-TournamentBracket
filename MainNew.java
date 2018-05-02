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

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This class reads in the team names from the file, sets up the GUI, and handles the user interaction
 * to create a functioning tournament bracket for 16, 8, 4, 2, 1, or 0 teams. This class handles the user
 * input of scores and the user action of pressing the submit button. It displays the progression of each
 * team through the tournament and eventually displays the top three teams of the tournament.
 * @author Haley, Jonah, Sam
 *
 */
public class MainNew extends Application {
	
	// This field stores the Team objects for each team read in from the file
	static ArrayList<Team> teamsList;
	private static Bracket bracket; 
	static final int LENGTH_OF_TEXT_FIELD = 5; 
	
	/**
	 * This method initializes the controls and the setup of the GUI. It handles and seeds the
	 * teamsList in order to create a proper bracket display for each possible number of teams. 
	 * It then handles the users input to the tournament games and eventually displays the 
	 * winners of the tournament
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			
		
			// This section initializes each game to be played in each round, starting with the
			// round of 16, then quarter finals, then semi finals, then finals. This code correctly
			// seeds teams read in from the file (supports sizes 16, 8, 4, 2, 1, and 0) 
			// Each game is a vertical box with 2 horizontal boxes (each with a Label and TextField)
			// and a submit button. Each round of games is then put into its own vertical box 
			

			
			
			VBox rounds[] = new VBox[bracket.getNumberOfRounds()];
			for(int i =0; i<rounds.length;i++) {
				rounds[i] = new VBox();
				for(int j=0; j<bracket.getRound(i).size();j++) {
					rounds[i].getChildren().addAll(bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
				}
			}

			
			
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
//			if(teamsList.size() == 16)
//				gPane.add(round1, 0, 0);
//			if(teamsList.size() >= 8)
//				gPane.add(quarters, 1, 0);
//			if(teamsList.size() >= 4)
//				gPane.add(semis, 2, 0);
//			if(teamsList.size() >= 2)
//				gPane.add(finals, 3, 0);
			
			for(int i =0; i<rounds.length;i++) {
					gPane.add(rounds[i], i, 0);
				
			}
			
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
			
			// adds a scroll bar for functionality on smaller screens
			ScrollPane scrollPane = new ScrollPane();
	        scrollPane.setContent(gPane);
			
			root.setLeft(list);
			root.setCenter(gPane);
			root.setCenter(scrollPane);
			root.setRight(topTeams);
			
			// Sets the size of the window to be maximized on users screen
			Screen screen = Screen.getPrimary();
			Rectangle2D bounds = screen.getVisualBounds();
			primaryStage.setX(bounds.getMinX());
			primaryStage.setY(bounds.getMinY());
			primaryStage.setWidth(bounds.getWidth());
			primaryStage.setHeight(bounds.getHeight());
			
	
//			// force the text fields to be numeric only
//			score1.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score1.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score1.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score2.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			    	
//			        if (!newValue.matches("\\d*")) {
//			        	score2.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score2.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score3.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score3.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score3.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score4.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score4.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==5) {
//			        	score4.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score5.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score5.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score5.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score6.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score6.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score6.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score7.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score7.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score7.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score8.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score8.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score8.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score9.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score9.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score9.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score10.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score10.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score10.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score11.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score11.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score11.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score12.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score12.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score12.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score13.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score13.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score13.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score14.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score14.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score14.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score15.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score15.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score15.setText(oldValue);
//			        }
//			    }
//			});
//			
//			score16.textProperty().addListener(new ChangeListener<String>() {
//			    @Override
//			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
//			        String newValue) {
//			        if (!newValue.matches("\\d*")) {
//			        	score16.setText(newValue.replaceAll("[^\\d]", ""));
//			        }
//			        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
//			        	score16.setText(oldValue);
//			        }
//			    }
//			});
//			
//
//			
//			
//			
//			// Set listeners for buttons
//			game1submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//				if((score1.getText().equals("")||score16.getText().equals(""))) 
//					return;
//					
//			bracket.getRound(0).get(0).playGame(score1.getText(), score16.getText());
//			teamq1.setText(bracket.getRound(0).get(0).getWinner().getName());
//			game1submit.setDisable(true);
//			
//			bracket.nextRound();
//			
//			if(teamq2.getText()!="TBD")
//			quarter1submit.setDisable(false);
//				
//			
//				
//			});
//			
//			game2submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(1).playGame(score8.getText(), score9.getText());
//			teamq2.setText(bracket.getRound(0).get(1).getWinner().getName());
//			game2submit.setDisable(true);
//			if(teamq1.getText()!="TBD")
//			quarter1submit.setDisable(false);
//			
//			bracket.nextRound();
//			});
//			
//			game3submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(2).playGame(score4.getText(), score13.getText());
//			teamq3.setText(bracket.getRound(0).get(2).getWinner().getName());
//			game3submit.setDisable(true);
//			
//			if(teamq4.getText()!="TBD")
//			quarter2submit.setDisable(false);
//			
//			bracket.nextRound();
//			});
//			
//			game4submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(3).playGame(score5.getText(), score12.getText());
//			teamq4.setText(bracket.getRound(0).get(3).getWinner().getName());
//			game4submit.setDisable(true);
//			if(teamq3.getText()!="TBD")
//			quarter2submit.setDisable(false);
//			bracket.nextRound();	
//			});
//			
//			game5submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(4).playGame(score2.getText(), score15.getText());
//			teamq5.setText(bracket.getRound(0).get(4).getWinner().getName());
//			game5submit.setDisable(true);
//			
//			if(teamq6.getText()!="TBD")
//			quarter3submit.setDisable(false);
//			bracket.nextRound();
//				
//			});
//			
//			game6submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(5).playGame(score7.getText(), score10.getText());
//			teamq6.setText(bracket.getRound(0).get(5).getWinner().getName());
//			game6submit.setDisable(true);
//			if(teamq5.getText()!="TBD")
//			quarter3submit.setDisable(false);
//			
//			bracket.nextRound();
//				
//			});
//			
//			game7submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(6).playGame(score3.getText(), score14.getText());
//			teamq7.setText(bracket.getRound(0).get(6).getWinner().getName());
//			game7submit.setDisable(true);
//			if(teamq8.getText()!="TBD")
//			quarter4submit.setDisable(false);
//			bracket.nextRound();
//				
//			});
//			
//			game8submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//			bracket.getRound(0).get(7).playGame(score6.getText(), score11.getText());
//			teamq8.setText(bracket.getRound(0).get(7).getWinner().getName());
//			game8submit.setDisable(true);
//			if(teamq7.getText()!="TBD")
//			quarter4submit.setDisable(false);
//			bracket.nextRound();
//				
//			});
//			
//			quarter1submit.setOnAction(event -> {
//				// TODO Auto-generated method stub
//				if((scoreq1.getText().equals("")||scoreq2.getText().equals(""))) 
//					return;
//					
//			bracket.getRound(0).get(1).playGame(scoreq1.getText(), score16.getText());
//			teamq1.setText(bracket.getRound(1).get(0).getWinner().getName());
//			game1submit.setDisable(true);
//			
//			bracket.nextRound();
//			
//			if(teamq2.getText()!="TBD")
//			quarter1submit.setDisable(false);
//				
//			
//				
//			});
			
			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method reads in the file containing the team names from the command line and then 
	 * creates an instance of the TeamReader class to store the ArrayList of teams as a field
	 * in the Main class. 
	 * @param args
	 */
	public static void main(String[] args) {
		TeamReader read = new TeamReader("src/16Teams.txt"); // (args[0]);
        teamsList = read.getTeams();
         bracket = new Bracket(teamsList);
        
		launch(args);
	}
	


}
