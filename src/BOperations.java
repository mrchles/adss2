import java.util.LinkedList;

public class BOperations implements BOperationsINT {

    LinkedList<BankAccount> accounts = new LinkedList<>();
    @Override
    public void addAccount(BankAccount acc) {
        accounts.add(acc);
        System.out.println("account added");
    }

    @Override
    public void showAccounts() {
        for (BankAccount a : accounts) {
            a.display();
        }
    }

    @Override
    public BankAccount findByUsername(String username) {
        for (BankAccount a : accounts) {
            if (a.getUsername().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }
}
