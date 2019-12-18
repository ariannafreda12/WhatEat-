package controller;

import dao.UserDao;
import model.User;


public class DBManager {
	private static DBManager instance = null; //singleton

    public DBManager() {}

    public static DBManager getInstance() {

        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }


public User login(String username, String password) {
	return UserDao.loginDao(username, password);
	}

public static boolean register(String username, String password, String email) {
	return UserDao.registrationDao(username, password, email);
}

}
