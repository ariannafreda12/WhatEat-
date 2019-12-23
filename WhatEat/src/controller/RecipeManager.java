package controller;

import dao.RecipeDao;

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
     public  Recipe chooseCategory(String category, String difficulty) {
    	 	
    		return RecipeDao.chooseCategoryDao(category,difficulty);
    		}
     
   
 

}
