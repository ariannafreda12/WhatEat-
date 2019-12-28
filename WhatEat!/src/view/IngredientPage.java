package view;

import java.util.ArrayList;
import java.util.List;

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
	public CheckBox artichoke;
	@FXML
	public CheckBox aspargus;
	@FXML
	public CheckBox aubergine;
	@FXML
	public CheckBox avocado;
	@FXML
	public CheckBox beansprouts;
	@FXML
	public CheckBox beetroot;
	@FXML
	public CheckBox broadbeans;
	@FXML
	public CheckBox broccoli;
	@FXML
	public CheckBox cabbage;
	@FXML
	public CheckBox carrot;
	@FXML
	public CheckBox cauliflower;
	@FXML
	public CheckBox celery;
	@FXML
	public CheckBox chillipepper;
	@FXML
	public CheckBox courgette;
	@FXML
	public CheckBox cucumber;
	@FXML
	public CheckBox frenchbeans;
	@FXML
	public CheckBox garlic;
	@FXML
	public CheckBox ginger;
	@FXML
	public CheckBox leek;
	@FXML
	public CheckBox lettuce;
	@FXML
	public CheckBox mushroom;
	@FXML
	public CheckBox onion;
	@FXML
	public CheckBox peas;
	@FXML
	public CheckBox pepper;
	@FXML
	public CheckBox potato;
	@FXML
	public CheckBox pumkin;
	@FXML
	public CheckBox radish;
	@FXML
	public CheckBox rocket;
	@FXML
	public CheckBox tomato;
	@FXML
	public CheckBox turnip;
	@FXML
	public CheckBox spinach;
	@FXML
	public CheckBox squash;
	@FXML
	public CheckBox apple;
	@FXML
	public CheckBox apricot;
	@FXML
	public CheckBox banana;
	@FXML
	public CheckBox blackberry;
	@FXML
	public CheckBox bluebarry;
	@FXML
	public CheckBox cherry;
	@FXML
	public CheckBox coconut;
	@FXML
	public CheckBox fig;
	@FXML
	public CheckBox grape;
	@FXML
	public CheckBox kiwi;
	@FXML
	public CheckBox lemon;
	@FXML
	public CheckBox lime;
	@FXML
	public CheckBox mango;
	@FXML
	public CheckBox melon;
	@FXML
	public CheckBox orange;
	@FXML
	public CheckBox peach;
	@FXML
	public CheckBox pear;
	@FXML
	public CheckBox pineapple;
	@FXML
	public CheckBox plum;
	@FXML
	public CheckBox ruspberry;
	@FXML
	public CheckBox strawberry;
	@FXML
	public CheckBox anchovy;
	@FXML
	public CheckBox cod;
	@FXML
	public CheckBox herring;
	@FXML
	public CheckBox mackerel;
	@FXML
	public CheckBox pilchard;
	@FXML
	public CheckBox plaice;
	@FXML
	public CheckBox salmon;
	@FXML
	public CheckBox sardine;
	@FXML
	public CheckBox sole;
	@FXML
	public CheckBox trout;
	@FXML
	public CheckBox tuna;
	@FXML
	public CheckBox bacon;
	@FXML
	public CheckBox beef;
	@FXML
	public CheckBox chicken;
	@FXML
	public CheckBox duck;
	@FXML
	public CheckBox ham;
	@FXML
	public CheckBox lamb;
	@FXML
	public CheckBox liver;
	@FXML
	public CheckBox mince;
	@FXML
	public CheckBox salami;
	@FXML
	public CheckBox sausage;
	@FXML
	public CheckBox turkey;
	@FXML
	public CheckBox veal;
	
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
		System.out.println(choiceList);
		return choiceList; 
	}

}
