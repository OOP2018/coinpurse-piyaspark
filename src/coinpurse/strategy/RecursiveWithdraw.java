package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * RecursiveWithdraw is class that have withdraw methods by using recursion.
 * @author Piyaphol Wiengperm.
 */
public class RecursiveWithdraw implements WithdrawStrategy {
    private Comparator<Valuable> comparator = new ValueComparator();
    private List<Valuable> tempList = new ArrayList<>();

    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
        money.sort(comparator);
        return helper(money,amount.getValue(),amount);
    }

    public List<Valuable> helper( List<Valuable> money, double value,Valuable amount) {
        if (value == 0) return new ArrayList<>();
        if (value < 0) return null;
        if (money.size() == 0) if (value != 0) return null;
        tempList = helper(money.subList(1, money.size()), value - money.get(0).getValue(), amount);
        if (tempList == null) return helper(money.subList(1, money.size()),value, amount);
        else {
            if(!amount.getCurrency().equals(money.get(0).getCurrency())) return helper(money.subList(1, money.size()),value, amount);
            tempList.add(money.get(0));
            money.remove(0);
            return tempList;
        }
    }
}