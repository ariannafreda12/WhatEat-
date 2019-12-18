package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MealPage {
	
	
	public void start() throws Exception {
		Stage mealStage = new Stage();
		FXMLLoader loader = new FXMLLoader (Login.class.getResource("meal.fxml"));
		AnchorPane root = loader.load();
		mealStage.getIcons().add(new Image("img/icon.png"));
        mealStage.setTitle("WhatEat?!" );
        mealStage.setResizable(false);
        Scene scene = new Scene(root, 1024, 768);
        mealStage.setScene(scene);
        mealStage.show();

	}
}