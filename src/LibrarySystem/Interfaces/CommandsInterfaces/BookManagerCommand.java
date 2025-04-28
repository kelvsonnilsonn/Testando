package LibrarySystem.Interfaces.CommandsInterfaces;

import LibrarySystem.services.BookManagerService.BookManagerApp;

import java.util.Scanner;

public interface BookManagerCommand {
    void execute(Scanner scan, BookManagerApp bookManager);
}
