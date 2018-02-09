public class Main {
    public static void main(String args[]){
//        Dealer dealer = new Dealer();
            Bot bot = new Bot();
//        dealer.dealHand(bot);
        bot.createAllAvailableHandsHashTable();
        System.out.println(bot.allAvailableHands.get(WinningHands.PAIR.toString()));
    }
}
