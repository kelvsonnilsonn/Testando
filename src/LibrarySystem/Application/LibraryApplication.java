package LibrarySystem.Application;

import LibrarySystem.services.MenuServices.AvailableMenus.InitialMenu;
import LibrarySystem.services.BookManagerService.BookManagerApp;
import LibrarySystem.services.ClientManagerService.ClientManagerApp;
import LibrarySystem.services.MenuServices.MenuHandler;

import java.util.Scanner;

public class LibraryApplication {
    private final Scanner scan;
    private final MenuHandler menuHandler;

    public LibraryApplication(Scanner scan){
        this.scan = scan;
        this.menuHandler = new MenuHandler(
                new BookManagerApp(),
                new ClientManagerApp(),
                scan
        );
    }

    public void run(){
        boolean running = true;

        while (running) {
            int option = InitialMenu.initialMenu(scan);
            try {
                switch(option){
                    case 1 -> menuHandler.handleOptionPageTwo(InitialMenu.initialMenuPageTwo(scan));
                    case 2 -> menuHandler.handleOptionPageThree(InitialMenu.initialMenuPageThree(scan));
                    case 3 -> menuHandler.handleOptionPageFour(InitialMenu.initialMenuPageFour(scan));
                    case 0 -> System.out.println("Closing program.");
                    default -> System.out.println("Invalid page.");
                }

                running = (option != 0);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
