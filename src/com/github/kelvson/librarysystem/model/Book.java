package com.github.kelvson.librarysystem.model;

import com.github.kelvson.librarysystem.model.variable.models.BookInformation;

import java.sql.Date;

public class Book extends BookInformation{
    private int bookId;
    private BookStatus status;

    public Book(String title, String author, String description, Date date){
        super(title, author, description, date);
        this.status = BookStatus.WAITING_FOR_BORROWER;
    }

    public void setBookIdFromDataBase(int bookId) { this.bookId = bookId; }
    public int getBookId() { return this.bookId; }

    public String getBookStatus() { return status.getBookStatus(); }
    public void changeStatus(){ status = (status == BookStatus.BORROWED) ? BookStatus.WAITING_FOR_BORROWER : BookStatus.BORROWED; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(this.getBookId()).append("\n")
                .append("Title: ").append(this.getTitle()).append("\n")
                .append("Author: ").append(this.getAuthor()).append("\n")
                .append("Description: ").append(this.getDescription()).append("\n")
                .append("Date: ").append(getCreationDate().toString()).append("\n")
                .append("Status: ").append(getBookStatus()).append("\n");

        return sb.toString();
    }

    private enum BookStatus {
        BORROWED("BORROWED"),
        WAITING_FOR_BORROWER("UNBORROWED");

        private final String description;

        BookStatus(String description){
            this.description = description;
        }

        public String getBookStatus() { return this.description; }
    }
}
