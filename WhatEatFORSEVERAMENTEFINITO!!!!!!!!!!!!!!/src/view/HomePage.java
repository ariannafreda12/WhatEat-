package view;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import bean.RecipeBean;
import bean.UserBean;
import controller.GraphicController;
import controller.LoginManager;
import controller.RecipeManager;
import controller.UserProfileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Recipe;
import model.UserProfile;

public class HomePage {

	public Button backButton;
	@FXML
    private static ObservableList<Recipe> list = FXCollections.observableArrayList();
	
	ArrayList <Recipe> popularRecipe = new ArrayList<Recipe>();	
	Recipe daily = new Recipe();	
	UserProfile fav = new UserProfile();
	GraphicController gc = new GraphicController();
	
    RecipeManager rm= RecipeManager.getInstance();
	RecipeBean rb= new RecipeBean();
	
	LoginManager lm =LoginManager.getInstance();
	UserBean ub= lm.getUser();

	public void myProfile() throws Exception {
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
	
	public void createNote() throws Exception {
     	GraphicController graphicController = new GraphicController();
       	graphicController.notePage(); 
	}
	
	public void newUser() throws Exception {
		GraphicController graphicController = new GraphicController();
		graphicController.registrationPage();
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
        
        Label titleLabel = new Label("Discover popular recipes:");
        titleLabel.setAlignment(Pos.TOP_LEFT);
        titleLabel.setFont(Font.font("System",FontWeight.BOLD, FontPosture.ITALIC, 20));
        titleLabel.setTextFill(Color.FIREBRICK);
        titleLabel.setLayoutX(79);
        titleLabel.setLayoutY(129);
        
        Label recLabel = new Label();
        recLabel.setAlignment(Pos.TOP_LEFT);
        recLabel.setFont(Font.font("System",FontWeight.BOLD, FontPosture.ITALIC, 20));
        recLabel.setTextFill(Color.FIREBRICK);
        recLabel.setLayoutX(405);
        recLabel.setLayoutY(129);
        
        Label search= new Label();
        search.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 18));
        search.setText("Search a cooking class near you");
        search.setTextFill(Color.FIREBRICK);
        search.setLayoutX(80);
        search.setLayoutY(350);
        
        final Label hi= new Label();
        hi.setText("Hi " + ub.getUsername());
        hi.setLayoutY(10);
        hi.setLayoutX(600);
        hi.setFont(Font.font("System", FontPosture.ITALIC, 18));
        
        FileInputStream inputP = new FileInputStream("src\\img\\icons8-nome-100.png");
        Image imageP = new Image(inputP);
        ImageView userView = new ImageView(imageP);
        userView.setFitHeight(30);
        userView.setFitWidth(34);
        userView.setLayoutX(712);
        userView.setLayoutY(7);
        userView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
				myProfile();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        FileInputStream inputN = new FileInputStream("src\\img\\icons8-libretto-a-spirale-legato-80.png");
        Image imageN = new Image(inputN);
        ImageView noteView = new ImageView(imageN);
        noteView.setFitHeight(39);
        noteView.setFitWidth(38);
        noteView.setLayoutX(490);
        noteView.setLayoutY(3);
        noteView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
				createNote();
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        FileInputStream inputL = new FileInputStream("src\\img\\icons8-uscita-100.png");
        Image imageL = new Image(inputL);
        ImageView logoutView = new ImageView(imageL);
        logoutView.setFitHeight(30);
        logoutView.setFitWidth(28);
        logoutView.setLayoutX(758);
        logoutView.setLayoutY(7);
        logoutView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
				logOut(event);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        if (lm.getUser().getUsername()=="Chef"){
			noteView.setVisible(false);
			userView.setVisible(false);
			FileInputStream inputR = new FileInputStream("src\\img\\icons8-nome-100.png");
	        Image imageR = new Image(inputR);
	        ImageView rView = new ImageView(imageR);
	        rView.setFitHeight(30);
	        rView.setFitWidth(34);
	        rView.setLayoutX(712);
	        rView.setLayoutY(7);
	        root.getChildren().add(rView);
	        rView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
	            try {
					newUser();
				} catch (Exception e) {
					e.printStackTrace();
				}
	        });
	        
        }
        
        root.getChildren().addAll(hi, noteView, userView, logoutView, titleLabel, recLabel);
        
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
        scroll.setLayoutY(175);
        scroll.setPannable(true);
        scroll.setPrefSize(300, 160);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
               
        VBox vb = new VBox();
        
        Label title= new Label();
        title.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 18));
        
        Label cat= new Label();
        cat.setFont(Font.font("System", FontPosture.ITALIC, 16));
        
        Label diff= new Label();
        diff.setFont(Font.font("System", FontPosture.ITALIC, 16));
        
        Label prep= new Label();
        prep.setFont(Font.font("System", FontPosture.ITALIC, 16));
        
        TextArea necLabel = new TextArea();
        necLabel.setWrapText(true);
        necLabel.setFont(Font.font("System", FontPosture.ITALIC, 14));
        necLabel.setPrefSize(330, 80);
        necLabel.setEditable(false);
        
        TextArea prepLabel = new TextArea();
        prepLabel.setPrefSize(330, 150);
        prepLabel.setWrapText(true);
        prepLabel.setFont(Font.font("System", FontPosture.ITALIC, 14));
        prepLabel.setEditable(false);
           
        vb.getChildren().addAll(title, cat, diff, prep, necLabel, prepLabel);
        vb.setSpacing(5); 
        
        ScrollPane scroll2 = new ScrollPane(vb);
        scroll2.setLayoutX(400);
        scroll2.setLayoutY(175);
        scroll2.setPannable(true);
        scroll2.setPrefSize(340, 370);
        scroll2.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        VBox vbo = new VBox();
        
        TextArea tf = new TextArea();
        tf.setWrapText(true);
        tf.setFont(Font.font("System", FontPosture.ITALIC, 18));
        tf.setPrefSize(290, 10);
        tf.setMaxHeight(10);
        tf.setPromptText("Insert your city");
        tf.setLayoutX(75);
        tf.setLayoutY(380);
                              
        Button se= new Button();
        se.setText("Find it!");
        se.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 16));
        se.setPrefSize(100,10);
        se.setLayoutX(170);
        se.setLayoutY(445);
               
        se.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
        	String testoRicerca = "cooking course in ";
			String result = tf.getText();
			System.out.println(result);
			String valoreQ="";
			String valoreQ2="";
  
			try {
				if(!tf.getText().isEmpty()) {
				valoreQ = URLEncoder.encode(testoRicerca, "UTF-8");
				valoreQ2 = URLEncoder.encode(result, "UTF-8");
				URI uriRicerca = new URI("https://www.google.com/search?q=" + valoreQ + valoreQ2);
	 		    Desktop.getDesktop().browse(uriRicerca);}
				else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Attention!");
					alert.setContentText("Enter your city. Please.");
					alert.showAndWait();
				}
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
 				
        });      
    
        root.getChildren().addAll(scroll,scroll2,search, tf, se);
             
         if (lm.getUser().getUsername()=="Chef")    {
        	daily=RecipeManager.dailyRecipe(); 
        	recLabel.setText("Try daily recipe:");
        	title.setText("  " + daily.getTitle());
        	cat.setText("  Category:  " + daily.getCategory());
        	diff.setText("  Difficulty:  " + daily.getDifficulty());
        	prep.setText("  Preparation time:  " + daily.getTime());
        	necLabel.setText(daily.getNecessary());
        	prepLabel.setText(daily.getPreparation());
        } else  {
        	fav=UserProfileManager.favRecipe(lm.getUser().getUsername());
        	recLabel.setText("One of your favourite recipe:");
        	title.setText("  " + fav.getTitle());
        	cat.setText("  Category:  " + fav.getCategory());
        	diff.setText("  Difficulty:  " + fav.getDifficulty());
        	prep.setText("  Preparation time:  " + fav.getTime());
        	necLabel.setText(fav.getNecessary());
        	prepLabel.setText(fav.getPreparation());
        	
        }
        
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
			alert.setContentText("There are not popular recipes yet!");
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
