package view;


import controller.LoginManager;
import controller.NotesManager;
import controller.RecipeManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Notes;
import model.Recipe;
import model.User;

public class NotePage {
	

	public Button saveNotebtn = new Button();
	public Label writeNoteLabel = new Label();
	
	LoginManager lm = LoginManager.getInstance();
	User u = lm.getUser();
	
	NotesManager nm= NotesManager.getInstance();
	Notes n=nm.getNote();
	
	public void start () throws Exception {
		
		
		AnchorPane root = new AnchorPane();
		Stage window = new Stage();
		Scene scene = new Scene(root, 400, 400);
		window.setScene(scene);	
		root.setPrefSize(500, 500);
		writeNoteLabel.setText("Write note");
		writeNoteLabel.setLayoutY(30);
		writeNoteLabel.setLayoutX(30);
		writeNoteLabel.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 23));
	        
		saveNotebtn.setText("Save");
		saveNotebtn.setLayoutX(350);
		saveNotebtn.setLayoutY(350);
		
		TextArea txtNote = new TextArea ();
		txtNote.setLayoutX(60);
		txtNote.setLayoutY(60);
		txtNote.setPrefSize(246, 280);
        
        VBox vibox = new VBox(txtNote);
        ScrollPane spIng = new ScrollPane(vibox);
        spIng.setLayoutX(60);
        spIng.setLayoutY(60);
        spIng.setPrefSize(246, 280);
        spIng.setHbarPolicy(ScrollBarPolicy.NEVER);
        spIng.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        saveNotebtn.setOnAction(new EventHandler<ActionEvent>() {
 			public void handle(ActionEvent event) {
 				if ((nm.addNotes(txtNote.getText(), u.username))==true) {
 					 Alert alert = new Alert(AlertType.CONFIRMATION);
 						alert.setTitle("Success");
 						alert.setHeaderText("Success!");
 						alert.setContentText("Thanks for your opinion");
 						alert.showAndWait();
 						((Node)(event.getSource())).getScene().getWindow().hide();
 						
 						
 				}
 			}
 		});
       
		root.getChildren().add(spIng);
		root.getChildren().addAll(writeNoteLabel,saveNotebtn);
		window.setScene(scene);
		window.show();
	}
	

}
