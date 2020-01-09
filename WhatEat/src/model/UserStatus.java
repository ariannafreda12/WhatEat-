package model;

public class UserStatus {
	 private String status;

	    public UserStatus() {};

	    public UserStatus(String status) {this.status = status;}

	    public void setActive() {
	        this.status = "Attivo";
	    }
	    public  void setInactive() {
	        this.status = "Inattivo";
	    }
	    public void setBanned() {
	        this.status = "Bannato";
	    }


	    public String getStatus() {
	        return status;
	    }

}
