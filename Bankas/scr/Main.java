import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        MockBank myBank = new MockBank();
        System.out.println(myBank.getTotalReserves());

        MockAccount account01 = new MockAccount( "john doe", BigDecimal.valueOf(5));
        System.out.println(account01.getNumber());
        System.out.println(account01.getHolderName());
        System.out.println(account01.deposit(BigDecimal.valueOf(20)));
        System.out.println(account01.getBalance());
        System.out.println(account01.withdraw(BigDecimal.valueOf(10)));
        System.out.println(account01.getBalance());

        MockAccount account02 = (MockAccount) myBank.getAccountByNumber(account01.getNumber());

        System.out.println(account01);
        System.out.println(account02);


        System.out.println(myBank.getTotalReserves());




    }
}
