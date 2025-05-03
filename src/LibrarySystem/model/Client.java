package LibrarySystem.model;

import LibrarySystem.model.variableModels.ClientInformation;

import java.util.ArrayList;
import java.util.List;

public class Client extends ClientInformation {
    private int clientId;// ClientInformation
    private List<Book> borrowedBooks; // vai ser implementado também com mysql

    public Client(String name, String cpf, String email, char gender){
        super(name, cpf, email, gender);
        this.clientId = -1;

        this.borrowedBooks = new ArrayList<>();
    }

    public void setClientIdFromDataBase(int clientId) { this.clientId = clientId; }
    public int getClientId(){ return this.clientId; }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(this.getClientId()).append("\n")
                .append("Name: ").append(this.getName()).append("\n")
                .append("CPF: ").append(this.getCPFNumber()).append("\n")
                .append("Email: ").append(this.getEmailAddress()).append("\n")
                .append("Gender: ").append(Character.toUpperCase(this.getGender()));

        return sb.toString();
    }
}
