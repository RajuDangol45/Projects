package Model;

public class Meal {
    
    private String mealName;
    private int portionSize;
    private double caloriesGained;
    private double caloriesGainedPerMinute;

    public Meal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(int portionSize) {
        this.portionSize = portionSize;
    }

    public double getCaloriesGained() {
        return caloriesGained;
    }

    public void setCaloriesGained(double caloriesGained) {
        this.caloriesGained = caloriesGained;
    }

    public double getCaloriesGainedPerMinute() {
        return caloriesGainedPerMinute;
    }

    public void setCaloriesGainedPerMinute(double caloriesGainedPerMinute) {
        this.caloriesGainedPerMinute = caloriesGainedPerMinute;
    }
    
}
