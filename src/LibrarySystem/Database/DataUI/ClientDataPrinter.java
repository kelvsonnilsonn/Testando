package LibrarySystem.Database.DataUI;

import LibrarySystem.Interfaces.UtilsInterfaces.PrinterUtilsInterface;
import LibrarySystem.model.Client;

public class ClientDataPrinter implements PrinterUtilsInterface<Client> {

    public void printData(Client client) {
        System.out.println("=== Client data ===");
        System.out.println("ID: " + client.getId());
        System.out.println("Name: " + client.getName());
        System.out.println("CPF: " + client.getCPFNumber());
        System.out.println("Email: " + client.getEmailAddress());
        System.out.println("gender: " + client.getGender());
    }
}
