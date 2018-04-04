package View;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserDetailsView extends JDialog{
    
    private JFrame detailsWindow = new JFrame("User Details");
    private JPanel mainPanel = new JPanel();
    private JLabel instruction = new JLabel();
    private JLabel userNameLabel = new JLabel("Username:");
    private JLabel userAgeLabel = new JLabel("Age:");
    private JLabel userGenderLabel = new JLabel("Gender:");
    private JTextField userName = new JTextField();
    private JTextField userAge = new JTextField();
    String[] genderOptions = {"Male","Female"};
    private JComboBox userGender = new JComboBox(genderOptions);
    private GridBagLayout layoutManager = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button submit = new Button("Submit");
    
    public UserDetailsView(boolean firstRun) throws InterruptedException{
        
        super((Window)null);
        setModal(true);
        
        setLayout(new FlowLayout());
        mainPanel.setLayout(layoutManager);
        add(mainPanel);
        
        instruction.setText("Please enter your name, gender and age in years.");
        instruction.setFont(new Font("Times New Roman",Font.BOLD,20));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 15, 0);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        mainPanel.add(instruction,gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.ipady=10;
        gbc.ipadx=30;
        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=1;
        mainPanel.add(userNameLabel,gbc);
        gbc.ipadx=120;
        gbc.gridx=1;
        gbc.gridy=1;
        mainPanel.add(userName,gbc);
        gbc.ipadx=30;
        gbc.gridx=0;
        gbc.gridy=2;
        mainPanel.add(userGenderLabel,gbc);
        gbc.ipadx=120;
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.ipadx=120;
        mainPanel.add(userGender,gbc);
        gbc.ipadx=30;
        gbc.gridx=0;
        gbc.gridy=3;
        mainPanel.add(userAgeLabel,gbc);
        gbc.ipadx=120;
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.ipadx=120;
        mainPanel.add(userAge,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.ipadx=60;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.gridwidth=1;
        mainPanel.add(submit,gbc);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setSize(435,280);
        setLocationRelativeTo(null);
        setResizable(false);
        if(firstRun){
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we){
                    System.exit(0);
                }
            });
        }
    }

    public JTextField getUserName() {
        return userName;
    }

    public JTextField getUserAge() {
        return userAge;
    }

    public JComboBox getUserGender() {
        return userGender;
    }

    public Button getSubmit() {
        return submit;
    }
    
    public void showUserDetailsView(){
        setVisible(true);
    }
}
