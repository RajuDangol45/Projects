package Controller;

import Model.CalorieDb;
import Model.DailyRecordDb;
import Model.DatabaseConnect;
import Model.Exercise;
import Model.ExerciseDb;
import Model.Meal;
import Model.MealDb;
import Model.User;
import Model.UserDb;
import Model.WaistSizeDb;
import Model.WeightDb;
import View.Activities;
import View.Dashboard;
import View.EnterInformation;
import View.UserDetailsView;
import View.WeightChart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ITPL
 */
public class Controller {
    
    private Connection dbConnection;
    private User user;
    private UserDb userDb = new UserDb();
    private Activities activities;
    private CalorieDb calorieDb;
    private DailyRecordDb dailyRecordDb;
    private WeightDb weightDb;
    private WeightChart weightChart;
    private UserDetailsView userDetailsView;
    private EnterInformation enterInformation;
    private MealDb mealDb;
    private ExerciseDb exerciseDb;
    private WaistSizeDb waistSizeDb;
    private Dashboard dashboard;
    private JButton launch;
    private Exercise exercise;
    private Meal meal;
    private boolean morningWeight;
    private boolean morningWaistSize;
    
    public Controller(User user,Boolean userExists) throws InterruptedException {
        if(userExists){
            this.user = user;
            dbConnection = DatabaseConnect.getConnection();
        }
        else{
            this.user = user;
            dbConnection = DatabaseConnect.getConnection();
            userDb.storeUserDetailsInDatabase(dbConnection, user.getName(), user.getGender(), user.getAge());
        }
        activities = new Activities();
        calorieDb = new CalorieDb();
        dailyRecordDb = new DailyRecordDb();
        weightDb = new WeightDb();
        weightChart= new WeightChart();
        enterInformation = new EnterInformation();
        mealDb = new MealDb();
        exerciseDb = new ExerciseDb();
        waistSizeDb = new WaistSizeDb();
        dashboard = new Dashboard();
        launch = new JButton();
        morningWeight = true;
        morningWaistSize = true;
    }
    
    public void run(){
        launch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dashboard.prepareDashboard();
                dashboard.getHeaderMessage().setText("Hello "+user.getName()+", what would you like to do?");
                dashboard.getCurrentWeight().setText(""+user.getCurrentWeight());
                dashboard.getCurrentWaistSize().setText(""+user.getCurrentWaistSize());
                dashboard.getApplicationWindow().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we){
                        DatabaseConnect.closeConnection();
                    }
                });
                dashboard.showDashboard();
                dashboard.getAnalyseMyProgress().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        activities = new Activities();
                        ArrayList<Double> caloricIntakes = new ArrayList();
                        ArrayList<Double> caloricBurns = new ArrayList();
                        ArrayList<Double> caloricDifferences = new ArrayList();
                        double caloricDifference;
                        for(int i=0;i<dailyRecordDb.getNumberOfDays(dbConnection);i++){
                            double[] values = calorieDb.getCalorieValues(dbConnection, i+1);
                            caloricIntakes.add(values[0]);
                            caloricBurns.add(values[1]);
                            caloricDifference = caloricIntakes.get(i)-caloricBurns.get(i);
                            caloricDifferences.add(caloricDifference);
                        }

                        double averageWeightloss = 0;
                        ArrayList<Double> weightDifferences =new ArrayList();
                        double sumOfWeightDifferences = 0;
                        for(int i=1;i<weightDb.getNumberOfDays(dbConnection);i++){
                            double weight1 = weightDb.getWeight(dbConnection, i);
                            double weight2 = weightDb.getWeight(dbConnection, i+1);
                            double differenceInWeight = weight2-weight1;
                            weightDifferences.add(differenceInWeight);
                        }
                        for(int i=0;i<weightDifferences.size();i++){
                            sumOfWeightDifferences = weightDifferences.get(i)+sumOfWeightDifferences;
                        }
                        averageWeightloss = sumOfWeightDifferences/weightDifferences.size();

                        double weightInTheBeginning = weightDb.getWeight(dbConnection, 1);
                        double weightNow = weightDb.getWeight(dbConnection, weightDb.getNumberOfDays(dbConnection));
                        double weightChangeSinceBeginning = weightNow - weightInTheBeginning;

                        String activityLevel = dailyRecordDb.getAcvitiyLevel(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection));
                        double calorieIntakeRequired = 0;
                        switch (activityLevel){
                            case "INACTIVE":
                                if(user.getGender().equals("Male")){
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*5;
                                }
                                else{
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*4;
                                }
                                break;
                            case "MODERATELY_ACTIVE":
                                if(user.getGender().equals("Male")){
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*6;
                                }
                                else{
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*5;
                                }
                                break;
                            case "ACTIVE":
                                if(user.getGender().equals("Male")){
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*7.5;
                                }
                                else{
                                    calorieIntakeRequired = dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))*6;
                                }
                                break;
                        }

                        ArrayList<Double> weights = new ArrayList<>();
                        for (int i=1; i<=weightDb.getNumberOfDays(dbConnection);i++){
                            weights.add(weightDb.getWeight(dbConnection, i));
                        }

                        activities.buildActivitiesPanel(averageWeightloss, weightChangeSinceBeginning, weightChart.getWeightChart(weights), caloricIntakes, caloricBurns, caloricDifferences, calorieIntakeRequired);
                        activities.showActivitiesPanel();
                    }
                });
                dashboard.getChangePersonalDetails().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            userDetailsView = new UserDetailsView(false);
                            userDetailsView.getUserName().setText(user.getName());
                            if(user.getGender().equals("Male")){
                                userDetailsView.getUserGender().setSelectedIndex(0);
                            }
                            else{
                                userDetailsView.getUserGender().setSelectedIndex(0);
                            }
                            userDetailsView.getUserAge().setText(""+user.getAge());
                            userDetailsView.getSubmit().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    user.setName(userDetailsView.getUserName().getText());
                                    user.setAge(Integer.parseInt(userDetailsView.getUserAge().getText()));
                                    user.setGender(userDetailsView.getUserGender().getSelectedItem().toString());
                                    userDb.storeUserDetailsInDatabase(dbConnection, user.getName(), user.getGender(), user.getAge());
                                    dashboard.hideDashboard();
                                    dashboard = new Dashboard();
                                    launch.doClick();
                                }
                            });
                            userDetailsView.showUserDetailsView();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                dashboard.getSetActivityLevelForToday().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        activities = new Activities();
                        activities.buildActivitiesPanel();
                        activities.showActivitiesPanel();
                        activities.getSubmitActivityLevel().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                dailyRecordDb.setActivityLevel(dbConnection, activities.getActivitiesLevel().getSelectedItem().toString());
                            }
                        });
                    }
                });
                dashboard.getEnterExercise().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        enterInformation.buildEnterExercise();
                        enterInformation.showForm();
                        enterInformation.getSubmit().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterInformation.hideForm();
                                exercise = new Exercise(enterInformation.getName1().getText());
                                exercise.setMinutesOfExercise(Integer.parseInt(enterInformation.getValue().getText()));
                                boolean exerciseExists = exerciseDb.exerciseExists(dbConnection, exercise.getExerciseType());
                                if(exerciseExists){
                                    exercise.setCaloriesBurnedPerMinute(exerciseDb.getCalorieBurnedPerMinute(dbConnection, exercise.getExerciseType()));
                                    exercise.setCaloriesBurned(exercise.getCaloriesBurnedPerMinute()*exercise.getMinutesOfExercise());
                                    double[] calorieValues = calorieDb.getCalorieValues(dbConnection, calorieDb.getNumberOfDays(dbConnection));
                                    double caloricIntake = calorieValues[0];
                                    double calorieBurn = calorieValues[1];
                                    calorieDb.changeCaloricValue(dbConnection, calorieDb.getNumberOfDays(dbConnection),caloricIntake, calorieBurn+exercise.getCaloriesBurned());
                                }
                                else{
                                    String caloricBurnPerMinute=enterInformation.askInput("Please provide caloric burn per minute");
                                    exercise.setCaloriesBurnedPerMinute(Integer.parseInt(caloricBurnPerMinute));
                                    exercise.setCaloriesBurned(exercise.getCaloriesBurnedPerMinute()*exercise.getMinutesOfExercise());
                                    double[] calorieValues = calorieDb.getCalorieValues(dbConnection, calorieDb.getNumberOfDays(dbConnection));
                                    double caloricIntake = calorieValues[0];
                                    double calorieBurn = calorieValues[1];
                                    calorieDb.changeCaloricValue(dbConnection, calorieDb.getNumberOfDays(dbConnection),caloricIntake, calorieBurn+exercise.getCaloriesBurned());
                                    exerciseDb.addExercise(dbConnection, exercise.getExerciseType(), caloricBurnPerMinute);
                                }
                            }
                        });
                    }
                });
                dashboard.getEnterMeal().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        enterInformation.buildEnterMeal();
                        enterInformation.showForm();
                        enterInformation.getSubmit().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterInformation.hideForm();
                                meal = new Meal(enterInformation.getName1().getText());
                                meal.setPortionSize(Integer.parseInt(enterInformation.getValue().getText()));
                                boolean mealExists = mealDb.mealExists(dbConnection, meal.getMealName());
                                if(mealExists){
                                    meal.setCaloriesGainedPerMinute(mealDb.getCalorieGainedPerGram(dbConnection, meal.getMealName()));
                                    meal.setCaloriesGained(meal.getCaloriesGainedPerMinute()*meal.getPortionSize());
                                    double[] calorieValues = calorieDb.getCalorieValues(dbConnection, calorieDb.getNumberOfDays(dbConnection));
                                    double caloricIntake = calorieValues[0];
                                    double calorieBurn = calorieValues[1];
                                    calorieDb.changeCaloricValue(dbConnection, calorieDb.getNumberOfDays(dbConnection),caloricIntake+meal.getCaloriesGained(), calorieBurn);
                                }
                                else{
                                    String caloricGainPerMinute=enterInformation.askInput("Please provide caloric gain per gram");
                                    meal.setCaloriesGainedPerMinute(Integer.parseInt(caloricGainPerMinute));
                                    meal.setCaloriesGained(meal.getCaloriesGainedPerMinute()*meal.getPortionSize());
                                    double[] calorieValues = calorieDb.getCalorieValues(dbConnection, calorieDb.getNumberOfDays(dbConnection));
                                    double caloricIntake = calorieValues[0];
                                    double calorieBurn = calorieValues[1];
                                    calorieDb.changeCaloricValue(dbConnection, calorieDb.getNumberOfDays(dbConnection),caloricIntake+meal.getCaloriesGained(), calorieBurn);
                                    mealDb.addMeal(dbConnection, meal.getMealName(), caloricGainPerMinute);
                                }
                            }
                        });
                    }
                });
                dashboard.getEnterWeight().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        String weight;
                        weight = enterInformation.buildEnterWeight();
                        if(weight!=null){
                            boolean dayCompleted = checkDayCompletion();
                            if(morningWeight){
                                weightDb.setMorningWeight(dbConnection, Double.parseDouble(weight));
                                weightDb.setLastWeight(dbConnection, Double.parseDouble(weight));
                            }
                            else{
                                weightDb.setEveningWeight(dbConnection, Double.parseDouble(weight));
                                weightDb.setLastWeight(dbConnection, Double.parseDouble(weight));
                                weightDb.addWeight(dbConnection, (weightDb.getMorningWeight(dbConnection)+weightDb.getEveningWeight(dbConnection))/2);
                                dailyRecordDb.setWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection), (weightDb.getMorningWeight(dbConnection)+weightDb.getEveningWeight(dbConnection))/2);
                            }
                            morningWeight = !morningWeight;
                            if(dayCompleted){
                                calorieDb.addDay(dbConnection);
                                dailyRecordDb.addDay(dbConnection);
                            }
                            user.setCurrentWeight(Double.parseDouble(weight));
                            dashboard.hideDashboard();
                            dashboard.disposeDashboard();
                            dashboard = new Dashboard();
                            launch.doClick();
                        }
                    }
                });
                dashboard.getEnterWaistSize().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        String waistSize;
                        waistSize = enterInformation.buildEnterWaistSize();
                        if(waistSize!=null){
                            boolean dayCompleted = checkDayCompletion();
                            if(morningWaistSize){
                                waistSizeDb.setMorningWaistSize(dbConnection, Double.parseDouble(waistSize));
                                waistSizeDb.setLastWaistSize(dbConnection, Double.parseDouble(waistSize));
                            }
                            else{
                                waistSizeDb.setEveningWaistSize(dbConnection, Double.parseDouble(waistSize));
                                waistSizeDb.setLastWaistSize(dbConnection, Double.parseDouble(waistSize));
                                dailyRecordDb.setWaistSize(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection), (waistSizeDb.getMorningWaistSize(dbConnection)+waistSizeDb.getEveningWaistSize(dbConnection))/2);
                            }
                            morningWaistSize = !morningWaistSize;
                            if(dayCompleted){
                                calorieDb.addDay(dbConnection);
                                dailyRecordDb.addDay(dbConnection);
                            }
                            user.setCurrentWaistSize(Double.parseDouble(waistSize));
                            dashboard.hideDashboard();
                            dashboard.disposeDashboard();
                            dashboard = new Dashboard();
                            launch.doClick();
                        }
                    }
                });
                dashboard.getViewExercises().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        enterInformation.buildViewExercises(exerciseDb.getExercises(dbConnection),exerciseDb.getCaloriesBurnedPerMinute(dbConnection));
                        enterInformation.showForm();
                        enterInformation.getSave().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterInformation.getTableOfValues().getCellEditor(enterInformation.getTableOfValues().getSelectedRow(), enterInformation.getTableOfValues().getSelectedColumn()).stopCellEditing();
                                boolean exerciseConflict=false;
                                ArrayList<String> exerciseNames = new ArrayList<>();
                                ArrayList<String> calorieBurnedPerMinute = new ArrayList<>();
                                exerciseDb.truncateTable(dbConnection);
                                for (int i=1;i<=enterInformation.getTableOfValues().getRowCount();i++){
                                    exerciseNames.add(enterInformation.getTableOfValues().getValueAt(i-1, 0).toString());
                                    calorieBurnedPerMinute.add(enterInformation.getTableOfValues().getValueAt(i-1, 1).toString());
                                    exerciseConflict = exerciseDb.addExercise(dbConnection, exerciseNames.get(i-1), calorieBurnedPerMinute.get(i-1));
                                    if(exerciseConflict){
                                        enterInformation.showMessage("Exercise '"+exerciseNames.get(i-1)+"' already exists");
                                    }
                                }
                            }
                        });
                        enterInformation.getDelete().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String exerciseName = enterInformation.getTableOfValues().getValueAt(enterInformation.getTableOfValues().getSelectedRow(), 0).toString();
                                exerciseDb.deleteExercise(dbConnection, exerciseName);
                                enterInformation.hideForm();
                                dashboard.getViewExercises().doClick();
                            }
                        });
                        enterInformation.getAdd().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String exerciseName = enterInformation.askInput("Enter exercise name");
                                String calorieBurnedPerMinute = enterInformation.askInput("Enter caloriePerMinute");
                                if(exerciseDb.exerciseExists(dbConnection, exerciseName)){
                                    enterInformation.showMessage("Please enter a different exercise name");
                                }
                                else{
                                    exerciseDb.addExercise(dbConnection, exerciseName, calorieBurnedPerMinute);
                                    enterInformation.hideForm();
                                    dashboard.getViewExercises().doClick();
                                }
                            }
                        });
                    }
                });
                dashboard.getViewMeals().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterInformation = new EnterInformation();
                        enterInformation.buildViewMeals(mealDb.getMeals(dbConnection),mealDb.getCaloriesPerGram(dbConnection));
                        enterInformation.showForm();
                        enterInformation.getSave().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                enterInformation.getTableOfValues().getCellEditor(enterInformation.getTableOfValues().getSelectedRow(), enterInformation.getTableOfValues().getSelectedColumn()).stopCellEditing();
                                boolean mealConflict=false;
                                ArrayList<String> mealNames = new ArrayList<>();
                                ArrayList<String> caloriePerGram = new ArrayList<>();
                                mealDb.truncateTable(dbConnection);
                                for (int i=1;i<=enterInformation.getTableOfValues().getRowCount();i++){
                                    mealNames.add(enterInformation.getTableOfValues().getValueAt(i-1, 0).toString());
                                    caloriePerGram.add(enterInformation.getTableOfValues().getValueAt(i-1, 1).toString());
                                    mealConflict = mealDb.addMeal(dbConnection, mealNames.get(i-1), caloriePerGram.get(i-1));
                                    if(mealConflict){
                                        enterInformation.showMessage("Meal '"+mealNames.get(i-1)+"' already exists");
                                    }
                                }
                            }
                        });
                        enterInformation.getDelete().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String mealName = enterInformation.getTableOfValues().getValueAt(enterInformation.getTableOfValues().getSelectedRow(), 0).toString();
                                mealDb.deleteMeal(dbConnection, mealName);
                                enterInformation.hideForm();
                                dashboard.getViewMeals().doClick();
                            }
                        });
                        enterInformation.getAdd().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String mealName = enterInformation.askInput("Enter meal name");
                                String caloriePerGram = enterInformation.askInput("Enter caloriePerGram");
                                if(mealDb.mealExists(dbConnection, mealName)){
                                    enterInformation.showMessage("Please enter a different meal name");
                                }
                                else{
                                    mealDb.addMeal(dbConnection, mealName, caloriePerGram);
                                    enterInformation.hideForm();
                                    dashboard.getViewMeals().doClick();
                                }
                            }
                        });
                    }
                });
            }
        });
        launch.doClick();
    }
    
    public boolean checkDayCompletion(){
        if(dailyRecordDb.getWeight(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))!=0 && dailyRecordDb.getWaistSize(dbConnection, dailyRecordDb.getNumberOfDays(dbConnection))!=0){
            return true;
        }
        return false;
    }
}
