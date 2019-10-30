package assignment6.q1;

public class Transaction {
    String transactionName;
    double amount;

    public Transaction(String transactionName, double amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return transactionName + " — " + amount;
    }
}
