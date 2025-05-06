package com.github.kelvson.librarysystem.services.menu.available;

import com.github.kelvson.librarysystem.services.menu.MenuBuilder;

import java.util.Scanner;

public class BorrowBookMenu extends MenuBuilder {
    public BorrowBookMenu(Scanner scan){
        super(scan,
                "Enter book title to borrow: ",
                "Enter client name: ");
    }
}
