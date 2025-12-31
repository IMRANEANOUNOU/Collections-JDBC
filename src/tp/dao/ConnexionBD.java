package tp.dao;
import java.sql.*;

public class ConnexionBD {
    private static String url = "jdbc:mysql://localhost:3306/testDB";
    private static String user = "root";


    public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(url,user,"");
    }
}
