package LibrarySystem.model;

import java.sql.Date;

public class Book {
    private static int bookIdCounter = 1;

    private final int bookId;
    private String title;
    private String author;
    private String description;
    private Date creationDate;

    public Book(String title, String author, String description, Date date){
        this.author = author;
        this.title = title;
        this.description = description;
        this.creationDate = date;

        this.bookId = bookIdCounter++;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
