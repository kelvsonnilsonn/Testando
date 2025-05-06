package com.github.kelvson.librarysystem.services.client;

import com.github.kelvson.librarysystem.database.datastorage.ClientStorage;

import com.github.kelvson.librarysystem.model.Book;
import com.github.kelvson.librarysystem.model.Client;

public class ClientManagerApp {
    private final ClientStorage clientStorage;

    public ClientManagerApp(ClientStorage clientStorage){
        this.clientStorage = clientStorage;
    }

    public void borrowerBookForClient(Book book, String clientName){
        Client client = checkIfClientExist(clientName);
        book.changeStatus();
        client.borrowerBook(book);
    }

    public void returnBook(String title, String clientName){
        Client client = checkIfClientExist(clientName);
        Book bookToReturn = client.returnBook(title);
        bookToReturn.changeStatus();
    }

    private Client checkIfClientExist(String clientName){
        Client client = clientStorage.getClientFromLibraryByName(clientName);
        if(client == null)
            throw new IllegalArgumentException("[ERROR] Client not found.");
        return client;
    }

}
