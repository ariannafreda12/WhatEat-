package utils;

public class Query {
	
	public static String loginQuery= "SELECT * FROM users WHERE username = '%s' AND password = '%s';";
	
	public static String regQuery = "INSERT INTO users VALUES('%s', '%s', '%s');";

}
