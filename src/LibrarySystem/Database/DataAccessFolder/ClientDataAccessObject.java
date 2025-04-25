package LibrarySystem.Database.DataAccessFolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.model.Client;

public class ClientDataAccessObject {

    public void addClientInLibrary(Client client){

        String sql = "INSERT INTO clients (nome, cpf, sexo) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = ConnectDatabase.getConnection().prepareStatement(sql);

            ps.setString(1, client.getName());
            ps.setString(2, client.getCPF());
            ps.setString(3, String.valueOf(client.getGender()));

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
