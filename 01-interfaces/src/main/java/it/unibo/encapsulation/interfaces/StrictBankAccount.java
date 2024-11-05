package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private double balance;
    private int transactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private final int id;

    public StrictBankAccount(final int id, final double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        this.transactions = 0;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void deposit(final int id, final double amount) {
        if (this.id == id) {
            this.transactions++;
            this.balance += amount;
        }
    }

    public void withdraw(final int id, final double amount) {
        if (this.id == id && this.balance >= amount) {
            this.transactions++;
            this.balance -= amount;
        }
    }

    public void depositFromATM(final int id, final double amount) {
        if (this.id == id) {
            this.transactions++;
            this.balance += (amount - ATM_TRANSACTION_FEE);
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (this.id == id && this.balance >= amount + ATM_TRANSACTION_FEE) {
            this.transactions++;
            this.balance -= (amount + ATM_TRANSACTION_FEE);
        }
    }

    public void chargeManagementFees(final int id) {
        if (this.id == id) {
            double managementFees = 5 + (0.1 * this.transactions);
            if (this.balance >= managementFees) {
                this.transactions++;
                this.balance -= managementFees;
            }
        }
    }
}
