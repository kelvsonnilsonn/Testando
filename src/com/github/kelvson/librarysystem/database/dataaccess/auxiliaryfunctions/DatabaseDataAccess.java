package com.github.kelvson.librarysystem.database.dataaccess.auxiliaryfunctions;

import com.github.kelvson.librarysystem.model.Book;
import com.github.kelvson.librarysystem.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDataAccess {

    public static List<Book> getAllBooksFromDatabase(Connection conn) {
        List<Book> books = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM books")) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Book book = new Book(
                        result.getString("title"),
                        result.getString("author"),
                        result.getString("description"),
                        result.getDate("date")
                );
                book.setBookIdFromDataBase(result.getInt("bookId"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Failed to retrieve books.", e);
        }

        return books;
    }

    public static List<Client> getAllClientsFromDatabase(Connection conn) {
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients")) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Client client = new Client(
                        result.getString("name"),
                        result.getString("cpf"),
                        result.getString("email"),
                        result.getString("gender").charAt(0)
                );
                client.setClientIdFromDataBase(result.getInt("clientId"));
                client.changeAdminStatus(result.getBoolean("isAdmin"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Failed to retrieve clients.", e);
        }

        return clients;
    }
}