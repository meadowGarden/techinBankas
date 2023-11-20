import ibank.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class TBank implements ibank.Bank {

    private ArrayList<Account> accountBook;

    public TBank() {
        this.accountBook = new ArrayList<>();
    }


    @Override
    public int getNumberOfAccounts() {
        return accountBook.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
//        BigDecimal sum = BigDecimal.valueOf(0);
//        for (Account a : accountBook) {
//            sum = sum.add(a.getBalance());
//        }
//        return sum;

        return accountBook.stream()
                .map(o -> o.getBalance())
                .reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountBook;
    }

    @Override
    public Account openDebitAccount(String accountHolderName) {
//        for (Account a : accountBook) {
//            if(a.getHolderName().equals(accountHolderName)) {
//                return null;
//            }
//        }
//        Account account = new DebitAccount(accountHolderName);
//        accountBook.add(account);
//        return account;

        if (accountBook.stream().anyMatch(a -> a.getHolderName().equals(accountHolderName))) {
            return null;
        }
        Account account = new DebitAccount(accountHolderName);
        accountBook.add(account);
        return account;
    }

    @Override
    public Account openCreditAccount(String accountHolderName, BigDecimal creditLimit) {
//        for (Account a : accountBook) {
//            if(a.getHolderName().equals(accountHolderName)) {
//                return null;
//            }
//        }
//        Account account = new CreditAccount(accountHolderName, creditLimit);
//        accountBook.add(account);
//        return account;

        if (accountBook.stream().anyMatch(a -> a.getHolderName().equals(accountHolderName))) {
            return null;
        }

        Account account = new CreditAccount(accountHolderName, creditLimit);
        accountBook.add(account);
        return account;
    }

    @Override
    public Account getAccountByHolderName(String s) {
//        for (Account a : accountBook) {
//            a.getHolderName().equals(s);
//            return a;
//        }
//        return null;

        return accountBook.stream()
                .filter(a -> a.getHolderName().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
//        for (Account a : accountBook) {
//            if (a.getNumber().equals(s)) {
//                return a;
//            }
//        }
//        return null;

        return accountBook.stream()
                .filter(a -> a.getNumber().equals(s))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accountBook.remove(account);
    }
}
