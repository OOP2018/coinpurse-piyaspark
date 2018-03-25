package coinpurse.strategy;

import coinpurse.Valuable;

import java.util.List;

/**
 * The interface that do like strategy for withdrawing money.
 * @author Piyaphol Wiengperm.
 */
public interface WithdrawStrategy {

    /**
     * A simple method for withdraw money.
     * @param amount amount of value you want to withdraw.
     * @param money money in your purse.
     * @return money that can withdraw.
     */
    public List<Valuable> withdraw(Valuable amount,List<Valuable> money);
}
