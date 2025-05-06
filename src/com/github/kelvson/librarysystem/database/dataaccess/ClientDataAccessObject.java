package com.github.kelvson.librarysystem.database.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.kelvson.librarysystem.database.connect.ConnectDatabase;
import com.github.kelvson.librarysystem.database.dataaccess.auxiliaryfunctions.DatabaseDataAccess;
import com.github.kelvson.librarysystem.database.dataaccess.clientdatamanipulator.InsertClient;
import com.github.kelvson.librarysystem.database.dataaccess.clientdatamanipulator.RemoveClient;

import com.github.kelvson.librarysystem.model.Client;

public class ClientDataAccessObject {

    public void addClientInLibrary(Client client) {

        try (Connection conn = ConnectDatabase.getConnection()) {
            InsertClient.addClientInLibrary(client, conn);
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database.");
        }
    }

    public List<Client> getAllClientsFromDatabase() {
            return DatabaseDataAccess.getAllClientsFromDatabase(ConnectDatabase.getConnection());
    }


    public void removeClientFromLibrary(int id){
        try(Connection conn = ConnectDatabase.getConnection()){
            RemoveClient.removeClientFromLibrary(conn, id);
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database.");
        }
    }
}
