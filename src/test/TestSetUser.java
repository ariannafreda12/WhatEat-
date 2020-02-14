package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.bean.UserBean;

class TestSetUser {

	@Test
	void test() {
		
		String username = "falessi";
		String u2="";
		UserBean ub = new UserBean();
		ub.setUsername(username);
		u2=ub.getUsername();
		assertEquals("falessi", u2);
		
	}
}
