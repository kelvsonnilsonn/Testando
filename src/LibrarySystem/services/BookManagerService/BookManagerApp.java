package LibrarySystem.services.BookManagerService;

import LibrarySystem.Database.DataAccessFolder.BookDataAccessObject;

import LibrarySystem.model.Book;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookManagerApp {
    private List<Book> books;

    public BookManagerApp(){
        this.books = new ArrayList<>();
    }

    public void insertBookInTheLibrary(String title, String author, String description, Date date){

        Book new_Book = new Book(title, author, description, date);
        System.out.printf("Trying to insert the book %s in the list.\n", title);
        new BookDataAccessObject().addBookInLibrary(new_Book);
        books.add(new_Book);
        System.out.printf("%s was inserted in the list.\n", title);

    }

    public void removeBookFromTheLibrary(String title){
        Book bookToRemove = getBookIdFromLibrary(title);
        System.out.printf("Trying to remove the book %s from the list.", title);

        new BookDataAccessObject().removeBookFromLibrary(bookToRemove.getBookId());
        books.remove(bookToRemove);

        System.out.printf("%s was removed from the list.", title);
    }

    private Book getBookIdFromLibrary(String title){
        return books.stream().filter(book->book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public void listBooksFromTheLibrary(){
        books.forEach(System.out::println);
//        books.stream().filter(book -> !(book.getBookStatus().equals("BORROWED"))).forEach(System.out::println);
    }

    public Book getBook(String title){
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }
}
