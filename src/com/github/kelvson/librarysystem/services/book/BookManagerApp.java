package com.github.kelvson.librarysystem.services.book;

import com.github.kelvson.librarysystem.database.datastorage.BookStorage;

import com.github.kelvson.librarysystem.model.Book;

import java.util.List;

public class BookManagerApp {

    private final BookStorage bookStorage;
    private final List<Book> books;

    public BookManagerApp(BookStorage bookStorage){
        this.bookStorage = bookStorage;
        this.books = bookStorage.getBooksFromBookStorage();
    }

    public void listBooksFromTheLibrary(){
        books.forEach(System.out::println);
    }

    public void searchBookInLibraryById(int id){
        System.out.println(bookStorage.searchBookInLibrary(id));
    }

    public void searchBookInLibraryByTitle(String title){
        bookStorage.searchAllBookInLibraryByTitle(title).forEach(System.out::println);
    }

    public Book getBook(String title){
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
