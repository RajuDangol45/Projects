package Model;

public class Exercise {
    
    private String exerciseType;
    private int minutesOfExercise;
    private double caloriesBurned;
    private double caloriesBurnedPerMinute;

    public Exercise(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getMinutesOfExercise() {
        return minutesOfExercise;
    }

    public void setMinutesOfExercise(int minutesOfExercise) {
        this.minutesOfExercise = minutesOfExercise;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public double getCaloriesBurnedPerMinute() {
        return caloriesBurnedPerMinute;
    }

    public void setCaloriesBurnedPerMinute(double caloriesBurnedPerMinute) {
        this.caloriesBurnedPerMinute = caloriesBurnedPerMinute;
    }
    
}
