package coinpurse;

/**
 *
 * Coins represent value and currency of coin.
 * @author Piyaphol Wiengperm.
 */
public class Coin implements Comparable<Coin>{
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
     *
     * @return value.
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @return currency.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * check two coins are equal if they have the same value and same currency.
     * @param arg
     * @return boolean
     */
    @Override
    public boolean equals(Object arg) {
        if (this == arg) return true;
        if (arg == null || this.getClass() != arg.getClass()) return false;
        Coin other = (Coin) arg;
        return this.value == other.value && this.currency == other.currency;
    }

    /**
     * compare two coins for check which coin have more value.
     * @param coin
     * @return integer.
     */
    public int compareTo(Coin coin) {
        if(this.value - coin.getValue() < 0)return -1;
        else if(this.value - coin.getValue() > 0)return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%f-%s", value, currency);
    }

}
