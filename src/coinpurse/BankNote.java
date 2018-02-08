package coinpurse;

/**
 * BankNote represent value and currency of banknote.
 * @author Piyaphol Wiengperm.
 */

public class BankNote implements Valuable{
    private double value;
    private String currency;
    private long serialNumber;
    private static long nextSerialNumber = 1000000;

    /**
     * a constructor for BankNote.
     * @param value is value of the coin such as 1,2,5,10.
     * @param currency is currency of the such as Baht,Dollars,Yen.
     * banknote will have unique serial number that start at 10000000.
     */
    public BankNote(double value,String currency){
        this.value = value;
        this.currency = currency;
        this.serialNumber = nextSerialNumber;
        nextSerialNumber++;
    }

    /**
     * get value of banknote.
     * @return value of banknote.
     */
    public double getValue(){
        return value;
    }

    /**
     * get currency of banknote.
     * @return currency of banknote.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * get unique serial number of banknote.
     * @return serial number of banknote.
     */
    public long getSerial() {
        return serialNumber;
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
        BankNote other = (BankNote) arg;
        return this.value == other.value && this.currency.equals(other.currency);
    }

    /**
     * String format that contains value and currency.
     * @return format of string.
     */
    @Override
    public String toString() {
        return String.format("%.0f-%s note [%d]",value,currency, serialNumber);
    }
}
