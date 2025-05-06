package com.github.kelvson.librarysystem.services.menu.available;

import com.github.kelvson.librarysystem.services.menu.MenuBuilder;

import java.util.Scanner;

public class CreateClientMenu extends MenuBuilder {
    public CreateClientMenu(Scanner scan){
        super(scan,"Enter client name: ",
                "Enter client CPF: ", "Enter client email: ", "Enter client gender (M/F): ");
    }
}
