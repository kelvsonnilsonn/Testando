package LibrarySystem.Database.DataAccessFolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.Database.DataAccessFolder.AuxiliaryFunctions.GetDataFromDataBase;
import LibrarySystem.Database.DataAccessFolder.ClientDataManipulator.InsertClient;
import LibrarySystem.Database.DataAccessFolder.ClientDataManipulator.RemoveClient;
import LibrarySystem.Database.DataAccessFolder.ClientDataManipulator.SelectClient;
import LibrarySystem.Database.DataUI.ClientDataPrinter;

import LibrarySystem.model.Client;

public class ClientDataAccessObject {

    public void addClientInLibrary(Client client) {

        try (Connection conn = ConnectDatabase.getConnection()) {
            InsertClient.addClientInLibrary(client, conn);
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database.");
        }
    }

    public List<Client> getAllClientsFromDataBase() {
        List<Client> clients;

        try (Connection conn = ConnectDatabase.getConnection()) {
            clients = GetDataFromDataBase.getAllClientsFromDataBase(conn);            // AJUSTE NECESSÁRIO
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database. " + e);
        }

        return clients;
    }

    public void removeClientFromLibrary(int id){
        try(Connection conn = ConnectDatabase.getConnection()){
            RemoveClient.removeClientFromLibrary(conn, id);
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database.");
        }
    }

    public Client searchClientInLibrary(int id){

        Client foundedClient;

        try (Connection conn = ConnectDatabase.getConnection();){

            foundedClient = SelectClient.findClientInLibrary(conn, id);

            ClientDataPrinter printer = new ClientDataPrinter();
            printer.printData(foundedClient);

            } catch (SQLException e) {
                throw new RuntimeException("[ERROR] Unable to connect to the database to search for customers");
        }

        return foundedClient;
    }
}
