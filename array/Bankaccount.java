package array;

class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(double initialBalance, double overdraftLimit) {
        super(initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

 class BA {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new SavingsAccount(1000, 5); // Initial balance: 1000, Interest rate: 5%
        accounts[1] = new CurrentAccount(2000, 1000); // Initial balance: 2000, Overdraft limit: 1000

        // Perform transactions
        accounts[0].deposit(500); // Deposit 500 to SavingsAccount
        accounts[1].withdraw(300); // Withdraw 300 from CurrentAccount

        // Calculate interest for SavingsAccount
        if (accounts[0] instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) accounts[0];
            savingsAccount.calculateInterest();
        }

        // Display balances
        for (BankAccount account : accounts) {
            System.out.println("Balance: " + account.getBalance());
        }
    }
}
