package test;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import logic.bean.UserBean;
import logic.dao.RecipeDao;
import logic.dao.UserDao;
import logic.dao.UserProfileDao;
import logic.model.Recipe;
import logic.model.User;
import logic.model.UserProfile;

class TestPrgL {

	@Test
	void testGetUsername() {
		
		String username = "michela";
		String u2="";
		UserBean ub = new UserBean();
		ub.setUsername(username);
		u2=ub.getUsername();
		assertEquals("michela", u2);
		
	}
	
	@Test
	void testFoundUserSuccess() {
		String username="arianna";	
		User u = UserDao.foundUserDao(username);
		assertEquals(true, u!=null);
	}
	
	@Test
	void testChooseRecipeDifficulty() {
		String title="Pumpkin Oatmeal Cookies";	
		Recipe r = RecipeDao.chooseRecipeDao(title);
		String difficulty= r.getDifficulty();
		assertEquals("beginner",difficulty);
	}
	
	@Test
	void testCheckChefSuccess() {
		String title="Chocolate Crisp Bran Cookies";
		String username="arianna";	
		UserProfile up = UserProfileDao.checkChefDao(username, title);
		assertEquals(true,up!=null);
	}
	
	@Test
	void testGetDifficulty() {
		String diff= "beginner";
		String diff2="";
		Recipe r= new Recipe();
		r.setCategory(diff);
		diff2= r.getCategory();
		assertEquals("beginner",diff2);
		
	}
}
