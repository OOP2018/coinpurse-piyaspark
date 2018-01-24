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

    /**
     * the filter for choosing coins with the same currency as the example.
     * @param coins is all coins that in the list.
     * @param currency is the currency you want to choose.
     * @return coins with the same currency.
     */
    public static List<Coin> filterByCurrency(List<Coin> coins,String currency){
        List<Coin> sameCoins = new ArrayList<>();
        for (Coin c : coins) {
            if (c.getCurrency().contains(currency))sameCoins.add(c);
            else continue;
        }
        return sameCoins;
    }

    /**
     * sort coins in the list by highest to lowest.
     * @param coins is all coins that in the list.
     */
    public static void sortCoins(List<Coin> coins){
        java.util.Collections.sort(coins);
    }

    public static void main(String[] args) {
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0,"Baht"));
        coins.add(new Coin(0.5,"Baht"));
        coins.add(new Coin(2.0,"Baht"));
        coins.add(new Coin(1.0,"Baht"));
        printCoins(coins);
        sortCoins(coins);
        printCoins(coins);

        printCoins(filterByCurrency(coins,"Baht"));

    }
}
