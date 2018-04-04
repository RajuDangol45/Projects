/**
 * Created by raju on 6/13/17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dices extends JPanel{
    private String[] image_names={"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg"};
    public static JButton[] image_btn=new JButton[6];
    private boolean clicked1=false;
    private boolean clicked2=false;
    private boolean clicked3=false;
    private boolean clicked4=false;
    private boolean clicked5=false;
    static private JButton[] up_btn=new JButton[6];
    static private JButton[] down_btn=new JButton[6];
    GridBagConstraints gbc=new GridBagConstraints();
    Player_Scores player_scores=new Player_Scores();
    Player_Scores2 player_scores2=new Player_Scores2();
    JLabel lockLabel[]=player_scores.getLocklabel();
    JLabel lockLabel2[]=player_scores2.getLocklabel();
    public void run(){

        setBackground(new Color(114, 144, 255));

player_scores.run();
player_scores2.run();

        GridBagLayout gbl=new GridBagLayout();
        setLayout(gbl);
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.ipadx=-30;
        gbc.ipady=-6;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        int j=0;
        for(int i=0;i<13;i+=3){
            gbc.gridy=i;
            up_btn[j]=new JButton("▲");
            up_btn[j].setForeground(Color.WHITE);
            up_btn[j].setBorderPainted(false);
            up_btn[j].setFocusPainted(false);
            up_btn[j].setBackground(new Color(0, 125, 9));
            add(up_btn[j],gbc);
            j++;
        }
        j=0;
        gbc.gridy=0;
        for(int i=2;i<15;i+=3){
            gbc.gridy=i;
            down_btn[j]=new JButton("▼");
            down_btn[j].setBorderPainted(false);
            down_btn[j].setForeground(Color.WHITE);
            down_btn[j].setFocusPainted(false);
            down_btn[j].setBackground(new Color(147, 0, 4));
            add(down_btn[j],gbc);
            j++;
        }
        j=0;
        gbc.gridy=0;
        for(int i=1;i<14;i+=3){
            gbc.gridy=i;
            image_btn[j]=new JButton(new ImageIcon(getClass().getResource("dices images/1.jpg")));
            image_btn[j].setBorderPainted(true);
            image_btn[j].setEnabled(false);
            image_btn[j].setBackground(new Color(114, 144, 255));
            add(image_btn[j],gbc);
            j++;
        }

            up_btn[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                        String s = ((ImageIcon) image_btn[0].getIcon()).getDescription();
                        if (s.charAt(s.length() - 5) != '6') {
                            String a = "" + s.charAt(s.length() - 5);
                            int b = Integer.parseInt(a);
                            b++;
                            image_btn[0].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                            for (int i = 0; i < 5; i++) {
                                up_btn[i].setEnabled(false);
                                down_btn[i].setEnabled(false);
                            }
                        }
                    }
                    player_scores.labelsofScores();
                }
            });
        up_btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[1].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '6') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b++;
                    image_btn[1].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
                }
                player_scores.labelsofScores();
            }
        });
        up_btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[2].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '6') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b++;
                    image_btn[2].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
            }
                player_scores.labelsofScores();
            }
        });
        up_btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                    String s = ((ImageIcon) image_btn[3].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '6') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b++;
                    image_btn[3].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
            }
                player_scores.labelsofScores();
            }
        });
        up_btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[4].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '6') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b++;
                    image_btn[4].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
            }
                player_scores.labelsofScores();
            }
        });
        down_btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[1].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '1') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b--;
                    image_btn[1].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
            }
                player_scores.labelsofScores();
            }
        });
        down_btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[2].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '1') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b--;
                    image_btn[2].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }
            }
                player_scores.labelsofScores();
            }
        });
        down_btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[3].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '1') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b--;
                    image_btn[3].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }}
                player_scores.labelsofScores();
            }
        });
        down_btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[4].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '1') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b--;
                    image_btn[4].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }}
                player_scores.labelsofScores();
            }
        });
        down_btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player_scores.getRollCount() != 1 || player_scores2.getRollCount()!=1) {
                String s = ((ImageIcon) image_btn[0].getIcon()).getDescription();
                if (s.charAt(s.length() - 5) != '1') {
                    String a = "" + s.charAt(s.length() - 5);
                    int b = Integer.parseInt(a);
                    b--;
                    image_btn[0].setIcon(new ImageIcon(getClass().getResource("dices images/" + b + ".jpg")));
                    for (int i = 0; i < 5; i++) {
                        up_btn[i].setEnabled(false);
                        down_btn[i].setEnabled(false);
                    }
                }}
                player_scores.labelsofScores();
            }
        });
        image_btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked1==false){
                    image_btn[0].setBackground(Color.RED);
                   try{
                       lockLabel[0].setText("\t\uD83D\uDD12");
                   }
                   catch (NullPointerException n){
                       System.out.println(n);
                        player_scores.run();
                       lockLabel[0].setText("\t\uD83D\uDD12");
                   }
                    lockLabel2[0].setText("\t\uD83D\uDD12");
                    clicked1=true;
                }
                else {
                    clicked1=false;
                    lockLabel[0].setText("");
                    lockLabel2[0].setText("");
                    image_btn[0].setBackground(new Color(114, 144, 255));
                }
            }
        });
        image_btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked2==false){
                    image_btn[1].setBackground(Color.RED);
                    lockLabel[1].setText("\t\uD83D\uDD12");
                    lockLabel2[1].setText("\t\uD83D\uDD12");
                    clicked2=true;
                }
                else {
                    clicked2=false;
                    lockLabel[1].setText("");
                    lockLabel2[1].setText("");
                    image_btn[1].setBackground(new Color(114, 144, 255));
                }
            }
        });
        image_btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked3==false){
                    image_btn[2].setBackground(Color.RED);
                    lockLabel[2].setText("\t\uD83D\uDD12");
                    lockLabel2[2].setText("\t\uD83D\uDD12");
                    clicked3=true;
                }
                else {
                    clicked3=false;
                    lockLabel[2].setText("");
                    lockLabel2[2].setText("");
                    image_btn[2].setBackground(new Color(114, 144, 255));
                }            }
        });
        image_btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked4==false){
                    image_btn[3].setBackground(Color.RED);
                    lockLabel[3].setText("\t\uD83D\uDD12");
                    lockLabel2[3].setText("\t\uD83D\uDD12");
                    clicked4=true;
                }
                else {
                    clicked4=false;
                    lockLabel[3].setText("");
                    lockLabel2[3].setText("");
                    image_btn[3].setBackground(new Color(114, 144, 255));
                }            }
        });
        image_btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked5==false){
                    image_btn[4].setBackground(Color.RED);
                    lockLabel[4].setText("\t\uD83D\uDD12");
                    lockLabel2[4].setText("\t\uD83D\uDD12");
                    clicked5=true;
                }
                else {
                    clicked5=false;
                    lockLabel[4].setText("");
                    lockLabel2[4].setText("");
                    image_btn[4].setBackground(new Color(114, 144, 255));
                }            }
        });
        setVisible(true);
    }
    public JButton[] getJButton(){
        return image_btn;
    }
    public JButton[] getUp_btn() {return up_btn;}
    public JButton[] getDown_btn() {return down_btn;}
}
