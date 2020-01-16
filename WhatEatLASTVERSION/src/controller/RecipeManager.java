package controller;

import java.util.ArrayList;

import bean.RecipeBean;
import dao.RecipeDao;
import model.Recipe;

public class RecipeManager {
	
	private static RecipeManager instance = null;
	private RecipeBean recipe;//singleton

    public RecipeManager() {}

    public static RecipeManager getInstance() {

        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }
    
    public RecipeBean getRecipe() {
        return recipe;
     }

    public void setRecipe(RecipeBean r){
        recipe = r;
    }
     
    public static ArrayList<Recipe> foundIngredient(ArrayList<String> ingredients,String category, String difficulty) {
    	return RecipeDao.ingredientsDao(ingredients,category,difficulty);
    }
    
    public static Recipe chooseRecipe(String title) {
    	return RecipeDao.chooseRecipeDao(title);
    }

	public boolean reviewRecipe(String title, int review) {
		return RecipeDao.reviewRecipeDao(title, review);
	}
	
	public boolean addReviewRecipe(String username, String title) {
		return RecipeDao.addReviewDao(username, title);
	}
	public boolean checkReviewRecipe(String username, String title) {
		return RecipeDao.checkReviewDao(username, title);
	}
}
