package com.github.kelvson.librarysystem.services.menu.available;

import com.github.kelvson.librarysystem.services.menu.MenuBuilder;

import java.util.Scanner;

public class CreateBookMenu extends MenuBuilder {
    public CreateBookMenu(Scanner scan){
        super(scan,
                "Enter book title: ", "Enter author name: ",
                "Enter description: ", "Enter publication date (yyyy-mm-dd): ");
    }
}
