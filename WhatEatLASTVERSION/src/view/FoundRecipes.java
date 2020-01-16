package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bean.RecipeBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Recipe;

public class FoundRecipes {
	@FXML
	public Button backButton;
	@FXML
	public ImageView profileImg;
	@FXML
	public ImageView logOutimg;
	@FXML
	public ImageView note;

	@FXML
    private static ObservableList<Recipe> list = FXCollections.observableArrayList();
	

	ArrayList <Recipe> recipe;	
	GraphicController gc = new GraphicController();
	
	//instance of recipe manager for get difficulty, category and ingredient list
    RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb=rm.getRecipe();
	
	public ArrayList<Recipe> createList(ArrayList<Recipe> first){
		
		for(int l=0; l<first.size(); l++) {
			for(int j=0; j<first.size(); j++) {
				if(first.get(j)==first.get(l)){
					first.remove(first.get(j));
				}
			}
		}
		return first;
	}
	
	public void createNote(MouseEvent e) throws Exception {
    	GraphicController graphicController = new GraphicController();
        graphicController.notePage();
	}
	
	public void start() throws Exception {
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (FoundRecipes.class.getResource("found_recipes.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        ingStage.setScene(scene);
        
        TableView<Recipe> tableView = new TableView();
       
        
        tableView.setPrefWidth(675);
        TableColumn<Recipe,String> column1 = new TableColumn<Recipe,String> ("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("title"));      
        tableView.getColumns().add(column1);
        
        TableColumn<Recipe,String> column2 = new TableColumn<Recipe,String> ("Preparation");
        column2.setCellValueFactory(new PropertyValueFactory<>("preparation"));      
        tableView.getColumns().add(column2);
        
        TableColumn<Recipe,String> column3 = new TableColumn<Recipe,String> ("Time");
        column3.setCellValueFactory(new PropertyValueFactory<>("time"));      
        tableView.getColumns().add(column3);
        
        TableColumn<Recipe,String> column4= new TableColumn<Recipe,String> ("Like");
        column4.setCellValueFactory(new PropertyValueFactory<>("review"));      
        tableView.getColumns().add(column4);
        
        VBox vbox = new VBox(tableView);
        ScrollPane scroll = new ScrollPane(vbox);
        scroll.setLayoutX(79);
        scroll.setLayoutY(104);
        scroll.setPannable(true);
        scroll.setPrefSize(678, 408);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        root.getChildren().add(scroll);
        ingStage.show();
        
        
		recipe=RecipeManager.foundIngredient(rb.getIngredients(),rb.getCategory(),rb.getDifficulty()); 
	
		if (recipe!= null) {
		//cycle for found recipes
			ArrayList <Recipe> secondList = createList(recipe);
			for(Recipe s : secondList) {
				
				//add title to the list
				list.add(new Recipe (s.getTitle(), s.getPreparation(), s.getTime(),s.getReview())); 
				tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				tableView.setItems(list);
				}
			}
		
		
		tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, (event -> {
            
          
            try { 
            	
            	
            	
            	
            	TablePosition<?, ?> pos= tableView.getSelectionModel().getSelectedCells().get(0);
            	int row = pos.getRow();
            	TableColumn col = pos.getTableColumn();
            	String t = (String) col.getCellObservableValue(row).getValue().toString();
            	Recipe rc = new Recipe(0,null,null,null,null,null,null,0); 
            	rc= rm.chooseRecipe(t);
            	
            	if(rb.validateRec(t)== true) { 
              		rb.setTitle(t);
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

	public void back(ActionEvent e) throws Exception {
		list.clear();
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.ingredientPage();
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
}