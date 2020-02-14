package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.view.Registration;

class TestMail {

	@Test
	void test() {
		Registration r = new Registration();
		String mail= "ciao@gmail.com";
		boolean b= r.checkMail(mail);
		assertEquals(true,b);
	}

}
