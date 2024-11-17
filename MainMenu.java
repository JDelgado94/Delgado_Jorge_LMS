/*Project: Library Management System
Name: Jorge Delgado
Date: 11/08/2024
Course: CEN:3024
Class Name: MainMenu
Description: This class will contain the Main Menu Gui and
             will perform the following:
             1. List all books in the database
             2. Add books
             3. Remove books (By Barcode and Title)
             4. Check in Books
             5. Check out Books
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainMenu extends JFrame {

    //Variables:--------------------------------------------------------------------------------------------------------
    private JPanel mainMenuPanel;
    private JButton viewLibraryButton;
    private JButton addBookButton;
    private JButton deleteBookByBarcodeButton;
    private JButton checkOutBookButton;
    private JButton checkInBookButton;
    private JButton exitButton;
    private JButton deleteBookByTitleButton;

    private Library library;
    private List<Book> books;


    // Constructor: ----------------------------------------------------------------------------------------------------
    public MainMenu(Library library) {
        this.library = library;
        setContentPane(mainMenuPanel);
        setTitle("Library Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        //View Library Button: -----------------------------------------------------------------------------------------
        viewLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               displayLibrary();

            }
        });

        //Add book button: ---------------------------------------------------------------------------------------------
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = JOptionPane.showInputDialog("Enter the book code");
                String title = JOptionPane.showInputDialog("Enter the title");
                String author = JOptionPane.showInputDialog("Enter the author");
                String genre = JOptionPane.showInputDialog("Enter the genre");
                String status = "Available";
                String dueDate = null;
                library.addBook(barcode, title, author, genre, status, dueDate);
                displayLibrary();
            }
        });

        // Delete Book by Barcode Button: ------------------------------------------------------------------------------
        deleteBookByBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = JOptionPane.showInputDialog("Enter the Barcode of The Book You Wish To Delete:");
                String message = library.removeBookByBarcode(barcode);
                JOptionPane.showMessageDialog(mainMenuPanel, message);
                displayLibrary();
            }
        });

        // Delete Book by Title Button: --------------------------------------------------------------------------------
        deleteBookByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the Title of The Book You Wish To Delete:");
                String message = library.removeBookByTitle(title);
                JOptionPane.showMessageDialog(mainMenuPanel, message);
                displayLibrary();
            }
        });

        // Check Out Book Button: --------------------------------------------------------------------------------------
        checkOutBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the Title of The Book You Wish To Check Out:");
                String message = library.checkOutBook(title);
                library.checkOutBook(title);
                JOptionPane.showMessageDialog(mainMenuPanel, message);
                displayLibrary();
            }
        });

        // Check In Book Button: -------------------------------------------------------------------------------------------------
        checkInBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter the Title of The Book You Wish To Check In:");
                library.checkInBook(title);
                JOptionPane.showMessageDialog(mainMenuPanel, title +" Has Been Checked In");
                displayLibrary();
            }
        });

        //Exit Button: -------------------------------------------------------------------------------------------------
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------
/*
* method: displayLibrary
* parameters: None
* return: void
* purpose: Displays The current books in the Library database to the GUI
* */
private void displayLibrary(){
    List <String> books = library.listAllBooks();


    StringBuilder booksInLibrary = new StringBuilder("Books in the Library: \n");
    if (books.isEmpty()) {
        JOptionPane.showMessageDialog(mainMenuPanel, "There are no books in the library");
    }
    else {
        for (String book : books) {
            booksInLibrary.append(book).append("\n");
        }
        JOptionPane.showMessageDialog(mainMenuPanel, booksInLibrary.toString());
    }
    }
}

