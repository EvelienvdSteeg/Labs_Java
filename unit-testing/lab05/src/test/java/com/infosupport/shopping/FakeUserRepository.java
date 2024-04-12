package com.infosupport.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.infosupport.shopping.repository.UserRepository;

public class FakeUserRepository implements UserRepository {

    private HashMap<String, User> users = new HashMap<>();
    private List<PaymentHistory> payments = new ArrayList<>();

    public List<PaymentHistory> getPayments() {
        return payments;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void addPaymentHistory(String username, BigDecimal payment) {
        payments.add(new PaymentHistory(username, payment));
    }

    public record PaymentHistory(String username, BigDecimal payment) {
    }

}
