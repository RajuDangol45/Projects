import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by raju on 6/13/17.
 */

public class Scores_Panel extends JPanel {
    private String[] scores={"Aces","Twos","Threes","Fours","Fives","Sixes",
        "Three of a kind","Four of a kind","Full House","Small Straight","Large Straight","Yahtzee","Chance"};
    private JButton[] scores_button=new JButton[13];
    static private JLabel[] scores_label=new JLabel[13];
    static Dices dices=new Dices();
    public void run(){
        setBackground(new Color(114, 144, 255));
        GridBagConstraints gbc=new GridBagConstraints();
        setLayout(new GridBagLayout());
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.ipady=10;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        for (int i=0;i<13;i++){
            scores_button[i]=new JButton(scores[i]);
            scores_button[i].setBackground(Color.WHITE);
            scores_button[i].setFocusPainted(false);
            if(i<6) {scores_button[i].setForeground(Color.WHITE); scores_button[i].setBackground(new Color(249, 8, 3));}
            else {scores_button[i].setForeground(Color.WHITE); scores_button[i].setBackground(new Color(0, 7, 145));}
            add(scores_button[i],gbc);
            gbc.gridy++;
        }
        gbc.gridx=1;
        gbc.gridy=0;
        for(int i=0;i<13;i++){
            scores_label[i]=new JLabel();
            scores_label[i].setFont(new Font("",Font.PLAIN,15));
            scores_label[i].setBackground(new Color(112, 125, 234));
            scores_label[i].setOpaque(true);
            scores_label[i].setText("0");
            add(scores_label[i],gbc);
            gbc.gridy++;
        }

        scores_button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the ones");
            }
        });
        scores_button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the twos");
            }
        });
        scores_button[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the threes");
            }
        });
        scores_button[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the fours");
            }
        });
        scores_button[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the fives");
            }
        });
        scores_button[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Double the sum of all the sixes");
            }
        });
        scores_button[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"If three or more die faces show the same number, you score the total of all the dice.");
            }
        });
        scores_button[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"If four or more die faces show the same number, you scores the total of all the dice.");
            }
        });
        scores_button[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"A straight is a sequence of consecutive die faces. A small straight is four consecutive faces, and scores thirty points.");
            }
        });
        scores_button[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"A large straight is a sequence of five consecutive die faces, and scores forty points.");
            }
        });
        scores_button[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"A full house consists of a set of dice that have three faces of one number and two of another.");
            }
        });
        scores_button[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"A Yahtzee is five of a kind, and scores 50 points. If you score multiple Yahtzees in a single game, each additional Yahtzee gains a bonus 100 points.");
            }
        });
        scores_button[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Can be used for any combination of dice, and simply sums up their face value and awards the total in points.");
            }
        });



    }
    public JLabel[] getJLabel(){
        return scores_label;
    }
}
