package coinpurse;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 *  A purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *
 *  @author Piyaphol Wiengperm.
 */
public class Purse {
    private Comparator<Valuable> comp = new ValueComparator();

    /** Collection of objects in the purse. */
    private List<Valuable> money;

    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;

    /** Withdraw strategy that will use to withdraw.*/
    private WithdrawStrategy strategy;

    /**
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum money you can put in purse.
     */
    public Purse( int capacity ) {
        this.capacity = capacity;
        this.money = new ArrayList<>();
        setWithdrawStrategy(new RecursiveWithdraw());
    }

    /**
     * Count and return money in the purse.
     * This is the number of money, not their value.
     * @return money in the purse
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
     * Insert money into the purse.
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
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn,
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount) {
        if(amount == null)return null;
        if(amount.getValue() < 0 || this.getBalance() < amount.getValue())return null;
        List<Valuable> templist = strategy.withdraw(amount,money);
        money.sort(comp);
        Collections.reverse(money);

        if(templist.size()>0) for(Valuable value : templist) money.remove(value);
        else return null;

        Valuable[] arrayMoney = new Valuable[templist.size()];
        arrayMoney = templist.toArray(arrayMoney);
        return arrayMoney;
	}

    public Valuable[] withdraw(double amountNeededToWithdraw){
        return withdraw(new Money(amountNeededToWithdraw,"Baht"));
    }

    /**
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return String.format("%d money with value %f",count(),getBalance());
    }

    /**
     * Set withdraw strategy you want to use.
     * @param strategy
     */
    public void setWithdrawStrategy(WithdrawStrategy strategy){
        this.strategy = strategy;
    }
}

