import ibank.Bank;
import ibank.BaseBankTest;

public class MockTest extends BaseBankTest {


    @Override
    protected Bank createBank() {
        return new TBank();
    }
}
