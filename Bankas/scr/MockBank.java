import ibank.Account;
import ibank.Bank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class MockBank implements Bank {

    private ArrayList<Account> accountBook;

    public MockBank() {
        this.accountBook = new ArrayList<>();
    }


    @Override
    public int getNumberOfAccounts() {
        return accountBook.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Account a : accountBook) {
            sum = sum.add(a.getBalance());
        }
        return sum;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountBook;
    }

    @Override
    public Account openDebitAccount(String s) {
        return null;
    }

    @Override
    public Account openCreditAccount(String s, BigDecimal bigDecimal) {
        return null;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        for (Account a : accountBook) {
            a.getHolderName().equals(s);
            return a;
        }
        return null;
    }

    @Override
    public Account getAccountByNumber(String s) {
        for (Account a : accountBook) {
            if (a.getNumber().equals(s)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void closeAccount(Account account) {

    }
}
