package LibrarySystem.Database.DataAccessFolder;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.model.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDataAccessObject {

    public void addBookInLibrary(Book book){

        String sql = "INSERT INTO books (bookId, titulo, autor, descricao, dataDeCriacao) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = ConnectDatabase.getConnection().prepareStatement(sql);
            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getDescription());
            ps.setDate(5, book.getCreationDate());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
