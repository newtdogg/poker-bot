public class Main {
    public static void main(String args[]){
        Dealer dealer = new Dealer();
        Bot bot = new Bot();
        Player player = new Player();
        dealer.dealHand(bot, player);
        System.out.println(WinningHands.values()[9]);
    }
}
