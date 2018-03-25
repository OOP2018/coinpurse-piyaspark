package coinpurse.strategy;

import coinpurse.Money;
import coinpurse.Valuable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test for all possible way that Withdraw class can do.
 * @author Piyaphol Wiengperm.
 */
public class WithdrawTest {
    private WithdrawStrategy strategy;

    @Before
    public void setUp() {
        strategy = new GreedyWithdraw();
    }

    /**
     * Get total value from list of money.
     * @param money
     * @return total value.
     */
    public double getValue(List<Valuable> money){
        double total = 0;
        for (Valuable m : money)total += m.getValue();
        return total;
    }

    /**
     * Test simple withdraw with 1 or 2 times.
     */
    @Test
    public void testWithdraw() {
        List<Valuable> money = new ArrayList<>();
        money.add(new Money(5, "Baht"));
        money.add(new Money(20, "Baht"));
        money.add(new Money(10, "Baht"));
        money.add(new Money(1, "Baht"));
        assertTrue(getValue(strategy.withdraw(new Money(5, "Baht"), money)) == new Money(5, "Baht").getValue());
        assertTrue(getValue(strategy.withdraw(new Money(20, "Baht"), money)) == new Money(20, "Baht").getValue());
        assertTrue(getValue(strategy.withdraw(new Money(1, "Baht"), money)) == new Money(1, "Baht").getValue());

    }

    /**
     * Test withdraw all money in the list.
     */
    @Test
    public void testWithdrawAll() {
        List<Valuable> money = new ArrayList<>();
        money.add(new Money(5, "Baht"));
        money.add(new Money(20, "Baht"));
        money.add(new Money(10, "Baht"));
        money.add(new Money(1, "Baht"));
        assertEquals(new Money(36, "Baht").getValue(),getValue(strategy.withdraw(new Money(36, "Baht"),money)),0);
    }

    /**
     * Test withdraw everything except one item in the list.
     */
    @Test
    public void testWithdrawExceptOne(){
        List<Valuable> money = new ArrayList<>();
        money.add(new Money(5, "Baht"));
        money.add(new Money(20, "Baht"));
        money.add(new Money(10, "Baht"));
        money.add(new Money(1, "Baht"));
        strategy.withdraw(new Money(35,"Baht"),money);
        assertEquals(1,money.size());
        assertEquals(new Money(1,"Baht"),money.get(0));
    }

    /**
     * Test when user withdraw more than money in the purse.
     */
    @Test
    public void testExceedWithdraw(){
        List<Valuable> money = new ArrayList<>();
        money.add(new Money(5, "Baht"));
        money.add(new Money(20, "Baht"));
        money.add(new Money(10, "Baht"));
        money.add(new Money(1, "Baht"));
        assertFalse(strategy.withdraw(new Money(40,"Baht"),money) != null);
        assertEquals(null,strategy.withdraw(new Money(50,"Baht"),money));
    }

    /**
     * Test withdraw with wrong currency.
     */
    @Test
    public void testWrongCurrencyWithdraw(){
        List<Valuable> money = new ArrayList<>();
        money.add(new Money(5, "Baht"));
        money.add(new Money(20, "Ringgit"));
        money.add(new Money(10, "Ringgit"));
        money.add(new Money(1, "Baht"));
        assertFalse(strategy.withdraw(new Money(5,"Ringgit"),money) != null);
        assertFalse(strategy.withdraw(new Money(10,"Baht"),money) != null);
    }

    /**
     * Test impossible way to withdraw money.
     */
    @Test
    public void testImpossibleWithdraw(){
        List<Valuable> money = new ArrayList<>();
        assertFalse(strategy.withdraw(new Money(10,"Baht"),money) != null);
        assertTrue(strategy.withdraw(new Money(0,"Baht"),money) != null);
        assertTrue(strategy.withdraw(new Money(-1,"Baht"),money) == null);
    }

}