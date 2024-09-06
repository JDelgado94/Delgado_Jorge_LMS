/*
Project: Library Management System
Name: Jorge Delgado
Date: 9/1/2024
Course: CEN:3024
App Name: LMS.java
Description: This application will allow the user to
add, remove and view a collection books from a text file
*/

import java.util.Scanner;


//Main Method:
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    library.readFile();


    int choice = 1;
    while (choice != 4) {
        System.out.println("Menu:");
        System.out.println("1. View Library");
        System.out.println("2. Add Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Exit");

        choice = scanner.nextInt();
        switch (choice) {

            // 1.View Library:
            case 1:
                library.listAllBooks();
                break;

            // 2. Add book:
            case 2:

                System.out.println("Enter Book ID:");
                int bookID = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Book Title: ");
                String title = scanner.nextLine();

                System.out.println("Enter Book Author: ");
                String author = scanner.nextLine();


                Book book = new Book(bookID, title, author);
                library.addBook(book);
                System.out.println(title +" Added");


                break;

            //Delete book:
            case 3:
                System.out.println("Please enter the Book ID of the book you wish to remove: ");
                int RemoveBookID = scanner.nextInt();
                library.removeBook(RemoveBookID);
                System.out.println("Book #" + RemoveBookID +" Removed");

                break;

            //Exit:
            case 4:
                System.out.println("Thank you for using Library Management System");
                System.out.println("Have a good day!");
                break;

            // For invalid options:
            default:
                System.out.println(choice + " is not a valid option, please try again");
        }
    }

    }
}