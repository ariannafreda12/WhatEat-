package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Recipe;
import utils.Query;

public class RecipeDao {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static Connection connection = null;
	
	 public static Recipe chooseCategoryDao(String category,String difficulty) {
		 Statement stmt = null;
		 Recipe recipe = null;
			try {
				Class.forName(DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(URL, USER, PASS);
				stmt = connection.createStatement();
				String sql = String.format(Query.recipeQuery, category, difficulty);
				System.out.println("query:\n"+sql);
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					recipe = new Recipe(rs.getInt("id_recipe"),rs.getString("title"), rs.getString("preparation"),
							 difficulty,  category, rs.getString("time"), rs.getString("ingredients"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(connection != null)
						connection.close();
					if(stmt != null)
						stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return recipe;		 
	 }
}
