package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaistSizeDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    private PreparedStatement preparedStatement;
    
    public double getLastWaistSize(Connection connection){
        double lastWaistSize=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from waist_size";
            results = statement.executeQuery(sql);
            results.first();
            lastWaistSize = results.getDouble("last_waist_size_provided");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastWaistSize;
    }
    
    public int getNumberOfDays(Connection connection){
        int noOfDays=0;
        try {
            statement = connection.createStatement();
            sql = "select count(*) from waist_size";
            results = statement.executeQuery(sql);
            results.first();
            noOfDays = results.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfDays;
    }
    
    public double getMorningWaistSize(Connection connection){
        double waistSize=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from waist_size";
            results = statement.executeQuery(sql);
            results.first();
            waistSize = results.getDouble("waist_size_in_the_morning");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return waistSize;
    }
    
    public double getEveningWaistSize(Connection connection){
        double waistSize=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from waist_size";
            results = statement.executeQuery(sql);
            results.first();
            waistSize = results.getDouble("waist_size_in_the_evening");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return waistSize;
    }
    
    public void setMorningWaistSize(Connection connection, double waistSize){
        try {
            statement = connection.createStatement();
            sql = "update waist_size set waist_size_in_the_morning=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, waistSize);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setEveningWaistSize(Connection connection, double waistSize){
        try {
            statement = connection.createStatement();
            sql = "update waist_size set waist_size_in_the_evening=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, waistSize);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLastWaistSize(Connection connection, double waistSize){
        try {
            statement = connection.createStatement();
            sql = "update waist_size set last_waist_size_provided=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, waistSize);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
