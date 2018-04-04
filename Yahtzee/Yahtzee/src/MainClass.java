/**
 * Created by raju on 6/10/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainClass {
    static public JFrame frame=new JFrame("Game");
    static private JLabel label=new JLabel("Yahtzee");
    static private JButton single_button=new JButton("Single Player");
    static private JButton multi_button=new JButton("Multi Player");
    static private JButton rules_button=new JButton("Rules");
    static private JLabel name_label=new JLabel("Raju Dangol");
    static private int numberofPlayers=0;
    static private String name;
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,520);
        frame.setLocation(300,50);
        frame.getContentPane().setBackground(new Color(114, 144, 255));
        label.setBounds(0,0,450,250);
        label.setFont(new Font("Informal Roman Regular",Font.BOLD,80));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(156, 0, 6));
        frame.add(label);
        single_button.setBounds(100,250,250,50);
        single_button.setBackground(new Color(255, 8, 0));
        single_button.setForeground(new Color(238, 238, 238));
        single_button.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(255,255,255)));
        single_button.setFocusPainted(false);
        frame.add(single_button);
        multi_button.setBounds(100,320,250,50);
        multi_button.setBackground(new Color(255, 8, 0));
        multi_button.setForeground(new Color(238, 238, 238));
        multi_button.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(255,255,255)));
        multi_button.setFocusPainted(false);
        frame.add(multi_button);
        name_label.setBounds(350,500,100,30);
        frame.add(name_label);
        frame.setVisible(true);
        multi_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                MainGame mainGame=new MainGame(2);
                mainGame.run();
            }
        });
        single_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                MainGame mainGame=new MainGame(1);
                mainGame.run();
            }
        });
    }
}
