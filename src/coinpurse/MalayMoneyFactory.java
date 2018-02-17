package coinpurse;

/**
 * Class for create Malaysia money.
 * @author Piyaphol Wiengperm.
 */
public class MalayMoneyFactory extends MoneyFactory {
    private final String malayCoinCurrency = "Sen";
    private final String malayCurrency = "Ringgit";

    /**
     * A constructor for MalayMoneyFactory.
     * Set the serial number for identical.
     */
    public MalayMoneyFactory(){
        BankNote.setNextSerialNumber(1000000);
    }

    /**
     * Create Malaysia money with two types.
     * if value is 0.05,0.1,0.2,0.5, it will create a coin with "Baht" currency.
     * if value is 1,2,5,10,20,50,100, it will create a banknote with "Baht" currency.
     * @param value is value of money.
     * @return a coin or banknote.
     */
    @Override
    public Valuable createMoney(double value) {
        if(value==0.05||value==0.10||value==0.20||value==0.5)return new Coin(value,malayCoinCurrency);
        else if(value==1||value==2||value==5||value==10||value==20||value==50||value==100)return new BankNote(value,malayCurrency);
        else throw new IllegalArgumentException("Can't create Malaysia money.");
    }
}
