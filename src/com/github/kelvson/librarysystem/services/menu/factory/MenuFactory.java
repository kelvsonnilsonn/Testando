package com.github.kelvson.librarysystem.services.menu.factory;

import com.github.kelvson.librarysystem.services.menu.available.BorrowBookMenu;
import com.github.kelvson.librarysystem.services.menu.available.CreateBookMenu;
import com.github.kelvson.librarysystem.services.menu.available.CreateClientMenu;
import com.github.kelvson.librarysystem.services.menu.available.ReturnBookMenu;
import com.github.kelvson.librarysystem.interfaces.MenuInterface;

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
