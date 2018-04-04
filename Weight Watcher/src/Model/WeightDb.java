package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeightDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    private PreparedStatement preparedStatement;
    
    public double getWeight(Connection connection, int day){
        double weight=0;
        try {
            statement = connection.createStatement();
            sql = "select * from weights where day="+day;
            results = statement.executeQuery(sql);
            results.first();
            weight = results.getDouble("value");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weight;
    }
    
    public int getNumberOfDays(Connection connection){
        int noOfDays=0;
        try {
            statement = connection.createStatement();
            sql = "select count(*) from weights";
            results = statement.executeQuery(sql);
            results.first();
            noOfDays = results.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfDays;
    }
    
    public double getLastWeight(Connection connection){
        double lastWeight=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from weight";
            results = statement.executeQuery(sql);
            results.first();
            lastWeight = results.getDouble("last_provided_weight");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastWeight;
    }
    
    public double getMorningWeight(Connection connection){
        double weight=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from weight";
            results = statement.executeQuery(sql);
            results.first();
            weight = results.getDouble("weight_in_the_morning");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weight;
    }
    
    public double getEveningWeight(Connection connection){
        double weight=0.0;
        try {
            statement = connection.createStatement();
            sql = "select * from weight";
            results = statement.executeQuery(sql);
            results.first();
            weight = results.getDouble("weight_in_the_evening");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weight;
    }
    
    public void setMorningWeight(Connection connection, double weight){
        try {
            statement = connection.createStatement();
            sql = "update weight set weight_in_the_morning=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, weight);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setEveningWeight(Connection connection, double weight){
        try {
            statement = connection.createStatement();
            sql = "update weight set weight_in_the_evening=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, weight);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setLastWeight(Connection connection, double weight){
        try {
            statement = connection.createStatement();
            sql = "update weight set last_provided_weight=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, weight);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addWeight(Connection connection, double weight){
        try {
            statement = connection.createStatement();
            sql = "insert into weights(value) values ("+weight+")";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
