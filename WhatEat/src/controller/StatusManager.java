package controller;

import java.sql.SQLException;

import dao.UserDao;
import model.UserStatus;

public class StatusManager {

	private static StatusManager instance = null;         //singleton


    private StatusManager() {
    }

    public static StatusManager getInstance() {

        if (instance == null) {
            instance = new StatusManager();
        }
        return instance;
    }

    public UserStatus getStatus(String nickname) throws SQLException {

        UserDao ud = new UserDao();
        UserStatus us;

        us = ud.getStatus( nickname );

        return us;
    }

    public boolean changeUserStatus(String nickname, UserStatus status) {

        UserDao ud = new UserDao();

        boolean done = ud.changeStatus( nickname, status );

        return done;
    }
    

}
