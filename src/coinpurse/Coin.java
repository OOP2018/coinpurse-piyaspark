package coinpurse;

/**
 *
 * Coins represent value and currency of coin.
 * @author Piyaphol Wiengperm.
 */
public class Coin implements Valuable{
    private double value;
    private String currency;

    /**
     * a constructor for coin.
     * @param value is value of the coin such as 1,2,5,10.
     * @param currency is currency of the such as Baht,Dollars,Yen.
     */
    public Coin(double value, String currency) {
        if (value < 0) return;
        this.value = value;
        this.currency = currency;
    }

    /**
     * get value for usage.
     * @return value.
     */
    public double getValue() {
        return value;
    }

    /**
     * get value for usage.
     * @return currency.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * check two coins are equal if they have the same value and same currency.
     * @param arg is other object.
     * @return boolean
     */
    @Override
    public boolean equals(Object arg) {
        if (this == arg) return true;
        if (arg == null || this.getClass() != arg.getClass()) return false;
        Coin other = (Coin) arg;
        return this.value == other.value && this.currency.equals(other.currency);
    }

    /**
     * String format that contains value and currency.
     * @return format of string.
     */
    @Override
    public String toString() {
        return String.format("%f-%s", value, currency);
    }

}
