package LibrarySystem.Database.DataAccessFolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.Database.DataAccessFolder.ClientDataManipulator.InsertClient;
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

    public void searchClientInLibrary(int id){

        String sql = "SELECT * FROM clients WHERE clientId = ?";

        try (Connection conn = ConnectDatabase.getConnection();){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            Client foundedClient = SelectClient.findClientInLibrary(ps);

            ClientDataPrinter printer = new ClientDataPrinter();
            printer.printData(foundedClient);

            } catch (SQLException e) {
                throw new RuntimeException("[ERROR] Unable to connect to the database to search for customers");
        }
    }
}
