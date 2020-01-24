package view;
import java.util.ArrayList;

import bean.RecipeBean;
import bean.UserBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.NotesManager;
import controller.RecipeManager;
import controller.UserProfileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import model.Notes;
import model.Recipe;
import model.User;
import model.UserProfile;

public class ProfilePage {
	
	@FXML
	public ImageView logOutimg;

	@FXML
    private static ObservableList<UserProfile> list = FXCollections.observableArrayList();
	
	@FXML
    private static ObservableList<Notes> notesList = FXCollections.observableArrayList();
	

	ArrayList <UserProfile> userprofile;
	ArrayList <Notes> notes;
	
	//instance of UserProfileManager for get user's recipes
	UserProfileManager upm= UserProfileManager.getInstance();
	UserProfile up=upm.getUserProfile();
	
	
	RecipeManager rm= RecipeManager.getInstance();
	Recipe rc=rm.getRecipe();
	RecipeBean rb= new RecipeBean();
	
	LoginManager lm =LoginManager.getInstance();
	User u= lm.getUser();
	String mail= u.getEmail();
	

	public void start() throws Exception {
			
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (ProfilePage.class.getResource("profilePage.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        
        //create new label for insert user
        final Label userLabel = new Label();
        userLabel.setText(u.getUsername());
        userLabel.setLayoutY(93);
        userLabel.setLayoutX(323);
        userLabel.setFont(Font.font("System", FontPosture.ITALIC, 22));
        
        //create new label for mail
        final Label mailLabel = new Label();
        mailLabel.setText(mail);
        mailLabel.setLayoutY(93);
        mailLabel.setLayoutX(550);
        mailLabel.setFont(Font.font("System", FontPosture.ITALIC, 22));
        
        TableView<Notes> tableView2 = new TableView();
        tableView2.setPrefWidth(300);
        TableColumn<Notes,String> column2 = new TableColumn<Notes,String> ("Notes");
        column2.setCellValueFactory(new PropertyValueFactory<>("note"));      
        tableView2.getColumns().add(column2);
        VBox vibox = new VBox(tableView2);
        ScrollPane spNote = new ScrollPane(vibox);
        spNote.setLayoutX(182);
        spNote.setLayoutY(260);
        spNote.setPrefSize(246, 280);
        spNote.setHbarPolicy(ScrollBarPolicy.NEVER);
        spNote.setVbarPolicy(ScrollBarPolicy.ALWAYS);
       
        TableView<UserProfile> tableView = new TableView();
        tableView.setPrefWidth(300);
        TableColumn<UserProfile,String> column1 = new TableColumn<UserProfile,String> ("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("title"));      
        tableView.getColumns().add(column1);
        VBox vbox = new VBox(tableView);
        ScrollPane spRec = new ScrollPane(vbox);
        spRec.setLayoutX(472);
        spRec.setLayoutY(260);
        spRec.setPrefSize(309, 280);
        spRec.setHbarPolicy(ScrollBarPolicy.NEVER);
        spRec.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        
        root.getChildren().addAll(userLabel);
        root.getChildren().addAll(mailLabel);
        root.getChildren().addAll(spNote);
        root.getChildren().addAll(spRec);
        ingStage.setScene(scene);
        ingStage.show();
        
     
        
        userprofile=UserProfileManager.foundIngredient(LoginManager.getInstance().getUser().getUsername()); 
        list.clear();
		if (userprofile!= null) {
			
		//cycle for found recipes
			for(UserProfile s : userprofile) {
				
				//add title to the list
				list.add(new UserProfile (s.getTitle())); 
				tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				tableView.setItems(list);		
			}
      
		tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (event -> {
            GraphicController gc = new GraphicController();
          
            try { 
            	
            	RecipeBean rb = new RecipeBean();
            	
            	TablePosition<?, ?> pos= tableView.getSelectionModel().getSelectedCells().get(0);
            	int row = pos.getRow();
            	TableColumn col = pos.getTableColumn();
            	String t = (String) col.getCellObservableValue(row).getValue().toString();
            	rc = rm.chooseRecipe(t);
            	
            	if(rb.validateRec(t)== true) { 
              		rc.setTitle(t);
            		rm.setRecipe(rc);
            		gc.userRecipePage();
            	}
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
		
		  	notes=NotesManager.userNotes(LoginManager.getInstance().getUser().getUsername()); 
		  	notesList.clear();
			if (notes!= null) {
			
			//cycle for found recipes
				for(Notes n : notes) {
					
					//add title to the list
					notesList.add(new Notes (n.getNote())); 
					tableView2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
					tableView2.setItems(notesList);
					
				}
					
			}
		  
        
				
		}
             
	}
}