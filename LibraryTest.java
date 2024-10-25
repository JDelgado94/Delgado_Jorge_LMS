import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;


    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    @DisplayName("Adding a book")
    void addBookTest() {
        Book book = new Book("004", "Fahrenheit 451", "Ray Bradbury", "Sci-Fi",
                                "Available", "N/A");
        library.addBook(book);
        boolean ifAdded = false;
        ifAdded = library.bookExists("Fahrenheit 451");
        assertTrue(ifAdded, "Fahrenheit 451 is in the library");
    }

    @Test
    @DisplayName("Removing a book by barcode")
    void removeBookByBarcodeTest() {
        boolean ifRemovedBarcode = true;
        Book book = new Book("004", "Fahrenheit 451", "Ray Bradbury", "Sci-Fi",
                "Available", "N/A");
        library.addBook(book);
        library.removeBookByBarcode("004");
        ifRemovedBarcode = library.bookExists("Fahrenheit 451");
        assertFalse(ifRemovedBarcode, "Book #004 is not the library");
    }

    @Test
    @DisplayName("Removing a book by title")
    void removeBookByTitleTest() {
        boolean ifRemovedTitle = true;
        Book book = new Book("004", "Fahrenheit 451", "Ray Bradbury", "Sci-Fi",
                "Available", "N/A");
        library.addBook(book);
        library.removeBookByTitle("Fahrenheit 451");
        ifRemovedTitle = library.bookExists("Fahrenheit 451");
        assertFalse(ifRemovedTitle, "Fahrenheit 451 is not the library");
    }

    @Test
    @DisplayName("Checking out a book")
    void checkOutBookTest() {
        Book book = new Book("004", "Fahrenheit 451", "Ray Bradbury", "Sci-Fi",
                "Available", "N/A");
        library.addBook(book);
        library.checkOutBook("Fahrenheit 451");
        assertEquals ("Checked Out", book.getStatus(),"Fahrenheit 451 is checked out");
        assertNotEquals("N/A",book.getDueDate(), "The due date for Fahrenheit 451 is not N/A");
    }

    @Test
    @DisplayName("Checking in a book")
    void checkInBookTest() {
        Book book = new Book("004", "Fahrenheit 451", "Ray Bradbury", "Sci-Fi",
                "Available", "N/A");
        library.addBook(book);
        library.checkInBook("Fahrenheit 451");
        assertEquals("Available",book.getStatus(), "The book is now available");
        assertEquals("N/A",book.getDueDate(), "The Due date for this book is n/a");

    }
}