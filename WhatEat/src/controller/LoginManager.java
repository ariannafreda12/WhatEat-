package controller;


import dao.UserDao;
import model.Recipe;
import model.User;


public class LoginManager {
	private static LoginManager instance = null;         //singleton
	private User user;//singleton
	
    private LoginManager() {}

    public static LoginManager getInstance() {

        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }
    public User getUser() {
        return user;
     }

    public void setUser(User u){
        user = u;
    }

    public static User login(String nickname, String password) {

        UserDao ud = new UserDao();
        User data = null;

        data = ud.loginDao(nickname, password );
        return data;
    }
    
  
}
