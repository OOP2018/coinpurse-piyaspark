package coinpurse;

/**
 * This is demo test class for MoneyFactory.
 * Test printing Thai money and Malaysia money.
 * @author Piyaphol Wiengperm.
 */
public class MoneyFactoryDemo {
    public static void main(String[] args) {
        System.out.println("Test creating Thai money...");
        MoneyFactory.setFactory(new ThaiMoneyFactory());
        MoneyFactory mF2 = MoneyFactory.getInstance();
        Valuable thaiMoney1 = mF2.createMoney(0.25);
        System.out.println(thaiMoney1.toString());
        Valuable thaiMoney2 = mF2.createMoney("100.0");
        System.out.println(thaiMoney2.toString());
        Valuable thaiMoney3 = mF2.createMoney("500.0");
        System.out.println(thaiMoney3.toString());

        System.out.println("Test creating Malaysia money...");
        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory mF3 = MoneyFactory.getInstance();
        Valuable malayMoney1 = mF3.createMoney(5.0);
        System.out.println(malayMoney1.toString());
        Valuable malayMoney2 = mF3.createMoney("0.1");
        System.out.println(malayMoney2.toString());
        Valuable malayMoney3 = mF3.createMoney("10.0");
        System.out.println(malayMoney3.toString());

    }
}
