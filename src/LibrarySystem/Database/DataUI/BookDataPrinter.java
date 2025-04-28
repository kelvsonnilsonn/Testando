package LibrarySystem.Database.DataUI;

import LibrarySystem.Interfaces.UtilsInterfaces.PrinterUtilsInterface;
import LibrarySystem.model.Book;

public class BookDataPrinter implements PrinterUtilsInterface<Book> {

    public void printData(Book book) {
        System.out.println("=== Client data ===");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Description: " + book.getDescription());
        System.out.println("Date: " + book.getCreationDate());
    }
}