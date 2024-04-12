package com.infosupport.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infosupport.shopping.service.BankingService;

public class FakeBankingService implements BankingService {

    private final Map<String, BigDecimal> balances = new HashMap<>();
    private final List<Payment> payments = new ArrayList<>();

    public Map<String, BigDecimal> getBalances() {
        return balances;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public BigDecimal getBalance(String accountNumber) {
        return balances.get(accountNumber);
    }

    @Override
    public void makePayment(String accountNumber, BigDecimal payment) {
        payments.add(new Payment(accountNumber, payment));
    }

    public record Payment(String accountNumber, BigDecimal payment) {
    }

}
