package model;

public class User {

		
		private String username;
		private String password;
		private String email;
		
	
		
		public User(String username, String password, String email) {
			
			this.setUsername(username);
			this.setPassword(password);
			this.setEmail(email);
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email= email;
			
		}

		public void reset() {
		        this.setEmail(null);
		        this.setPassword(null);
		        this.setUsername(null);
			
		}
	}
	 

	    

