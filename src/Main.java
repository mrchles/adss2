import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BOperations bankSystem = new BOperations();

    public static void main(String[] args) {

        while (true) {
            System.out.println("main menu");
            System.out.println("1 enter bank");
            System.out.println("2 enter atm");
            System.out.println("3 admin area");
            System.out.println("4 exit");
            System.out.println("enter: ");


            int choice = readInt();

            if (choice == 1) bankMenu();
            else if (choice == 2) atmMenu();
            else if (choice == 3) adminMenu();
            else return;
        }
    }

    private static void bankMenu() {
        while (true) {
            System.out.println("bank menu");
            System.out.println("1 submit account request");
            System.out.println("2 deposit");
            System.out.println("3 withdraw");
            System.out.println("4 add bill");
            System.out.println("5 add transaction");
            System.out.println("6 show last transaction");
            System.out.println("7 undo transaction");
            System.out.println("8 show accounts");
            System.out.println("9 search");
            System.out.println("0 back");
            System.out.println("enter: ");

            int c = readInt();

            if (c == 1) {
                System.out.print("account number ");
                int id = readInt();
                System.out.print("username ");
                String u = scanner.nextLine();
                System.out.print("deposit ");
                double d = readDouble();
                bankSystem.submitAccountRequest(new AccountRequest(id, u, d));
            }

            else if (c == 2) {
                System.out.print("username ");
                String u = scanner.nextLine();
                System.out.print("amount ");
                double a = readDouble();
                bankSystem.deposit(u, a);
            }

            else if (c == 3) {
                System.out.print("username ");
                String u = scanner.nextLine();
                System.out.print("amount ");
                double a = readDouble();
                bankSystem.withdraw(u, a);
            }

            else if (c == 4) {
                System.out.print("bill name ");
                bankSystem.addBillPayment(scanner.nextLine());
            }

            else if (c == 5) {
                bankSystem.addTransaction(scanner.nextLine());
            }

            else if (c == 6) bankSystem.showLastTransaction();
            else if (c == 7) bankSystem.undoLastTransaction();
            else if (c == 8) bankSystem.displayAllAccounts();

            else if (c == 9) {
                System.out.print("username ");
                System.out.println(bankSystem.searchByUsername(scanner.nextLine()));
            }

            else return;
        }
    }

    private static void atmMenu() {
        while (true) {
            System.out.println("atm menu");
            System.out.println("1 balance enquiry");
            System.out.println("2 withdraw");
            System.out.println("0 back");
            System.out.println("enter: ");

            int c = readInt();

            if (c == 1) {
                System.out.print("username ");
                bankSystem.balanceEnquiry(scanner.nextLine());
            }

            else if (c == 2) {
                System.out.print("username ");
                String u = scanner.nextLine();
                System.out.print("amount ");
                double a = readDouble();
                bankSystem.withdraw(u, a);
            }

            else return;
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("admin menu");
            System.out.println("1 view requests");
            System.out.println("2 process request");
            System.out.println("3 view bills");
            System.out.println("4 process bill");
            System.out.println("5 show accounts");
            System.out.println("6 show predifined accounts");
            System.out.println("0 back");
            System.out.println("enter: ");

            int c = readInt();

            if (c == 1) bankSystem.displayPendingRequests();
            else if (c == 2) bankSystem.processAccountRequest();
            else if (c == 3) bankSystem.displayBillQueue();
            else if (c == 4) bankSystem.processNextBillPayment();
            else if (c == 5) bankSystem.displayAllAccounts();
            else if (c == 6) bankSystem.showArray();
            else return;
        }
    }

    private static int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }
}