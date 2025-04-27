package LibrarySystem;

import LibrarySystem.Database.DataAccessFolder.BookDataAccessObject;
import LibrarySystem.Database.DataAccessFolder.ClientDataAccessObject;

import LibrarySystem.model.Book;
import LibrarySystem.model.Client;

import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        Client cliente1 = new Client(1, "Kerison",
                new CPF("11863304495"),
                new Email("kerisonnilson01@gmail.com"),
                'M');

        // new ClientDataAccessObject().addClientInLibrary(cliente1);
        new ClientDataAccessObject().searchClientInLibrary(5);
    }
}
