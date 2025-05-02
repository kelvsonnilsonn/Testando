package LibrarySystem.Database.DataAccessFolder.BookDataManipulator;

import LibrarySystem.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBook {
    public static void addBookInLibrary(Book book, Connection conn) {

        String sql = "INSERT INTO books (title, author, description, date) VALUES (?, ?, ?, ?)";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            if(SelectBook.findBookInLibrary(conn, book.getBookId()) == null){
                throw new IllegalArgumentException("[ERROR] User already exist in database.");
            }

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getDescription());
            ps.setDate(4, book.getCreationDate());

            ps.execute();

        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to insert a new book in the database.");
        }
    }
}
