package com.github.kelvson.librarysystem.database.dataaccess.clientdatamanipulator;

import com.github.kelvson.librarysystem.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertClient {
    public static void addClientInLibrary(Client client, Connection conn) {

        String sql = "INSERT INTO clients (name, cpf, email, gender, isAdmin) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            if(SelectClient.findClientInLibrary(conn, client.getClientId()) != null){
                throw new IllegalArgumentException("[ERROR] User already exist in database.");
            }

            ps.setString(1, client.getName());
            ps.setString(2, client.getCPFNumber());
            ps.setString(3, client.getEmailAddress());
            ps.setString(4, String.valueOf(client.getGender()));
            ps.setBoolean(5, client.getAdminStatus());

            ps.execute();
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to insert a new client in the database.");
        }
    }
}
