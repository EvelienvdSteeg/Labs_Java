import Bank.Bank;
import org.junit.jupiter.api.Test;
import Bank.Account;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void testBankApplicatie() {
        Account account1 = new Account();
        account1.setBalance(100.25);
        account1.setNumber(1);
        account1.setInterestRate(2.3);
        assertEquals(100.25, account1.getBalance());
        assertEquals(1, account1.getNumber());
        assertEquals(2.3, account1.getInterestRate());
        assertEquals(2.3057499999999997, account1.returnYearlyInterest());

        account1.depositMoney(2);
        assertEquals(102.25, account1.getBalance());
        account1.withdrawMoney(10);
        assertEquals(92.25, account1.getBalance());

        Account account2 = new Account();
        account2.setBalance(5.50);
        account2.setInterestRate(1.4);
        account2.setNumber(2);

        Bank ING = new Bank();
        ING.setName("ING");


        ING.transferMoney(account1, account2, 10);
        assertEquals(82.25, account1.getBalance());
        assertEquals(15.50, account2.getBalance());
        assertEquals(97.75, ING.totalAmountInBank());

        assertThrows(RuntimeException.class, () -> account1.withdrawMoney(1000));
        assertThrows(RuntimeException.class, () -> ING.transferMoney(account2, account1, 20));
    }
}