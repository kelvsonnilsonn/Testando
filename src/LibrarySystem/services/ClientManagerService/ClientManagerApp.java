package LibrarySystem.services.ClientManagerService;

import LibrarySystem.Database.DataAccessFolder.ClientDataAccessObject;
import LibrarySystem.model.Book;
import LibrarySystem.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientManagerApp {
    private final List<Client> clients;

    public ClientManagerApp(){
//        this.clients = new ClientDataAccessObject().getAllClientsFromDataBase();
        this.clients = new ArrayList<>();
    }

    public void searchClientInLibrary(int id){
        System.out.println((new ClientDataAccessObject().searchClientInLibrary(id)).toString());
    }

    public void removeClientFromLibrary(int id){
        System.out.println("Trying to remove client.");
        this.clients.removeIf(book -> book.getClientId() == id);
        new ClientDataAccessObject().removeClientFromLibrary(id);
        System.out.println("Client was removed.\n");
    }

    public void listClientsFromTheLibrary(){
        clients.forEach(System.out::println);
    }

    public void addClientInTheLibrary(String name, String cpf, String email, char gender){

        try{

            Client clientToAdd = new Client(name, cpf, email, gender);
            new ClientDataAccessObject().addClientInLibrary(clientToAdd);
            clients.add(clientToAdd);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void borrowerBookForClient(Book book, String clientName){
        Client client = findClientInTheSystem(clientName);
        if(client == null)
            throw new IllegalArgumentException("Client not found.");

        book.changeStatus();
        client.borrowerBook(book);
    }

    public void returnBook(String title, String clientName){
        Client client = findClientInTheSystem(clientName);
        if(client == null)
            throw new IllegalArgumentException("Client not found.");

        Book bookToReturn = client.returnBook(title);
        bookToReturn.changeStatus();
    }

    private Client findClientInTheSystem(String clientName){
        return clients.stream()
                .filter(client -> client.getName().equals(clientName))
                .findFirst()
                .orElse(null);
    }
}
