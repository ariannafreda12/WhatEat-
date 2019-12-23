package bean;

import java.util.ArrayList;
import java.util.List;


import controller.RecipeManager;
import model.Recipe;


public class RecipeBean {
	
	private String title;
	private int id_recipe;
	private String preparation;
	public String difficulty;
	public String category;
	private List <String> ingredients = new ArrayList <String>();
	private String time;
	

	
	public boolean validateCategory() {
		
		RecipeManager controller = RecipeManager.getInstance();
		synchronized(controller) {
		
		Recipe found = controller.chooseCategory(this.category,this.difficulty);
			if(found != null) {
			
				return true;
			}
			return false;
		}
		
	}
	
	public int getId() {
		return id_recipe;
	}
	
	private void setId(int id_recipe) {
		this.id_recipe = id_recipe;	
	}


	private void setTitle(String title) {
		this.title = title;	
	}
	
	public String getTitle() {
		return title;
	}
	
	private void setPreparation(String preparation) {
		this.preparation= preparation;	
	}

	public String getPreparation() {
		return preparation;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
		
	}	
	
	public String getDifficulty() {
		return difficulty;
	}


	public void setCategory(String category) {
		this.category = category;	
	}
	
	public String getCategory() {
		return category;
	}


	private void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}	
	
	public List<String> getIngredients() {
        return ingredients;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }


}
