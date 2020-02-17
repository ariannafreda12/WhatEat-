package test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import logic.bean.NotesBean;

import logic.dao.UserDao;
import logic.dao.UserProfileDao;
import logic.model.Recipe;
import logic.model.User;
import logic.model.UserProfile;
import logic.view.Registration;

class TestProgF {

	@Test
	void testNote() {
		String note= "ciao";
		String note2="";
		NotesBean nb= new NotesBean();
		nb.setNote(note);
		note2=nb.getNote();
		assertEquals("ciao",note2);
		
	}
	@Test
	void testCheckMail() {
		Registration r = new Registration();
		String mail= "ciao@gmail.com";
		boolean b= r.checkMail(mail);
		assertEquals(true,b);
	}
	
	@Test
	void testLoginSuccess() {
		String username="arianna";
		String password="arianna";		
		User x= UserDao.loginDao(username, password);
		assertEquals(true, x!=null);
		}
	
	@Test
	void testChooseUserRecipeUsername() {
		String title="Chocolate Crisp Bran Cookies";
		UserProfile up = UserProfileDao.chooseUserRecipeDao(title);
		String u= up.getUsername();
		assertEquals("arianna",u);
	}
	
	@Test
	void testGetCatergory() {
		String cat= "starters";
		String cat2="";
		Recipe r= new Recipe();
		r.setCategory(cat);
		cat2= r.getCategory();
		assertEquals("starters",cat2);
		
	}
	


}
