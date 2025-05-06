package com.github.kelvson.librarysystem.database.datastorage;

import com.github.kelvson.librarysystem.database.dataaccess.ClientDataAccessObject;

import com.github.kelvson.librarysystem.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientStorage {
    private final List<Client> clients;
    private final ClientDataAccessObject clientDataAccessObject;

    public ClientStorage(ClientDataAccessObject clientDataAccessObject){
        this.clientDataAccessObject = clientDataAccessObject;
        this.clients = clientDataAccessObject.getAllClientsFromDatabase();
    }

    public List<Client> getClientsFromClientStorage(){
        return new ArrayList<>(clients);
    }

    public void removeClientFromLibrary(int id){
        Client clientToRemove = getClientFromLibraryById(id);
        System.out.printf("Trying to remove the customer %s from the list.", clientToRemove.getName());

        clientDataAccessObject.removeClientFromLibrary(clientToRemove.getClientId());
        this.clients.remove(clientToRemove);

        System.out.printf("%s was removed from the list.", clientToRemove.getName());
    }

    public void addClientInTheLibrary(String name, String cpf, String email, char gender){
        Client new_Client = new Client(name, cpf, email, gender);
        System.out.printf("Trying to insert the book %s in the list.\n", name);

        clientDataAccessObject.addClientInLibrary(new_Client);
        this.clients.add(new_Client);

        System.out.printf("%s was inserted in the list.\n", name);
    }

    public Client getClientFromLibraryById(int id){
        return this.clients.stream().filter(client->client.getClientId() == id).findFirst().orElse(null);
    }

    public Client getClientFromLibraryByName(String name){
        return this.clients.stream().filter(client->client.getName().equals(name)).findFirst().orElse(null);
    }
}
