package LibrarySystem.Interfaces.CommandsInterfaces;

import LibrarySystem.services.ClientManagerService.ClientManagerApp;

import java.util.Scanner;

public interface ClientManagerCommand {
    void execute(Scanner scan, ClientManagerApp clientManager);
}
