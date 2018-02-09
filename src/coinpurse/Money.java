package coinpurse;

import coinpurse.Valuable;

public class Money implements Valuable{
    private double value;
    private String currency;

    public Money(double value,String currency){
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public int compareTo(Valuable o){
        return Double.compare(this.value,o.getValue());
    }

    /**
     * check two coins are equal if they have the same value and same currency.
     * @param arg is other object.
     * @return boolean
     */
    public boolean equals(Object arg) {
        if (this == arg) return true;
        if (arg == null || this.getClass() != arg.getClass()) return false;
        Money other = (Money) arg;
        return this.value == other.value && this.currency.equals(other.currency);
    }
}
