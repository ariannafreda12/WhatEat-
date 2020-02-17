package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.RecipeBean;
import logic.dao.NotesDao;
import logic.dao.RecipeDao;
import logic.dao.UserDao;
import logic.model.Notes;
import logic.model.User;





class TestProgM {

	@Test
	void testGetTitle() {
		
		String title = "Carbonara";
		String t2="";
		RecipeBean rb = new RecipeBean();
		rb.setRecBeanTitle(title);
		t2 =rb.getRecBeanTitle();
		assertEquals("Carbonara", t2);
		
	}
	@Test
	void testChooseNoteUsername() {
		String notes="ciao";	
		Notes n = NotesDao.chooseNoteDao(notes);
		String user= n.getUsername();
		assertEquals("arianna",user);
	}
	
	
	@Test
	void testCheckReviewSuccess() {
		String title="Fresh Apple Cake";	
		String username="arianna";	
		boolean r = RecipeDao.checkReviewDao(username, title);
		assertEquals(true,r);
	}
	
	@Test
	void testFoundUserFailed() {
		String username="alessia";	
		User u = UserDao.foundUserDao(username);
		assertEquals(true, u==null);
	}
	
	@Test
	void testGetPassword() {
		String pass = "alessia";
		String pass2="";
		User u = new User(null,null,null);
		u.setPassword(pass);
		pass2=u.getPassword();
		assertEquals("alessia", pass2);
		
	}
	
	

}
