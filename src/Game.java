import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private JPanel main;
    private JButton Play;
    private JPanel room;
    private JLabel bot1rank;
    private JLabel bot1suit;
    private JLabel bot2rank;
    private JLabel bot2suit;
    private JPanel bot1;
    private JPanel bot2;
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
    private JPanel player1;
    private JPanel player2;
    private JLabel player1rank;
    private JLabel player1suit;
    private JLabel player2suit;
    private JLabel player2rank;
    private JButton bet;
    private JButton check;
    private JButton fold;
    public int pot;

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
        Player player = new Player();
        pot = 0;
        dealer.generateRankSymbols();
        dealer.generateSuitSymbols();

        Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealer.dealHand(bot, player);
                String key1rankBot = bot.hand.holdEm.get(0).rank.name();
                String key2rankBot = bot.hand.holdEm.get(1).rank.name();
                String key1suitBot = bot.hand.holdEm.get(0).suit.name();
                String key2suitBot = bot.hand.holdEm.get(1).suit.name();
                String key1rankPlayer = player.hand.holdEm.get(0).rank.name();
                String key2rankPlayer = player.hand.holdEm.get(1).rank.name();
                String key1suitPlayer = player.hand.holdEm.get(0).suit.name();
                String key2suitPlayer = player.hand.holdEm.get(1).suit.name();
                bot1rank.setText(dealer.rankSymbol.get(key1rankBot).toString());
                bot1suit.setText(dealer.suitSymbol.get(key1suitBot).toString());
                bot2rank.setText(dealer.rankSymbol.get(key2rankBot).toString());
                bot2suit.setText(dealer.suitSymbol.get(key2suitBot).toString());
                player1rank.setText(dealer.rankSymbol.get(key1rankPlayer).toString());
                player1suit.setText(dealer.suitSymbol.get(key1suitPlayer).toString());
                player2rank.setText(dealer.rankSymbol.get(key2rankPlayer).toString());
                player2suit.setText(dealer.suitSymbol.get(key2suitPlayer).toString());
                bot1.setBackground(Color.white);
                bot2.setBackground(Color.white);
                Play.setVisible(false);

            }
        });



//        dealFlopButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dealer.dealFlop(bot);
//                String key3rank = bot.hand.playableCards.get(2).rank.name();
//                String key4rank = bot.hand.playableCards.get(3).rank.name();
//                String key5rank = bot.hand.playableCards.get(4).rank.name();
//                String key3suit = bot.hand.playableCards.get(2).suit.name();
//                String key4suit = bot.hand.playableCards.get(3).suit.name();
//                String key5suit = bot.hand.playableCards.get(4).suit.name();
//                flop1rank.setText(dealer.rankSymbol.get(key3rank).toString());
//                flop1suit.setText(dealer.suitSymbol.get(key3suit).toString());
//                flop2rank.setText(dealer.rankSymbol.get(key4rank).toString());
//                flop2suit.setText(dealer.suitSymbol.get(key4suit).toString());
//                flop3rank.setText(dealer.rankSymbol.get(key5rank).toString());
//                flop3suit.setText(dealer.suitSymbol.get(key5suit).toString());
//                flop1.setBackground(Color.white);
//                flop2.setBackground(Color.white);
//                flop3.setBackground(Color.white);
//                flop1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
//            }
//        });
        fold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bot.chips += pot;
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b)
            }
        });
    }

}
