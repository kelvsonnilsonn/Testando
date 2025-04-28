package LibrarySystem.model.Enums;

public enum BookStatus {
    BORROWED("The book was borrowed."),
    WAITING_FOR_BORROWER("The book is waiting for someone to borrower it.");

    private final String description;

    BookStatus(String description){
        this.description = description;
    }

    public String getBookStatus() { return this.description; }

}
