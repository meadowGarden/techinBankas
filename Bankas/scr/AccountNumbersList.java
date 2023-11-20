import java.util.ArrayList;
import java.util.Random;

public class AccountNumbersList {

    private static ArrayList<String> list;
    private int counter;

    public AccountNumbersList() {
        this.list = new ArrayList<>();
    }

    public String generateId() {
        String newID = "LT" + new Random().nextLong(9999);
        while (true) {
            if (!list.contains(newID)) {
                list.add(newID);
                return newID;
            }
            newID = "LT" + new Random().nextLong(9999);
        }
    }

}
