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

import application.Game.GameUI;
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
import javafx.scene.paint.Color;

/**
 * This class reads in the team names from the file, sets up the GUI, and handles the user interaction
 * to create a functioning tournament bracket for 16, 8, 4, 2, 1, or 0 teams. This class handles the user
 * input of scores and the user action of pressing the submit button. It displays the progression of each
 * team through the tournament and eventually displays the top three teams of the tournament.
 * @author Haley, Jonah, Sam
 *
 */
public class Main extends Application {
	
	// This field stores the Team objects for each team read in from the file
	static ArrayList<Team> teamsList;
	private static Bracket bracket; 
	static final int LENGTH_OF_TEXT_FIELD = 5;
	private Label lbl_firstPlace;
	private Label lbl_secondPlace;
	private Label lbl_thirdPlace; 
	
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
			

			
		
			VBox rounds[] = new VBox[bracket.getNumberOfRounds()];
			for(int i =0; i<rounds.length;i++) {
				rounds[i] = new VBox();
				for(int j=0; j<bracket.getRound(i).size();j++) {
					// adding the extra labels in this section allows the display to look aesthetically pleasing
					// and like a typical tournament bracket for any number of teams
					if(i == 1) {
						if(j == 0) 
							rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "), 
									bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
						else if(j == 1)
							rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "), bracket.getRound(i).get(j).getGameUI().getUi(),
									new Label(" "));
						else 
							rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "),new Label("    "), 
									bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
					}
						
					else if(i == 2) {
						if(j == 0) {
							rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "), new Label("    "),new Label("    "),
									new Label("    "), bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
						}
						else 
							rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "),new Label("    "),new Label("    "),
									new Label("    "),new Label("    "), new Label("    "),new Label("    "),
									new Label("    "), bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
					}	
					else if(i == 3) {
						rounds[i].getChildren().addAll(new Label("    "),new Label("    "),new Label("    "),
								new Label("    "),new Label("    "),new Label("    "),new Label("    "),
								new Label("    "),new Label("    "),new Label("    "),new Label("    "),
								new Label("    "),new Label("    "), new Label("    "),new Label("    "),
								new Label("    "),new Label("    "),new Label("    "), 
								bracket.getRound(i).get(j).getGameUI().getUi(), new Label(" "));
					}
					else 
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
			
		    lbl_firstPlace = new Label("First Place:");
			lbl_firstPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0) // handles the case where there are 0 teams
				lbl_firstPlace.setText("No winner");
			else if(teamsList.size() == 1) // handles the case where there's only 1 team
				lbl_firstPlace.setText(teamsList.get(0).getName());
			
		    lbl_secondPlace = new Label("Second Place:");
			lbl_secondPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0)
				lbl_secondPlace.setText("No runner-up");
			else if(teamsList.size() == 1)
				lbl_secondPlace.setText("No runner-up");
			
			lbl_thirdPlace = new Label("Third Place:");
			lbl_thirdPlace.setStyle("-fx-font: 20 arial;");
			if(teamsList.size() == 0)
				lbl_thirdPlace.setText("No third place");
			else if(teamsList.size() == 1) 
				lbl_thirdPlace.setText("No third place");
			else if(teamsList.size() == 2) // handles the case where there are only 2 teams
				lbl_thirdPlace.setText("No third place");
			
			VBox topTeams = new VBox();
			topTeams.setAlignment(Pos.CENTER);
			topTeams.getChildren().addAll(top,lbl_firstPlace,lbl_secondPlace,lbl_thirdPlace);
			
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
			
	
			
			// Listeners for all games
			for(int i =0; i<rounds.length;i++) {
				rounds[i] = new VBox();
				for(int j=0; j<bracket.getRound(i).size();j++) {
					
					 TextField t1 = bracket.getRound(i).get(j).getGameUI().getTxt_score1();
					 TextField t2 = bracket.getRound(i).get(j).getGameUI().getTxt_score2();
					 Button b1 = bracket.getRound(i).get(j).getGameUI().getBtn_submit();
					 int currentRound = i;
					 int currentGame = j;
					 int nextRoundGame = j/2;
					 
					 //Disable all buttons except for in the first round
					 if(i!=0) {
						 b1.setDisable(true);
					 }
					 
					 //Only allow valid input in text box
					 t1.textProperty().addListener(new ChangeListener<String>() {
						    @Override
						    public void changed(ObservableValue<? extends String> observable, String oldValue, 
						        String newValue) {
						        if (!newValue.matches("\\d*")) {
						        	t1.setText(newValue.replaceAll("[^\\d]", ""));
						        }
						        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
						        	t1.setText(oldValue);
						        }
						    }
						});
					 
					 t2.textProperty().addListener(new ChangeListener<String>() {
						    @Override
						    public void changed(ObservableValue<? extends String> observable, String oldValue, 
						        String newValue) {
						        if (!newValue.matches("\\d*")) {
						        	t2.setText(newValue.replaceAll("[^\\d]", ""));
						        }
						        else if(newValue.length()==LENGTH_OF_TEXT_FIELD) {
						        	t2.setText(oldValue);
						        }
						    }
						});
					 
					 //In the case the last round (Finals)
					 if(i == rounds.length-1) {
						 b1.setOnAction(event -> {
								if((t1.getText().equals("")||t2.getText().equals(""))) 
									return;
									
								lbl_firstPlace.setText("First Place:" +bracket.getRound(currentRound).get(currentGame).playGame(t1.getText(), t2.getText()).getName());
								lbl_secondPlace.setText("Second Place:" +bracket.getRound(currentRound).get(currentGame).getLoser().getName());
								
							
							b1.setDisable(true);
								
							});
						 break;
					}
					 
					 
					 

					 Button btn_NextRound = bracket.getRound(i+1).get(nextRoundGame).getGameUI().getBtn_submit();
					 b1.setOnAction(event -> {
							if((t1.getText().equals("")||t2.getText().equals(""))) 
								return;
								
						Team winner = bracket.getRound(currentRound).get(currentGame).playGame(t1.getText(), t2.getText());
						if(currentGame%2==0) {
							bracket.getRound(currentRound+1).get(nextRoundGame).setTeam1(winner);
							if(bracket.getRound(currentRound+1).get(nextRoundGame).getTeam2().getName()!="TBD")
								btn_NextRound.setDisable(false);
						}
						
						else {
							bracket.getRound(currentRound+1).get(nextRoundGame).setTeam2(winner);
							if(bracket.getRound(currentRound+1).get(nextRoundGame).getTeam1().getName()!="TBD")
								btn_NextRound.setDisable(false);
						}
						
						
						
						b1.setDisable(true);
						
						//bracket.nextRound();
						

							
						
							
						});
				}
			}

			
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
