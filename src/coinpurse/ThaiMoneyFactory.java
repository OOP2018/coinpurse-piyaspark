package coinpurse;

/**
 * Class for create Thai money.
 * @author Piyaphol Wiengperm.
 */
public class ThaiMoneyFactory extends MoneyFactory {
    private final String thaiCurrency = "Baht";
    private long nextSerialNumber = 1000000;

    /**
     * Create Thai money with two types.
     * if value is 0.25,0.5,1,2,5,10, it will create a coin with "Baht" currency.
     * if value is 20,50,100,500,1000, it will create a banknote with "Baht" currency.
     * @param value is value of money.
     * @return a coin or banknote.
     */
    @Override
    public Valuable createMoney(double value) {
        if(value==0.25||value==0.5||value==1||value==2||value==5||value==10)return new Coin(value,thaiCurrency);
        else if(value==20||value==50||value==100||value==500||value==1000)return new BankNote(value,thaiCurrency,nextSerialNumber++);
        else throw new IllegalArgumentException("Can't create Thai money.");
    }
}
