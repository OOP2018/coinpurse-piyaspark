package coinpurse;

/**
 * MoneyUtil is use to test Coin class.
 *
 * @author Piyaphol Wiengperm.
 */

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

    /**
     * print all coin that added.
     * @param coin is object that represent a coin which contains value and currency.
     */
    public static void printCoins(List<Coin> coin){
        for (Coin c : coin) {
            System.out.println(c.toString());
        }
    }

    public static void main(String[] args) {
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0,"Baht"));
        coins.add(new Coin(0.5,"Baht"));
        coins.add(new Coin(2.0,"Baht"));
        coins.add(new Coin(1.0,"Baht"));
        printCoins(coins);
        java.util.Collections.sort(coins);
        printCoins(coins);
    }
}
