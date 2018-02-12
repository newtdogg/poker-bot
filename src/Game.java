import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private JPanel main;
    private JButton Deal;
    private JPanel room;
    private JLabel card1rank;
    private JLabel card1suit;
    private JLabel card2rank;
    private JLabel card2suit;
    private JPanel card1;
    private JPanel card2;
    private JButton dealFlopButton;
    private JPanel board;
    private JPanel flop1;
    private JPanel flop2;
    private JPanel flop3;
    private JPanel turn;
    private JPanel river;
    private JLabel flop1suit;
    private JLabel flop1rank;
    private JLabel flop2suit;
    private JLabel flop2rank;
    private JLabel flop3suit;
    private JLabel flop3rank;
    private JLabel riversuit;
    private JLabel riverrank;
    private JLabel turnsuit;
    private JLabel turnrank;
    private JPanel bot;

    public static void main(String args[]){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Game().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Game() {
        Dealer dealer = new Dealer();
        Bot bot = new Bot();
        Deal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealer.dealHand(bot);
                card1rank.setText(bot.hand.holdEm.get(0).rank.name());
                card1suit.setText(bot.hand.holdEm.get(0).suit.name());
                card2rank.setText(bot.hand.holdEm.get(1).rank.name());
                card2suit.setText(bot.hand.holdEm.get(1).suit.name());
                card1.setBackground(Color.white);
                card2.setBackground(Color.white);
            }
        });
        dealFlopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealer.dealFlop(bot);
                flop1rank.setText(bot.hand.playableCards.get(2).rank.name());
                flop1suit.setText(bot.hand.playableCards.get(2).suit.name());
                flop2rank.setText(bot.hand.playableCards.get(3).rank.name());
                flop2suit.setText(bot.hand.playableCards.get(3).suit.name());
                flop3rank.setText(bot.hand.playableCards.get(4).rank.name());
                flop3suit.setText(bot.hand.playableCards.get(4).suit.name());
                flop1.setBackground(Color.white);
                flop2.setBackground(Color.white);
                flop3.setBackground(Color.white);
                flop1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
            }
        });
    }




}
