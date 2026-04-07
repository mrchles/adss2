import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BOperations bank = new BOperations();
        Scanner sc = new Scanner(System.in);

        System.out.println("task 1");
        //bank.addAccount(new BankAccount(1, "Miras", 150000));
        //bank.addAccount(new BankAccount(2, "Ayanokoji", 220000));
        //bank.addAccount(new BankAccount(2, "Dima", 1000000));
        for (int i = 0; i < 2; i++) {
            System.out.print("enter username: ");
            String name = sc.next();

            System.out.print("enter balance: ");
            double balance = sc.nextDouble();

            bank.addAccount(new BankAccount(i + 1, name, balance));
        }

        System.out.println("accounts list:");
        bank.showAccounts();

        System.out.print("enter username to search: ");
        String searchName = sc.next();

        BankAccount found = bank.findByUsername(searchName);

        if (found != null) {
            System.out.println("account found:");
            found.display();
        } else {
            System.out.println("account not found");
        }
    }
}
