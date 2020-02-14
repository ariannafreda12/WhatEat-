package logic.controller;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.view.ChangePasswordPage;
import logic.view.DifficultPage;
import logic.view.FoundRecipes;
import logic.view.HomePage;
import logic.view.IngredientPage;
import logic.view.Login;
import logic.view.MealPage;
import logic.view.NotePage;
import logic.view.OpenNotePage;
import logic.view.ProfilePage;
import logic.view.RecipePage;
import logic.view.Registration;
import logic.view.UserRecipePage;

public class GraphicController extends Application {
	
	static Logger logger = Logger.getAnonymousLogger();
	 private static final String CONTEXT = "context";

	@Override
	public void start(Stage primaryStage) throws Exception {
		Login login = new Login();
		login.start();
	}

	public void homePage(){
		HomePage homepage = new HomePage();
		try {
			homepage.startHomePage();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
	}
	
	public void registrationPage() {
		Registration regPage = new Registration();
		try {
			regPage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
	}

	public void difficultPage() {
		DifficultPage difPage= new DifficultPage();
		try {
			difPage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}		
	}

	public void ingredientPage(){
		IngredientPage ingPage = new IngredientPage();
		try {
			ingPage.start();
		} catch (Exception e) {
			
			logger.log(null, CONTEXT,e);
		}
	}

	public void changePasswordPage(){
		ChangePasswordPage cpassPage= new ChangePasswordPage();
		try {
			cpassPage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
	}

	public void foundPage(){
		FoundRecipes frecPage= new FoundRecipes();
		try {
			frecPage.startFoundRec();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
		
	}

	public void showRecipe(){
		RecipePage recPage= new RecipePage();
		try {
			recPage.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void mealPage(){
		MealPage mealpage= new MealPage();
		try {
			mealpage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
		
	}


	public void profilePage(){
		ProfilePage profpage= new ProfilePage();
		try {
			profpage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}

		
	}

	public void userRecipePage(){
		UserRecipePage userRecPage = new UserRecipePage();
		try {
			userRecPage.start();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e); 
		}
		
	}


	public void notePage(){
		NotePage notePage = new NotePage();
		try {
			notePage.start();
		} catch (Exception e) {
			logger.log(null,CONTEXT,e);
		}
		
	}
	
	public void openNotePage(){
		OpenNotePage openNotePage = new OpenNotePage();
		try {
			openNotePage.startOpNotePage();
		} catch (Exception e) {
			logger.log(null, CONTEXT,e);
		}
		
	}
}
