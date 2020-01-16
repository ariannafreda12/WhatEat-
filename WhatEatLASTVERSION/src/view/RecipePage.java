package view;

import bean.RecipeBean;
import bean.UserBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import controller.UserProfileManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage;
import model.Recipe;
import model.User;
import model.UserProfile;


public class RecipePage{
	
	@FXML
	public ImageView profileImg;
	@FXML
	public ImageView logOutimg;
	@FXML
	public ImageView note;
	
	
	RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= rm.getRecipe();
	
			
	LoginManager lm = LoginManager.getInstance();
	UserBean u = lm.getUser();
	
	UserProfileManager upm= UserProfileManager.getInstance();
	
	
	
	public Label reviewLabel = new Label();
	public Button likebtn = new Button();	 

	public void start() throws Exception {
			
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (RecipePage.class.getResource("recipePage.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        
        //create new label for insert title
        final Label titleLabel = new Label();
        titleLabel.setText(rb.getTitle());
        titleLabel.setLayoutY(84);
        titleLabel.setLayoutX(53);
        titleLabel.setPrefWidth(726);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setFont(Font.font("System",FontWeight.BOLD, FontPosture.ITALIC, 32));
        
        //create new label for insert difficulty level
        final Label diffLabel = new Label();
        diffLabel.setText(rb.getDifficulty());
        diffLabel.setLayoutY(150);
        diffLabel.setLayoutX(298);
        diffLabel.setFont(Font.font("System", FontPosture.ITALIC, 20));
        
        //create new label for insert time
        final Label timeLabel = new Label();
        timeLabel.setText(rb.getTime());
        timeLabel.setLayoutY(150);
        timeLabel.setLayoutX(496);
        timeLabel.setFont(Font.font("System", FontPosture.ITALIC, 20));
        
        //create new label for insert category
        final Label catLabel = new Label();
        catLabel.setText(rb.getCategory());
        catLabel.setLayoutY(150);
        catLabel.setLayoutX(637);
        catLabel.setFont(Font.font("System", FontPosture.ITALIC, 20));
        
        
        TextArea necLabel = new TextArea(rb.getNecessary());
        necLabel.setWrapText(true);
        necLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
        necLabel.setLayoutX(130);
        necLabel.setLayoutY(244);
        necLabel.setPrefSize(282, 256);
        necLabel.setEditable(false);
     
        TextArea prepLabel = new TextArea(rb.getPreparation());
        prepLabel.setLayoutX(445);
        prepLabel.setLayoutY(244);
        prepLabel.setPrefSize(320, 256);
        prepLabel.setWrapText(true);
        prepLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
        prepLabel.setEditable(false);
        reviewLabel.setText("Leave review");
    	reviewLabel.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 20));
    	reviewLabel.setLayoutX(533);
    	reviewLabel.setLayoutY(511);
    	
    	
    	likebtn.setText("Like");
    	likebtn.setLayoutX(665);
    	likebtn.setLayoutY(505);
    	likebtn.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC,18));
    	
    	likebtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if ((rm.reviewRecipe(rb.getTitle(), rb.getReview()))==true) {
					if ((rm.addReviewRecipe(u.getUsername(), rb.getTitle()))==true) {
					
					 Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Success");
						alert.setHeaderText("Success!");
						alert.setContentText("Thanks for your opinion");
						alert.showAndWait();
						likebtn.setVisible(false);
						reviewLabel.setText("You like it!");
						
				}
			
				}
			}
		});
    	if ((rm.checkReviewRecipe(u.getUsername(), rb.getTitle()))==true) {
			
				likebtn.setVisible(false);
				reviewLabel.setText("You like it!");
				
		}
    	
        
        root.getChildren().addAll(reviewLabel,likebtn);
        root.getChildren().addAll(titleLabel);
        root.getChildren().addAll(catLabel);
        root.getChildren().addAll(diffLabel);
        root.getChildren().addAll(timeLabel);
        root.getChildren().addAll(necLabel);
        root.getChildren().addAll(prepLabel);
        ingStage.setScene(scene);
        ingStage.show();
             
	}
	
	public void createNote(MouseEvent e) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.notePage();
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
    
	public void saveRecipe(MouseEvent e) throws Exception {
		if((upm.saveRecipe(rb.getTitle(), rb.getPreparation(), rb.getDifficulty(), rb.getCategory(), rb.getTime(), rb.getNecessary(), u.getUsername()))==true) {
		
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Success!");
			alert.setContentText("Saved recipe successful");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Information!");
			alert.setContentText("Recipe already saved");
			alert.showAndWait();
		}
	}
	
	
   
       
}
