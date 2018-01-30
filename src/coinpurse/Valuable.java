package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 */

public interface Valuable {
    /**
     * Get the monetary value of this object.
     * @return the value of this object
     */
    double getValue();

    /**
     * Get the currency of this object such as "Baht","Dollar".
     * @return the currency of this object
     */
    String getCurrency();

}
