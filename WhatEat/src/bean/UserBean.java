package bean;

import java.io.Serializable;

import controller.LoginManager;
import model.User;


public class UserBean implements Serializable {

	    public UserBean() {}

	    private String password;
	    private String email;
	    private String username;
	    private boolean found;
	    
	    public boolean isFound() {
	        return found;
	    }

	    public void setFound(boolean found) {
	        this.found = found;
	    }

	    public boolean validate() {
	    	
	    	LoginManager loginManager = LoginManager.getInstance();
	        
	        User found = loginManager.login( this.username, this.password );

	        
			if(found != null) {
				//this.set(found.getId());
				return true;
			}
			return false;
		}
	        

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNickname() {
	        return username;
	    }

	    public void setNickname(String nickname) {
	        this.username = nickname;
	    }
	}



