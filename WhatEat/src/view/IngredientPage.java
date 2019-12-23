package view;


import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class IngredientPage {
	
	@FXML
	public CheckBox butter;
	
	@FXML
	public CheckBox cheese;
	
	@FXML
	public Button searchBtn;
	
	ArrayList<String> choiceList = new ArrayList<String>();
	
	public void start() throws Exception {
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (IngredientPage.class.getResource("chooseIngredients.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        ingStage.setScene(scene);
        ingStage.show();
 
	}
	
	public void selectButter() {
			if (butter.isSelected()) {
	        	choiceList.add(butter.getText());
	        }
	        
	        
	        }
	public void selectCheese() {
		if (cheese.isSelected()) {
        	choiceList.add(cheese.getText());
        }
		
	}
	public ArrayList<String> selectIngredients() {
		System.out.println(choiceList.get(0));
		System.out.println(choiceList.get(1));
		return choiceList; 
		}
        

}
