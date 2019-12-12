package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import exception.UsernameNotFoundException;
import model.User;
import model.UserStatus;

public class UserDao {
	
	
	 private static final String URL = "jdbc:postgresql://localhost:5432/WhatEat";
	 private static final String USER = "postgres";
	 private static final String PASS = "postgres";
	 private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	  private static Connection connection = null;
	
	  public User login(String username, String password) {
		 
				Statement stmt = null;
				User u = null;
				try {
					Class.forName(DRIVER_CLASS_NAME);
					connection = DriverManager.getConnection(URL, USER, PASS);
					stmt = connection.createStatement();
					String sql = "SELECT * from user where "
							+ "username = '" + username + "' and password = '" + password + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						u = new User(username, password);
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
				return u;
			}
    
		
	public boolean changeStatus(String nickname, UserStatus newStatus) {

        try {
            connection = DriverManager.getConnection( URL, USER, PASS );
            String query = "UPDATE user " +
                    "SET status = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement( query );
            preparedStatement.setString( 1, newStatus.getStatus() );
            preparedStatement.setString( 2, nickname );
            int row = preparedStatement.executeUpdate();

            if (row != 1) {
                connection.close();
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
	public UserStatus getStatus(String nickname) {

        UserStatus us = new UserStatus();

        try {
            connection = DriverManager.getConnection( URL, USER, PASS );

            String query = "SELECT status FROM userdata WHERE nickname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement( query );
            preparedStatement.setString( 1, nickname);
            ResultSet rs = preparedStatement.executeQuery();


            if (rs.next()) {

                String currentStatus = rs.getString( "status" );
                if (currentStatus.equals( "Attivo" )) {
                    us.setActive();
                    return us;
                } else if (currentStatus.equals( "Inattivo" )) {
                    us.setInactive();
                    return us;
                } else if (currentStatus.equals( "Bannato" )) {
                    us.setBanned();
                    return us;
                }
                connection.close();
            } else {
                connection.close();
                try {
                    throw (new UsernameNotFoundException());
                } catch (UsernameNotFoundException e) {
                    return us;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return us;
    }

}
