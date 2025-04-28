package LibrarySystem.services.MenuServices;

import LibrarySystem.Interfaces.MenuInterface;
import LibrarySystem.services.MenuServices.AvailableMenus.BorrowBookMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.CreateBookMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.CreateClientMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.ReturnBookMenu;
import LibrarySystem.model.Book;
import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;
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

    public void handleOption(int option){
        switch (option) {
            case 1 -> listBooksFromLibrary();
            case 2 -> listClientsFromLibrary();
            case 3 -> createBook();
            case 4 -> removeBookFromLibrary();
            case 5 -> createClient();
            case 6 -> borrowBook();
            case 7 -> returnBookToLibrary();
            case 0 -> System.out.println("Exiting Library System...");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void listBooksFromLibrary(){
        bookManager.listBooksFromTheLibrary();
    }

    private void listClientsFromLibrary(){
        clientManager.listClientsFromTheLibrary();
    }

    private void removeBookFromLibrary(){
        System.out.print("Enter book title to remove: ");
        String titleToRemove = scan.nextLine();
        bookManager.removeBookFromTheLibrary(titleToRemove); }

    private void createClient(){
        String[] dataCreateClient = menu(MenuFactory.MenuType.CREATE_CLIENT);
        clientManager.addClientInTheLibrary(Integer.parseInt(dataCreateClient[0]), dataCreateClient[1],
                new CPF(dataCreateClient[2]), new Email(dataCreateClient[3]), dataCreateClient[4].charAt(0));
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
