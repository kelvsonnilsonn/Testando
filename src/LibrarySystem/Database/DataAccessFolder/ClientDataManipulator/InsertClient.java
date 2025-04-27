package LibrarySystem.Database.DataAccessFolder.ClientDataManipulator;

import LibrarySystem.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertClient {
    public static void addClientInLibrary(Client client, Connection conn) {

        String sql = "INSERT INTO clients (name, cpf, email, gender) VALUES (?, ?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, client.getName());
            ps.setString(2, client.getCPFNumber());
            ps.setString(3, client.getEmailAddress());
            ps.setString(4, String.valueOf(client.getGender()));

            ps.execute();
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to insert a new client in the database.");
        }
    }
}
