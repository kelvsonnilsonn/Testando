package LibrarySystem.Database.DataAccessFolder.AggregateFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountDataBase {
    public static int count(Connection conn, String table){

        if (!table.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            throw new IllegalArgumentException("[ERROR] Invalid table name to count.");
        }

        String sql = "SELECT COUNT(*) FROM " + table;
        int count = 0;

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet result = ps.executeQuery();

            if(result.next())
                count = result.getInt(1);

        } catch (SQLException e){
            throw new IllegalArgumentException("[ERROR] Problem counting records in table: " + table, e);
        }

        return count;
    }
}
