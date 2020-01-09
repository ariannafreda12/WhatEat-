package utils;

public class Query {
	
	//query for login
	public static String loginQuery= "SELECT * FROM users WHERE username = '%s' AND password = '%s';";
	
	//query for registration
	public static String regQuery = "INSERT INTO users VALUES('%s', '%s', '%s');";
	
	
	//query for select recipe
	public static String recipesQuery= "SELECT * FROM recipes JOIN recipeingredient ON recipes.id_recipe=recipeingredient.id_rec JOIN ingredients ON recipeingredient.id_in=ingredients.id_ing WHERE  category = '%s' AND difficulty = '%s'  AND description = '%s';";
	
	
	//query for found user
	public static String foundUserQuery= "SELECT * FROM users WHERE username = '%s';";
		
	//query for change password
	public static String changePasswordQuery= "UPDATE users SET password = '%s' WHERE username = '%s';";
	
	//query for a single recipe
	public static String recipe1Query= "SELECT * FROM recipes WHERE title= '%s';";
	
	//query for save recipe
	public static String saveQuery = "INSERT INTO recipeuser VALUES('%s', '%s', '%s','%s', '%s', '%s');";
	
	//query for like recipe
	public static String reviewQuery= "UPDATE recipes SET review = '%s' WHERE title = '%s';";
}
