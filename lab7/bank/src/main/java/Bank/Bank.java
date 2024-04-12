package Bank;

public class Bank {




    private AccountManager accountManager = new AccountManager();
    String name;

    public Bank(){

    }

    public Bank(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void addAccount(Account newAccount) {
        this.accountManager.addNewAccount(newAccount);

    }
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public String toString() {
        return "Bank.Bank{" +
                "bankAccounts=" +
                ", name='" + name + '\'' +
                '}';
    }

    public void transferMoney(Account account1, Account account2, double amount) {
        if (account1.getBalance() > amount) {
            account1.withdrawMoney(amount);
            account2.depositMoney(amount);
        } else {
            throw new RuntimeException("Niet genoeg geld in het account");
        }

    }

    public double totalAmountInBank() {
        return this.accountManager.totalAmountInBank();

    }

    public void showAccounts(){
        for(Account a : accountManager){
            System.out.println(a);
        }
    }

}
