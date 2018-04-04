package View;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EnterInformation extends JFrame{
    
    private JPanel form;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    JLabel requestName;
    JLabel requestValue;
    JTextField name1;
    JTextField value;
    JButton submit;
    String weight;
    String waistSize;
    JTable tableOfValues;
    JButton add;
    JButton delete;
    JButton save;
    JLabel note;
    
    public EnterInformation(){
        form = new JPanel();
        setLayout(new FlowLayout());
        add(form);
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        form.setLayout(gbl);
        requestName = new JLabel();
        requestValue = new JLabel();
        submit = new JButton("Submit");
        name1 = new JTextField();
        value = new JTextField();
        setSize(500, 120);
        setLocation(300,150);
        tableOfValues = new JTable();
        tableOfValues.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        save = new JButton();
        delete = new JButton();
        add = new JButton();
        note = new JLabel();
        note.setText("Click on the cell you want to edit and click save after the edit is complete");
    }
    
    public void buildEnterExercise(){
        setTitle("Enter Exercise");
        requestName.setText("Enter the name of exercise");
        requestValue.setText("Enter the minutes you undertook the exercise");
        gbc.ipadx=20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        form.add(requestName,gbc);
        gbc.ipadx=200;
        gbc.gridwidth=2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        form.add(name1,gbc);
        gbc.ipadx=20;
        gbc.gridwidth=1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        form.add(requestValue,gbc);
        gbc.ipadx=200;
        gbc.gridwidth=2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        form.add(value,gbc);
        gbc.ipadx=20;
        gbc.gridwidth=1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        form.add(submit,gbc);
    }
    
    public void buildEnterMeal(){
        setTitle("Enter Meal");
        requestName.setText("Enter the name of meal");
        requestValue.setText("Enter the minutes you undertook the meal");
        gbc.ipadx=20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        form.add(requestName,gbc);
        gbc.ipadx=200;
        gbc.gridwidth=2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        form.add(name1,gbc);
        gbc.ipadx=20;
        gbc.gridwidth=1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        form.add(requestValue,gbc);
        gbc.ipadx=200;
        gbc.gridwidth=2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        form.add(value,gbc);
        gbc.ipadx=20;
        gbc.gridwidth=1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        form.add(submit,gbc);
    }
    
    public String buildEnterWeight(){
        String weight = JOptionPane.showInputDialog("Please enter your weight.");
        return weight;
    }
    
    public String buildEnterWaistSize(){
        String waistSize = JOptionPane.showInputDialog("Please enter your waist-size.");
        return waistSize;
    }
    
    public void buildViewMeals(ArrayList<String> meals, ArrayList<String> caloriesPerGram){
        setTitle("Configure Meals");
        add.setText("Add meal");
        delete.setText("Delete meal");
        save.setText("Save meals");
        String[] columnNames = {"Meal","Calorie per gram"};
        Object[][] values = new Object[meals.size()][];
        for (int i=1;i<=meals.size();i++){
            values[i-1] = new String[2];
            values[i-1][0] = meals.get(i-1);
            values[i-1][1] = caloriesPerGram.get(i-1);
        }
        tableOfValues = new JTable(values, columnNames);
        tableOfValues.getColumnModel().getColumn(0).setMinWidth(180);
        tableOfValues.getColumnModel().getColumn(1).setMinWidth(180);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=3;
        form.add(tableOfValues.getTableHeader(),gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        form.add(tableOfValues,gbc);
        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        form.add(add,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        form.add(save,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        form.add(delete,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=3;
        form.add(note,gbc);
        setSize(550, 300);
    }
    
    public void buildViewExercises(ArrayList<String> exercises, ArrayList<String> caloriesBurnedPerMinute){
        setTitle("Configure Exercises");
        add.setText("Add exercise");
        delete.setText("Delete exercise");
        save.setText("Save exercise");
        String[] columnNames = {"Exercise","Calorie burned per minute"};
        Object[][] values = new Object[exercises.size()][];
        for (int i=1;i<=exercises.size();i++){
            values[i-1] = new String[2];
            values[i-1][0] = exercises.get(i-1);
            values[i-1][1] = caloriesBurnedPerMinute.get(i-1);
        }
        tableOfValues = new JTable(values, columnNames);
        tableOfValues.getColumnModel().getColumn(0).setMinWidth(180);
        tableOfValues.getColumnModel().getColumn(1).setMinWidth(180);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=3;
        form.add(tableOfValues.getTableHeader(),gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        form.add(tableOfValues,gbc);
        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        form.add(add,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        form.add(save,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        form.add(delete,gbc);
        setSize(550, 300);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=3;
        form.add(note,gbc);
    }
    
    public void showForm(){
        setVisible(true);
    }
    
    public void hideForm(){
        setVisible(false);
    }

    public JTextField getName1() {
        return name1;
    }

    public JTextField getValue() {
        return value;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getSave() {
        return save;
    }

    public JTable getTableOfValues() {
        return tableOfValues;
    }
    
    public void repaintFrame(){
        repaint();
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(rootPane, message);
    }
    
    public String askInput(String question){
        return JOptionPane.showInputDialog(question);
    }
    
}
