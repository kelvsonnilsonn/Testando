package com.github.kelvson.librarysystem.services.admin;

import com.github.kelvson.librarysystem.database.datastorage.BookStorage;
import com.github.kelvson.librarysystem.database.datastorage.ClientStorage;

import java.sql.Date;


public class AdminManagerApp {

    private final ClientStorage clientStorage;
    private final BookStorage bookStorage;

    public AdminManagerApp(ClientStorage clientStorage, BookStorage bookStorage){
        this.clientStorage = clientStorage;
        this.bookStorage = bookStorage;
    }

    public void searchClientInLibrary(int id){
        System.out.println(clientStorage.getClientFromLibraryById(id));
    }

    public void addClientInTheLibrary(String name, String cpf, String email, char gender){
        clientStorage.addClientInTheLibrary(name, cpf, email, gender);
    }

    public void removeClientFromLibrary(int id){
        clientStorage.removeClientFromLibrary(id);
    }

    public void listClientsFromTheLibrary(){
        (clientStorage.getClientsFromClientStorage()).forEach(System.out::println);
    }

    public void insertBookInTheLibrary(String title, String author, String description, Date date){
        bookStorage.insertBookInTheLibrary(title, author, description, date);
    }

    public void removeBookFromTheLibrary(String title){
        bookStorage.removeBookFromTheLibrary(title);
    }

}
