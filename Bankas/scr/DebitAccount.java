import java.math.BigDecimal;

public class DebitAccount extends Account {

    private BigDecimal accountLimit;

    public DebitAccount(String holderName) {
        super(holderName);
        accountLimit = BigDecimal.valueOf(0);
    }
}
