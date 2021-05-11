package com.fullteaching.backend.CourseDetails_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.filegroup.FileGroup;
import com.fullteaching.backend.forum.Forum;

class CourseDetails_Test {
	
	CourseDetails cd1;
	CourseDetails cd2;

	@BeforeEach
	private void init() {
		cd1 = new CourseDetails();
		cd2 = new CourseDetails(new Course());
	}
	
	@Test
	void getId_Test() {
		assertAll(
				() -> assertEquals(0L, cd1.getId())
				);
	}
	
	@Test
	void setId_Test() {
		cd1.setId(3L);
		assertAll(
				() -> assertEquals(3L, cd1.getId())
				);
	}
	
	@Test
	void getInfo_Test() {
		assertAll(
				() -> assertEquals("", cd1.getInfo()),
				() -> assertEquals("", cd2.getInfo())
				);
	}
	
	@Test
	void setInfo_Test() {
		cd1.setInfo("info1");
		cd2.setInfo("info2");
		assertAll(
				() -> assertEquals("info1", cd1.getInfo()),
				() -> assertEquals("info2", cd2.getInfo())
				);
	}
	
	@Test
	void setCourse_Test() {
		Course c = new Course();
		cd1.setCourse(c);
		assertAll(
				() -> assertEquals(c, cd1.getCourse())
				);
	}
	
	@Test
	void getCourse_Test() {
		assertAll(
				() -> assertEquals(new Course(), cd2.getCourse()),
				() -> assertEquals(null, cd1.getCourse())
				);
	}
	
	@Test
	void getFileGroup_Test() {
		assertAll(
				() -> assertEquals(new ArrayList<FileGroup>(), cd1.getFiles())
				);
	}
	
	@Test
	void setFileGroup_Test() {
		ArrayList<FileGroup> fg = new ArrayList<FileGroup>();
		fg.add(new FileGroup());
		cd1.setFiles(fg);
		assertAll(
				() -> assertTrue(fg.equals(cd1.getFiles()))
				);
	}
	
	@Test
	void getForum_Test() {
		Course c = new Course();
		cd1.setCourse(c);
		assertAll(
				() -> assertEquals(c, cd1.getCourse())
				);
	}
	
	@Test
	void setForum_Test() {
		Forum f = new Forum();
		cd1.setForum(f);
		assertAll(
				() -> assertEquals(f, cd1.getForum())
				);
	}
}
