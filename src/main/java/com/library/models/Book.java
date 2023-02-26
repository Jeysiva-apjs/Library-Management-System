package com.library.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {

	private static int authorID = 1;
	private String title;
	private String ISBN;
	private int publicationYear;
	private ArrayList<Author> authors = new ArrayList<>();

	public Book(String ISBN, String title, int publicationYear, ArrayList<Author> authors) {

		//impliment a method for exception
		if (title.isEmpty())
			throw new IllegalArgumentException("Title of the book cannot be null");
		if (ISBN.isEmpty())
			throw new IllegalArgumentException("ISBN of the book cannot be null");
		if (authors.size() == 0 || authors.isEmpty())
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
		return authors.stream().map(author -> author.getName()).collect(Collectors.toList());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null)
			throw new IllegalArgumentException("Title of the book cannot be null");

		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		if (ISBN == null)
			throw new IllegalArgumentException("ISBN of the book cannot be null");

		this.ISBN = ISBN;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		if (publicationYear < 0 || publicationYear > 2023) {
			throw new IllegalArgumentException("Publication year is not valid");
		}
		this.publicationYear = publicationYear;
	}

	public void setAuthors(ArrayList<Author> authors) {
		if (authors.size() == 0)
			throw new IllegalArgumentException("There should be atleast one author for the book");
		this.authors = authors;
	}

	public ArrayList<Author> getAuthors() {
		return this.authors;
	}

	@Override
	public String toString() {
		return "\nISBN: " + this.getISBN() + "\nTitle: " + this.getTitle() + "\nPublication Year: "
				+ this.getPublicationYear() + "\nAuthors: " + this.getAuthorNames();
	}

}
