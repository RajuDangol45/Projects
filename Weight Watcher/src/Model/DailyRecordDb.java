package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyRecordDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    private PreparedStatement preparedStatement;
    
    public int getNumberOfDays(Connection connection){
        int noOfDays=0;
        try {
            statement = connection.createStatement();
            sql = "select count(*) from dailyrecord";
            results = statement.executeQuery(sql);
            results.first();
            noOfDays = results.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noOfDays;
    }
    
    public String getAcvitiyLevel(Connection connection, int day){
        String activityLevel = "";
        try {
            statement = connection.createStatement();
            sql = "select * from dailyrecord where day="+day;
            results = statement.executeQuery(sql);
            results.first();
            activityLevel = results.getString("activity_level");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activityLevel;
    }
    
    public double getWeight(Connection connection, int day){
        double weight = 0;
        try {
            statement = connection.createStatement();
            sql = "select * from dailyrecord where day="+day;
            results = statement.executeQuery(sql);
            results.first();
            weight = results.getDouble("weight");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weight;
    }
    
    public double getWaistSize(Connection connection, int day){
        double waistSize = 0;
        try {
            statement = connection.createStatement();
            sql = "select * from dailyrecord where day="+day;
            results = statement.executeQuery(sql);
            results.first();
            waistSize = results.getDouble("waist_size");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return waistSize;
    }
    
    public void setActivityLevel(Connection connection,String activityLevel){
        try {
            statement = connection.createStatement();
            sql = "update dailyrecord set activity_level=? where day=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, activityLevel);
            preparedStatement.setInt(2, getNumberOfDays(connection));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addDay(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "insert into dailyrecord(activity_level,weight,waist_size) " + "values ('INACTIVE',"+0+","+0+")";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setWeight(Connection connection, int day,double weight){
        try {
            statement = connection.createStatement();
            sql = "update dailyrecord set weight=? where day=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, weight);
            preparedStatement.setInt(2, day);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setWaistSize(Connection connection, int day,double waistSize){
        try {
            statement = connection.createStatement();
            sql = "update dailyrecord set waist_size=? where day=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, waistSize);
            preparedStatement.setInt(2, day);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
