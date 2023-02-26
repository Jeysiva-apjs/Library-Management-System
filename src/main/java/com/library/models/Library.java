package com.library.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {

	private ArrayList<Book> books = new ArrayList<>();
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	
	
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	
	
	
	public List<Book> getAllBooksSortedByPublicationYear() {
		if(books.size() == 0)
			throw new IllegalStateException("No book is added into the library yet");
		
		return books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).collect(Collectors.toList());
	}
	
	
	
	
	public List<Book> searchBooks(String query) {
		List<Book> result = books.stream()
				                 .filter(book -> book.getTitle().contains(query) || book.getISBN().contains(query) ||
				    		      book.getAuthorNames().contains(query))
				                  .collect(Collectors.toList());

		if (result.size() == 0)
			throw new IllegalArgumentException("The book with " + query +  " is not present in the library");
		
		return result;
	}
	
	
	
	public void updateBook(String ISBN, Book updateBook) {
		this.searchBooks(ISBN);
		this.books = (ArrayList<Book>) this.books.stream()
				                                  .map(book -> book.getISBN().contains(ISBN)? updateBook : book)
												  .collect(Collectors.toList());
	}

	
	
	public void removeBook(String ISBN) {
		
		this.searchBooks(ISBN);
		books.removeIf(book -> book.getISBN().equals(ISBN));

	}

}
