package LibrarySystem.model;

import LibrarySystem.model.Enums.BookStatus;
import LibrarySystem.model.variableModels.BookInformation;

import java.sql.Date;

public class Book {
    private final BookInformation data;
    private BookStatus status;

    public Book(BookInformation data){
        this.data = data;
        this.status = BookStatus.WAITING_FOR_BORROWER;
    }

    public Date getCreationDate() {
        return data.getCreationDate();
    }
    public String getAuthor() {
        return data.getAuthor();
    }
    public String getDescription() {
        return data.getDescription();
    }
    public String getTitle() {
        return data.getTitle();
    }
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
