package com.github.kelvson.librarysystem.database.dataaccess.bookdatamanipulator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveBook {
    public static void removeBookFromLibrary(Connection conn, int id){
        String sql = "DELETE FROM books WHERE bookId = ?";

        try{
            if(SelectBook.findBookInLibrary(conn, id) == null){
                throw new IllegalArgumentException("[ERROR] tried to remove a book that doesn't exist.");
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException("[ERROR] Unable to connect to the database to search for books");
        }
    }
}
