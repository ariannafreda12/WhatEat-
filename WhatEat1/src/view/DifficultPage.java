package view;

import controller.GraphicController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DifficultPage {
	
	public void beginner(MouseEvent beginner) throws Exception{
		((Node)(beginner.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.ingredientPage();
		
	}
	
	
	
	public void back(ActionEvent e) throws Exception {

		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.mealPage();
	}

	
	public void start() throws Exception {
		Stage diffStage = new Stage();
		FXMLLoader loader = new FXMLLoader (Login.class.getResource("difficult_level.fxml"));
		AnchorPane root = loader.load();
		diffStage.getIcons().add(new Image("img/icon.png"));
        diffStage.setTitle("WhatEat?!" );
        diffStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        diffStage.setScene(scene);
        diffStage.show();
 
	}

}
