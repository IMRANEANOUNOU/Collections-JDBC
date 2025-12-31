package tp.app;
import java.sql.*;
public class Test {

    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/testDB";
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("connected!");
        conn.close();
    }catch (SQLException e){
       e.printStackTrace();
    }
    }
}
