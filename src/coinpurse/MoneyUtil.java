package coinpurse;

/**
 * MoneyUtil is use to test Coin and Banknote class.
 *
 * @author Piyaphol Wiengperm.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil {

    /**
     * print all coin that added.
     * @param value is object that represent a coin which contains value and currency.
     */
    public static void printValue(List<Valuable> value){
        for (Valuable v : value) {
            System.out.println(v.toString());
        }
    }

    /**
     * the filter for choosing valuable with the same currency as the example.
     * @param value is all values that in the list.
     * @param currency is the currency you want to choose.
     * @return value with the same currency.
     */
    public static <E extends Valuable> List<E> filterByCurrency(List<E> value, String currency){
        List<E> sameCurrency = new ArrayList<>();
        for (E v : value) {
            if (v.getCurrency().contains(currency))sameCurrency.add(v);
            else continue;
        }
        return sameCurrency;
    }

    /**
     * sort value in the list by highest to lowest.
     * @param value is all value that in the list.
     */
    public static void sortMoney(List<? extends Valuable> value){
        Comparator<Valuable> comp = new ValueComparator();
        value.sort(comp);
    }


    public static <E extends Comparable<? super E>> E max(E ... args){
        E max = args[0];
        for(E a : args){
            if(max.compareTo(a)<0)max = a;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Valuable> value = new ArrayList<Valuable>();
        value.add(new Coin(10.0,"Baht"));
        value.add(new Coin(0.5,"Baht"));
        value.add(new Coin(2.0,"Baht"));
        value.add(new Coin(1.0,"Baht"));
        value.add(new BankNote(50,"Dollar",1000000));
        value.add(new BankNote(100,"Dollar",1000000));
        value.add(new BankNote(1000,"Dollar",1000000));

        printValue(value);
        sortMoney(value);
        printValue(value);

        printValue(filterByCurrency(value,"Dollar"));

    }
}
