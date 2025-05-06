package com.github.kelvson.librarysystem.application;

import com.github.kelvson.librarysystem.database.dataaccess.BookDataAccessObject;
import com.github.kelvson.librarysystem.database.dataaccess.ClientDataAccessObject;
import com.github.kelvson.librarysystem.database.datastorage.BookStorage;
import com.github.kelvson.librarysystem.database.datastorage.ClientStorage;
import com.github.kelvson.librarysystem.model.Client;
import com.github.kelvson.librarysystem.services.admin.AdminManagerApp;
import com.github.kelvson.librarysystem.services.menu.available.InitialMenu;
import com.github.kelvson.librarysystem.services.book.BookManagerApp;
import com.github.kelvson.librarysystem.services.client.ClientManagerApp;
import com.github.kelvson.librarysystem.services.menu.MenuHandler;

import java.util.Scanner;

public class LibraryApplication {
    private final Scanner scan;
    private final MenuHandler menuHandler;

    public LibraryApplication(Scanner scan){
        ClientStorage clientStorage = new ClientStorage(new ClientDataAccessObject());
        BookStorage bookStorage = new BookStorage(new BookDataAccessObject());
        this.scan = scan;
        this.menuHandler = new MenuHandler(
                new BookManagerApp(bookStorage),
                new ClientManagerApp(clientStorage),
                new AdminManagerApp(clientStorage, bookStorage),
                scan
        );
    }

    public void run(Client client){
        boolean running = true;

        while (running) {

            int option = (!client.getAdminStatus()) ? InitialMenu.initialMenuClient(scan) : InitialMenu.initialMenuAdmin(scan);
            try {
                if(client.getAdminStatus()){
                    switch(option){
                        case 1 -> menuHandler.handleOptionPageTwo(InitialMenu.initialMenuPageTwo(scan));
                        case 2 -> menuHandler.adminPage(InitialMenu.adminInitialPage(scan));
                        case 3 -> menuHandler.handleOptionPageFour(InitialMenu.initialMenuPageFour(scan));
                        case 0 -> System.out.println("Closing program.");
                        default -> System.out.println("Invalid page.");
                    }
                } else {
                    switch(option){
                        case 1 -> menuHandler.handleOptionPageTwo(InitialMenu.initialMenuPageTwo(scan));
                        case 2 -> menuHandler.handleOptionPageFour(InitialMenu.initialMenuPageFour(scan));
                        case 0 -> System.out.println("Closing program.");
                        default -> System.out.println("Invalid page.");
                    }
                }

                running = (option != 0);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
