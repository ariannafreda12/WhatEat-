package view;

import java.io.IOException;

import bean.UserBean;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application  {

	public Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		showLoginWindow();
	}

	public static void main(String[] args) {
		launch(args);
	}
	public void showLoginWindow(){
		try {			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("login.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			Stage loginStage = new Stage();			
			loginStage.setTitle("WhatEat?!");		
			loginStage.setScene(new Scene(anchorPane));
			
			Login controller = loader.getController();
			controller.setMain(this);
			controller.setStage(loginStage);
			
			loginStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void showMealWindow(){
		try {			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("meal.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			
			Stage mealStage = new Stage();			
			mealStage.setTitle("WhatEat?!");		
			mealStage.setScene(new Scene(anchorPane));
			
			Login controller = loader.getController();
			controller.setMain(this);
			controller.setStage(mealStage);
			
			mealStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
