package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Notes;
import utils.Query;

public class NotesDao {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static Connection connection = null;
	
	public static ArrayList <Notes> userNotesDao(String username) {
		 Statement stmt = null;
		 Notes notes = null;
		 ArrayList<Notes> n= new ArrayList <Notes>();
		 
			try {
				Class.forName(DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(URL, USER, PASS);
				stmt = connection.createStatement();
				
					
					String sql = String.format(Query.notesQuery, username);
					System.out.println("query:\n"+sql);
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						
						notes = new Notes(rs.getString("note"),username);
								
								n.add(notes);
								
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
			return n;		 
	 }
	
	

}
