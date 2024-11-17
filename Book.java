/*
Project: Library Management System
Name: Jorge Delgado
Date: 11/08/2024
Course: CEN:3024
Class Name: Book Class
Description: This class will create a book object with a
barcode, title, author, genre, status and a due date.
*/
public class Book {
    private String barcode;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String dueDate;

    // Constructor method:
    public Book(String barcode, String title, String author, String genre, String status, String dueDate) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;

    }
    //----------------------------------------------------------------------------------------
    // Getter Methods:
    public String getBarcode() {
        return barcode;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getStatus(){
        return status;
    }
    public String getGenre(){
        return genre;
    }
    public String getDueDate(){
        return dueDate;
    }
//----------------------------------------------------------------------------------------

    // Setter methods:
    public void setBarcode(String barcode) {

        this.barcode = barcode;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setGenre(String genre) {
        this.genre = genre;}
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;}
    //----------------------------------------------------------------------------------------
} // end of Book Class


