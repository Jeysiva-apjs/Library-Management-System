# Library-Management-System

Implemented an application to manage a library system that stores information about books and authors. The application is able to perform the following tasks:
1.         Add new books to the library with their title, ISBN, publication year, and the name of the author(s).
2.         Retrieve a list of all books in the library sorted by publication year in ascending order.
3.         Search for books by title, ISBN, or author name and return a list of matching books.
4.         Remove a book from the library by ISBN.
5.         Update information for a book such as its title, publication year, or author name.

The application is implemented using Java 8, with Lambda expressions and streams to manipulate the data. The books and authors information should be stored in memory and be accessible throughout the application's lifecycle. The application is able to handle multiple authors for a single book and multiple books for a single author.

In addition, the application should handle errors and exceptions gracefully, for example, if the ISBN for a book being added already exists in the library, it should throw an exception. If a book being searched for by ISBN is not found in the library, it should return a message indicating that no book was found.

