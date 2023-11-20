import ibank.Account;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MockAccount implements Account {

    private String accountNumber;
    private String holderName;
    private BigDecimal balance;

    public MockAccount(String holderName, BigDecimal balance) {
        this.accountNumber = new AccountNumbersList().generateId();
        this.holderName = holderName;
        this.balance = balance;
    }

    @Override
    public String getNumber() {
        return accountNumber;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.add(bigDecimal);
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.subtract(bigDecimal);
            return true;
        }
        return false;
    }
}
