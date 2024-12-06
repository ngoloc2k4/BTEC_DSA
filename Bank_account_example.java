public class Bank_account_example {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        System.out.println("Initial balance: " + account.getBalance());
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());
        account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}

// Example of improved security in banking system

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
