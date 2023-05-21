import java.util.ArrayList;
import java.util.Scanner;

public class BankTranfer {
    public static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void createAccount(String accountNumber, double balance) {
        BankAccount account = new BankAccount(accountNumber, balance);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public static void deleteAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                break;
            }
        }
    }

    public static void showAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountNumber() + " have balance: " + account.getBalance());
        }
    }

    public static void deposit(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                break;
            }
        }
    }

    public static void withdraw(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                break;
            }
        }
    }

    public static void enterNumber() {
        System.out.println("Hello. Please enter number.");
        System.out.println("1. Register account.");
        System.out.println("2. Delete account.");
        System.out.println("3. Show all accounts.");
        System.out.println("4. Deposit.");
        System.out.println("5. Withdraw.");
        System.out.println("6. Exit.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number;
            boolean isContinue = false;
            do {
                enterNumber();
                number = scanner.nextInt();
                switch (number) {
                    case (1): {
                        String accountNumber;
                        do {
                            System.out.println("Please enter account number.");
                            accountNumber = scanner.next();
                        } while (accountNumber.length() != 11);

                        double balance;
                        do {
                            System.out.println("Please enter balance.");
                            balance = scanner.nextDouble();
                        } while (balance < 0);

                        createAccount(accountNumber, balance);
                        break;
                    }

                    case (2): {
                        System.out.println("Please enter account number.");
                        String accountNumber = scanner.next();
                        deleteAccount(accountNumber);
                        break;
                    }

                    case (3): {
                        showAllAccounts();
                        break;
                    }

                    case (4): {
                        System.out.println("Please enter account number.");
                        String accountNumber = scanner.next();
                        System.out.println("Please enter amount.");
                        double amount = scanner.nextDouble();
                        deposit(accountNumber, amount);
                        break;
                    }

                    case (5): {
                        System.out.println("Please enter account number.");
                        String accountNumber = scanner.next();
                        System.out.println("Please enter amount.");
                        double amount = scanner.nextDouble();
                        withdraw(accountNumber, amount);
                        break;
                    }

                    case (6): {
                        isContinue = true;
                        System.exit(0);
                    }

                    default: {
                        System.out.println("Invalid number.");
                        break;
                    }
                }
            } while (!isContinue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
