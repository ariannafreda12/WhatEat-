package bean;



import controller.DBManager;
import model.User;

public class UserBean {
	
		private String username;
		private String password;
		private String email;
		
		public boolean validate() {
			
			DBManager controller = DBManager.getInstance();
			synchronized(controller) {
			User found = controller.login(this.username, this.password);
				if(found != null) {
				
					return true;
				}
				return false;
			}
		}
		
		public boolean foundUser() {
			DBManager controller = DBManager.getInstance();
			synchronized(controller) {
			User found = controller.foundUser(this.username);
				if(found != null) {
				
					return true;
				}
				return false;
				}
		}
		
	
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email= email;
			
		}
	}



