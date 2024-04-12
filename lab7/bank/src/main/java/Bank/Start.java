package Bank;

public class Start {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setBalance(100.25);
        System.out.println(account1.getBalance());
        account1.setNumber(1);
        account1.setInterestRate(2.3);
        System.out.println(account1.returnYearlyInterest());
        Account account2 = new Account();
        account2.setBalance(5.50);
        account2.setInterestRate(1.4);
        account2.setNumber(2);

        AccountManager ingAccountManager = new AccountManager();

        ingAccountManager.addNewAccount(account1);
        ingAccountManager.addNewAccount(account2);


        account1.depositMoney(500);

        Bank ING = new Bank();
        ING.setName("ING");


        System.out.println(ING);

        ING.transferMoney(account1, account2, 10);

        System.out.println(ING);



        System.out.println("Total amount in the bank: " + ING.totalAmountInBank());

        Bank Rabobank = new Bank();
        Rabobank.setName("Rabobank");
        System.out.println(Rabobank.getName());

        Account account3 = new Account();
        account3.setBalance(15.50);
        account3.setInterestRate(1.4);
        account3.setNumber(3);

        Account account4 = new Account();
        account4.setBalance(25.50);
        account4.setInterestRate(1.4);
        account4.setNumber(4);

        System.out.println(ING.totalAmountInBank());


    }
}
