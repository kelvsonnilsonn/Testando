package LibrarySystem.Database.ConnectFolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String user = "root";
    private static final String password = "@Kel851762";

    private static Connection conn;

    public static Connection getConnection(){
        try {
            if(conn != null){
                return conn;
            }

            conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
