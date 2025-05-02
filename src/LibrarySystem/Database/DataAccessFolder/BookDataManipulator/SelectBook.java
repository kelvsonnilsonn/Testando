package LibrarySystem.Database.DataAccessFolder.BookDataManipulator;

import LibrarySystem.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectBook {
    public static Book findBookInLibrary(Connection conn, int id){

        String sql = "SELECT * FROM books WHERE bookId = ?";

        Book foundedBook = null;

        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery()){

            ps.setInt(1, id);

            if(!result.next()){
                throw new IllegalArgumentException("[ERROR] Book don't found in database.");
            }

            foundedBook = new Book(
                    result.getString("title"),
                    result.getString("author"),
                    result.getString("description"),
                    result.getDate("date")
            );

            foundedBook.setBookIdFromDataBase(result.getInt("bookId"));

        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to access client data.");
        }

        return foundedBook;
    }
}
