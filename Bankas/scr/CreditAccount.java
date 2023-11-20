import java.math.BigDecimal;

public class CreditAccount extends Account {
    private BigDecimal accountLimit;

    public CreditAccount(String holderName, BigDecimal creditLimit) {
        super(holderName);
        accountLimit = creditLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if (super.balance.add(accountLimit).subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.subtract(amount);
            return true;
        }
        return false;
    }
}