package com.github.kelvson.librarysystem.services.menu;

import com.github.kelvson.librarysystem.interfaces.MenuInterface;

import com.github.kelvson.librarysystem.model.Book;

import com.github.kelvson.librarysystem.services.admin.AdminManagerApp;
import com.github.kelvson.librarysystem.services.book.BookManagerApp;
import com.github.kelvson.librarysystem.services.client.ClientManagerApp;
import com.github.kelvson.librarysystem.services.menu.factory.MenuFactory;

import java.sql.Date;

import java.util.Scanner;

public class MenuHandler {

    private final BookManagerApp bookManager;
    private final ClientManagerApp clientManager;
    private final AdminManagerApp adminManager;
    private final Scanner scan;

    public MenuHandler(BookManagerApp bookManager, ClientManagerApp clientManager, AdminManagerApp adminManager, Scanner scan){
        this.bookManager = bookManager;
        this.clientManager = clientManager;
        this.adminManager = adminManager;
        this.scan = scan;
    }


    public void handleOptionPageTwo(int option){
        switch (option) {
            case 1 -> listBooksFromLibrary();
            case 2 -> searchBookInLibraryById();
            case 3 -> searchBookInLibraryByTitle();
            case 0 -> System.out.println("Exiting Library System...");
            default -> System.out.println("Invalid option. Please try again.");

            // case 2
        }
    }

    public void adminPage(int option){
        switch (option){
            case 1 -> listBooksFromLibrary();
            case 2 -> listClientsFromLibrary(); // admin only
            case 3 -> searchBookInLibraryById();
            case 4 -> searchBookInLibraryByTitle();
            case 5 -> searchClientInLibrary();
            case 6 -> createBook();
            case 7 -> removeBookFromLibrary(); // admin only
            case 8 -> createClient();
            case 9 -> removeClientFromLibrary();
            case 10 -> borrowBook();
            case 11 -> returnBookToLibrary();
            case 0 -> System.out.println("Exiting Library System...");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    public void handleOptionPageFour(int option){
        switch (option){
            case 1 -> borrowBook();
            case 2 -> returnBookToLibrary();
            case 0 -> System.out.println("Exiting Library System...");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void searchClientInLibrary(){
        System.out.println("Digite o id para pesquisar client: ");
        int id = scan.nextInt();        // CRIAR VERIFICAÇÃO (CLASSE ID);
        adminManager.searchClientInLibrary(id);
    }

    private void searchBookInLibraryById(){
        System.out.println("Digite o id para pesquisar livro: ");
        int id = scan.nextInt();
        bookManager.searchBookInLibraryById(id);
    }

    private void searchBookInLibraryByTitle(){
        System.out.println("Digite o titulo para pesquisar livro: ");
        String title = scan.nextLine();
        bookManager.searchBookInLibraryByTitle(title);
    }

    private void listBooksFromLibrary(){
        bookManager.listBooksFromTheLibrary();
    }

    private void listClientsFromLibrary(){
        adminManager.listClientsFromTheLibrary();
    }
    private void removeClientFromLibrary() {
        System.out.println("Digite o id para remover: ");
        int id = scan.nextInt();        // CRIAR VERIFICAÇÃO (CLASSE ID);
        adminManager.removeClientFromLibrary(id);
    }

    private void removeBookFromLibrary(){
        System.out.print("Enter book title to remove: ");
        String titleToRemove = scan.nextLine();
        adminManager.removeBookFromTheLibrary(titleToRemove);
    }

    private void createClient(){
        String[] dataCreateClient = menu(MenuFactory.MenuType.CREATE_CLIENT);
        adminManager.addClientInTheLibrary(dataCreateClient[0],
                dataCreateClient[1], dataCreateClient[2], dataCreateClient[3].charAt(0));
    }

    private void createBook(){
        String[] dataCreateBook = menu(MenuFactory.MenuType.CREATE_BOOK);
        adminManager.insertBookInTheLibrary(dataCreateBook[0], dataCreateBook[1], dataCreateBook[2], Date.valueOf(dataCreateBook[3]));
    }

    private void returnBookToLibrary(){
        String[] dataToReturn = menu(MenuFactory.MenuType.RETURN_BOOK);
        clientManager.returnBook(dataToReturn[0], dataToReturn[1]);
    }

    private void borrowBook(){
        String[] dataToBorrow = menu(MenuFactory.MenuType.BORROW_BOOK);
        Book book = bookManager.getBook(dataToBorrow[0]);
        if(book == null)
            throw new IllegalArgumentException("Book doesn't exist.");
        clientManager.borrowerBookForClient(book, dataToBorrow[1]);
    }

    private String[] menu(MenuFactory.MenuType type){
        MenuInterface menu = MenuFactory.createMenu(type, scan);
        return menu.collectData();
    }

}
