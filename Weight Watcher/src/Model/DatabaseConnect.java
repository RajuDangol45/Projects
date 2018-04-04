package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {
    
    private static Connection connection;
    private static String userName="root";
    private static String password="";
    private static String url="jdbc:mysql://localhost/ADI_raju00168589_19c";
    
    private DatabaseConnect(){}
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,userName,password);
            return connection;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
