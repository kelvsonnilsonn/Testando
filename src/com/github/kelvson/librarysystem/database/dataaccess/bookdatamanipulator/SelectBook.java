package com.github.kelvson.librarysystem.database.dataaccess.bookdatamanipulator;

import com.github.kelvson.librarysystem.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectBook {
    public static Book findBookInLibrary(Connection conn, int id){
        String sql = "SELECT * FROM books WHERE bookId = ?";

        Book foundedBook = null;

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if(!result.next()){
                return foundedBook;
            }

            foundedBook = new Book(
                    result.getString("title"),
                    result.getString("author"),
                    result.getString("description"),
                    result.getDate("date")
            );

            foundedBook.setBookIdFromDataBase(result.getInt("bookId"));

        } catch (SQLException e){
            throw new RuntimeException("[ERROR] Unable to access book data.");
        }

        return foundedBook;
    }
}
