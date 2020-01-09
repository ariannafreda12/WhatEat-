package view;

import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Recipe;
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
		
	Recipe rc= new Recipe(0, null, null, null, null, null, null,0);
	RecipeManager rm= RecipeManager.getInstance();
	
	
	public void chooseStarters(MouseEvent starters) throws Exception{
		rc.setCategory("starters");
		rm.setRecipe(rc);
		showDiffPage(starters);
	}
		
	public void chooseMainCourses(MouseEvent mainCourses) throws Exception {
		rc.setCategory("main course");
		rm.setRecipe(rc);
		showDiffPage(mainCourses);		
	}
	
	public void choosSecondCourses(MouseEvent secCourses) throws Exception {
		rc.setCategory("second course");
		rm.setRecipe(rc);
		showDiffPage(secCourses);	
	}

	public void chooseSide(MouseEvent side) throws Exception {
		rc.setCategory("side");
		rm.setRecipe(rc);
		showDiffPage(side);
	}
	
	public void chooseBreakfast(MouseEvent breakfast) throws Exception {
		rc.setCategory("breakfast");
		rm.setRecipe(rc);
		showDiffPage(breakfast);
	}
	
	public void chooseDessert(MouseEvent dessert) throws Exception {
		rc.setCategory("dessert");
		rm.setRecipe(rc);
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
