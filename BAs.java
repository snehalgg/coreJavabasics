import java.util.ArrayList;

// Abstract class for BankAccount
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public abstract void printTransactionHistory();

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Concrete class for SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + getAccountNumber());
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println();
    }
}

// Concrete class for CheckingAccount
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
        } else {
            System.out.println("Exceeded overdraft limit.");
        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + getAccountNumber());
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println();
    }
}

public class BAs {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount("SA001", 1000, 5);
        BankAccount checkingAccount = new CheckingAccount("CA001", 2000, 1000);

        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);

        checkingAccount.deposit(1000);
        checkingAccount.withdraw(2500);

        savingsAccount.printTransactionHistory();
        checkingAccount.printTransactionHistory();
    }
}
