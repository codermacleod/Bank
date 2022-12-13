// For: src/main/java/tech/makers/bank/Main.java
// Note the package:
package tech.makers.bank;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        BankAccount bankAccount = new BankAccount();

        // Given a client makes a deposit of 1000 on 2021-01-10
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));

        // And a deposit of 2000 on 2021-01-13
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));

        // And a withdrawal of 500 on 2021-01-14
        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        // And a withdrawal of 500 now
        bankAccount.withdraw(50, LocalDate.now());

        // When she prints her bank statement
        System.out.println(bankAccount.generateStatement());
    }
}