package tdt4140.gr1802.app.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tdt4140.gr1802.app.core.Athlete;
import tdt4140.gr1802.app.core.Database;
import tdt4140.gr1802.app.core.Workout;

public class SeeWorkoutsController{
	private Database database = new Database();
	private Athlete athlete = database.getAthlete("Nils22");
	
	@FXML
	private TableView<Workout> tableView;
	
	@FXML
	private TableColumn<Workout, String> dateColumn;
	
	@FXML
	private TableColumn<Workout, Integer> durationColumn;
	
	@FXML
	private TableColumn<Workout, Double> kilometresColumn;
	
	@FXML
	private TableColumn<Workout, Integer> maxHRColumn;
	
	@FXML
	private TableColumn<Workout, Integer> averageHRColumn;
	
	@FXML
	private Button btAddWorkout;
	
	@FXML
	private Button btSeeWorkouts;
	
	@FXML
	private Button btSeeCoaches;
	
	@FXML
	private Button btCoachRequests;
	
	// Returns an ObservableList with the Workouts registered for the Athlete logged in
	public ObservableList<Workout> getWorkouts(){
		ObservableList<Workout> workouts = FXCollections.observableArrayList();
		for (Workout wo:athlete.getAllWorkouts()) {
			workouts.add(wo);
		}
		return workouts;
	}
	
	public void initialize() {
		// Connect columns to right attribute
		dateColumn.setCellValueFactory(new PropertyValueFactory<Workout,String>("dateString"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<Workout,Integer>("duration"));
		kilometresColumn.setCellValueFactory(new PropertyValueFactory<Workout,Double>("kilometres"));
		maxHRColumn.setCellValueFactory(new PropertyValueFactory<Workout,Integer>("maxHR"));
		averageHRColumn.setCellValueFactory(new PropertyValueFactory<Workout,Integer>("averageHR"));
		
		// Fill table with values
		tableView.setItems(getWorkouts());
	}
	
	// Side-menu buttons
	public void clickAddWorkout(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("AddWorkout.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public void clickSeeWorkouts (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SeeWorkouts.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void clickSeeCoaches(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SeeCoaches.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	public void clickCoachRequest(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("CoachRequests.fxml"));
		Scene scene = new Scene(root,800,600);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	

}
