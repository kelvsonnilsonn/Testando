package LibrarySystem.model.Enums;

public enum BookStatus {
    BORROWED("BORROWED"),
    WAITING_FOR_BORROWER("UNBORROWED");

    private final String description;

    BookStatus(String description){
        this.description = description;
    }

    public String getBookStatus() { return this.description; }

}
