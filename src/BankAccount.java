public class BankAccount {
    private int accountNumber;
    private String username;
    private double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void display() {
        System.out.println(username + " balance: " + balance);
    }

}
