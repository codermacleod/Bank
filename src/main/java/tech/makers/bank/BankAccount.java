package tech.makers.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int balance;
    public List<Transaction> transactions;

    public BankAccount() {
//        balance = 0;
        transactions = new ArrayList<>();
    }

    public void deposit(int amount, LocalDate date) {
//        balance += amount;
        transactions.add(new Transaction(amount, date, "deposit"));
    }

    public void withdraw(int amount, LocalDate date) {
//        balance -= amount;
        transactions.add(new Transaction(amount, date, "withdrawal"));
    }
    public class Transaction {
        public int amount;
        public LocalDate date;
        public String type;

        public Transaction(int amount, LocalDate date, String type) {
            this.amount = amount;
            this.date = date;
            this.type = type;
        }
    }

    public String generateStatement() {
        String statement = "";
        statement += "";
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Date", "Credit", "Debit", "Balance");
        int credit = 0;
        int debit = 0;
        for (Transaction t : transactions) {
            if (t.type == "deposit") {
                credit = t.amount;
                balance += credit;
            } else if (t.type == "withdrawal") {
                debit += t.amount;
                credit = 0;
                balance -= debit;
            }

//            statement += t.date + "\t" + t.amount + "\t" + balance + "\n";
            System.out.printf("%-15s %-10s %-10s %-10s\n", t.date, credit, debit, balance);
        }
        return statement;

    }


}