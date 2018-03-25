package coinpurse.strategy;


import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Greedy withdraw use basic logic to withdraw money.
 * @author Piyaphol Wiengperm.
 */
public class GreedyWithdraw implements WithdrawStrategy {
    private Comparator<Valuable> comp = new ValueComparator();

    /**
     * Methods that show how to withdraw money.
     * @param amount
     * @param money
     * @return list of money.
     */
    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
        if(amount == null)return null;
        if(amount.getValue() < 0)return null;
        double amountNeededToWithdraw = amount.getValue();
        List<Valuable> templist = new ArrayList<>();
        money.sort(comp);
        Collections.reverse(money);

        for(int i = 0;i<=money.size()-1;i++){
            if(amountNeededToWithdraw>0){
                if (money.get(i).getCurrency().equalsIgnoreCase(amount.getCurrency())){
                    if(amountNeededToWithdraw - money.get(i).getValue()>=0) {
                        amountNeededToWithdraw -= money.get(i).getValue();
                        templist.add(money.get(i));
                    }
                }else break;
            }
        }
        if ( amountNeededToWithdraw != 0 ) return null;
        for (Valuable v : templist) money.remove(v);
        money = new ArrayList<>();
        return templist ;
    }

}
