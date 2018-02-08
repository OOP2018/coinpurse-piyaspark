package coinpurse;

import java.util.Comparator;

/**
 * Compare two objects that implement Valuable.
 * First compare them by currency, so that "Baht" < "Dollar".
 * If both objects have the same currency, order them by value.
 *
 * @author Piyaphol Wiengperm.
 */

public class ValueComparator implements Comparator<Valuable> {

    /**
     * compare two value for check which one is higher than the other.
     * @param a is Valuable that are coins or banknotes.
     * @param b is Valuable that are coins or banknotes.
     * @return integer.
     */
    public int compare(Valuable a,Valuable b){
        if(a.getCurrency().equals(b.getCurrency())){
            if(a.getValue() < b.getValue())return -1;
            else if(a.getValue() > b.getValue())return 1;
            else return 0;
        } else {
            if(a.getCurrency().compareTo(b.getCurrency())>0)return 1;
            if(a.getCurrency().compareTo(b.getCurrency())<0)return -1;
            return 0;
        }

    }
}
