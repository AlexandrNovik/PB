package aliak.dev.presentation;

import javax.swing.*;

/**
 * Created by Alex on 28.10.2017.
 */
public class Table {
    private JPanel container;
    private JLabel tvPlayerName4;
    private JLabel tvPlayerName5;
    private JLabel tvPlayerName6;
    private JLabel tvPlayerName1;
    private JLabel tvPlayerName2;
    private JLabel tvPlayerName3;
    private JPanel cardsContainer;
    private JPanel cardContainerPlayer1;
    private JPanel cardContainerPlayer2;
    private JPanel cardContainerPlayer3;
    private JPanel cardContainerPlayer4;
    private JPanel cardContainerPlayer5;
    private JPanel cardContainerPlayer6;
    private JLabel tvPot;
    private JLabel tvFlop1;
    private JLabel tvFlop2;
    private JLabel tvFlop3;
    private JLabel tvTurn;
    private JLabel tvRiver;
    private JLabel tvPlayer1Card1;
    private JLabel tvPlayer1Card2;
    private JLabel tvPlayer2Card2;
    private JLabel tvPlayer2Card1;
    private JLabel tvPlayer3Card1;
    private JLabel tvPlayer3Card2;
    private JLabel tvPlayer4Card2;
    private JLabel tvPlayer4Card1;
    private JLabel tvPlayer5Card1;
    private JLabel tvPlayer5Card2;
    private JLabel tvPlayer6Card2;
    private JLabel tvPlayer6Card1;
    private JLabel tvPostionPlayer1;
    private JLabel tvPostionPlayer2;
    private JLabel tvPostionPlayer3;
    private JLabel tvPlayerStack1;
    private JLabel tvPlayerStack2;
    private JLabel tvPlayerStack3;
    private JLabel tvPlayerStack6;
    private JLabel tvPlayerStack5;
    private JLabel tvPlayerStack4;
    private JLabel tvPostionPlayer4;
    private JLabel tvPostionPlayer5;
    private JLabel tvPostionPlayer6;
    private JButton btRaise;
    private JButton btCall;
    private JButton btFold;
    private JButton btRaise34;
    private JButton btRaise12;
    private JButton btRaisePot;
    private JTextField etBetSize;

    public void show() {
        JFrame frame = new JFrame("Poker bot");
        frame.setContentPane(this.container);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
