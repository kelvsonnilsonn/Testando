package LibrarySystem.Database.DataAccessFolder;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.model.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDataAccessObject {

    public void addBookInLibrary(Book book){

        String sql = "INSERT INTO books (title, author, description, date) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = ConnectDatabase.getConnection().prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getDescription());
            ps.setDate(4, book.getCreationDate());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
