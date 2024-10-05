/*
Project: Library Management System
Name: Jorge Delgado
Date: 9/27/2024
Course: CEN:3024
App Name: LMS.java
Description: This application will allow the user to
add, remove and view a collection books from a text file
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Main Method:
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();

    int choice = 1;
    int choiceDelete = 0;

    System.out.println("Welcome to the Library Management System!");
    System.out.println("Please enter File name:");
    String fileName = scanner.nextLine();

    //Will check for file name:
    try{
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String[] bookInfo = fileScanner.nextLine().split(",");
            library.addBook(new Book(bookInfo[0],bookInfo[1],bookInfo[2],bookInfo[3],
                            "Available", "N/A"));
        }
    }catch (FileNotFoundException e){
        System.out.println("We could not find that file");

    }


    while (choice != 6) {
        System.out.println("Menu:");
        System.out.println("1. View Library");
        System.out.println("2. Add Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Check out Book");
        System.out.println("5. Check in Book");
        System.out.println("6. Exit");

        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {

            // 1.View Library: -----------------------------------------------------------------------
            case 1:
                System.out.println("Printing...");
                library.listAllBooks();
                break;

            // 2. Add book: -----------------------------------------------------------------------
            case 2:

                System.out.println("Enter Barcode:");
                String barcode = scanner.nextLine();


                System.out.println("Enter Book Title: ");
                String title = scanner.nextLine();

                System.out.println("Enter Book Author: ");
                String author = scanner.nextLine();

                System.out.println("Enter Book's Genre: ");
                String genre = scanner.nextLine();

                String status = "Available";
                String dueDate = "N/A";

                Book book = new Book(barcode, title, author,genre,status,dueDate);
                library.addBook(book);
                System.out.println(title +" Added");
                library.listAllBooks();

                break;

            //Delete book: -----------------------------------------------------------------------
            case 3:
                System.out.println("How would you like to remove the book?");
                System.out.println("1. By Barcode");
                System.out.println("2. By Title");
                System.out.println("3. Return to Main Menu");
                choiceDelete = scanner.nextInt();
                scanner.nextLine();

                if (choiceDelete == 1) {
                    System.out.println("Enter your book's barcode:");
                    barcode = scanner.nextLine();
                    library.removeBookByBarcode(barcode);
                    library.listAllBooks();
                }
                if (choiceDelete == 2) {
                    System.out.println("Enter your book's title:");
                    title = scanner.nextLine();
                    library.removeBookByTitle(title);
                    library.listAllBooks();
                }
                if (choiceDelete == 3) {
                    break;
                }
                else{
                    System.out.println("Invalid choice, please try again later.");
                }

                break;

            // Check out book: -----------------------------------------------------------------------
            case 4:
                System.out.println("Enter the title of the book you would like to check out:");
                String CheckOutTitle = scanner.nextLine();
                library.checkOutBook(CheckOutTitle);
                library.listAllBooks();
                break;

            // Check in: -----------------------------------------------------------------------
            case 5:
                System.out.println("Enter the title of the book you would like to check in:");
                String checkInTitle = scanner.nextLine();
                library.checkInBook(checkInTitle);
                library.listAllBooks();
                break;

            //Exit: -----------------------------------------------------------------------
            case 6:
                System.out.println("Thank you for using Library Management System");
                System.out.println("Have a good day!");
                break;

            // For invalid options: -----------------------------------------------------------------------
            default:
                System.out.println(choice + " is not a valid option, please try again");
        }
    }

    }
}
