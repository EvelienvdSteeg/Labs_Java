package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManager implements Iterable<Account> {


    List<Account> bankAccounts = new ArrayList<>();

    public void addNewAccount(Account newAccount) {
        this.bankAccounts.add(newAccount);

    }

    public double totalAmountInBank() {
        double totalAmount = 0;
        for (int i = 0; i < bankAccounts.size(); i++) {
            totalAmount += bankAccounts.get(i).getBalance();

        }
        return totalAmount;
    }

    @Override
    public Iterator<Account> iterator() {
        return new Accountiterator();
    }

    class Accountiterator implements Iterator<Account> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if (counter < bankAccounts.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Account next() {
            var a = bankAccounts.get(counter);
            counter++;
            return a;
        }
    }
}
