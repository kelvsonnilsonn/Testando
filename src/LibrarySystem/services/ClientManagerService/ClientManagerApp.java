package LibrarySystem.services.ClientManagerService;

import LibrarySystem.Database.DataAccessFolder.ClientDataAccessObject;
import LibrarySystem.model.Book;
import LibrarySystem.model.Client;
import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.util.ArrayList;
import java.util.List;

public class ClientManagerApp {
    private List<Client> clients;

    public ClientManagerApp(){
        this.clients = new ArrayList<>();
    }

    public void listClientsFromTheLibrary(){
        clients.forEach(System.out::println);
    }

    public void addClientInTheLibrary(int id, String name, CPF cpf, Email email, char gender){

        try{

            new ClientDataAccessObject().addClientInLibrary(new Client(id, name, cpf, email, gender));
            clients.add(new Client(id, name, cpf, email, gender));

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
