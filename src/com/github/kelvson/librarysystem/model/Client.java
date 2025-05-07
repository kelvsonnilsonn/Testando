package com.github.kelvson.librarysystem.model;

import com.github.kelvson.librarysystem.model.variable.models.ClientInformation;

import java.util.ArrayList;
import java.util.List;

public class Client extends ClientInformation {
    private final List<Book> borrowedBooks;

    public Client(String name, String password, String cpf, String email, char gender){
        super(name, cpf, email, password, gender);

        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowerBook(Book book){
        borrowedBooks.add(book);
    }

    public Book returnBook(String title){
        Book book = findBorrowedBooks(title);
        if(book == null)
            throw new IllegalArgumentException("The book wasn't borrowed.");
        borrowedBooks.remove(book);
        return book;
    }

    private Book findBorrowedBooks(String title){
        return borrowedBooks.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
