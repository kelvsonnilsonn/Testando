package LibrarySystem.Database.DataAccessFolder;

import LibrarySystem.Database.ConnectFolder.ConnectDatabase;
import LibrarySystem.Database.DataAccessFolder.BookDataManipulator.InsertBook;
import LibrarySystem.Database.DataAccessFolder.BookDataManipulator.RemoveBook;
import LibrarySystem.Database.DataAccessFolder.BookDataManipulator.SelectBook;
import LibrarySystem.Database.DataUI.BookDataPrinter;

import LibrarySystem.model.Book;

import java.sql.Connection;
import java.sql.SQLException;

public class BookDataAccessObject {

    public void addBookInLibrary(Book book){

        try (Connection conn = ConnectDatabase.getConnection()){
            InsertBook.addBookInLibrary(book, conn);
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database. " + e);
        }
    }

    public void removeBookFromLibrary(int id){
        try(Connection conn = ConnectDatabase.getConnection()){
            RemoveBook.removeBookFromLibrary(conn, id);
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database to search for books");
        }
    }

    public Book searchBookInLibrary(int id){
        Book foundedBook = null;

        try (Connection conn = ConnectDatabase.getConnection();){
            foundedBook = SelectBook.findBookInLibrary(conn, id);
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database to search for books");
        }

        return foundedBook;
    }
}
