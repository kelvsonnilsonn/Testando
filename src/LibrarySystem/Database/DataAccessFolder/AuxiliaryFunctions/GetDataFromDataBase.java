package LibrarySystem.Database.DataAccessFolder.AuxiliaryFunctions;

import LibrarySystem.model.Book;
import LibrarySystem.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromDataBase{

    public static List<Book> getAllBooksFromDataBase(Connection conn){
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Book book = new Book(result.getString("title"),
                        result.getString("author"),
                        result.getString("description"),
                        result.getDate("date"));
                book.setBookIdFromDataBase(result.getInt("bookId"));

                books.add(book);
            }

        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Failed to retrieve books from database.", e);
        }

        return books;
    }

    public static List<Client> getAllClientsFromDataBase(Connection conn){
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Client client = new Client(result.getString("name"),
                        result.getString("cpf"), result.getString("email"),
                        result.getString("gender").charAt(0));
                client.setClientIdFromDataBase(result.getInt("clientId"));
                clients.add(client);
            }

        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Failed to retrieve customers from database.",e);
        }
        return clients;
    }
}
