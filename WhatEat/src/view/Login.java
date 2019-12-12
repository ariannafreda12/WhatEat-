package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import bean.UserBean;
import controller.StatusManager;
import exception.EmptyFieldexception;
import exception.UsernameNotFoundException;

public class Login {

	 @FXML
	  private Stage stage;
	 @FXML
	  private PasswordField passField;
	 @FXML
	  private TextField userField;
	 @FXML
	  private Button btnLogin;
	 
	


	  private Main main;
	 
	    public void setMain(Main main) {
			this.main = main;
		}

		public void setStage(Stage loginStage) {
			this.stage = loginStage;
		}
		public void handleLogin(ActionEvent event) throws Exception{
			String user = this.userField.getText();
			String pass = this.passField.getText();
			try {
				if (user.isEmpty() || pass.isEmpty()) {
					throw new EmptyFieldexception();
				}
				 UserBean ub = new UserBean();
		            ub.setPassword( pass );
		            ub.setNickname(user);
		            StatusManager sm = StatusManager.getInstance();

		            if (ub.validate()!= false) {
		             
		            	stage.close();
		                main.showMealWindow();
		             }
		            
		            else {
		            	throw new UsernameNotFoundException();
		            }
			}catch(EmptyFieldexception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("");
				alert.setHeaderText("Attenzione!");
				alert.setContentText("Per effettuare il login inserire username e password.");
				alert.showAndWait();
			} catch(UsernameNotFoundException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("");
				alert.setHeaderText("Utente non trovato");
				alert.setContentText("Username e/o password errati.");
				alert.showAndWait();
			} 
			
		}
			






}
