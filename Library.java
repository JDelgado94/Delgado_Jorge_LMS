/*Project: Library Management System
Name: Jorge Delgado
Date: 9/27/2024
Course: CEN:3024
Class Name: Library Class
Description: This class will contain all the book objects,
             users will be able to:
             1. List all books in the collection
             2. Add books
             3. Remove books
             4. Check in Books
             5. Check out Books
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
     * method: removeBookByBarcode
     * parameters: barcode
     * return: void
     * purpose: Removes a book from the collection by using the book's barcode
     */
    public void removeBookByBarcode(String barcode) {
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getBarcode().equals(barcode)) {
                System.out.println( books.get(i).getTitle()+ " has been removed");
                books.remove(i);
                return;
            }
        }
        System.out.println("Invalid choice, please try again later.");
    }
    //----------------------------------------------------------------------------------------
    /*
     * method: removeBookByTitle
     * parameters: title
     * return: void
     * purpose: Removes a book from the collection by using the book's title
     */
    public void removeBookByTitle(String Title){
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getTitle().equals(Title)) {
                System.out.println( books.get(i).getTitle()+ " has been removed");
                books.remove(i);
                return;
            }
        }
        System.out.println("Invalid choice, please try again later.");
    }
    //--
    // --------------------------------------------------------------------------------------
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
                System.out.println(book.getBarcode()+ "," + book.getTitle() + "," + book.getAuthor()
                                     + "," + book.getGenre() + "," + book.getStatus() + "," + book.getDueDate());
            }
        }
    }

    //----------------------------------------------------------------------------------------
    /*
     * method: checkOutBook
     * parameters: title
     * return: void
     * purpose: Takes a book title and checks to see if it's available
     *          if it is, this method changes the Book status to "Checked Out"
     */
    public void checkOutBook(String title) {
        for (Book book : books) {
            if(book.getTitle().equals(title)) {
                if(book.getStatus().equals("Available")) {
                    book.setStatus("Checked Out");
                    System.out.println(book.getTitle() + " is checked out.");

                } else{
                    System.out.println("Unfortunately, " + book.getTitle() + " book is not available");
                }
                return;

            }
        }
    }


    //----------------------------------------------------------------------------------------
    /*
     * method: checkInBook
     * parameters: title
     * return: void
     * purpose: Takes a book title checks to see if it is checked out and
     *          if it is, this method changes the Book status to "Available"
     */
       public void checkInBook(String title) {
           for (Book book : books) {
               if(book.getTitle().equals(title)) {
                   if(book.getStatus().equals("Checked Out")) {
                       book.setStatus("Available");
                       System.out.println(book.getTitle() + " is checked in.");
                   }
                   else{
                       System.out.println("Book is already checked in.");
                   }
               }
           }
       }


    //----------------------------------------------------------------------------------------



}// End of Library Class
}// End of Library Class
