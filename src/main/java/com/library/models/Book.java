package com.library.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
	
	private String title;
	private String ISBN;
	private int publicationYear;
	private List<Author> authors = new ArrayList<>();

	public Book(String ISBN, String title, int publicationYear, List<Author> authors) {

		//impliment a method for exception
		if (title.isEmpty())
			throw new IllegalArgumentException("Title of the book cannot be null");
		if (ISBN.isEmpty())
			throw new IllegalArgumentException("ISBN of the book cannot be null");
		if (authors.isEmpty())
			throw new IllegalArgumentException("There should be atleast one author for the book");
		if (publicationYear < 0 || publicationYear > 2023) {
			throw new IllegalArgumentException("Publication year is not valid");
		}

		this.title = title;
		this.ISBN = ISBN;
		this.publicationYear = publicationYear;
		this.authors = authors;
	}
	//check how to chnage the if and bulk code using fun programming

	public List<String> getAuthorNames() {
		return authors.stream().map(Author::getName).collect(Collectors.toList());
	}

	public String getTitle() {
		return title;
	}


	public String getISBN() {
		return ISBN;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	@Override
	public String toString() {
		return "\nISBN: " + this.getISBN() + "\nTitle: " + this.getTitle() + "\nPublication Year: "
				+ this.getPublicationYear() + "\nAuthors: " + this.getAuthorNames();
	}

}
