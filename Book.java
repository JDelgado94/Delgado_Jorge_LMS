/*
Project: Library Management System
Name: Jorge Delgado
Date: 9/1/2024
Course: CEN:3024
Class Name: Book Class
Description: This class will create a book object with a
Book ID, Title, and Author
*/
public class Book {
    private int bookId;
    private String title;
    private String author;

    // Constructor method:
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    //----------------------------------------------------------------------------------------
    // Getter Methods:
    public int getBookId() {
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
//----------------------------------------------------------------------------------------

    // Setter methods:
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    //----------------------------------------------------------------------------------------
} // end of Book Class

