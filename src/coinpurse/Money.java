package coinpurse;

/**
 * Money contains coin and banknotes.
 * @author Piyaphol Wiengperm
 */
public class Money implements Valuable{
    private double value;
    private String currency;

    /**
     * The constructor for money that have value and currency.
     * @param value is value of money such as 10,50,100.
     * @param currency is currency of money such as "Baht","Dollar","Yen".
     */
    public Money(double value,String currency){
        this.value = value;
        this.currency = currency;
    }

    /**
     * Get a value of money.
     * @return value of money.
     */
    public double getValue() {
        return value;
    }

    /**
     * Get a currency of money.
     * @return currency of money.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Compare two value of money.
     * @param o is money.
     * @return integer.
     */
    public int compareTo(Valuable o){
        if (this.getCurrency().equalsIgnoreCase(o.getCurrency())) return Double.compare(this.getValue(),o.getValue());
        else return this.getCurrency().compareTo(o.getCurrency());
    }

    /**
     * check two coins are equal if they have the same value and same currency.
     * @param arg is other object.
     * @return boolean.
     */
    public boolean equals(Object arg) {
        if (this == arg) return true;
        if (arg == null || this.getClass() != arg.getClass()) return false;
        Money other = (Money) arg;
        return this.value == other.value && this.currency.equals(other.currency);
    }
}
