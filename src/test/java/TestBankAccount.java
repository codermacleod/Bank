import org.junit.jupiter.api.Test;
import tech.makers.bank.BankAccount;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBankAccount {

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100, LocalDate.now());
        assertEquals(100, bankAccount.transactions.get(0).amount);
        assertEquals(LocalDate.now(), bankAccount.transactions.get(0).date);
        assertEquals("deposit", bankAccount.transactions.get(0).type);
    }

    @Test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(50, LocalDate.now());
        assertEquals(50, bankAccount.transactions.get(0).amount);
        assertEquals(LocalDate.now(), bankAccount.transactions.get(0).date);
        assertEquals("withdrawal", bankAccount.transactions.get(0).type);
    }

    @Test
    public void testGenerateStatement() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100, LocalDate.now());
        bankAccount.withdraw(50, LocalDate.now());
        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append(String.format(
                "%-15s %-10s %-10s %-10s\n", "Date", "Credit", "Debit", "Balance    \n"+
                        LocalDate.now()+"      100        0          100       \n"+
                        LocalDate.now()+"      0          50         50        \n"));
        assertEquals(expectedStatement, bankAccount.generateStatement());
    }

}