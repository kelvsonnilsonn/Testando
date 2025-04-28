package LibrarySystem.services.MenuServices.Factorys;

import LibrarySystem.services.MenuServices.AvailableMenus.BorrowBookMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.CreateBookMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.CreateClientMenu;
import LibrarySystem.services.MenuServices.AvailableMenus.ReturnBookMenu;
import LibrarySystem.Interfaces.MenuInterface;

import java.util.Scanner;

public class MenuFactory {
    public static MenuInterface createMenu(MenuType type, Scanner scan){
        return switch (type){
            case BORROW_BOOK -> new BorrowBookMenu(scan);
            case CREATE_BOOK -> new CreateBookMenu(scan);
            case RETURN_BOOK -> new ReturnBookMenu(scan);
            case CREATE_CLIENT -> new CreateClientMenu(scan);
        };
    }

    public enum MenuType{
        BORROW_BOOK, CREATE_BOOK, RETURN_BOOK, CREATE_CLIENT
    }
}
