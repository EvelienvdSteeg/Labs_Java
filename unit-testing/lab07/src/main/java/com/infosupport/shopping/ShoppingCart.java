package com.infosupport.shopping;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.infosupport.shopping.repository.UserRepository;
import com.infosupport.shopping.service.BankingService;

public class ShoppingCart {
    private Map<Product, Integer> orders = new HashMap<>();
    private String owner;
    private UserRepository userRepository;
    private BankingService bankingService;

    public String getOwner() {
        return owner;
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

    public ShoppingCart(String username, UserRepository userRepository, BankingService bankingService) {
        this.userRepository = userRepository;
        this.bankingService = bankingService;
        orders = new HashMap<Product, Integer>();
        owner = username;
    }

    /**
     * Add a new item to this cart.
     * When the item is already in the list, only the amount should be increased
     * and no new item added.
     * 
     * @param item   the item to add
     * @param amount The amount for this item to be added.
     */
    public void add(Product item, int amount) {
        if (orders.containsKey(item)) {
            orders.put(item, orders.get(item) + amount);
        } else {
            orders.put(item, amount);
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (var product : orders.keySet()) {
            total = total.add(product.price().multiply(BigDecimal.valueOf(orders.get(product))));
        }
        return total;
    }

    public void checkOut() {
        var user = userRepository.getUser(owner);
        BigDecimal total = getTotal();
        BigDecimal balance = bankingService.getBalance(user.accountNumber());
        if (balance.compareTo(total) >= 0) {
            bankingService.makePayment(user.accountNumber(), total);
            userRepository.addPaymentHistory(owner, total);
        } else {
            throw new InsufficientBalanceException(owner, balance, total);
        }
    }
}
