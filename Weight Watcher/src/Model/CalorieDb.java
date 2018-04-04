package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalorieDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    private PreparedStatement preparedStatement;
    
    public void storeCalorieValuesInDatabase(Connection connection, double caloricIntake, double caloricBurn){
        try {
            statement = connection.createStatement();
            sql = "insert into calorie(caloricIntake,caloricBurn) " + "values ("+caloricIntake+","+caloricBurn+")";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double[] getCalorieValues(Connection connection, int day){
        double caloricIntake,caloricBurn;
        double[] values = new double[2];
        try {
            statement = connection.createStatement();
            sql = "select * from calorie where day="+day;
            results = statement.executeQuery(sql);
            results.first();
            caloricIntake = results.getDouble("caloricIntake");
            caloricBurn = results.getDouble("caloricBurn");
            values[0]=caloricIntake;
            values[1]=caloricBurn;
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return values;
    }
    
    public void changeCaloricValue(Connection connection, int day, double caloricIntake, double caloricBurn){
        try {
            statement = connection.createStatement();
            sql = "update calorie set caloricIntake=?, caloricBurn=? where day=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, caloricIntake);
            preparedStatement.setDouble(2, caloricBurn);
            preparedStatement.setInt(3, day);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getNumberOfDays(Connection connection){
        int noOfDays=0;
        try {
            statement = connection.createStatement();
            sql = "select count(*) from calorie";
            results = statement.executeQuery(sql);
            results.first();
            noOfDays = results.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfDays;
    }
    
    public void addDay(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "insert into calorie(caloricIntake,caloricBurn) " + "values ("+0+","+0+")";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
