package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExerciseDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    
    public boolean exerciseExists(Connection connection,String name){
        try {
            statement = connection.createStatement();
            sql = "select * from exercise where name='"+name+"'";
            results = statement.executeQuery(sql);
            if (!results.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public ArrayList<String> getExercises(Connection connection){
        ArrayList<String> exercises = new ArrayList<>();
        try {
            statement = connection.createStatement();
            sql = "select * from exercise";
            results = statement.executeQuery(sql);
            while(results.next()){
                exercises.add(results.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exercises;
    }
    
    public ArrayList<String> getCaloriesBurnedPerMinute(Connection connection){
        ArrayList<String> caloriesBurnedPerMinute = new ArrayList<>();
        try {
            statement = connection.createStatement();
            sql = "select * from exercise";
            results = statement.executeQuery(sql);
            while(results.next()){
                caloriesBurnedPerMinute.add(results.getString("calories_burned_per_minute"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caloriesBurnedPerMinute;
    }
    
    public double getCalorieBurnedPerMinute(Connection connection, String name){
        double caloriesBurnedPerMinute = 0;
        try {
            statement = connection.createStatement();
            sql = "select * from exercise where name="+"'"+name+"'";
            results = statement.executeQuery(sql);
            results.first();
            caloriesBurnedPerMinute = results.getDouble("calories_burned_per_minute");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caloriesBurnedPerMinute;
    }
    
    public void truncateTable(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "truncate table exercise";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MealDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addExercise(Connection connection,String exercise,String caloriesBurnedPerMinute){
        try {
            statement = connection.createStatement();
            sql = "insert into exercise values"+"('"+exercise+"','"+caloriesBurnedPerMinute+"')";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            return true;
        }
        return false;
    }
    
    public void deleteExercise(Connection connection, String exerciseName){
        try {
            statement = connection.createStatement();
            sql = "delete from exercise where name="+"'"+exerciseName+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
