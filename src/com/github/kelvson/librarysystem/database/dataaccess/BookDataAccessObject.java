package com.github.kelvson.librarysystem.database.dataaccess;

import com.github.kelvson.librarysystem.database.connect.ConnectDatabase;
import com.github.kelvson.librarysystem.database.dataaccess.auxiliaryfunctions.DatabaseDataAccess;
import com.github.kelvson.librarysystem.database.dataaccess.bookdatamanipulator.InsertBook;
import com.github.kelvson.librarysystem.database.dataaccess.bookdatamanipulator.RemoveBook;

import com.github.kelvson.librarysystem.model.Book;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

public class BookDataAccessObject {

    public void addBookInLibrary(Book book){

        try (Connection conn = ConnectDatabase.getConnection()){
            InsertBook.addBookInLibrary(book, conn);
        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database. " + e);
        }
    }

    public List<Book> getAllBooksFromDatabase() {
        return DatabaseDataAccess.getAllBooksFromDatabase(ConnectDatabase.getConnection());
    }

    public void removeBookFromLibrary(int id){
        try(Connection conn = ConnectDatabase.getConnection()){
            RemoveBook.removeBookFromLibrary(conn, id);
        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to connect to the database to search for books");
        }
    }
}
