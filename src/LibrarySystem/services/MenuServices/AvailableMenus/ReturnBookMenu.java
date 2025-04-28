package LibrarySystem.services.MenuServices.AvailableMenus;

import LibrarySystem.services.MenuServices.MenuBuilder;

import java.util.Scanner;

public class ReturnBookMenu extends MenuBuilder {
    public ReturnBookMenu(Scanner scan){
        super(scan, "Enter book title to return: ", "Enter client name: ");
    }
}
