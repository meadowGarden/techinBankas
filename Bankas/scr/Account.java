import java.math.BigDecimal;

public class Account implements ibank.Account {

    private String accountNumber;
    private String holderName;
    protected BigDecimal balance;


    public Account(String holderName) {
        this(holderName, BigDecimal.valueOf(0));
    }

    public Account(String holderName, BigDecimal balance) {
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

    @Override
    public String toString() {
//        return String.format("%s %s %.2f", accountNumber, holderName, balance);
        return String.format(this.getClass().getSimpleName() + " -> %s %s %.2f", accountNumber, holderName, balance);
    }
}
