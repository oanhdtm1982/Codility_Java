public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountNumber + " balance:" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountNumber + " balance:" + balance);
        } else {
            System.out.println("Insufficient balance." + accountNumber + " balance:" + balance);
        }
    }
}
