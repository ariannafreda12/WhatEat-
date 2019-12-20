package view;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Ingredient;


public class IngredientPage {
	
	@FXML
	public CheckBox butter;
	@FXML
	public Button searchBtn;
	
	ArrayList<Ingredient> choiceList = new ArrayList<Ingredient>();
	
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
	
	public void selectIngredients(ActionEvent e) {
	
		butter.setOnAction(event -> {
	        if (butter.isSelected() == true) {
	            //((Appendable) choiceList).append(butter.getText().toString());
	        }
		});
	        System.out.println(choiceList);
       
    }

}
