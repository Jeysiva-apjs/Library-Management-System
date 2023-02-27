package com.library.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BookTest {

	@Test
	void testBook() {
		//Given
		Book book;
		
		//When
		book = new Book("0001", "peace", 1990, new ArrayList<Author>(List.of(new Author("siva"), new Author("john"))));
		
		//Then
		assertAll(() -> assertEquals("0001", book.getISBN()),
				() -> assertEquals("peace", book.getTitle()),
				() -> assertEquals(1990, book.getPublicationYear()),
				() -> assertTrue(book.getAuthorNames().contains("siva")),
				() -> assertTrue(book.getAuthorNames().contains("john"))
				);	
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_IsbnIsEmpty() {
		//Given
		Book book;
		
		//When
		Executable executable = () -> new Book("", "peace", 1990, new ArrayList<Author>(List.of(new Author("siva"), new Author("john"))));
			
		// Then
		assertThrows(IllegalArgumentException.class, executable);
		
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_TitleIsEmpty() {
		//Given
		Book book;
		
		//When
		Executable executable = () -> new Book("0001", "", 1990, new ArrayList<Author>(List.of(new Author("siva"), new Author("john"))));
			
		// Then
		assertThrows(IllegalArgumentException.class, executable);
		
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_InvalidYear() {
		//Given
		Book book;
		
		//When
		Executable executable = () -> new Book("0001", "peace", 3050, new ArrayList<Author>(List.of(new Author("siva"), new Author("john"))));
			
		// Then
		assertThrows(IllegalArgumentException.class, executable);	
	}
	
	@Test
	void should_ThrowIllegalArgumentException_when_NoAuthor() {
		//Given
		Book book;
		
		//When
		Executable executable = () -> new Book("0001", "peace", 2000, new ArrayList<Author>());
			
		// Then
		assertThrows(IllegalArgumentException.class, executable);
	}
	
	@Test
	void should_ReturnTheBookDetails() {
		//Given
		Book book;
		
		//When
		book = new Book("0001", "peace", 1990, new ArrayList<Author>(List.of(new Author("siva"), new Author("john"))));
		
		//Then
		assertEquals("\nISBN: 0001" + "\nTitle: peace" + "\nPublication Year: 1990"
				 + "\nAuthors: [siva, john]" , book.toString());
		
	}

}
