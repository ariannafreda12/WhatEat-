package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.DifficultPage;
import view.IngredientPage;
import view.Login;
import view.MealPage;
import view.Registration;

public class GraphicController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Login login = new Login();
		login.start(primaryStage);
	}

	public void mealPage()throws Exception {
		MealPage mealPage = new MealPage();
		mealPage.start();
	}

	public void registrationPage() throws Exception {
		Registration regPage = new Registration();
		regPage.start();
	}

	public void difficultPage() throws Exception {
		DifficultPage difPage= new DifficultPage();
		difPage.start();		
	}

	public void ingredientPage() throws Exception {
		IngredientPage ingPage = new IngredientPage();
		ingPage.start();
	}
}
