package controller;

import java.util.ArrayList;

import dao.RecipeDao;
import dao.UserProfileDao;
import model.Recipe;
import model.UserProfile;

public class UserProfileManager {
	
	private static UserProfileManager instance = null;
	private UserProfile userprofile;//singleton

    public UserProfileManager() {}

    public static UserProfileManager getInstance() {

        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }
    
    public UserProfile getUserProfile() {
        return userprofile;
     }

    public void setUserProfile(UserProfile up){
    	userprofile = up;
    }
    public boolean saveRecipe(String title, String preparation, String difficulty, String category, String time, String necessary,String username) {
    	return UserProfileDao.saveRecipeDao(title, preparation, difficulty, category, time, necessary, username);
    }
    
    public static ArrayList<UserProfile> foundIngredient(String username) {
    	return UserProfileDao.userRecipeDao(username);
    }
    
    


}
