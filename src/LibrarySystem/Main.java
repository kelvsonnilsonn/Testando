package LibrarySystem;

import LibrarySystem.Database.DataAccessFolder.BookDataAccessObject;
import LibrarySystem.Database.DataAccessFolder.ClientDataAccessObject;
import LibrarySystem.model.Book;
import LibrarySystem.model.Client;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        // Book newBook = new Book("Sansao, o nenem",
        //         "kelvson",
        //         "ele é um neném muito lindo",
        //         Date.valueOf("2005-10-20"));

        // new BookDataAccessObject().addBookInLibrary(newBook);

        Client cliente1 = new Client("Pedro", "71787243400", 'F');

        new ClientDataAccessObject().addClientInLibrary(cliente1);
    }
}
