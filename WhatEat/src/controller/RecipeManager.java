package controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import dao.RecipeDao;
import dao.UserDao;
import model.Recipe;

public class RecipeManager {
	
	private static RecipeManager instance = null;
	private Recipe recipe;//singleton

    public RecipeManager() {}

    public static RecipeManager getInstance() {

        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }
    
    public Recipe getRecipe() {
        return recipe;
     }

    public void setRecipe(Recipe r){
        recipe = r;
    }
     

    
    public static ArrayList<Recipe> foundIngredient(ArrayList<String> ingredients,String category, String difficulty) {
    	return RecipeDao.ingredientsDao(ingredients,category,difficulty);
    }
    
    public  Recipe chooseRecipe(String title) {
    	return RecipeDao.chooseRecipeDao(title);
    }
   
    public boolean reviewRecipe(String title, int review) {
    	return RecipeDao.reviewRecipeDao(title, review);
    }
}
