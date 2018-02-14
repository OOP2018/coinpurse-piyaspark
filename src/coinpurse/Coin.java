package coinpurse;

/**
 *
 * Coins represent value and currency of coin.
 * @author Piyaphol Wiengperm.
 */
public class Coin extends Money{


    /**
     * a constructor for coin.
     * @param value is value of the coin such as 1,2,5,10.
     * @param currency is currency of the such as Baht,Dollars,Yen.
     */
    public Coin(double value, String currency) {
        super(value,currency);
        if (value < 0) return;
    }

    /**
     * String format that contains value and currency.
     * @return format of string.
     */

    public String toString() {
        return String.format("%f-%s", this.getValue(), this.getCurrency());
    }

}
