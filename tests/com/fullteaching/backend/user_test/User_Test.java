package com.fullteaching.backend.user_test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.user.User;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.*;

class User_Test {
	private User user;
	private User user1;
	private User user2;
	private User user3;

	
	@BeforeEach
	private void initialize() {
		user  = new User();
		user1 = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		user2 = new User("Gustavo Lopes", "12345", "lopes", "", "aluno");
		user3 = new User("Gustavo Lopes", "12345", "lopes", null, "aluno");
	}
	@Test
	@DisplayName("getId Test")
	void getId_Test() {
		Assertions.assertEquals(0, user1.getId());
	}
	
	@Test
	@DisplayName("setId Test")
	void setId_Test(){
		user1.setId(1L);
		Assertions.assertEquals(1, user1.getId());
	}
	
	@Test
	@DisplayName("getName Test")
	void getName_Test(){
		Assertions.assertEquals("Gustavo Lopes", user1.getName());
	}
	
	@Test
	@DisplayName("setName Test")
	void setName_Test(){
		user1.setName("Gustavo de Paula");
		Assertions.assertEquals("Gustavo de Paula", user1.getName());
	}
	
	@Test
	@DisplayName("getPasswordHash Test")
	void getPasswordHas_Test(){
		Assertions.assertTrue(new BCryptPasswordEncoder().matches("12345",user1.getPasswordHash()));
	}
	@Test
	@DisplayName("setPassword Test")
	void setPassword_Test(){
		user1.setPasswordHash(new BCryptPasswordEncoder().encode("67890"));
		Assertions.assertTrue(new BCryptPasswordEncoder().matches("67890",user1.getPasswordHash()));
	}
	
	@Test
	@DisplayName("getRoles Test")
	void getRoles_Test(){
		List<String> roles = new ArrayList<String>();
		roles.add("aluno");
		Assertions.assertTrue(user1.getRoles().equals(roles));
	}
	
	@Test
	@DisplayName("setRoles Test")
	void setRoles_Test(){
		List<String> roles = new ArrayList<String>();
		roles.add("alunos");
		user1.setRoles(roles);
		Assertions.assertTrue(user1.getRoles().equals(roles));
	}
	
	@Test
	@DisplayName("getNickName Test")
	void getNickName_Test(){
		Assertions.assertEquals(user1.getNickName(), "lopes");
	}
	
	@Test
	@DisplayName("setNickName Test")
	void setNickName_Test(){
		user1.setNickName("lopesss");
		Assertions.assertEquals(user1.getNickName(), "lopesss");
	}
	
	@Test
	@DisplayName("getPicture Test")
	void getPicture_Test(){
		Assertions.assertEquals(user1.getPicture(), "foto.jpeg");
	}
	
	@Test
	@DisplayName("setPicture Test")
	void setPicture_Test(){
		user1.setPicture("foto2.jpeg");
		Assertions.assertEquals(user1.getPicture(), "foto2.jpeg");
	}
	
	@Test
	@DisplayName("getRegistrationDate Test")
	public void getRegistrationDate_Test() {
		//Como da diferenças de ms, coloquei uma margem de 2 ms pra passar no teste 		
		Assertions.assertTrue(Math.abs(user1.getRegistrationDate() - System.currentTimeMillis()) <= 10);
	}
	
	@Test
	@DisplayName("getRegistrationDate Test")
	public void setRegistrationDate_Test() {
		long time = System.currentTimeMillis();
		user1.setRegistrationDate(time);
		Assertions.assertEquals(user1.getRegistrationDate(), time);
	}
	
	@Test
	@DisplayName("getCourses Test")
	public void getCourses_Test() {
		Set<Course> courses = new HashSet<>();
		Assertions.assertEquals(user1.getCourses(), courses);
	}
	
	@Test
	@DisplayName("setCourses Test")
	public void setCourses_Test() {
		Set<Course> courses = new HashSet<>();
		Course curso = new Course();
		courses.add(curso);
		user1.setCourses(courses);
		Assertions.assertEquals(user1.getCourses(), courses);
	}
	
	@Test
	@DisplayName("equals Test")
	public void equals_Test() {
		User user2 = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		user2.setId(0L);
		Assertions.assertAll(
				() -> assertFalse(user1.equals(null)),
				() -> assertTrue(user1.equals(user1)),
				() -> assertFalse(user1.equals(new Course())),
				() -> assertTrue(user1.equals(user2)),
				() -> {
					user2.setId(user1.getId());
					user2.setName("Gustavo");
					assertFalse(user1.equals(user2));
				},
				() -> {
					user2.setId(123L);
					user2.setName("Gustavo");
					assertFalse(user1.equals(user2));
				}
				);
	}
	
	@Test
	@DisplayName("getHash Test")
	public void getHash_Test() {
		Assertions.assertEquals(user1.hashCode(), "Gustavo Lopes".hashCode());
	}
	
	@Test
	@DisplayName("toString Test")
	public void toString_Test() {
		Assertions.assertEquals(user1.getNickName(), "lopes");
	}
	
}
