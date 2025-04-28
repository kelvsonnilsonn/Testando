package LibrarySystem;

import LibrarySystem.Application.LibraryApplication;
import LibrarySystem.services.MenuServices.Factorys.MenuFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LibraryApplication app = new LibraryApplication(scan);
        app.run();

        scan.close();
    }
}
