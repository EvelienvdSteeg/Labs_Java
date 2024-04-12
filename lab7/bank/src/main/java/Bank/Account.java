package Bank;

public class Account {
    private int number;
    private double balance;
    private double interestRate;

    public Account(){};

    public Account(int number, double balance, double interestRate){
        setNumber(number);
        setBalance(balance);
        setInterestRate(interestRate);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void withdrawMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RuntimeException("Niet genoeg geld in de bank");
        }

    }

    public void depositMoney(double amount) {
        balance += amount;
    }

    public double returnYearlyInterest() {
        double yearlyInterest = this.interestRate / 100 * this.balance;
        return yearlyInterest;
    }


    @Override
    public String toString() {
        return "Bank.Account{" +
                "number=" + number +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }


}
