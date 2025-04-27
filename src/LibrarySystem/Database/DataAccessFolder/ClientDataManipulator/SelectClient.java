package LibrarySystem.Database.DataAccessFolder.ClientDataManipulator;

import LibrarySystem.model.Client;
import LibrarySystem.model.validateModels.CPF.CPF;
import LibrarySystem.model.validateModels.Email.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectClient {
    public static Client findClientInLibrary(PreparedStatement ps){
        String sql = "SELECT * FROM clients WHERE clientId = ?";

        try(ResultSet result = ps.executeQuery()){

            if(!result.next()){
                throw new IllegalArgumentException("[ERROR] Client don't found in database.");
            }

            return new Client(
                    result.getInt("clientId"),
                    result.getString("name"),
                    new CPF(result.getString("cpf")),
                    new Email(result.getString("email")),
                    result.getString("gender").charAt(0)
            );

        } catch (SQLException e){
               throw new RuntimeException("[ERROR] Unable to access client data.");
        }
    }
}
