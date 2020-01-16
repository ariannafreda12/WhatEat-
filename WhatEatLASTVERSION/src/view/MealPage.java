package view;

import bean.RecipeBean;
import bean.UserBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Recipe;
import model.User;
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
	@FXML
	public ImageView profileImg;
	@FXML
	public ImageView logOutimg;
	@FXML
	public ImageView note;
	
	LoginManager lm =LoginManager.getInstance();
	
	UserBean ub= lm.getUser();
		
	RecipeBean rb = new RecipeBean();
	RecipeManager rm= RecipeManager.getInstance();
	
	public void chooseStarters(MouseEvent starters) throws Exception{
		rb.setCategory("starters");
		rm.setRecipe(rb);
		showDiffPage(starters);
	}
		
	public void chooseMainCourses(MouseEvent mainCourses) throws Exception {
		rb.setCategory("main course");
		rm.setRecipe(rb);
		showDiffPage(mainCourses);		
	}
	
	public void choosSecondCourses(MouseEvent secCourses) throws Exception {
		rb.setCategory("second course");
		rm.setRecipe(rb);
		showDiffPage(secCourses);	
	}

	public void chooseSide(MouseEvent side) throws Exception {
		rb.setCategory("side");
		rm.setRecipe(rb);
		showDiffPage(side);
	}
	
	public void chooseBreakfast(MouseEvent breakfast) throws Exception {
		rb.setCategory("breakfast");
		rm.setRecipe(rb);
		showDiffPage(breakfast);
	}
	
	public void chooseDessert(MouseEvent dessert) throws Exception {
		rb.setCategory("dessert");
		rm.setRecipe(rb);
		showDiffPage(dessert);
  	}
	
	public void showDiffPage(MouseEvent e) throws Exception {
		
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.difficultPage();
	}
	
	public void myProfile(MouseEvent me) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.profilePage();
	}
	
	public void logOut(MouseEvent me) throws Exception {
		LoginManager controller = new LoginManager();
        controller.resetUser();
        ((Node)(me.getSource())).getScene().getWindow().hide();
        GraphicController graphicController = new GraphicController();
        Stage stage = null;
        graphicController.start(stage);
		
	}
	
	public void createNote(MouseEvent e) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.notePage();
	}
	
	public void start() throws Exception {
		
		Stage mealStage = new Stage();
		FXMLLoader loader = new FXMLLoader(MealPage.class.getResource("meal.fxml"));
		AnchorPane root = loader.load();
		mealStage.getIcons().add(new Image("img/icon.png"));
        mealStage.setTitle("WhatEat?!" );
        mealStage.setResizable(false);

        // **** FUNZIONA SOLO CON LOGIN---> CONTINUE AS VISITOR DA ERRORE****//
       
        final Label hi= new Label();
        hi.setText("Hi, " + ub.getUsername());
        hi.setLayoutY(10);
        hi.setLayoutX(620);
        hi.setFont(Font.font("System", FontPosture.ITALIC, 18));
        
        root.getChildren().addAll(hi);
        Scene scene = new Scene(root, 800, 600);
        mealStage.setScene(scene);
        mealStage.show();
	
		
	}
}
