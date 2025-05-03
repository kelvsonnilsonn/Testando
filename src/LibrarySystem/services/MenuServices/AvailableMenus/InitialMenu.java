package LibrarySystem.services.MenuServices.AvailableMenus;

import java.util.Scanner;

public class InitialMenu {
    public static int initialMenu(Scanner scan){
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Search commands.");
        System.out.println("2. Data manipulation commands.");
        System.out.println("3. Auxiliary commands.");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine(); // consumir quebra de linha pendente

        return option;
    }

    public static int initialMenuPageTwo(Scanner scan){
        System.out.println("\n=== Library Menu - SEARCH ===");
        System.out.println("1. List all books");
        System.out.println("2. List all clients");
        System.out.println("3. Search book in library");
        System.out.println("4. Search client in library");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine(); // consumir quebra de linha pendente

        return option;
    }

    public static int initialMenuPageThree(Scanner scan){
        System.out.println("\n=== Library Menu - DATA MANIPULATION ===");
        System.out.println("1. Add a new book");
        System.out.println("2. Remove a book");
        System.out.println("3. Add a new client");
        System.out.println("4. Remove a client");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine(); // consumir quebra de linha pendente

        return option;
    }

    public static int initialMenuPageFour(Scanner scan){
        System.out.println("\n=== Library Menu - AUXILIARY ===");
        System.out.println("6. Borrow a book");
        System.out.println("7. Return a book");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine(); // consumir quebra de linha pendente

        return option;
    }
}
