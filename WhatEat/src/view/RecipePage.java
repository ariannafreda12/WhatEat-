package view;


import bean.RecipeBean;
import controller.RecipeManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Recipe;


public class RecipePage{
	
	 
	public Button likebtn = new Button();
	
	public Label reviewLabel = new Label();
	

	
	RecipeManager rm= RecipeManager.getInstance();
	Recipe rc=rm.getRecipe();
	RecipeBean rb= new RecipeBean();
	

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
        titleLabel.setText(rc.getTitle());
        titleLabel.setLayoutY(84);
        titleLabel.setLayoutX(53);
        titleLabel.setPrefWidth(726);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setFont(Font.font("System",FontWeight.BOLD, FontPosture.ITALIC, 36));
        
        reviewLabel.setText("Leave review");
    	reviewLabel.setLayoutY(551);
    	reviewLabel.setLayoutX(445);
    	reviewLabel.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 23));
        
    	likebtn.setText("Like");
    	likebtn.setLayoutX(607);
    	likebtn.setLayoutY(555);
        //create new label for insert difficulty level
        final Label diffLabel = new Label();
        diffLabel.setText(rc.getDifficulty());
        diffLabel.setLayoutY(150);
        diffLabel.setLayoutX(298);
        diffLabel.setFont(Font.font("System", FontPosture.ITALIC, 22));
        
        //create new label for insert time
        final Label timeLabel = new Label();
        timeLabel.setText(rc.getTime());
        timeLabel.setLayoutY(150);
        timeLabel.setLayoutX(496);
        timeLabel.setFont(Font.font("System", FontPosture.ITALIC, 22));
        
        //create new label for insert category
        final Label catLabel = new Label();
        catLabel.setText(rc.getCategory());
        catLabel.setLayoutY(150);
        catLabel.setLayoutX(637);
        catLabel.setFont(Font.font("System", FontPosture.ITALIC, 22));
        
        
        
       
        
        ScrollPane spIng = new ScrollPane();
        spIng.setLayoutX(130);
        spIng.setLayoutY(244);
        spIng.setPrefSize(282, 256);
        spIng.setHbarPolicy(ScrollBarPolicy.NEVER);
        spIng.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        Label necLabel = new Label(rc.getNecessary());
        spIng.setContent(necLabel);
        necLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
              
        
        ScrollPane spPrep = new ScrollPane();
        spPrep.setLayoutX(445);
        spPrep.setLayoutY(244);
        spPrep.setPrefSize(320, 256);
        spPrep.setHbarPolicy(ScrollBarPolicy.NEVER);
        spPrep.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        Label prepLabel = new Label(rc.getPreparation());
        spPrep.setContent(prepLabel);
        prepLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
        
        
        root.getChildren().addAll(titleLabel);
        root.getChildren().addAll(catLabel);
        root.getChildren().addAll(diffLabel);
        root.getChildren().addAll(timeLabel);
        root.getChildren().addAll(spIng);
        root.getChildren().addAll(spPrep);
        
        
        likebtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if ((rm.reviewRecipe(rc.title, rc.review))==true) {
					 Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Success");
						alert.setHeaderText("Success!");
						alert.setContentText("Thanks for your opinion");
						alert.showAndWait();
						likebtn.setVisible(false);
						reviewLabel.setText("You like it!");
						
				}
			}
		});
        
        root.getChildren().addAll(reviewLabel,likebtn);
        ingStage.setScene(scene);
        ingStage.show();
             
	}
    

	public void saveRecipe(MouseEvent e) throws Exception {
		
		
		if((rm.saveRecipe(rc.title, rc.preparation, rc.difficulty, rc.category, rc.time, rc.necessary))==true) {
		
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
