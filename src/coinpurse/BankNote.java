package coinpurse;

/**
 * BankNote represent value and currency of banknote.
 * @author Piyaphol Wiengperm.
 */

public class BankNote extends Money{
    private long serialNumber;
    private static long nextSerialNumber = 1000000;

    /**
     * A constructor for BankNote.
     * @param value is value of the coin such as 1,2,5,10.
     * @param currency is currency of the such as Baht,Dollars,Yen.
     * banknote will have unique serial number that start at 10000000.
     */
    public BankNote(double value,String currency){
       super(value,currency);
        this.serialNumber = nextSerialNumber;
        nextSerialNumber++;
    }

    /**
     * Get unique serial number of banknote.
     * @return serial number of banknote.
     */
    public long getSerial() {
        return serialNumber;
    }

    /**
     * String format that contains value and currency.
     * @return format of string.
     */
    public String toString() {
        return String.format("%.0f-%s note [%d]",this.getValue(),this.getCurrency(), serialNumber);
    }

    /**
     * Set the next serial number for MoneyFactory.
     * @param nextSerialNumber
     */
    public static void setNextSerialNumber(long nextSerialNumber){
        BankNote.nextSerialNumber = nextSerialNumber;
    }
}
