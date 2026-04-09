
public class BOperations {
    private AccList accounts;
    private Stack transactionHistory;
    private BillQueue billQueue;
    private BillQueue accountRequests;
    private BankAccount[] fixedAccounts;

    public BOperations() {
        accounts = new AccList();
        transactionHistory = new Stack(100);
        billQueue = new BillQueue();
        accountRequests = new BillQueue();

        accounts.add(new BankAccount(1001, "miras", 150000));
        accounts.add(new BankAccount(1002, "dima", 220000));
        accounts.add(new BankAccount(1003, "ayanokoji", 180000));

        fixedAccounts = new BankAccount[3];

        fixedAccounts[0] = new BankAccount(1, "alibek", 1000);
        fixedAccounts[1] = new BankAccount(2, "amina", 2000);
        fixedAccounts[2] = new BankAccount(3, "angsar", 1500);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("account added successfully");
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("no accounts found");
            return;
        }

        System.out.println("accounts list");
        accounts.display();
    }

    public BankAccount searchByUsername(String username) {
        return accounts.find(username);
    }

    public void deposit(String username, double amount) {
        BankAccount account = searchByUsername(username);

        if (account == null) {
            System.out.println("account not found");
            return;
        }

        if (amount <= 0) {
            System.out.println("amount must be positive");
            return;
        }

        account.deposit(amount);
        transactionHistory.push("deposit " + amount + " to " + username);

        System.out.println("new balance " + account.getBalance());
    }

    public void withdraw(String username, double amount) {
        BankAccount account = searchByUsername(username);

        if (account == null) {
            System.out.println("account not found");
            return;
        }

        if (!account.withdraw(amount)) {
            System.out.println("withdraw failed check amount or balance");
            return;
        }

        transactionHistory.push("withdraw " + amount + " from " + username);

        System.out.println("new balance " + account.getBalance());
    }

    public void addTransaction(String transaction) {
        transactionHistory.push(transaction);
        System.out.println("added " + transaction);
    }

    public void showLastTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("no transactions yet");
            return;
        }

        System.out.println("last transaction " + transactionHistory.peek());
    }

    public void undoLastTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("nothing to undo");
            return;
        }

        String removed = transactionHistory.pop();
        System.out.println("undo " + removed);
    }



    public void addBillPayment(String billName) {
        billQueue.offer(billName);

        String text = "bill payment " + billName;
        transactionHistory.push(text);

        System.out.println("added " + billName);
    }

    public void processNextBillPayment() {
        if (billQueue.isEmpty()) {
            System.out.println("bill queue is empty");
            return;
        }

        String bill = (String) billQueue.poll();

        String text = "processed bill " + bill;
        transactionHistory.push(text);

        System.out.println(text);
    }

    public void displayBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("no pending bills");
            return;
        }

        System.out.println("bill queue");
        billQueue.display();
    }

    public void submitAccountRequest(AccountRequest request) {
        accountRequests.offer(request);
        System.out.println("request submitted " + request);
    }

    public void processAccountRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("no account requests");
            return;
        }

        AccountRequest request = (AccountRequest) accountRequests.poll();

        BankAccount newAccount = new BankAccount(
                request.getAccountNumber(),
                request.getUsername(),
                request.getInitialDeposit()
        );

        addAccount(newAccount);
        transactionHistory.push("account opened for " + request.getUsername());

        System.out.println("processed request for " + request.getUsername());
    }

    public void displayPendingRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("no pending requests");
            return;
        }

        System.out.println("pending account requests");
        accountRequests.display();
    }

    public void balanceEnquiry(String username) {
        BankAccount account = searchByUsername(username);

        if (account == null) {
            System.out.println("account not found");
            return;
        }

        System.out.println("current balance " + account.getBalance());
    }
    public void showArray() {
        for (BankAccount a : fixedAccounts) {
            System.out.println(a);
        }
    }
}