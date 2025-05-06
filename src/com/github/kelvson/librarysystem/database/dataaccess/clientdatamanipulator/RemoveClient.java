package com.github.kelvson.librarysystem.database.dataaccess.clientdatamanipulator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveClient {
    public static void removeClientFromLibrary(Connection conn, int id){
        String sql = "DELETE FROM clients WHERE clientId = ?";

        try{
            if(SelectClient.findClientInLibrary(conn, id) == null){
                throw new IllegalArgumentException("[ERROR] tried to remove a client that doesn't exist.");
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database to search for customers");
        }
    }
}
