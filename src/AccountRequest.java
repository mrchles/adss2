public class AccountRequest {
    private int accountNumber;
    private String username;
    private double initialDeposit;

    public AccountRequest(int accountNumber, String username, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.initialDeposit = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public String toString() {
        return "request " + accountNumber + " " + username + " initial deposit " + initialDeposit;
    }
}