package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Dashboard {
    
    private JFrame applicationWindow;
    private JPanel dashboard;
    private JLabel headerMessage;
    private JPanel centerPanel;
    private JLabel currentWeight;
    private JLabel currentWaistSize;
    private JLabel currentWeightLabel;
    private JLabel currentWaistSizeLabel;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JButton analyseMyProgress;
    private JButton changePersonalDetails;
    private JButton enterWeight;
    private JButton enterWaistSize;
    private JButton setActivityLevelForToday;
    private JButton viewMeals;
    private JButton viewExercises;
    private JButton enterExercise;
    private JButton enterMeal;
    private JLabel note;
    
    public Dashboard(){
        applicationWindow = new JFrame("Dashboard");
        dashboard = new JPanel();
        headerMessage = new JLabel();
        centerPanel = new JPanel();
        currentWeightLabel = new JLabel("<HTML><U>Current Weight</U></HTML>");
        currentWaistSizeLabel = new JLabel("<HTML><U>Current Waist Size</U></HTML>");
        currentWeight = new JLabel("N/A");
        currentWaistSize = new JLabel("N/A");
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        analyseMyProgress = new JButton("Analyse my progress");
        changePersonalDetails = new JButton("Change my personal details");
        enterWeight = new JButton("Enter my Weight");
        enterWaistSize = new JButton("Enter my waist size");
        setActivityLevelForToday = new JButton("Set my activity level for the day");
        viewMeals = new JButton("View my meals");
        viewExercises = new JButton("View my Exercises");
        enterExercise = new JButton("Enter exercise");
        enterMeal = new JButton("Enter meal");
        
        applicationWindow.setLayout(new FlowLayout());
        dashboard.setLayout(new BorderLayout());
        centerPanel.setLayout(gbl);
    }

    public JLabel getHeaderMessage() {
        return headerMessage;
    }

    public JFrame getApplicationWindow() {
        return applicationWindow;
    }

    public JLabel getCurrentWeight() {
        return currentWeight;
    }

    public JLabel getCurrentWaistSize() {
        return currentWaistSize;
    }

    public JButton getAnalyseMyProgress() {
        return analyseMyProgress;
    }

    public JButton getChangePersonalDetails() {
        return changePersonalDetails;
    }

    public JButton getEnterWaistSize() {
        return enterWaistSize;
    }

    public JButton getSetActivityLevelForToday() {
        return setActivityLevelForToday;
    }

    public JButton getViewMeals() {
        return viewMeals;
    }

    public JButton getViewExercises() {
        return viewExercises;
    }

    public JButton getEnterExercise() {
        return enterExercise;
    }

    public JButton getEnterMeal() {
        return enterMeal;
    }
    
    public void prepareDashboard(){
        headerMessage.setFont(new Font("Times New Roman", Font.PLAIN,20));
        currentWeight.setFont(new Font("Times New Roman", Font.PLAIN,60));
        currentWeightLabel.setFont(new Font("Arial", Font.BOLD,20));
        currentWaistSizeLabel.setFont(new Font("Arial", Font.BOLD,20));
        currentWaistSize.setFont(new Font("Times New Roman", Font.PLAIN,60));
        
        headerMessage.setHorizontalAlignment(SwingConstants.CENTER);
        
        headerMessage.setBorder(new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
        
        headerMessage.setForeground(Color.blue);
        
        analyseMyProgress.setFocusPainted(false);
        changePersonalDetails.setFocusPainted(false);
        enterWeight.setFocusPainted(false);
        enterWaistSize.setFocusPainted(false);
        setActivityLevelForToday.setFocusPainted(false);
        viewMeals.setFocusPainted(false);
        viewExercises.setFocusPainted(false);
        enterExercise.setFocusPainted(false);
        enterMeal.setFocusPainted(false);
        
        applicationWindow.add(dashboard);
        dashboard.add(headerMessage,BorderLayout.NORTH);
        dashboard.add(centerPanel,BorderLayout.CENTER);
        gbc.insets = new Insets(20, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        centerPanel.add(currentWeightLabel,gbc);
        gbc.gridx=1;
        centerPanel.add(currentWaistSizeLabel,gbc);
        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=1;
        centerPanel.add(currentWeight,gbc);
        gbc.gridx=1;
        centerPanel.add(currentWaistSize,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.insets = new Insets(15, 10, 0, 10);
        centerPanel.add(analyseMyProgress,gbc);
        gbc.gridy=3;
        gbc.insets = new Insets(10, 10, 0, 10);
        centerPanel.add(changePersonalDetails,gbc);
        gbc.gridy=4;
        centerPanel.add(changePersonalDetails,gbc);
        gbc.gridy=5;
        centerPanel.add(setActivityLevelForToday,gbc);
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.weightx=0.25;
        centerPanel.add(enterExercise,gbc);
        gbc.gridx=1;
        centerPanel.add(enterMeal,gbc);
        gbc.gridx=0;
        gbc.gridy=7;
        centerPanel.add(enterWeight,gbc);
        gbc.gridx=1;
        gbc.gridy=7;
        centerPanel.add(enterWaistSize,gbc);
        gbc.gridx=0;
        gbc.gridy=8;
        centerPanel.add(viewMeals,gbc);
        gbc.gridx=1;
        gbc.gridy=8;
        centerPanel.add(viewExercises,gbc);
        
        applicationWindow.setLocation(300,100);
        applicationWindow.setSize(600,420);
        applicationWindow.setResizable(false);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void showDashboard(){
        applicationWindow.setVisible(true);
    }
    
    public void hideDashboard(){
        applicationWindow.setVisible(false);
    }
    
    public void setCurrentWeight(String weight){
        currentWeight.setText(weight);
    }
    
    public void setCurrentWaistSize(String waistSize){
        currentWaistSize.setText(waistSize);
    }

    public JButton getEnterWeight() {
        return enterWeight;
    }
    
    public void disposeDashboard(){
        applicationWindow.dispose();
    }
}
