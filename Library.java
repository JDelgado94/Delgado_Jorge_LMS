/*Project: Library Management System
Name: Jorge Delgado
Date: 9/1/2024
Course: CEN:3024
Class Name: Library Class
Description: This class will contain all the book objects,
             users will be able to:
             1. List all books in the collection
             2. Add books
             3. Remove books
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;


    // Constructor:
    public Library() {
        books = new ArrayList<>();
    }

    //----------------------------------------------------------------------------------------
    /*
     * method: addBook
     * parameters: Book
     * return: void
     * purpose: Adds a book to the Library
     */
    public void addBook(Book book) {

        books.add(book);
    }

    //----------------------------------------------------------------------------------------
    /*
     * method: removeBook
     * parameters: bookID
     * return: void
     * purpose: Removes a book from the collection by using the bookID
     */
    public void removeBook(int id) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getBookId() == id) {
                books.remove(i);
                return;
            }
        }

    }
    //----------------------------------------------------------------------------------------
    /*
     * method: listAllBooks
     * parameters: None
     * return: void
     * purpose: Lists all book objects currently in the library
     */
    public void listAllBooks() {
        if (books.isEmpty()) {
                System.out.println("No books in library");
        } else {
            System.out.println("Books in library:");
            for (Book book : books) {
                System.out.println(book.getBookId()+ "," + book.getTitle() + "," + book.getAuthor());
            }
        }
    }

    //----------------------------------------------------------------------------------------
    /*
     * method: readFile
     * parameters: None
     * return: void
     * purpose: Takes all the book info from the Library.txt file and creates
     *          book objects
     */

    public void readFile(){
        try {
            File file = new File("Library.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] splitter = line.split(",");
                if (splitter.length == 3) {
                    int id = Integer.parseInt(splitter[0].trim());
                    String title = splitter[1].trim();
                    String author = splitter[2].trim();
                    Book book = new Book(id, title, author);
                    books.add(book);
                }

            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File 'Library.txt' was not found");
        }
    }

}// End of Library Class
