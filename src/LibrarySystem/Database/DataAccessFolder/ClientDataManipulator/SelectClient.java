package LibrarySystem.Database.DataAccessFolder.ClientDataManipulator;

import LibrarySystem.model.Client;
import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectClient {
    public static Client findClientInLibrary(Connection conn, int id){
        String sql = "SELECT * FROM clients WHERE clientId = ?";

        Client foundedClient = null;

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if(!result.next()){
                return foundedClient;
            }

            foundedClient =  new Client(
                            result.getString("name"),
                            result.getString("cpf"),
                            result.getString("email"),
                            result.getString("gender").charAt(0)
            );

            foundedClient.setClientIdFromDataBase(result.getInt("clientId"));

        } catch (SQLException e){
               throw new RuntimeException("[ERROR] Unable to access client data.");
        }

        return foundedClient;
    }
}
