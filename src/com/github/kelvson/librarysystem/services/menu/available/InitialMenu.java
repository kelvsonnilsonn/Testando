package com.github.kelvson.librarysystem.services.menu.available;

import java.util.Scanner;

public class InitialMenu {
    public static int initialMenuClient(Scanner scan){
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Search commands.");
        System.out.println("2. Auxiliary commands.");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine();

        return option;
    }

    public static int initialMenuAdmin(Scanner scan){
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Search commands.");
        System.out.println("2. Data manipulation commands. [ADMIN ONLY]");
        System.out.println("3. Auxiliary commands.");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine();

        return option;
    }

    public static int initialMenuPageTwo(Scanner scan){
        System.out.println("\n=== Library Menu - SEARCH ===");
        System.out.println("1. List all books");
        System.out.println("2. Search book in library by ID");
        System.out.println("3. Search book in library by Title");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine();

        return option;
    }

    public static int adminInitialPage(Scanner scan){
        System.out.println("\n=== Library Menu - ADMIN ===");
        System.out.println("1. List all books");
        System.out.println("2. List all clients");
        System.out.println("3. Search book in library by ID");
        System.out.println("4. Search book in library by Title");
        System.out.println("5. Search client in library");
        System.out.println("6. Add a new book");
        System.out.println("7. Remove a book");
        System.out.println("8. Add a new client");
        System.out.println("9. Remove a client");
        System.out.println("10. Borrow a book");
        System.out.println("11. Return a book");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine();

        return option;
    }

    public static int initialMenuPageFour(Scanner scan){
        System.out.println("\n=== Library Menu - AUXILIARY ===");
        System.out.println("6. Borrow a book");
        System.out.println("7. Return a book");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option = scan.nextInt();
        scan.nextLine();

        return option;
    }
}
