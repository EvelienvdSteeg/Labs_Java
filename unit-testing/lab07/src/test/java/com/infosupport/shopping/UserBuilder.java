package com.infosupport.shopping;

import java.time.LocalDate;

public class UserBuilder {

    private String name = "Frank";
    private LocalDate birthDate = LocalDate.of(2010, 1, 1);
    private String accountNumber = "1234";

    public User build() {
        return new User(name, birthDate, accountNumber);
    }

    public UserBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withAge(int age) {
        LocalDate now = LocalDate.now();
        this.birthDate = now.withYear(now.getYear() - age);
        return this;
    }

}
