package model;

public class Recipe {
	
	private String title;
	private int id_recipe;
	private String preparation;
	public String difficulty;
	public String category;
	private String ingredients;
	private String time;
	
	public Recipe(int id_recipe, String title, String preparation, String difficulty, String category, String ingredients, String time) {
		
		this.setId(id_recipe);
		this.setTitle(title);
		this.setPreparation(preparation);
		this.setDifficulty(difficulty);
		this.setCategory(category);
		this.setIngredients(ingredients);
		this.setTime(time);
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
	
	public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients=ingredients;
    }
	
}