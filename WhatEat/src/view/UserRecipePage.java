package view;

import controller.LoginManager;
import controller.RecipeManager;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Recipe;
import model.User;

public class UserRecipePage {
	
	LoginManager lm = LoginManager.getInstance();
	User u = lm.getUser();
	RecipeManager rm= RecipeManager.getInstance();
	Recipe rc=rm.getRecipe();

	public void start() throws Exception {
		
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (RecipePage.class.getResource("userProfilePage.fxml"));
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
        
        
        TextArea necLabel = new TextArea(rc.getNecessary());
        necLabel.setWrapText(true);
        necLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
        necLabel.setLayoutX(130);
        necLabel.setLayoutY(244);
        necLabel.setPrefSize(282, 256);
     
        TextArea prepLabel = new TextArea(rc.getPreparation());
        prepLabel.setLayoutX(445);
        prepLabel.setLayoutY(244);
        prepLabel.setPrefSize(320, 256);
        prepLabel.setWrapText(true);
        prepLabel.setFont(Font.font("System", FontPosture.ITALIC, 18));
        
        
        root.getChildren().addAll(titleLabel);
        root.getChildren().addAll(catLabel);
        root.getChildren().addAll(diffLabel);
        root.getChildren().addAll(timeLabel);
        root.getChildren().addAll(necLabel);
        root.getChildren().addAll(prepLabel);
        
        ingStage.setScene(scene);
        ingStage.show();
             
	}

}
