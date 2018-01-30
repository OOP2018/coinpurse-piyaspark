package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 *  A money purse contains coins and banknotes.
 *  You can insert coins or banknotes, withdraw money, check the balance,
 *  and check if the purse is full.
 *
 *  @author Piyaphol Wiengperm.
 */
public class Purse {
    /** Collection of objects in the purse. */
    private List<Valuable> money;

    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;

    /**
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins and banknotes you can put in purse.
     */
    public Purse( int capacity ) {
        this.capacity = capacity;
        this.money = new ArrayList<>();
    }

    /**
     * Count and return the number of coins and banknotes in the purse.
     * This is the number of coins and banknotes, not their value.
     * @return the number of coins and banknotes in the purse
     */
    public int count() { return money.size(); }

    /**
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
        double balance = 0;
        for ( Valuable m : money){
            balance += m.getValue();
        }
		return balance;
	}


    /**
     * Return the capacity of the money purse.
     * @return the capacity
     */
    public int getCapacity() {
		return capacity;
	}

    /**
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if(count()==capacity)return true;
        return false;
    }

    /**
     * Insert a coin or banknote into the purse.
     * The money is only inserted if the purse has space for it
     * and the value has positive value.  No worthless value!
     * @param value is a value object to insert into purse
     * @return true if value inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        if(isFull())return false;
        else if(value.getValue()<=0)return false;
        else money.add(value);
        return true;
    }

    /**
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amountNeededToWithdraw is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn,
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amountNeededToWithdraw ) {
        List<Valuable> templist = new ArrayList<>();
        Comparator<Valuable> comp = new ValueComparator();
        money.sort(comp);
        Collections.reverse(money);
        for (Valuable v : money){
                if(amountNeededToWithdraw - v.getValue()>=0){
                    amountNeededToWithdraw -= v.getValue();
                    templist.add(v);
            }
        }

		if ( amountNeededToWithdraw != 0 ) return null;
        for (Valuable v : templist) money.remove(v);
        Valuable[] money = new Valuable[templist.size()];
        return templist.toArray(money) ;
	}

    /**
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return String.format("%d coins with value %f",count(),getBalance());
    }

}

