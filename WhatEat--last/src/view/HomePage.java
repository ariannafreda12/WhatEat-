package view;

import java.util.ArrayList;
import bean.RecipeBean;
import bean.UserBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import model.Recipe;

public class HomePage {
	public Button backButton;
	@FXML
	public ImageView profileImg;
	@FXML
	public ImageView logOutimg;
	@FXML
	public ImageView note;

	@FXML
    private static ObservableList<Recipe> list = FXCollections.observableArrayList();
	

	ArrayList <Recipe> popularRecipe;	
	GraphicController gc = new GraphicController();
	
    RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= new RecipeBean();
	
	LoginManager lm =LoginManager.getInstance();
	UserBean ub= lm.getUser();

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
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (FoundRecipes.class.getResource("homePage.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        ingStage.setScene(scene);
        
        final Label hi= new Label();
        hi.setText("Hi " + ub.getUsername());
        hi.setLayoutY(10);
        hi.setLayoutX(630);
        hi.setFont(Font.font("System", FontPosture.ITALIC, 18));
        
        root.getChildren().addAll(hi);
        
        TableView<Recipe> tableView = new TableView();
        tableView.setPrefWidth(300);
        
        TableColumn<Recipe,String> column1 = new TableColumn<Recipe,String> ("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("title"));      
        tableView.getColumns().add(column1);
        
        TableColumn<Recipe,String> column2= new TableColumn<Recipe,String> ("Like");
        column2.setCellValueFactory(new PropertyValueFactory<>("review"));      
        tableView.getColumns().add(column2);
        
        VBox vbox = new VBox(tableView);
        ScrollPane scroll = new ScrollPane(vbox);
        scroll.setLayoutX(79);
        scroll.setLayoutY(104);
        scroll.setPannable(true);
        scroll.setPrefSize(300, 408);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        root.getChildren().add(scroll);
        ingStage.show();
        
		popularRecipe=RecipeManager.popularRecipe(); 
	
		if (popularRecipe!= null) {
		//cycle for found recipes
			
			for(Recipe s : popularRecipe) {
				
				//add title to the list
				list.add(new Recipe (s.getTitle(), s.getReview())); 
				tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				tableView.setItems(list);
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Information!");
			alert.setContentText("There are not popular recipes today!");
			alert.showAndWait();
		}
		
		
		tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (event -> {
          
            try { 
            	
            	TablePosition<?, ?> pos= tableView.getSelectionModel().getSelectedCells().get(0);
            	int row = pos.getRow();
            	TableColumn col = pos.getTableColumn();
            	String t = (String) col.getCellObservableValue(row).getValue().toString();
            	Recipe rc = new Recipe(0,null,null,null,null,null,null,0); 
            	rc= rm.chooseRecipe(t);
            	
            	if(rc!=null) { 
              		rb.setTitle(rc.getTitle());
              		rb.setDifficulty(rc.getDifficulty());
              		rb.setCategory(rc.getCategory());
              		rb.setPreparation(rc.getPreparation());
              		rb.setNecessary(rc.getNecessary());
              		rb.setTime(rc.getTime());
            		rm.setRecipe(rb);
            		gc.showRecipe();
            	}
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
	}

	public void go(ActionEvent e) throws Exception {
		list.clear();
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.mealPage();
	}
}
