package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import logic.bean.UserBean;
import logic.dao.UserDao;
import logic.model.User;





class TestUser {

	@Test
	void testUsername() {
		
		String username = "falessi";
		String u2="";
		UserBean ub = new UserBean();
		ub.setUsername(username);
		u2=ub.getUsername();
		assertEquals("falessi", u2);
		
	}
	
	@Test
	void testPass() {
		
		String password = "falessi18";
		String p2="";
		UserBean ub = new UserBean();
		ub.setPassword(password);
		p2 =ub.getPassword();
		assertEquals("falessi18", p2);
		
	}
	@Test
	void testMail() {
		
		String mail = "falessi18@gmail.com";
		String e2="";
		UserBean ub = new UserBean();
		ub.setEmail(mail);
		e2 =ub.getEmail();
		assertEquals("falessi18@gmail.com", e2);
		
	}
	
	@Test
	public void testuser () {
		String username="alessia";
		String password="123456";
		String email = "alessia@gmail.com";
	
		
		User u = new User(username,password, email);
		
		assertEquals(username, u.getUsername());
		assertEquals(email, u.getEmail());
		assertEquals(password, u.getPassword());
	}
	
	
	@Test
	void testLogin() {
		String username="alessia";
		String password="123456";
		String email = "alessia@gmail.com";
	
		UserDao ud = new UserDao(username,password,email);
		User x= ud.loginDao(username, password);
		assertEquals(true, x!=null);
	
}
	@Test
	void testFoundUser() {
		
		String username="alessia";
		String password="123456";
		String email = "alessia@gmail.com";
	
		UserDao ud = new UserDao(username,password,email);
		User u = ud.foundUserDao(username);
		assertEquals(true, u!=null);
	
}
	}
