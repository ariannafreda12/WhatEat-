package view;


import bean.RecipeBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Recipe;

public class DifficultPage {
	@FXML
	public ImageView profileImg;
	@FXML
	public ImageView logOutimg;
	@FXML
	public ImageView note;
	@FXML
	public Text beginnerTxt;
	@FXML
	public Text mediumTxt;
	@FXML
	public Text advancedTxt;
	@FXML
	public Button backButton;
	
	
	RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb=rm.getRecipe();
	
	//CREATE NEW NOTE
	public void createNote(MouseEvent e) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.notePage();
	}
	//BEGINNER
	public void beginner(MouseEvent beginner) throws Exception{
		rb.setDifficulty("beginner");
		rm.setRecipe(rb);
		((Node)(beginner.getSource())).getScene().getWindow().hide();
		GraphicController graphicController = new GraphicController();
		graphicController.ingredientPage();
	}
	
	//MEDIUM
	public void medium(MouseEvent medium) throws Exception{
		rb.setDifficulty("medium");
		rm.setRecipe(rb);
	    ((Node)(medium.getSource())).getScene().getWindow().hide();
		GraphicController graphicController = new GraphicController();
		graphicController.ingredientPage();	
	}
	//ADVANCED 
	public void advanced(MouseEvent advanced) throws Exception{
		rb.setDifficulty("advanced");
		rm.setRecipe(rb);
		((Node)(advanced.getSource())).getScene().getWindow().hide();
		GraphicController graphicController = new GraphicController();
		graphicController.ingredientPage();
	}
	
	//BACK BUTTON
	public void back(ActionEvent e) throws Exception {
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.mealPage();
	}
	
	//PROFILE USER
	public void myProfile(MouseEvent me) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.profilePage();
	}
	
	//FOR LOGOUT
	public void logOut(MouseEvent me) throws Exception {
		LoginManager controller = new LoginManager();
        controller.resetUser();
        ((Node)(me.getSource())).getScene().getWindow().hide();
        GraphicController graphicController = new GraphicController();
        Stage stage = null;
        graphicController.start(stage);	
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
