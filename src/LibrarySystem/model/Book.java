package LibrarySystem.model;

import LibrarySystem.model.Enums.BookStatus;
import LibrarySystem.model.variableModels.BookInformation;

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

        sb.append("Title: ").append(this.getTitle()).append("\n")
                .append("Author: ").append(this.getAuthor()).append("\n")
                .append("Description: ").append(this.getDescription()).append("\n")
                .append("Date: ").append(getCreationDate().toString()).append("\n")
                .append("Status: ").append(getBookStatus()).append("\n");

        return sb.toString();
    }
}
