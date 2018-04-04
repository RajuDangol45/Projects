package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    
    public void storeUserDetailsInDatabase(Connection connection, String username, String gender, int age){
        try {
            statement = connection.createStatement();
            sql = "truncate table user";
            statement.executeUpdate(sql);
            sql = "insert into user " + "values ('"+username+"','"+gender+"',"+age+")";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean userExists(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "select * from user";
            results = statement.executeQuery(sql);
            if (!results.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public String getUserName(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "select * from user";
            results = statement.executeQuery(sql);
            results.first();
            return results.getString("name");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getUserGender(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "select * from user";
            results = statement.executeQuery(sql);
            results.first();
            return results.getString("gender");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getUserAge(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "select * from user";
            results = statement.executeQuery(sql);
            results.first();
            return Integer.parseInt(results.getString("age"));
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
