package LibrarySystem.services.MenuServices;

import LibrarySystem.Interfaces.MenuInterface;

import LibrarySystem.model.Book;

import LibrarySystem.services.BookManagerService.BookManagerApp;
import LibrarySystem.services.ClientManagerService.ClientManagerApp;
import LibrarySystem.services.MenuServices.Factorys.MenuFactory;

import java.sql.Date;

import java.util.Scanner;

public class MenuHandler {

    private final BookManagerApp bookManager;
    private final ClientManagerApp clientManager;
    private final Scanner scan;

    public MenuHandler(BookManagerApp bookManager, ClientManagerApp clientManager, Scanner scan){
        this.bookManager = bookManager;
        this.clientManager = clientManager;
        this.scan = scan;
    }


    public void handleOptionPageTwo(int option){
        switch (option) {
            case 1 -> listBooksFromLibrary();
            case 2 -> listClientsFromLibrary(); // admin only
            case 3 -> searchBookInLibrary();
            case 4 -> searchClientInLibrary();
            case 0 -> System.out.println("Exiting Library System...");
            default -> System.out.println("Invalid option. Please try again.");

            // case 2
        }
    }

    public void handleOptionPageThree(int option){
        switch (option){
            case 1 -> createBook();
            case 2 -> removeBookFromLibrary(); // admin only
            case 3 -> createClient();
            case 4 -> removeClientFromLibrary();
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
        clientManager.searchClientInLibrary(id);
    }

    private void searchBookInLibrary(){
        System.out.println("Digite o id para pesquisar livro: ");
        int id = scan.nextInt();        // CRIAR VERIFICAÇÃO (CLASSE ID);
        bookManager.searchBookInLibrary(id);
    }

    private void listBooksFromLibrary(){
        bookManager.listBooksFromTheLibrary();
    }

    private void listClientsFromLibrary(){
        clientManager.listClientsFromTheLibrary();
    }
    private void removeClientFromLibrary() {
        System.out.println("Digite o id para remover: ");
        int id = scan.nextInt();        // CRIAR VERIFICAÇÃO (CLASSE ID);
        clientManager.removeClientFromLibrary(id);
    }

    private void removeBookFromLibrary(){
        System.out.print("Enter book title to remove: ");
        String titleToRemove = scan.nextLine();
        bookManager.removeBookFromTheLibrary(titleToRemove);
    }

    private void createClient(){
        String[] dataCreateClient = menu(MenuFactory.MenuType.CREATE_CLIENT);
        clientManager.addClientInTheLibrary(dataCreateClient[0],
                dataCreateClient[1], dataCreateClient[2], dataCreateClient[3].charAt(0));
    }

    private void createBook(){
        String[] dataCreateBook = menu(MenuFactory.MenuType.CREATE_BOOK);
        bookManager.insertBookInTheLibrary(dataCreateBook[0], dataCreateBook[1], dataCreateBook[2], Date.valueOf(dataCreateBook[3]));
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
