package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ingredient;
import model.Recipe;
import utils.Query;

public class RecipeDao {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static Connection connection = null;
	
	 public static ArrayList <Recipe> ingredientsDao(ArrayList <String> ingredientList, String category,String difficulty) {
		 Statement stmt = null;
		 Recipe r = null;
		 ArrayList<Recipe> recipe= new ArrayList <Recipe>();
		 int i;
		 
			try {
				Class.forName(DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(URL, USER, PASS);
				stmt = connection.createStatement();
				for (i=0; i<ingredientList.size(); i++ ) {
					
					String sql = String.format(Query.recipesQuery,category,difficulty, ingredientList.get(i));
					System.out.println("query:\n"+sql);
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						
						r = new Recipe(rs.getInt("id_recipe"),rs.getString("title"), rs.getString("preparation"),
								rs.getString("difficulty"),  rs.getString("category"), rs.getString("time"), rs.getString("necessary"),rs.getInt("review"));
								System.out.println(rs.getString("title"));
								recipe.add(r);
								
					}
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
	 
	 public static Recipe chooseRecipeDao(String title) {
		 Statement stmt = null;
		 Recipe r = null;
			try {
				Class.forName(DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(URL, USER, PASS);
				stmt = connection.createStatement();
					
					String sql = String.format(Query.recipe1Query,title);
					System.out.println("query:\n"+sql);
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						r = new Recipe(rs.getInt("id_recipe"),title, rs.getString("preparation"),
								 rs.getString("difficulty"),  rs.getString("category"), rs.getString("time"),rs.getString("necessary"),rs.getInt("review"));
						 
						 
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
			return r;		 
	 }
	 
	 public static boolean saveRecipeDao(String title, String preparation, String difficulty, String category, String time, String necessary) {
		  Statement stmt = null;
	      Connection conn = null;
	        try {
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection(URL, USER, PASS);
	            stmt = conn.createStatement();
	            String sql1= String.format(Query.saveQuery, title, preparation, difficulty,category,time,necessary);
	            System.out.println("query:\n"+sql1);
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	            int rs = stmt.executeUpdate(sql1);

	            if (rs != 1) {
	                System.out.println("Errore nella Query.");
	                return false;
	            }

	            // STEP 6: Clean-up dell'ambiente
	            stmt.close();
	            conn.close();

	            System.out.println("Registrazione effettuata con successo");
	            return true;

	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	                se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Query fallita");
	        return false;
	    }
	 public static boolean reviewRecipeDao(String title, int review) {
		  Statement stmt = null;
	      Connection conn = null;
	        try {
	            Class.forName("org.postgresql.Driver");
	            conn = DriverManager.getConnection(URL, USER, PASS);
	            stmt = conn.createStatement();
	            String sql1= String.format(Query.reviewQuery,review+1, title);
	            System.out.println("query:\n"+sql1);
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	            int rs = stmt.executeUpdate(sql1);

	            if (rs != 1) {
	                System.out.println("Errore nella Query.");
	                return false;
	            }

	            // STEP 6: Clean-up dell'ambiente
	            stmt.close();
	            conn.close();
	            return true;

	        } catch (SQLException se) {
	            // Errore durante l'apertura della connessione
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Errore nel loading del driver
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	                se2.printStackTrace();
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Query fallita");
	        return false;
	    }
}
