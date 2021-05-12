package com.fullteaching.backend.Course_test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

class Course_Test {

	Course course1;
	Course course2;
	Course course3;
	CourseDetails cd;
	User user;
	@BeforeEach
	private void init() {
		user = new User("Gustavo","Senha1234","Lopes","","aluno");
		cd = new CourseDetails();
		course1 = new Course();
		course2 = new Course("Teste","foto.jpeg", user);
		course3 = new Course("Qualidade", "foto.jpeg", user, cd);
	}
	
	@Test
	void getId_test() {
		assertAll(
				() -> assertEquals(course1.getId(), 0)
				);
	}
	
	@Test
	void setId_test() {
		course1.setId(1234L);
		assertAll(
				() -> assertEquals(course1.getId(), 1234L)
				);
	}
	@Test
	void getTitle_test() {
		assertAll(
				() -> assertEquals(course1.getTitle(), null),
				() -> assertEquals(course2.getTitle(), "Teste"),
				() -> assertEquals(course3.getTitle(), "Qualidade")
				);
	}
	@Test
	void setTitle_test() {
		course1.setTitle("Compiladores");
		assertAll(
				() -> assertEquals(course1.getTitle(), "Compiladores")
				);
	}
	
	@Test
	void getImage_test() {
		assertAll(
				() -> assertEquals(course1.getImage(), null),
				() -> assertEquals(course2.getImage(), "foto.jpeg"),
				() -> assertEquals(course3.getImage(), "foto.jpeg")
				);
	}
	
	@Test
	void setImage_test() {
		course1.setImage("foto2.jpeg");
		assertAll(
				() -> assertEquals(course1.getImage(), "foto2.jpeg")
				);
	}
	
	@Test
	void getTeacher_test() {
		assertAll(
				() -> assertEquals(course1.getTeacher(), null),
				() -> assertEquals(course2.getTeacher(), user),
				() -> assertEquals(course3.getTeacher(), user)
				);
	}
	
	@Test
	void setTeacher_test() {
		course1.setTeacher(user);
		assertAll(
				() -> assertEquals(course1.getTeacher(), user)
				);
	}

	@Test
	void getCourseDetails_test() {
		assertAll(
				() -> assertEquals(course1.getCourseDetails(), null),
				() -> assertEquals(course2.getCourseDetails(), null),
				() -> assertEquals(course3.getCourseDetails(), cd)
				);
	}
	
	@Test
	void setCourseDetails_test() {
		course1.setCourseDetails(cd);
		assertAll(
				() -> assertEquals(course1.getCourseDetails(), cd)
				);
	}
	
	@Test
	void getAttenders_test() {
		Set<User> att = new HashSet<>();
		assertAll(
				() -> assertEquals(course1.getAttenders(), null),
				() -> assertEquals(course2.getAttenders(), att),
				() -> assertEquals(course3.getAttenders(), att)
				);
	}
	
	@Test
	void setAttenders_test() {
		Set<User> att = new HashSet<>();
		user.setName("Gustavo");
		att.add(user);
		course1.setAttenders(att);
		assertAll(
				() -> assertEquals(course1.getAttenders(), att)
				);
	}
	
	@Test
	void getSessions_test() {
		Set<Session> sess = new HashSet<>();
		assertAll(
				() -> assertEquals(course1.getSessions(), null),
				() -> assertEquals(course2.getSessions(), sess),
				() -> assertEquals(course3.getSessions(), sess)
				);
	}
	
	@Test
	void setSessions_test() {
		Set<Session> sess = new HashSet<>();
		Session s = new Session();
		s.setTitle("Teste");
		sess.add(s);
		course1.setSessions(sess);
		assertAll(
				() -> assertEquals(course1.getSessions(), sess)
				);
	}
	
	@Test
	void equals_test() {
		assertAll(
				() -> assertEquals(course1.equals(null), false),
				() -> assertEquals(course1.equals(new Session()),false),
				() -> assertEquals(course1.equals(course1),true),
				() -> {course2.setId(2L); assertFalse(course1.equals(course2));},
				() -> {course2.setId(course1.getId()); assertTrue(course1.equals(course2));}
				);
	}
	
	@Test
	void toString_test() {
		assertAll(
				() -> assertEquals(course2.toString(),"Course[title: \"Teste\", teacher: \"Lopes\", #attenders: 0, #sessions: 0]")
				);
	}
	
	
}
