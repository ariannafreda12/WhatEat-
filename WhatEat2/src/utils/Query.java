package utils;

public class Query {
	
	//query for login
	public static String loginQuery= "SELECT * FROM users WHERE username = '%s' AND password = '%s';";
	
	//query for registration
	public static String regQuery = "INSERT INTO users VALUES('%s', '%s', '%s');";
	
	//query for found user
	public static String foundUserQuery= "SELECT * FROM users WHERE username = '%s';";
	
	//query for change password
	public static String changePasswordQuery= "UPDATE users SET password = '%s' WHERE username = '%s';";

}
