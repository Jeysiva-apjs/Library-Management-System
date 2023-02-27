package com.library.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class AuthorTest {

	@Test
	void testAuthor() {
		//Given 
		Author author;
		
		//When
		author = new Author("john");
		
		//Then
		assertEquals("john", author.getName());
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_NameIsEmpty() {
		//Given 
		Author author;
		
		//When
		Executable executable = () -> new Author("");
		
		//Then
		assertThrows(IllegalArgumentException.class, executable);
			
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_NameIsEmpty2() {
		//Given 
		Author author = new Author("john");
		
		//When
		Executable executable = () -> author.setName("");
		
		//Then
		assertThrows(IllegalArgumentException.class, executable);
			
	}
	
	@Test
	void testSetName() {
		//Given 
		Author author = new Author("john");
		
		//When
		author.setName("Jack");
		
		//Then
		assertEquals("Jack", author.getName());
		
	}

}
