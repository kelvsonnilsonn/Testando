package LibrarySystem.services.BookManagerService;

import LibrarySystem.model.Book;
import LibrarySystem.model.variableModels.BookInformation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookManagerApp {
    private List<Book> books;

    public BookManagerApp(){
        this.books = new ArrayList<>();
    }

    public void insertBookInTheLibrary(String title, String author, String description, Date date){

        Book new_Book = new Book(new BookInformation(title, author, description, date));
        System.out.printf("Trying to insert the book %s in the list.", title);
        books.add(new_Book);
        System.out.printf("%s was inserted in the list.", title);

    }

    public void removeBookFromTheLibrary(String title){
        System.out.printf("Trying to remove the book %s from the list.", title);
        books.removeIf(book -> book.getTitle().equals(title));
        System.out.printf("%s was removed from the list.", title);
    }

    public void listBooksFromTheLibrary(){
        books.forEach(System.out::println);
    }
}
