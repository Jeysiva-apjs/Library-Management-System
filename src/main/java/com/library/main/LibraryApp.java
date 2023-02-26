package com.library.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.library.models.Author;
import com.library.models.Book;
import com.library.models.Library;

public class LibraryApp {
	private static String title, ISBN, authorName, criteria, searchText;
	private static int publicationYear, noOfAuthors, choice, updateChoice, updateCriteria;
	private static Book resultBook;
	private static Library library = new Library();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {


		try {

			System.out.println();
			System.out.println("--------------------------");
			System.out.println("Library Management System");
			System.out.println("--------------------------");

			boolean isRunning = true;

			while (isRunning) {

				try {

					System.out.println();
					System.out.println("Enter Choice");
					System.out.println("   1.Add Book");
					System.out.println("   2.Get all Books");
					System.out.println("   3.Search book");
					System.out.println("   4.Update book details");
					System.out.println("   5.Remove book");
					System.out.println("   6.Exit");

					choice = scan.nextInt();
					scan.nextLine();

					switch (choice) {

					case 1:

						library.addBook(createBook(null));
						break;

					case 2:
						library.getAllBooksSortedByPublicationYear().forEach(System.out::println);
						break;

					case 3:
						System.out.print("Enter query: ");
						library.searchBooks(scan.nextLine()).stream().forEach(System.out::println);
						break;
						
					case 4:
						System.out.print("Enter ISBN of the book to update: ");
						ISBN = scan.nextLine();
						library.searchBooks(ISBN).stream().forEach(System.out::println);
						library.updateBook(ISBN, createBook(ISBN));
						System.out.println("Book is successfully updated");
						break;

					case 5:
						System.out.print("Enter ISBN of the book to remove: ");
						library.removeBook(scan.nextLine());
						System.out.println("Book is successfully removed from the library");
						break;

					case 6:
						System.out.println("Thankyou visit again!");
						isRunning = false;
						scan.close();
						break;

					default:
						throw new IllegalArgumentException("The choice entered is wrong, Enter the correct choice");
					}

				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter the correct input.");
					scan.nextLine();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Book createBook(String Isbn){

		System.out.println();
		if(Isbn == null) {
			System.out.print("Enter ISBN: ");
			ISBN = scan.nextLine();
		}else {
			ISBN =Isbn;
		}
		
		
		System.out.print("Enter title: ");
		title = scan.nextLine();

		System.out.print("Enter Publication Year: ");
		publicationYear = scan.nextInt();
		scan.nextLine();

		System.out.print("Enter the number of authors: ");
		noOfAuthors = scan.nextInt();
		scan.nextLine();

		ArrayList<Author> authors = new ArrayList<>();
		System.out.print("Enter Author names:");
		
		while (noOfAuthors != 0) {
			authors.add(new Author(scan.nextLine()));
			noOfAuthors--;
		}
		return new Book(ISBN, title, publicationYear, authors);
	
}
}
