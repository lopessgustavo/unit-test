package com.fullteaching.backend_comment_test;
import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Comment_Test {
	Comment comment;
	Comment comment2;
	Comment comment3;
	@BeforeEach
	private void init() {
		comment = new Comment();
		User user = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		comment2 = new Comment("ola", 12345L, user, comment);
		comment3 = new Comment("ola2",123L,user);
	}
	
	
	@Test
	void getCommentParent_Test() {
		assertAll(
				() -> assertNull(comment.getCommentParent()),
				() -> assertEquals(comment2.getCommentParent(), comment)
				);
	}
	
	@Test
	void getId_Test() {
		assertEquals(comment.getId(), 0L);
	}
	
	@Test
	void setId_Test() {
		comment.setId(1L);
		assertEquals(comment.getId(), 1L);
	}
	
	@Test
	void getMessage_Test() {
		assertAll(
				() -> assertNull(comment.getMessage()),
				() -> assertEquals(comment2.getMessage(), "ola")
				);
	}
	
	@Test
	void setMessage_Test() {
		comment.setMessage("oi");
		assertEquals(comment.getMessage(),"oi");
	}
	
	@Test
	void getDate_Test() {
		assertAll(
				() -> assertEquals(comment.getDate(), 0L),
				() -> assertEquals(comment2.getDate(), 12345L)
				);
	}
	
	@Test
	void setDate_Test() {
		comment.setDate(1234L);
		assertEquals(comment.getDate(), 1234L);
	}
	
	@Test
	void getReplies_Test() {
		ArrayList<Comment> repl = new ArrayList<Comment>();
		assertAll(() -> assertEquals(comment.getReplies(), null),
				() -> assertEquals(comment2.getReplies(), repl));
	}
	
	@Test
	void setReplies_Test(){
		ArrayList<Comment> repl = new ArrayList<Comment>();
		repl.add(comment2);
		comment.setReplies(repl);
		assertEquals(comment.getReplies(), repl);
	}
	
	@Test
	void getUser_Test(){
		assertAll(() -> assertEquals(comment.getUser(), null),
				() -> assertEquals(comment2.getUser(), new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno")));
	}
	
	@Test
	void setUser_Test(){
		User u = new User("Gustavo Lopes", "12345", "lopes", "foto.jpeg", "aluno");
		comment.setUser(u);
		assertEquals(comment.getUser(), u);
	}
	
	
	@Test
	void setCommentParent_Test() {
		comment.setCommentParent(comment2);
		assertEquals(comment.getCommentParent(), comment2);
	}
	@Test
	void toString_test(){
		assertAll(
				() -> assertEquals(comment.toString(), "Comment[message: \"" + comment.getMessage() + "\", author: \"\", parent: \"" + comment.getCommentParent() + "\", #replies: 0date: \"" + comment.getDate() + "\"]"),
				() -> assertEquals(comment2.toString(), "Comment[message: \"" + comment2.getMessage() + "\", author: \"" + comment2.getUser() + "\", parent: \"" + comment2.getCommentParent().getMessage() + "\", #replies: " + comment2.getReplies().size() + "date: \"" + comment2.getDate() + "\"]")
				);
	}
}
