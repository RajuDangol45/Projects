package Model;

public class User {
    
    private String name;
    private String gender;
    private int age;
    private double currentWeight;
    private double currentWaistSize;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getCurrentWaistSize() {
        return currentWaistSize;
    }

    public void setCurrentWaistSize(double currentWaistSize) {
        this.currentWaistSize = currentWaistSize;
    }
    
}
