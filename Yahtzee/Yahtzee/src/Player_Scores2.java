import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Raju Dangol on 6/28/2017.
 */
public class Player_Scores2 extends JPanel{
    int Yahtzeecount=0;
    int pressedCount[] =new int[13];
    int grandpressedcount=0;
    int ok=10;
    int totalScore=0;
    int totalSelection=0;
    int forfirst=0;
    static JLabel locklabel[] =new JLabel[5];
   static Dices dices=new Dices();
   static Scores_Panel scores_panel=new Scores_Panel();
    int occurrences=0;

    Random random=new Random();
    int borderofReroll=4;
    int ii;
    int[] anyValues=new int[5];
    static int rollCount=1;
    int rerollCount=1;

    int buttonPressedCount=0;

    JButton[] firstPlayerScores=new JButton[13];
    JLabel firstPlayerBonus=new JLabel();
    JLabel Bonustext=new JLabel("Bonus");
    JLabel firstPlayerTotal=new JLabel();
    JLabel Totaltext=new JLabel("Total");
    JButton rollButton=new JButton("Roll");
    JButton rerollButton=new JButton("Re-Roll");
    
    //for second player
    JButton[] firstPlayerScores2=new JButton[13];
    JLabel firstPlayerBonus2=new JLabel();
    JLabel firstPlayerTotal2=new JLabel();
    static int rollCount2=1;
    int rerollCount2=1;
    int Yahtzeecount2=0;
    int pressedCount2[] =new int[13];
    int borderofReroll2=4;
    int totalScore2=0;


    int whoseturn=0;

















    public void run(){

        setBackground(new Color(114, 144, 255));
        setLayout(null);


        for(int i=0;i<5;i++){
            locklabel[i]=new JLabel("");
            locklabel[i].setBounds(1100,i*120+80+i*11,100,50);
            add(locklabel[i]);
        }



        for(ii=0;ii<13;ii++){
            firstPlayerScores[ii]=new JButton();
            firstPlayerScores[ii].setBounds(110,138+ii*36,50,30);
            firstPlayerScores[ii].setBackground(new Color(1, 141, 29));
            firstPlayerScores[ii].setText(null);
            firstPlayerScores[ii].setForeground(Color.WHITE);
            firstPlayerScores[ii].setFocusPainted(false);
            firstPlayerScores[ii].setEnabled(false);
            firstPlayerScores[ii].setText(" ");
            firstPlayerScores[ii].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whoseturn++;
                    buttonPressedCount++;
                    JButton[] btn=dices.getJButton();
                    for(int j=0;j<13;j++){


                        totalSelection++;
                        firstPlayerScores[j].setEnabled(false);
                        firstPlayerScores[j].setForeground(new Color(1, 141, 29));
                        firstPlayerScores[j].setBackground(Color.WHITE);
                    }
                    rollCount=1;
                    rollCount2=1;
                    rollButton.setBackground(new Color(255, 254, 3));
                    rollButton.setForeground(new Color(0, 0, 0));
                    rollButton.setEnabled(true);
                    rerollButton.setEnabled(false);
                    rerollButton.setForeground(new Color(255, 254, 3));
                    rerollButton.setBackground(new Color(0, 0, 0));

                    for(int i=0;i<5;i++){
                        locklabel[i].setText("");
                        btn[i].setEnabled(false);
                        btn[i].setBackground(new Color(114, 144, 255));
                    }

                    rerollButton.setBorder(BorderFactory.createTitledBorder(rollButton.getBorder(),""+borderofReroll2, 1,0,new Font("",Font.ITALIC,15),Color.BLACK));

                }
            });
            add(firstPlayerScores[ii]);
        }
        firstPlayerBonus.setBackground(new Color(1, 141, 29));
        firstPlayerBonus.setOpaque(true);
        firstPlayerBonus.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlayerBonus.setForeground(Color.WHITE);
        firstPlayerBonus.setBounds(110,606,50,30);
        add(firstPlayerBonus);
        Bonustext.setBackground(new Color(0, 0, 0));
        Bonustext.setOpaque(true);
        Bonustext.setHorizontalAlignment(SwingConstants.CENTER);
        Bonustext.setForeground(new Color(8, 255, 0));
        Bonustext.setBounds(50,606,50,30);
        add(Bonustext);

        firstPlayerTotal.setBackground(new Color(1, 141, 29));
        firstPlayerTotal.setOpaque(true);
        firstPlayerTotal.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlayerTotal.setForeground(Color.WHITE);
        firstPlayerTotal.setText("0");
        firstPlayerTotal.setBounds(110,642,50,30);
        add(firstPlayerTotal);
        Totaltext.setBackground(new Color(0, 0, 0));
        Totaltext.setOpaque(true);
        Totaltext.setHorizontalAlignment(SwingConstants.CENTER);
        Totaltext.setForeground(new Color(8, 255, 0));
        Totaltext.setBounds(50,642,50,30);
        add(Totaltext);

        rollButton.setBounds(350,680,100,50);
        rollButton.setBackground(new Color(255, 254, 3));
        rollButton.setForeground(new Color(0, 0, 0));
        rollButton.setFocusPainted(false);
        rollButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        rollButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             if(forfirst==0){
                                                 for(int j=0;j<13;j++){
                                                         firstPlayerScores[j].setEnabled(true);
                                                         firstPlayerScores[j].setBackground(new Color(1, 141, 29));
                                                         firstPlayerScores[j].setForeground(Color.WHITE);

                                                 }
                                             }
                                             forfirst=1;
                                             Dices d=new Dices();
                                             for(int i=0;i<5;i++){
                                                 anyValues[i]= random.nextInt(6)+1;
                                             }
                                             JButton[] btn=d.getJButton();
                                             for(int i=0;i<5;i++){
                                                 if (btn[i].getBackground()!=Color.RED) {
                                                     btn[i].setEnabled(true);
                                                     btn[i].setIcon(new ImageIcon(getClass().getResource("dices images/" + anyValues[i] + ".jpg")));
                                                 }
                                                 //btn[i].setBackground(new Color(114, 144, 255));
                                             }
                                             rollCount++;
                                             if(rollCount>3) {
                                                 rollButton.setEnabled(false);
                                                 rollButton.setForeground(new Color(255, 254, 3));
                                                 rollButton.setBackground(new Color(0, 0, 0));
                                                 if(rerollCount<=3) {
                                                     rerollButton.setEnabled(true);
                                                     rerollButton.setBackground(new Color(255, 254, 3));
                                                     rerollButton.setForeground(new Color(0, 0, 0));
                                                 }
                                             }
                                             if(whoseturn%2==0) {
                                                 for (int j = 0; j < 13; j++) {
                                                     if (pressedCount[j] < 2) {
                                                         firstPlayerScores[j].setEnabled(true);
                                                         firstPlayerScores[j].setBackground(new Color(1, 141, 29));
                                                         firstPlayerScores[j].setForeground(Color.WHITE);
                                                     }
                                                 }
                                             }
                                             labelsofScores();
                                             upanddown();
                                         }
                                     });
                add(rollButton);
        rerollButton.setBounds(550,680,100,50);
        rerollButton.setBorder(BorderFactory.createTitledBorder(rollButton.getBorder(),""+borderofReroll, 1,0,new Font("",Font.ITALIC,15),Color.BLACK));
        rerollButton.setBackground(new Color(255, 254, 3));
        rerollButton.setForeground(new Color(0, 0, 0));
        rerollButton.setFocusPainted(false);
        rerollButton.setEnabled(false);
        rerollButton.setForeground(new Color(255, 254, 3));
        rerollButton.setBackground(new Color(0, 0, 0));
        rerollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (whoseturn % 2 == 0) {
                    borderofReroll--;
                    rerollButton.setBorder(BorderFactory.createTitledBorder(rollButton.getBorder(), "" + borderofReroll, 1, 0, new Font("", Font.ITALIC, 15), Color.BLACK));

                    Dices d = new Dices();
                    for (int i = 0; i < 5; i++) {
                        anyValues[i] = random.nextInt(6) + 1;
                    }
                    JButton[] btn = d.getJButton();

                    rerollCount++;
                    if (rerollCount > 4) {
                        rerollButton.setEnabled(false);
                        rerollButton.setForeground(new Color(255, 254, 3));
                        rerollButton.setBackground(new Color(0, 0, 0));
                    }
                    for (int i = 0; i < 5; i++) {
                        if (btn[i].getBackground() != Color.RED) {
                            btn[i].setIcon(new ImageIcon(getClass().getResource("dices images/" + anyValues[i] + ".jpg")));
                        }
                        //btn[i].setBackground(new Color(114, 144, 255));
                    }
                    labelsofScores();
                    upanddown();
                }
            }
        });
        add(rerollButton);

        firstPlayerScores[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[0]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[0].getText());
                if(firstPlayerScores[0].getText()==" ") firstPlayerScores[0].setText("0");
                int second=Integer.parseInt(firstPlayerScores[0].getText());
                System.out.println(""+first+"   "+second);
                int total=first+second;
                firstPlayerScores[0].setText(""+total);

                if(pressedCount[0]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }
                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[1]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[1].getText());
                if(firstPlayerScores[1].getText()==" ") firstPlayerScores[1].setText("0");
                int second=Integer.parseInt(firstPlayerScores[1].getText());
                int total=first+second;
                firstPlayerScores[1].setText(""+total);

                if(pressedCount[1]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[2]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[2].getText());
                if(firstPlayerScores[2].getText()==" ") firstPlayerScores[2].setText("0");
                int second=Integer.parseInt(firstPlayerScores[2].getText());
                int total=first+second;
                firstPlayerScores[2].setText(""+total);

                if(pressedCount[2]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[3]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[3].getText());
                if(firstPlayerScores[3].getText()==" ") firstPlayerScores[3].setText("0");
                int second=Integer.parseInt(firstPlayerScores[3].getText());
                int total=first+second;
                firstPlayerScores[3].setText(""+total);

                if(pressedCount[3]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[4]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[4].getText());
                if(firstPlayerScores[4].getText()==" ") firstPlayerScores[4].setText("0");
                int second=Integer.parseInt(firstPlayerScores[4].getText());
                int total=first+second;
                firstPlayerScores[4].setText(""+total);

                if(pressedCount[4]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[5]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[5].getText());
                if(firstPlayerScores[5].getText()==" ") firstPlayerScores[5].setText("0");
                int second=Integer.parseInt(firstPlayerScores[5].getText());
                int total=first+second;
                firstPlayerScores[5].setText(""+total);

                if(pressedCount[5]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[6]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[6].getText());
                if(firstPlayerScores[6].getText()==" ") firstPlayerScores[6].setText("0");
                int second=Integer.parseInt(firstPlayerScores[6].getText());
                int total=first+second;
                firstPlayerScores[6].setText(""+total);

                if(pressedCount[6]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[7]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[7].getText());
                if(firstPlayerScores[7].getText()==" ") firstPlayerScores[7].setText("0");
                int second=Integer.parseInt(firstPlayerScores[7].getText());
                int total=first+second;
                firstPlayerScores[7].setText(""+total);

                if(pressedCount[7]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[8]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[8].getText());
                if(firstPlayerScores[8].getText()==" ") firstPlayerScores[8].setText("0");
                int second=Integer.parseInt(firstPlayerScores[8].getText());
                int total=first+second;
                firstPlayerScores[8].setText(""+total);

                if(pressedCount[8]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[9]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[9].getText());
                if(firstPlayerScores[9].getText()==" ") firstPlayerScores[9].setText("0");
                int second=Integer.parseInt(firstPlayerScores[9].getText());
                int total=first+second;
                firstPlayerScores[9].setText(""+total);

                if(pressedCount[9]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[10]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[10].getText());
                if(firstPlayerScores[10].getText()==" ") firstPlayerScores[10].setText("0");
                int second=Integer.parseInt(firstPlayerScores[10].getText());
                int total=first+second;
                firstPlayerScores[10].setText(""+total);

                if(pressedCount[10]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[11]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[11].getText());
                if(firstPlayerScores[11].getText()==" ") firstPlayerScores[11].setText("0");
                int second=Integer.parseInt(firstPlayerScores[11].getText());
                int total=first+second;
                firstPlayerScores[11].setText(""+total);




                if(Yahtzeecount==1){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("100");

                }
                if(Yahtzeecount==2){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("200");
                }
                if(Yahtzeecount==3){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("300");
                }
                if(Yahtzeecount==4){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("400");
                }
                if(Yahtzeecount==5){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("500");
                }
                if(Yahtzeecount==6){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("600");
                }
                if(Yahtzeecount==7){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("700");
                }
                if(Yahtzeecount==8){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("800");
                }
                if(Yahtzeecount==9){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("900");
                }
                if(Yahtzeecount==10){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("1000");
                }
                if(Yahtzeecount==11){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("1100");
                }
                if(Yahtzeecount==12){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("1200");
                }
                if(Yahtzeecount==13){
                    totalScore=totalScore+100;
                    firstPlayerBonus.setText("1300");
                }
                if(first==50){
                    Yahtzeecount++;
                }

                if(pressedCount[11]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        firstPlayerScores[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount[12]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[12].getText());
                if(firstPlayerScores[12].getText()==" ") firstPlayerScores[12].setText("0");
                int second=Integer.parseInt(firstPlayerScores[12].getText());
                int total=first+second;
                firstPlayerScores[12].setText(""+total);

                if(pressedCount[12]==1){
                    totalScore=totalScore+total;
                }
                else {
                    totalScore=totalScore+first;
                }                firstPlayerTotal.setText(""+totalScore);
            }
        });
        
//second
        for(ii=0;ii<13;ii++){
            firstPlayerScores2[ii]=new JButton();
            firstPlayerScores2[ii].setBounds(210,138+ii*36,50,30);
            firstPlayerScores2[ii].setBackground(new Color(1, 141, 29));
            firstPlayerScores2[ii].setText(null);
            firstPlayerScores2[ii].setForeground(Color.WHITE);
            firstPlayerScores2[ii].setFocusPainted(false);
            firstPlayerScores2[ii].setEnabled(false);
            firstPlayerScores2[ii].setText(" ");
            firstPlayerScores2[ii].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    whoseturn++;
                    buttonPressedCount++;
                    JButton[] btn=dices.getJButton();
                    for(int j=0;j<13;j++){


                        totalSelection++;
                        firstPlayerScores2[j].setEnabled(false);
                        firstPlayerScores2[j].setForeground(new Color(1, 141, 29));
                        firstPlayerScores2[j].setBackground(Color.WHITE);
                    }
                    rollCount2=1;
                    rollCount=1;
                    rollButton.setBackground(new Color(255, 254, 3));
                    rollButton.setForeground(new Color(0, 0, 0));
                    rollButton.setEnabled(true);
                    rerollButton.setEnabled(false);
                    rerollButton.setForeground(new Color(255, 254, 3));
                    rerollButton.setBackground(new Color(0, 0, 0));

                    for(int i=0;i<5;i++){
                        locklabel[i].setText("");
                        btn[i].setEnabled(false);
                        btn[i].setBackground(new Color(114, 144, 255));
                    }

                    rerollButton.setBorder(BorderFactory.createTitledBorder(rollButton.getBorder(),""+borderofReroll, 1,0,new Font("",Font.ITALIC,15),Color.BLACK));

                    grandpressedcount++;

                    if(grandpressedcount==13){
                        String s1=firstPlayerTotal.getText();
                        String s2=firstPlayerTotal2.getText();
                        int a1=Integer.parseInt(s1);
                        int a2=Integer.parseInt(s2);
                        if(a1>a2){
                            JOptionPane.showMessageDialog(null,"First Player won");
                        }
                        else if(a2>a1){
                            JOptionPane.showMessageDialog(null,"Second Player won");

                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Draw");
                        }
                        MainGame.dispose();

                    }



                }
            });
            add(firstPlayerScores2[ii]);
        }
        firstPlayerBonus2.setBackground(new Color(1, 141, 29));
        firstPlayerBonus2.setOpaque(true);
        firstPlayerBonus2.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlayerBonus2.setForeground(Color.WHITE);
        firstPlayerBonus2.setBounds(210,606,50,30);
        add(firstPlayerBonus2);
        firstPlayerTotal2.setBackground(new Color(1, 141, 29));
        firstPlayerTotal2.setOpaque(true);
        firstPlayerTotal2.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlayerTotal2.setForeground(Color.WHITE);
        firstPlayerTotal2.setText("0");
        firstPlayerTotal2.setBounds(210,642,50,30);
        add(firstPlayerTotal2);
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                forfirst=1;
                Dices d=new Dices();
                for(int i=0;i<5;i++){
                    anyValues[i]= random.nextInt(6)+1;
                }
                JButton[] btn=d.getJButton();
                for(int i=0;i<5;i++){
                    if (btn[i].getBackground()!=Color.RED) {
                        btn[i].setEnabled(true);
                        btn[i].setIcon(new ImageIcon(getClass().getResource("dices images/" + anyValues[i] + ".jpg")));
                    }
                    //btn[i].setBackground(new Color(114, 144, 255));
                }
                rollCount2++;
                if(rollCount2>3) {
                    rollButton.setEnabled(false);
                    rollButton.setForeground(new Color(255, 254, 3));
                    rollButton.setBackground(new Color(0, 0, 0));
                    if(rerollCount2<=3) {
                        rerollButton.setEnabled(true);
                        rerollButton.setBackground(new Color(255, 254, 3));
                        rerollButton.setForeground(new Color(0, 0, 0));
                    }
                }
                if(whoseturn%2!=0) {
                    for (int j = 0; j < 13; j++) {
                        if (pressedCount2[j] < 2) {
                            firstPlayerScores2[j].setEnabled(true);
                            firstPlayerScores2[j].setBackground(new Color(1, 141, 29));
                            firstPlayerScores2[j].setForeground(Color.WHITE);
                        }
                    }
                }
                labelsofScores();
                upanddown();

            }
        });
        rerollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (whoseturn % 2 != 0) {
                    borderofReroll2--;
                    rerollButton.setBorder(BorderFactory.createTitledBorder(rollButton.getBorder(), "" + borderofReroll2, 1, 0, new Font("", Font.ITALIC, 15), Color.BLACK));

                    Dices d = new Dices();
                    for (int i = 0; i < 5; i++) {
                        anyValues[i] = random.nextInt(6) + 1;
                    }
                    JButton[] btn = d.getJButton();

                    rerollCount2++;
                    if (rerollCount2 > 4) {
                        rerollButton.setEnabled(false);
                        rerollButton.setForeground(new Color(255, 254, 3));
                        rerollButton.setBackground(new Color(0, 0, 0));
                    }
                    for (int i = 0; i < 5; i++) {
                        if (btn[i].getBackground() != Color.RED) {
                            btn[i].setIcon(new ImageIcon(getClass().getResource("dices images/" + anyValues[i] + ".jpg")));
                        }
                    }
                    labelsofScores();
                    upanddown();
                }
            }
        });
        firstPlayerScores2[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[1]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[1].getText());
                if(firstPlayerScores2[1].getText()==" ") firstPlayerScores2[1].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[1].getText());
                int total=first+second;
                firstPlayerScores2[1].setText(""+total);

                if(pressedCount2[1]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[2]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[2].getText());
                if(firstPlayerScores2[2].getText()==" ") firstPlayerScores2[2].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[2].getText());
                int total=first+second;
                firstPlayerScores2[2].setText(""+total);

                if(pressedCount2[2]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[3]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[3].getText());
                if(firstPlayerScores2[3].getText()==" ") firstPlayerScores2[3].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[3].getText());
                int total=first+second;
                firstPlayerScores2[3].setText(""+total);

                if(pressedCount2[3]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[4]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[4].getText());
                if(firstPlayerScores2[4].getText()==" ") firstPlayerScores2[4].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[4].getText());
                int total=first+second;
                firstPlayerScores2[4].setText(""+total);

                if(pressedCount2[4]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[5]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[5].getText());
                if(firstPlayerScores2[5].getText()==" ") firstPlayerScores2[5].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[5].getText());
                int total=first+second;
                firstPlayerScores2[5].setText(""+total);

                if(pressedCount2[5]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[6]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[6].getText());
                if(firstPlayerScores2[6].getText()==" ") firstPlayerScores2[6].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[6].getText());
                int total=first+second;
                firstPlayerScores2[6].setText(""+total);

                if(pressedCount2[6]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[7]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[7].getText());
                if(firstPlayerScores2[7].getText()==" ") firstPlayerScores2[7].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[7].getText());
                int total=first+second;
                firstPlayerScores2[7].setText(""+total);

                if(pressedCount2[7]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[8]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[8].getText());
                if(firstPlayerScores2[8].getText()==" ") firstPlayerScores2[8].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[8].getText());
                int total=first+second;
                firstPlayerScores2[8].setText(""+total);

                if(pressedCount2[8]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[9]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[9].getText());
                if(firstPlayerScores2[9].getText()==" ") firstPlayerScores2[9].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[9].getText());
                int total=first+second;
                firstPlayerScores2[9].setText(""+total);

                if(pressedCount2[9]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[10]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[10].getText());
                if(firstPlayerScores2[10].getText()==" ") firstPlayerScores2[10].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[10].getText());
                int total=first+second;
                firstPlayerScores2[10].setText(""+total);

                if(pressedCount2[10]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[11]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[11].getText());
                if(firstPlayerScores2[11].getText()==" ") firstPlayerScores2[11].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[11].getText());
                int total=first+second;
                firstPlayerScores2[11].setText(""+total);




                if(Yahtzeecount2==1){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("100");

                }
                if(Yahtzeecount2==2){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("200");
                }
                if(Yahtzeecount2==3){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("300");
                }
                if(Yahtzeecount2==4){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("400");
                }
                if(Yahtzeecount2==5){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("500");
                }
                if(Yahtzeecount2==6){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("600");
                }
                if(Yahtzeecount2==7){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("700");
                }
                if(Yahtzeecount2==8){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("800");
                }
                if(Yahtzeecount2==9){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("900");
                }
                if(Yahtzeecount2==10){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("1000");
                }
                if(Yahtzeecount2==11){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("1100");
                }
                if(Yahtzeecount2==12){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("1200");
                }
                if(Yahtzeecount2==13){
                    totalScore2=totalScore2+100;
                    firstPlayerBonus2.setText("1300");
                }
                if(first==50){
                    Yahtzeecount2++;
                }

                if(pressedCount2[11]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        firstPlayerScores2[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedCount2[12]++;
                JLabel[] label=scores_panel.getJLabel();
                int first=Integer.parseInt(label[12].getText());
                if(firstPlayerScores2[12].getText()==" ") firstPlayerScores2[12].setText("0");
                int second=Integer.parseInt(firstPlayerScores2[12].getText());
                int total=first+second;
                firstPlayerScores2[12].setText(""+total);

                if(pressedCount2[12]==1){
                    totalScore2=totalScore2+total;
                }
                else {
                    totalScore2=totalScore2+first;
                }                firstPlayerTotal2.setText(""+totalScore2);
            }
        });
        




        setVisible(true);
    }
    public void labelsofScores(){
        String orderedDices="";
        JLabel[] label=scores_panel.getJLabel();
        int [] forOrder=new int[5];
        JButton[] btn=dices.getJButton();
        String scoreSet="";
        for(int i=0;i<5;i++) {
            String s = ((ImageIcon) btn[i].getIcon()).getDescription();
            scoreSet=scoreSet+s.charAt(s.length() - 5);
        }
        int acecounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='1') acecounter+=2;
        }
        label[0].setText(""+acecounter);
        int twocounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='2') twocounter+=4;
        }
        label[1].setText(""+twocounter);
        int threecounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='3') threecounter+=6;
        }
        label[2].setText(""+threecounter);
        int fourcounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='4') fourcounter+=8;
        }
        label[3].setText(""+fourcounter);
        int fivecounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='5') fivecounter+=10;
        }
        label[4].setText(""+fivecounter);
        int sixcounter=0;
        for(int i=0;i<5;i++){
            if(scoreSet.charAt(i)=='6') sixcounter+=12;
        }
        label[5].setText(""+sixcounter);

        int total=(acecounter+threecounter+twocounter+fivecounter+fourcounter+sixcounter)/2;

        if(acecounter>=6 || twocounter>=12 || threecounter>=18 || fourcounter>=24 || fivecounter>=30 || sixcounter>=36){
            label[6].setText(""+total);
        }
        else{
            label[6].setText("0");
        }
        if(acecounter>=8 || twocounter>=16 || threecounter>=24 || fourcounter>=32 || fivecounter>=40 || sixcounter>=48){
            label[7].setText(""+total);
        }
        else{
            label[7].setText("0");
        }
        if((acecounter== 4 && (twocounter==12 || threecounter==18 || fourcounter==24 || fivecounter==30 || sixcounter==36)) ||
                (acecounter==6 && (twocounter==8 || threecounter==12 || fourcounter==16 || fivecounter==20 || sixcounter==24)) ||
                (twocounter==8 && (acecounter==6 || threecounter==18 || fourcounter==24 || fivecounter==30 || sixcounter==36)) ||
                (twocounter==12 && (acecounter==4 || threecounter==12 || fourcounter==16 || fivecounter==20 || sixcounter==24)) ||
                (threecounter==12 && (acecounter==6 || twocounter==12 || fourcounter==24 || fivecounter==30 || sixcounter==36)) ||
                (threecounter==18 && (acecounter==4 || twocounter==12 || fourcounter==16 || fivecounter==20 || sixcounter==24)) ||
                (fourcounter==16 && (acecounter==6 || threecounter==18 || twocounter==12 || fivecounter==30 || sixcounter==36)) ||
                (fourcounter==24 && (acecounter==4 || threecounter==12 || twocounter==8 || fivecounter==20 || sixcounter==24)) ||
                (fivecounter==20 && (acecounter==6 || threecounter==18 || fourcounter==24 || twocounter==12 || sixcounter==36)) ||
                (fivecounter==30 && (acecounter==4 || threecounter==12 || fourcounter==16 || twocounter==8 || sixcounter==24)) ||
                (sixcounter==24 && (acecounter==6 || threecounter==18 || fourcounter==24 || fivecounter==30 || twocounter==12)) ||
                (sixcounter==36 && (acecounter==4 || threecounter==12 || fourcounter==16 || fivecounter==20 || twocounter==8))){
            label[8].setText("25");
        }
         else {
            label[8].setText("0");
        }
        for(int i=0;i<5;i++){
            forOrder[i]=Character.getNumericValue(scoreSet.charAt(i));
        }

        for(int i=0;i<5;i++){
            for (int j=0;j<4;j++){
                if(forOrder[j]==forOrder[j+1]){
                    forOrder[j+1]=ok++;
                }
                if(forOrder[j]>forOrder[j+1]) {
                    int a=forOrder[j];
                    forOrder[j]=forOrder[j+1];
                    forOrder[j+1]=a;
                }
            }
        }
        for(int i=0;i<5;i++) {
            orderedDices=orderedDices+forOrder[i];
        }

        if(orderedDices.contains("1234") || (orderedDices.contains("2345")) || (orderedDices.contains("3456"))){
            label[9].setText("30");
        }
        else label[9].setText("0");

        if(orderedDices.contains("12345") || (orderedDices.contains("23456"))){
            label[10].setText("40");
        }
        else label[10].setText("0");

        if(acecounter==10 || twocounter==20 || threecounter==30 || fourcounter==40 || fivecounter==50){
            label[11].setText("50");
        }
        else label[11].setText("0");

        label[12].setText(""+total);

    }
    public void upanddown(){
        JButton[] up=dices.getUp_btn();
        JButton[] down=dices.getDown_btn();
        for(int i=0;i<5;i++){
            up[i].setEnabled(true);
            down[i].setEnabled(true);
        }
    }
    public int getRollCount()
    {
        if(whoseturn%2==0){
            return rollCount;
        }
            return rollCount2;
    }
    public JLabel[] getLocklabel(){
        return locklabel;
    }
}
