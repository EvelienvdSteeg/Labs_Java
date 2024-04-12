package com.infosupport.shopping;

import java.time.LocalDate;

public class UserBuilder {
    private String name = "John Doe";
    private LocalDate datum = LocalDate.of(2010, 1, 1);
    private String bankAccount = "12345";

    public UserBuilder withNoBankAccount(){
        bankAccount = null;
        return this;
    }

    public User build(){
        return new User(name, datum, bankAccount);
    }







}
