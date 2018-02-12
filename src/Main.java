public class Main {
    public static void main(String args[]){
        Dealer dealer = new Dealer();
        Bot bot = new Bot();
        dealer.dealHand(bot);
        System.out.println(WinningHands.values()[9]);
    }
}
