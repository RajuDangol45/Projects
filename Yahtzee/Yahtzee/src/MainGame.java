import javax.swing.*;
import java.awt.*;

/**
 * Created by raju on 6/13/17.
 */
public class MainGame {
    public static JFrame frame=new JFrame("Yahtzee");
    public Dices dices;
    int playerNumber=0;
public MainGame(int number){
    playerNumber=number;
}
    public void run(){
        JOptionPane.showMessageDialog(null,"Press roll to start the game");
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366,768);
        frame.getContentPane().setBackground(new Color(114, 144, 255));

        dices=new Dices();
        dices.run();
        frame.add(dices,BorderLayout.EAST);

        Scores_Panel scores_panel=new Scores_Panel();
        scores_panel.run();
        frame.add(scores_panel,BorderLayout.WEST);
if(playerNumber==1){
    Player_Scores player_scores=new Player_Scores();
    player_scores.run();
    frame.add(player_scores);

}
       if(playerNumber==2){
           Player_Scores2 player_scores=new Player_Scores2();
           player_scores.run();
           frame.add(player_scores);

       }

        frame.setVisible(true);
    }

    public Dices getDices() {
        return dices;
    }
    public static void dispose(){
        frame.setVisible(false);
        frame.dispose();
    }
}
