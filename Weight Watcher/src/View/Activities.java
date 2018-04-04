package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Activities extends JFrame{
    
    private JPanel activitiesPanel;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JComboBox activitiesLevel;
    private JButton submitActivityLevel;
    
    public Activities(){
        activitiesPanel = new JPanel();
        setLayout(new FlowLayout());
        add(activitiesPanel);
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        activitiesPanel.setLayout(gbl);
    }
    
    public void buildActivitiesPanel(double avgWeightChange, double weightChange, JPanel lineGraph, ArrayList<Double> caloricIntake, ArrayList<Double> caloricBurn, ArrayList<Double> caloricDifference, double caloricIntakeRequired){
        JLabel avgWeightChangeLbl = new JLabel("Your average weight change is "+avgWeightChange);
        JLabel weightChangeLbl = new JLabel("Your weight change since beginning is "+weightChange +" | (+) for gain and (-) for loss");
        String[] columnNames = {"Day","Caloric intake for the day","Caloric burn for the day","Calorie gain/loss for the day"};
        Object[][] values = new Object[caloricIntake.size()][];
        for (int i=1;i<=caloricIntake.size();i++){
            values[i-1] = new String[4];
            values[i-1][0] = Integer.toString(i);
            values[i-1][1] = Double.toString(caloricIntake.get(i-1));
            values[i-1][2] = Double.toString(caloricBurn.get(i-1));
            values[i-1][3] = Double.toString(caloricDifference.get(i-1));
        }
        JTable tableOfCalorieValues= new JTable(values, columnNames);
        tableOfCalorieValues.getColumnModel().getColumn(1).setMinWidth(180);
        tableOfCalorieValues.getColumnModel().getColumn(2).setMinWidth(180);
        tableOfCalorieValues.getColumnModel().getColumn(3).setMinWidth(180);
        JLabel caloricIntakeRequiredLbl = new JLabel("Caloric intake required for today is "+caloricIntakeRequired+" cal");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(15, 0, 0, 0);
        activitiesPanel.add(avgWeightChangeLbl,gbc);
        gbc.gridy=1;
        activitiesPanel.add(weightChangeLbl,gbc);
        gbc.insets = new Insets(25, 0, 0, 0);
        gbc.gridy=2;
        activitiesPanel.add(lineGraph,gbc);
        gbc.gridy=3;
        gbc.insets = new Insets(15, 0, 0, 0);
        activitiesPanel.add(tableOfCalorieValues.getTableHeader(),gbc);
        gbc.gridy=4;
        gbc.insets = new Insets(0, 0, 0, 0);
        activitiesPanel.add(tableOfCalorieValues,gbc);
        gbc.gridy=5;
        gbc.insets = new Insets(15, 0, 0, 0);
        activitiesPanel.add(caloricIntakeRequiredLbl,gbc);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(400, 100);
        setTitle("Analysis of your progress");
    }
    
    public void buildActivitiesPanel(){
        String[] activityLevels = {"INACTIVE","MODERATELY_ACTIVE","ACTIVE"};
        activitiesLevel = new JComboBox(activityLevels);
        JLabel label = new JLabel("Set your activity level for the day.");
        submitActivityLevel= new JButton("Submit");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(20, 0, 0, 0);
        activitiesPanel.add(label,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        activitiesPanel.add(activitiesLevel,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        activitiesPanel.add(submitActivityLevel,gbc);
        setSize(300,200);
        setLocation(100, 100);
        setTitle("Set Activities Level for the day");
        submitActivityLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hideActivitiesPanel();
            }
        });
    }
    
    public void showActivitiesPanel(){
        setVisible(true);
    }
    
    public void hideActivitiesPanel(){
        setVisible(false);
    }

    public JButton getSubmitActivityLevel() {
        return submitActivityLevel;
    }

    public JComboBox getActivitiesLevel() {
        return activitiesLevel;
    }
    
}
