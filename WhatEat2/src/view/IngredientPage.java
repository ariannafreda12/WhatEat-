package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IngredientPage {
	
	

	public void start() throws Exception {
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (IngredientPage.class.getResource("chooseIngredients.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 1024, 768);
        ingStage.setScene(scene);
        ingStage.show();
 
		
	}

}
