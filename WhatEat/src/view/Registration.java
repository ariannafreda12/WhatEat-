package view;


import controller.DBManager;
import controller.GraphicController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration {
	@FXML
	public Button createAccount;
	@FXML
	public TextField usernameField;
	@FXML
	public TextField emailField;
	@FXML
	public PasswordField passwordField;
	@FXML
	public Text goToLogin1;
	
	
	//Method to create a new account
	public void createAccount(ActionEvent actionEvent) throws Exception {
		
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();


        if (username.equals("") ||password.equals("") || email.equals("")){
        	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Attention!");
			alert.setContentText("Enter username, password and/or email.");
			alert.showAndWait();
        
        }
        if (username.length()<6 || password.length()<6){
        	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("Attention!");
			alert.setContentText("Username and password must be \nat least six characters");
			alert.showAndWait();
        }
            if (DBManager.register(username, password, email)){
                GraphicController graphicController = new GraphicController();
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
                graphicController.start(null);
                //ti rimanda alla pagina di login per effettuare l'accesso con il nuov account
                Alert alert = new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText("Success!");
    			alert.setContentText("Registration successful");
    			alert.showAndWait();
                
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Warning");
    			alert.setHeaderText("Attention!");
    			alert.setContentText("Registration failed.\n User already registered");
    			alert.showAndWait();
                
            }
        }
	
  
	
	//per tornare alla pagina di login
	public void goToLogin(MouseEvent mouseEvent) throws Exception{
		
		((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.start(null);	
	}
	
	
	
	public void start() throws Exception {
		
		Stage regStage = new Stage();
		FXMLLoader loader = new FXMLLoader (Registration.class.getResource("registration.fxml"));
		AnchorPane root = loader.load();
		regStage.getIcons().add(new Image("img/icon.png"));
        regStage.setTitle("WhatEat?!" );
        regStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        regStage.setScene(scene);
        regStage.show();
	}
}
