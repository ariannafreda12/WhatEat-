package view;

import bean.RecipeBean;

import controller.GraphicController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


public class MealPage {
	
	@FXML
	public Text txtStarters;
	@FXML
	public Text txtMain;
	@FXML
	public Text txtSecond;
	@FXML
	public Text txtSideDishes;
	@FXML
	public Text txtBreakfast;
	@FXML
	public Text txtDessert;
	
	public String category;
	DifficultPage dp= new DifficultPage();
	
	public String getCategory() {
		return category;
		
	}
	
	public void setCategory(String category) {
		this.category = category;
		
	}
	
	public String takeCategory(String prova) {
		return prova;
		
	}
	
	
	public void chooseStarters(MouseEvent starters) throws Exception{
		
		RecipeBean rb = new RecipeBean();
		
		showDiffPage(starters);
  		
		
	}
		
		



		
	
	public void chooseMainCourses(MouseEvent mainCourses) throws Exception {

		RecipeBean rb = new RecipeBean();
		
		rb.setCategory("main course");
		if(rb.validateCategory()==true) {
			showDiffPage(mainCourses);
  		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Unsuccess");
			alert.setHeaderText("Unsuccess!");
			alert.setContentText("there are not available recipes");
			alert.showAndWait();
		}
		
		
	}
	
	public void choosSecondCourses(MouseEvent secCourses) throws Exception {

		RecipeBean rb = new RecipeBean();
		
		rb.setCategory("second course");
		if(rb.validateCategory()==true) {
			showDiffPage(secCourses);
  		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Unsuccess");
			alert.setHeaderText("Unsuccess!");
			alert.setContentText("there are not available recipes");
			alert.showAndWait();
		}
		
		
	}
	public void chooseSide(MouseEvent side) throws Exception {

		RecipeBean rb = new RecipeBean();
		
		rb.setCategory("side dishes");
		if(rb.validateCategory()==true) {
			showDiffPage(side);
  		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Unsuccess");
			alert.setHeaderText("Unsuccess!");
			alert.setContentText("there are not available recipes");
			alert.showAndWait();
		}
		

	
	}
	public void chooseBreakfast(MouseEvent breakfast) throws Exception {

		RecipeBean rb = new RecipeBean();
		
		rb.setCategory("breakfast");
		if(rb.validateCategory()==true) {
			showDiffPage(breakfast);
  		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Unsuccess");
			alert.setHeaderText("Unsuccess!");
			alert.setContentText("there are not available recipes");
			alert.showAndWait();
		}
		
		
	}
	
	public void chooseDessert(MouseEvent dessert) throws Exception {

		RecipeBean rb = new RecipeBean();
		
		rb.setCategory("dessert");
		if(rb.validateCategory()==true) {
			showDiffPage(dessert);
  		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Unsuccess");
			alert.setHeaderText("Unsuccess!");
			alert.setContentText("there are not available recipes");
			alert.showAndWait();
		}
	

	}
	
	
	public void showDiffPage(MouseEvent e) throws Exception {
		
		
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.difficultPage();
        
	}
	
	

	
	
	public void start() throws Exception {
		Stage mealStage = new Stage();
		FXMLLoader loader = new FXMLLoader (MealPage.class.getResource("meal.fxml"));
		AnchorPane root = loader.load();
		mealStage.getIcons().add(new Image("img/icon.png"));
        mealStage.setTitle("WhatEat?!" );
        mealStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        mealStage.setScene(scene);
        mealStage.show();
 
	}
	

}
