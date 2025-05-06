package com.github.kelvson.librarysystem.database.datastorage;

import com.github.kelvson.librarysystem.database.dataaccess.BookDataAccessObject;

import com.github.kelvson.librarysystem.model.Book;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    private final List<Book> books;
    private final BookDataAccessObject bookDataAccessObject;

    public BookStorage(BookDataAccessObject bookDataAccessObject){
        this.bookDataAccessObject = bookDataAccessObject;
        this.books = new ArrayList<>();
    }

    public List<Book> getBooksFromBookStorage(){
        return new ArrayList<>(books);
    }

    public void insertBookInTheLibrary(String title, String author, String description, Date date){

        Book new_Book = new Book(title, author, description, date);
        System.out.printf("Trying to insert the book %s in the list.\n", title);

        bookDataAccessObject.addBookInLibrary(new_Book);
        this.books.add(new_Book);

        System.out.printf("%s was inserted in the list.\n", title);

    }

    public void removeBookFromTheLibrary(String title){
        Book bookToRemove = searchBookInLibrary(title);
        System.out.printf("Trying to remove the book %s from the list.", title);

        bookDataAccessObject.removeBookFromLibrary(bookToRemove.getBookId());
        this.books.remove(bookToRemove);

        System.out.printf("%s was removed from the list.", title);
    }

    public Book searchBookInLibrary(int id){
        return books.stream().filter(client -> client.getBookId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book searchBookInLibrary(String title){
        return books.stream().filter(client -> client.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public List<Book> searchAllBookInLibraryByTitle(String title){
        List<Book> booksFound = books.stream().
                filter(book -> book.getTitle().equals(title))
                .toList();

        if(booksFound.isEmpty()){
            throw new RuntimeException("[ERROR] Book not found.");
        }
        return booksFound;
    }
}
