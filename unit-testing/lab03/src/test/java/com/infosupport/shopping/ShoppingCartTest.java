package com.infosupport.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    private final Product xbox = new Product("Xbox 360", new BigDecimal("199.99"));
    private final Product playstation = new Product("PlayStation3", new BigDecimal(250));

    @Test
    public void add_oneProduct_shouldAddProductToCart() {
        // Arrange
        var sut = new ShoppingCart("Frank", null, null);

        // Act
        sut.add(xbox, 2);

        // Assert
        assertProductIsInCart(sut, xbox, 2);
    }

    @Test
    public void add_twiceSameProduct_shouldAddToExistingAmount() {
        var sut = new ShoppingCart("Frank", null, null);
        sut.add(xbox, 2);
        sut.add(xbox, 3);
        assertProductIsInCart(sut, xbox, 5);
    }

    @Test
    public void add_twoDifferentProducts_shouldAddBothToCart() {
        var sut = new ShoppingCart("Frank", null, null);
        sut.add(xbox, 1);
        sut.add(playstation, 2);
        assertProductIsInCart(sut, xbox, 1);
        assertProductIsInCart(sut, playstation, 2);
    }

    @Test
    public void getTotal_emptyCart_shouldBeZero() {
        var sut = new ShoppingCart("Frank", null, null);
        assertEquals(BigDecimal.ZERO, sut.getTotal());
    }

    @Test
    public void getTotal_twoProductsWithDifferentAmount_shouldCalculateCorrectTotal() {
        var sut = new ShoppingCart("Frank", null, null);
        sut.add(playstation, 2); // 500
        sut.add(xbox, 1); // 199.99
        assertEquals(new BigDecimal("699.99"), sut.getTotal());
    }

    private void assertProductIsInCart(ShoppingCart sut, Product expectedItem, int expectedAmount) {
        assertTrue(sut.getOrders().containsKey(expectedItem));
        assertEquals(expectedAmount, sut.getOrders().get(expectedItem));
    }

    @Test
    public void checkout_sufficientBalance_addsToPaymentHistory() {
        // Arrange
        var userRepository = new FakeUserRepository();
        var bankingService = new FakeBankingService();
        bankingService.getBalances().put("123456", new BigDecimal("300"));
        userRepository.getUsers().put("username", new User("John Doe", LocalDate.of(2010, 1, 1), "123456"));
        var sut = new ShoppingCart("username", userRepository, bankingService);
        sut.add(xbox, 1); // 199.99

        // Act
        sut.checkOut();

        // Assert
        assertEquals(1, userRepository.getPayments().size());
        assertEquals(new FakeUserRepository.PaymentHistory("username", new BigDecimal("199.99")),
                userRepository.getPayments().get(0));
    }

    @Test
    public void checkout_insufficientBalance_doesNotAddToPaymentHistory() {
        // Arrange
        var userRepository = new FakeUserRepository();
        var bankingService = new FakeBankingService();
        userRepository.getUsers().put("username", new User("John Doe", LocalDate.of(2010, 1, 1), "123456"));
        bankingService.getBalances().put("123456", new BigDecimal("199"));
        var sut = new ShoppingCart("username", userRepository, bankingService);
        sut.add(xbox, 1); // 199.99

        // Act
        sut.checkOut();

        // Assert
        assertEquals(0, userRepository.getPayments().size());
    }

    @Test
    public void checkout_insufficientBalance_doesNotDoPayment() {
        // Arrange
        var userRepository = new FakeUserRepository();
        var bankingService = new FakeBankingService();
        userRepository.getUsers().put("username", new User("John Doe", LocalDate.of(2010, 1, 1), "123456"));
        bankingService.getBalances().put("123456", new BigDecimal("199"));
        var sut = new ShoppingCart("username", userRepository, bankingService);
        sut.add(xbox, 1); // 199.99

        // Act
        sut.checkOut();

        // Assert
        assertEquals(0, bankingService.getPayments().size());
    }

}
