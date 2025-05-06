package com.github.kelvson.librarysystem;

import com.github.kelvson.librarysystem.application.LibraryApplication;
import com.github.kelvson.librarysystem.model.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LibraryApplication app = new LibraryApplication(scan);
        Client client = new Client("kelvson", "71787243400", "kelvsonnilson01@gmail.com", 'M');
        client.changeAdminStatus(true);
        app.run(client);

        scan.close();
    }
}
