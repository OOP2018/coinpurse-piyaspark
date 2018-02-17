package coinpurse;

/**
 * MoneyFactory is class that create money for use.
 * @author Piyaphol Wiengperm.
 */
public abstract class MoneyFactory {
    private static MoneyFactory instance = null;

    protected MoneyFactory(){ }

    public static MoneyFactory getInstance(){
        return instance;
    }

    public abstract Valuable createMoney(double value);

    /**
     * Create money by parsing String value to double value.
     * If it can't create then throw an exception.
     * @param value is value of money in type of String.
     * @return Valuable.
     */
    public Valuable createMoney(String value){
        double doubleValue = 0;
        try {
            doubleValue = Double.parseDouble(value);
        }catch (Exception ex){
            throw new IllegalArgumentException("Can't parse String value to double value.");
        }
        return createMoney(doubleValue);
    }


    public static void setFactory(MoneyFactory f){
        instance = f;
    }
}