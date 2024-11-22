/*Project: Library Management System
Name: Jorge Delgado
Date: 11/08/2024
Course: CEN:3024
*/


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Library -- Contains all the book objects.
 * Description -- This class allows users to:
 *                1. Connect to the library database and extract its data
 *                2. Modify the library by adding, removing, and checking
 *                   in/out books.
 */

public class Library {
    private List<Book> books;
    private Connection connection;

    /**
     * Constructor for Library -- Connects the library Management System to
     *                            the database.
     */

    public Library() {
        books = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root",
                    "12341234!");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------

    /**
     * Method -- addBook
     * Description -- Adds a book to the Library Database
     * @param barcode -- A unique number that identifies each book.
     *                Is the primary key.
     * @param title -- Title of the book.
     * @param author -- Author of the book.
     * @param genre -- Genre of the book.
     * @param status -- The status of the book (Available, Checked out)
     * @param dueDate -- The date that the book needs to be returned when
     *                checked out.
     */

    public void addBook(String barcode, String title, String author, String genre,String status, String dueDate ) {
        String addBookQuery = "INSERT INTO books (barcode, title, author, genre, status, due_date) " +
                "VALUES (?, ?, ?, ?, 'Available', NULL)";
        try(PreparedStatement ps = connection.prepareStatement(addBookQuery)){
            ps.setString(1, barcode);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, genre);
            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();

        }
    }

    //----------------------------------------------------------------------------------------

    /**
     * method -- removeBookByBarcode
     * description -- Removes a book from the library database
     *                by using the book's barcode
     * @param barcode -- A unique number that identifies each book.
     *                   Is the primary key.
     * @return message -- Lets the user know if the book was removed.
     */

    public String removeBookByBarcode(String barcode) {
        String message;
        String removeBookBcQuery = "DELETE FROM books WHERE barcode = ?";
        try(PreparedStatement deleteBcStatement = connection.prepareStatement(removeBookBcQuery)) {
            deleteBcStatement.setString(1, barcode);
            deleteBcStatement.executeUpdate();
            if (deleteBcStatement.getUpdateCount() == 0) {
                message = "Error: Book #" + barcode + " was not deleted";
                return message;
            }
        }catch (SQLException e){
            e.printStackTrace();
            message = "Error: Book #" + barcode + " was not found";
            return message;
        }
        message = "Book #" + barcode + " has been deleted";
        return message;
    }
    //----------------------------------------------------------------------------------------

    /**
     * method -- removeBookByTitle
     * description -- Removes a book from the library database
     *                by using the book's title
     * @param title -- Title of the book.
     * @return message -- Lets the user know if the book was removed.
     */
    public String removeBookByTitle(String title){
        String message;
        String removeBookTQuery = "DELETE FROM books WHERE barcode = ?";
        try(PreparedStatement deleteTStatement = connection.prepareStatement(removeBookTQuery)) {
            deleteTStatement.setString(1, title);
            deleteTStatement.executeUpdate();
            if(deleteTStatement.getUpdateCount() == 0){
                message = "Error: " + title + " was not deleted";
                return message;
            }

        }catch (SQLException e){
            e.printStackTrace();
            message = "Error: " + title + " was not found";
            return message;
        }
        message = title + " has been deleted";
        return message;
    }
    //--
    // --------------------------------------------------------------------------------------

    /**
     * Method -- listAllBooks
     * Description -- Lists all book objects currently in the library database.
     * @return books -- Grabs the list of books in the database and returns them
     *                  to the user
     */
    public List<String> listAllBooks() {
        List<String> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Statement viewLibraryStatement = connection.createStatement();
             ResultSet viewLibraryRs = viewLibraryStatement.executeQuery(query)) {
            while (viewLibraryRs.next()) {
                String barcode = viewLibraryRs.getString("barcode");
                String title = viewLibraryRs.getString("title");
                String author = viewLibraryRs.getString("author");
                String genre = viewLibraryRs.getString("genre");
                String status = viewLibraryRs.getString("status");
                String dueDate = viewLibraryRs.getString("due_date");

                String bookDetails =  barcode +": " + title +", " + author + ", " + genre + ", "+ status+ ", " + (dueDate != null ? dueDate : "N/A");
                books.add(bookDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //----------------------------------------------------------------------------------------

    /**
     * Method -- checkOutBook
     * Description -- Takes a book title and checks to see if it's available
     *                 if it is, this method changes the Book status to "Checked Out".
     * @param title -- Title of the book.
     * @return message -- Lets the user know if the book was checked out or
     *                    not available.
     */
    public String checkOutBook(String title) {
        String message = "Book checked out successfully!";
        String checkOutBookQuery = "UPDATE books SET status = 'Checked Out', due_date = DATE_ADD(CURDATE(), INTERVAL 4 WEEK) " +
                "WHERE title = ? AND status = 'Available'";
        try(PreparedStatement checkOutBookStatement = connection.prepareStatement(checkOutBookQuery)) {
            checkOutBookStatement.setString(1, title);
            int bookUpdated = checkOutBookStatement.executeUpdate();
            if(bookUpdated == 0){
                return message = "Book Not Available";
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return message;
    }


    //----------------------------------------------------------------------------------------

    /**
     * Method -- checkInBook
     * Description -- Takes a book title checks to see if it is checked out and
     *                if it is, this method changes the Book status to "Available"
     * @param title -- Title of the book.
     */
       public void checkInBook(String title) {
          String checkInBookQuery = "Update books SET status = 'Available', due_date = NULL WHERE title = ?";
          try(PreparedStatement checkInBookStatement = connection.prepareStatement(checkInBookQuery)) {
              checkInBookStatement.setString(1, title);
              checkInBookStatement.executeUpdate();
          }catch (SQLException e) {
              e.printStackTrace();
          }

       }

}// End of Library Class
