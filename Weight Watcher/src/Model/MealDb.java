package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MealDb {
    
    private Statement statement;
    private String sql;
    private ResultSet results;
    
    public boolean mealExists(Connection connection,String name){
        try {
            statement = connection.createStatement();
            sql = "select * from meal where name='"+name+"'";
            results = statement.executeQuery(sql);
            if (!results.next()){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public ArrayList<String> getMeals(Connection connection){
        ArrayList<String> meals = new ArrayList<>();
        try {
            statement = connection.createStatement();
            sql = "select * from meal";
            results = statement.executeQuery(sql);
            while(results.next()){
                meals.add(results.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meals;
    }
    
    public ArrayList<String> getCaloriesPerGram(Connection connection){
        ArrayList<String> meals = new ArrayList<>();
        try {
            statement = connection.createStatement();
            sql = "select * from meal";
            results = statement.executeQuery(sql);
            while(results.next()){
                meals.add(results.getString("calorie_per_gram"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meals;
    }
    
    public double getCalorieGainedPerGram(Connection connection, String name){
        double caloriesGainedPerGram = 0;
        try {
            statement = connection.createStatement();
            sql = "select * from meal where name="+"'"+name+"'";
            results = statement.executeQuery(sql);
            results.first();
            caloriesGainedPerGram = results.getDouble("calorie_per_gram");
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caloriesGainedPerGram;
    }
    
    public void truncateTable(Connection connection){
        try {
            statement = connection.createStatement();
            sql = "truncate table meal";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MealDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addMeal(Connection connection,String meal,String caloriesPerGram){
        try {
            statement = connection.createStatement();
            sql = "insert into meal values"+"('"+meal+"','"+caloriesPerGram+"')";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            return true;
        }
        return false;
    }
    
    public void deleteMeal(Connection connection, String mealName){
        try {
            statement = connection.createStatement();
            sql = "delete from meal where name="+"'"+mealName+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
