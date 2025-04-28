package LibrarySystem.model;

import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final int id;
    private String name;
    private CPF cpf;
    private Email email;
    private char gender;
    private List<Book> borrowedBooks;

    public Client(int id, String name, CPF cpf, Email email, char gender){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.gender = gender;

        this.borrowedBooks = new ArrayList<>();
    }

    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public String getCPFNumber() { return this.cpf.getCpf(); }
    public String getEmailAddress() { return this.email.getEmail(); }
    public char getGender() { return this.gender;}

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
