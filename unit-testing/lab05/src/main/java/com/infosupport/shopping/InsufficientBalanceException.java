package com.infosupport.shopping;

import java.math.BigDecimal;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String accountNumber, BigDecimal balance, BigDecimal needed) {
       super(String.format("Insufficient balance for account %s! Needed: %s, actual balance: %s",
         accountNumber,
         needed,
         balance)
       );
    }
 }
 
