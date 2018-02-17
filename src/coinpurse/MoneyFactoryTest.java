package coinpurse;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Test the MoneyFactory using JUnit.
 * This is a JUnit 4 test suite.
 * @author Piyaphol Wiengperm.
 */
public class MoneyFactoryTest {
    /** test that MoneyFactory is singleton class.*/
    @Test
    public void testSingleton(){
        MoneyFactory mF1 = MoneyFactory.getInstance();
        MoneyFactory mF2 = MoneyFactory.getInstance();
        assertEquals(true,mF1==mF2);
    }

    /** test creating Thai money by String and double value.*/
    @Test
    public void testThaiMoney(){
        MoneyFactory mF = new ThaiMoneyFactory();
        assertEquals(100.0,mF.createMoney(100).getValue());
        assertEquals(20.0,mF.createMoney(20).getValue());
        assertEquals(500.0,mF.createMoney(500).getValue());
        assertEquals(10.0,mF.createMoney("10.0").getValue());
    }

    /** test creating Malaysia money by String and double value.*/
    @Test
    public void testMalayMoney(){
        MoneyFactory mF = new MalayMoneyFactory();
        assertEquals(50.0,mF.createMoney(50).getValue());
        assertEquals(0.1,mF.createMoney(0.1).getValue());
        assertEquals(0.2,mF.createMoney(0.2).getValue());
        assertEquals(10.0,mF.createMoney("10.0").getValue());
    }

    /** check Thai money currency.*/
    @Test
    public void testThaiMoneyCurrency(){
        MoneyFactory mF = new ThaiMoneyFactory();
        assertEquals("Baht",mF.createMoney(100).getCurrency());
        assertEquals("Baht",mF.createMoney(20).getCurrency());
        assertEquals("Baht",mF.createMoney(0.5).getCurrency());
    }

    /** check Malaysia money currency.*/
    @Test
    public void testMalayMoneyCurrency(){
        MoneyFactory mF = new MalayMoneyFactory();
        assertEquals("Ringgit",mF.createMoney(10).getCurrency());
        assertEquals("Ringgit",mF.createMoney(5).getCurrency());
        assertEquals("Ringgit",mF.createMoney(1).getCurrency());
        assertEquals("Sen",mF.createMoney(0.05).getCurrency());
        assertEquals("Sen",mF.createMoney(0.1).getCurrency());
        assertEquals("Sen",mF.createMoney(0.2).getCurrency());
    }

    /** test setting MoneyFactory to ThaiMoneyFactory.*/
    @Test
    public void testSetThaiMoneyFactory(){
        MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory thaiFactory = MoneyFactory.getInstance();
        assertTrue(thaiFactory instanceof ThaiMoneyFactory);
    }

    /** test setting MoneyFactory to MalayMoneyFactory.*/
    @Test
    public void testSetMalayMoneyFactory(){
        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory malayFactory = MoneyFactory.getInstance();
        assertTrue(malayFactory instanceof MalayMoneyFactory);
    }
}

