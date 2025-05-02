package LibrarySystem.Database.DataAccessFolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
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

    public void removeClientFromLibrary(int id){
        try(Connection conn = ConnectDatabase.getConnection()){
            RemoveClient.removeClientFromLibrary(conn, id);
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database.");
        }
    }

    public Client searchClientInLibrary(int id){

        Client foundedClient = null;

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
