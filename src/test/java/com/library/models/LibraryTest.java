package com.library.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class LibraryTest {
	Library library;

	@BeforeEach
	void setUp() {
		library = new Library();
		
		library.addBook(
				new Book("0001", "peace", 1990, new ArrayList<Author>(List.of(new Author("siva"), new Author("john")))));
		library.addBook(
				new Book("0002", "war", 1950, new ArrayList<Author>(List.of(new Author("jack"), new Author("siva")))));
	}

	@Test
	void testAddBook() {
		// given
		Book book = new Book("0003", "health",  1950,
				new ArrayList<Author>(List.of(new Author("jack"), new Author("rose"))));

		// when
		library.addBook(book);

		// then
		assertEquals(3, library.getBooks().size());
	}

	@Test
	void testGetAllBooksSortedByPublicationYear() {

		// When
		ArrayList<Book> books = (ArrayList<Book>) library.getAllBooksSortedByPublicationYear();

		// Then
		assertAll(() -> assertEquals(1950, books.get(0).getPublicationYear()),
				() -> assertEquals(1990, books.get(1).getPublicationYear()));

	}
	
	@Test
	void should_ThrowIllegalStateException_when_LibraryIsEmpty() {
		// Given
		Library emptyLibrary = new Library();

		// When
		Executable executable = () -> emptyLibrary.getAllBooksSortedByPublicationYear();

		// Then
		assertThrows(IllegalStateException.class, executable);

	}
	

	@Test
	void testSearchBooksByISBN() {


		// When
		ArrayList<Book> books = (ArrayList<Book>) library.searchBooks("0001");

		// Then
		assertAll(() -> assertEquals(1, books.size()), 
				() -> assertEquals("0001", books.get(0).getISBN()));

	}
	

	
	@Test
	void should_ThrowIllegalArgumentException_When_InvalidData() {
		// When
		Executable ISBNexecutable = () -> library.searchBooks("0009");
		Executable Titleexecutable = () -> library.searchBooks("happiness");
		Executable Authorexecutable = () -> library.searchBooks("chetan");

		// Then
		assertAll( () -> assertThrows(IllegalArgumentException.class, ISBNexecutable),
				() -> assertThrows(IllegalArgumentException.class, Authorexecutable),
				() -> assertThrows(IllegalArgumentException.class, Titleexecutable)	
				);
		

	}

	@Test
	void testSearchBooksByTitle() {
		

		// When
		ArrayList<Book> books = (ArrayList<Book>) library.searchBooks("peace");

		// Then
		assertAll(() -> assertEquals(1, books.size()), 
				() -> assertEquals("peace", books.get(0).getTitle()));

	}
	

	@Test
	void testSearchBooksByAuthorName() {
		
		// When
		ArrayList<Book> books = (ArrayList<Book>) library.searchBooks("siva");

		// Then
		assertAll(() -> assertEquals(2, books.size()), 
				() -> assertTrue(books.get(0).getAuthorNames().contains("siva")),
				() -> assertTrue(books.get(1).getAuthorNames().contains("siva")));

	}
	

	@Test
	void testUpdateBook() {
		
		//Given
		Book updatedBook = new Book("0001", "updatedTitle", 2022, new ArrayList<Author>(List.of(new Author("butcher"))));
		
		//When
		library.updateBook("0001", updatedBook);
		
		//Then
		assertAll( () -> assertEquals("updatedTitle", library.searchBooks("0001").get(0).getTitle()),
				() ->  assertEquals(2022, library.searchBooks("0001").get(0).getPublicationYear()),
				() -> assertTrue(library.searchBooks("0001").get(0).getAuthorNames().contains("butcher"))
				);
	}

	@Test
	void testRemoveBook_When_BookIsNotPresent() {
		//When 
		Executable executable = () -> library.removeBook("1111");;
		
		//Then 
		assertThrows(IllegalArgumentException.class, executable);

	}
	
	@Test
	void testRemoveBook() {
		
		//When 
		library.removeBook("0001");
		Executable executable = () -> library.searchBooks("0001");
		
		//Then 
		assertThrows(IllegalArgumentException.class, executable);

	}
	
	@Test
	void should_ThrowIllegalStateException_when_GettingBooksFromEmptyLibrary() {
		// Given
		library.removeBook("0001");
		library.removeBook("0002");

		// When
		Executable executable = () -> library.getAllBooksSortedByPublicationYear();

		// Then
		assertThrows(IllegalStateException.class, executable);

	}

}
