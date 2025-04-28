package LibrarySystem;

import LibrarySystem.Database.DataAccessFolder.BookDataAccessObject;
import LibrarySystem.Database.DataAccessFolder.ClientDataAccessObject;

import LibrarySystem.model.Book;
import LibrarySystem.model.Client;

import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LibraryApplication app = new LibraryApplication(scan);
        app.run();

        scan.close();
    }
}
