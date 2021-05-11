package com.fullteaching.backend.user_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.user.User;
import com.fullteaching.backend.user.UserComponent;

class UserComponent_Test {
	
	private UserComponent uc;
	
	@BeforeEach
	private void initialize() {
		uc = new UserComponent();
	}
	
	@Test
	@DisplayName("getLoggedUser_Test")
	void getLoggedUser_Test() {
		 assertNull(uc.getLoggedUser());
	}
	
	@Test
	@DisplayName("setLoggedUser_Test")
	void setLoggedUser_Test() {
		User user = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		uc.setLoggedUser(user);
		assertEquals(uc.getLoggedUser(),user);
	}
	
	@Test
	@DisplayName("isLoggedUser_Test")
	void isLoggedUser_Test() {
		User user = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		assertAll(
				() -> assertFalse(uc.isLoggedUser()),
				() -> {uc.setLoggedUser(user); assertTrue(uc.isLoggedUser());}
				);
	}

}
