package LibrarySystem.services.MenuServices.AvailableMenus;

import LibrarySystem.services.MenuServices.MenuBuilder;

import java.util.Scanner;

public class BorrowBookMenu extends MenuBuilder {
    public BorrowBookMenu(Scanner scan){
        super(scan,
                "Enter book title to borrow: ",
                "Enter client name: ");
    }
}
