package com.github.kelvson.librarysystem.services.menu.available;

import com.github.kelvson.librarysystem.services.menu.MenuBuilder;

import java.util.Scanner;

public class ReturnBookMenu extends MenuBuilder {
    public ReturnBookMenu(Scanner scan){
        super(scan, "Enter book title to return: ", "Enter client name: ");
    }
}
