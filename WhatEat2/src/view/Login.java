package view;


import bean.UserBean;
import controller.GraphicController;
import exception.EmptyFieldexception;
import exception.UsernameNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Login {
	
	    public Button btnLogin, btnVisitor;
	    public PasswordField passField;
	    public TextField userField;
	    
	    public void LoginMethod(ActionEvent actionEvent) throws Exception {
	    	
	    	String user = userField.getText();
			String pass = passField.getText();
			try {
				if (user.isEmpty() || pass.isEmpty()) {
					throw new EmptyFieldexception();
				}
				 UserBean ub = new UserBean();
		            ub.setPassword( pass );
		            ub.setUsername(user);
		            //StatusManager sm = StatusManager.getInstance();

		            if (ub.validate()!= false) {
		            
		            	((Node)(actionEvent.getSource())).getScene().getWindow().hide();
		            	GraphicController graphicController = new GraphicController();
		                graphicController.mealPage();
		            
		             }
		            
		            else {
		            	throw new UsernameNotFoundException();
		            }
			}catch(EmptyFieldexception e) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Attention!");
				alert.setContentText("To log in, enter your username and password.");
				alert.showAndWait();
			} catch(UsernameNotFoundException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("User not found");
				alert.setContentText("Incorrect username and/or password.");
				alert.showAndWait();
			} 
	    }
	    
	    //Continue as visitor
	    public void visitorMethod(ActionEvent actionEvent) throws Exception{
	    	
	    	((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        	GraphicController graphicController = new GraphicController();
            graphicController.mealPage();
	    	
	    }
	    
	    public void forgotPassword(MouseEvent mouseEvent) throws Exception{
	    	
	    	((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        	GraphicController graphicController = new GraphicController();
            graphicController.changePasswordPage();
	    	
	    	
	    }
	    
	    //forRegistrationPage
	    public void goToRegistrationPage(MouseEvent mouseEvent) throws Exception{
	    	
	    	((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        	GraphicController graphicController = new GraphicController();
            graphicController.registrationPage();
	    	
	   
            
	    }
	   

	public void start(Stage primaryStage ) throws Exception {
		Stage loginStage = new Stage();
		FXMLLoader loader = new FXMLLoader (Login.class.getResource("login.fxml"));
		AnchorPane root = loader.load();
		loginStage.getIcons().add(new Image("img/icon.png"));
        loginStage.setTitle("WhatEat?!" );
        loginStage.setResizable(false);
        Scene scene = new Scene(root, 1024, 768);
        loginStage.setScene(scene);
        loginStage.show();
		
		
	}

}
