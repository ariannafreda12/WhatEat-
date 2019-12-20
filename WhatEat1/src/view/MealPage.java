package view;

import controller.GraphicController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
	
	private String category;
	
	public String getCategory() {
		return category;
		
	}
	
	public void setCategory(String category) {
		this.category = category;
		
	}
	
	public void chooseStartes(MouseEvent startes) throws Exception{
		setCategory("startes");
		showDiffPage(startes);
		
	}
	
	public void chooseMainCourses(MouseEvent mainCourses) throws Exception {
		setCategory("main course");
		showDiffPage(mainCourses);
		
	}
	
	public void choosSecondCourses(MouseEvent secCourses) throws Exception {
		setCategory("second course");
		showDiffPage(secCourses);
		
		
	}
	public void chooseSide(MouseEvent side) throws Exception {
		setCategory("side dishes");
		showDiffPage(side);

	
	}
	public void chooseBreakfast(MouseEvent breakfast) throws Exception {
		setCategory("breakfast");
		showDiffPage(breakfast);
	}
	
	public void chooseDessert(MouseEvent dessert) throws Exception {
		setCategory("dessert");
		showDiffPage(dessert);

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
