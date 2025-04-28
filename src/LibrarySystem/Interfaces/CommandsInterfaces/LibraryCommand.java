package LibrarySystem.Interfaces.CommandsInterfaces;

import LibrarySystem.services.BookManagerService.BookManagerApp;
import LibrarySystem.services.ClientManagerService.ClientManagerApp;

import java.util.Scanner;

public interface LibraryCommand {
    void execute(Scanner scan, BookManagerApp bookManager, ClientManagerApp clientManager);
}
