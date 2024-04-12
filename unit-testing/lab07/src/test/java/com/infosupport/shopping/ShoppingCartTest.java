package com.infosupport.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import com.infosupport.shopping.repository.UserRepository;
import com.infosupport.shopping.service.BankingService;

public class ShoppingCartTest {

    private final Product xbox = new Product("Xbox 360", new BigDecimal("199.99"));
    private final Product playstation = new Product("PlayStation3", new BigDecimal(250));
    private final UserRepository userRepository;
    private final BankingService bankingService;
    private final ShoppingCart sut;

    public ShoppingCartTest() {
        userRepository = mock(UserRepository.class);
        bankingService = mock(BankingService.class);
        sut = new ShoppingCart("Frank", userRepository, bankingService);
    }

    @Test
    public void add_oneProduct_shouldAddProductToCart() {
        // Act
        sut.add(xbox, 2);

        // Assert
        assertProductIsInCart(sut, xbox, 2);
    }

    @Test
    public void add_twiceSameProduct_shouldAddToExistingAmount() {
        sut.add(xbox, 2);
        sut.add(xbox, 3);
        assertProductIsInCart(sut, xbox, 5);
    }

    @Test
    public void add_twoDifferentProducts_shouldAddBothToCart() {
        sut.add(xbox, 1);
        sut.add(playstation, 2);
        assertProductIsInCart(sut, xbox, 1);
        assertProductIsInCart(sut, playstation, 2);
    }

    @Test
    public void getTotal_emptyCart_shouldBeZero() {
        assertEquals(BigDecimal.ZERO, sut.getTotal());
    }

    @Test
    public void getTotal_twoProductsWithDifferentAmount_shouldCalculateCorrectTotal() {
        sut.add(playstation, 2); // 500
        sut.add(xbox, 1); // 199.99
        assertEquals(new BigDecimal("699.99"), sut.getTotal());
    }

    @Test
    public void getOwner_cartWithOwner_returnsOwner() {
        assertEquals("Frank", sut.getOwner());
    }

    private void assertProductIsInCart(ShoppingCart sut, Product expectedItem, int expectedAmount) {
        assertTrue(sut.getOrders().containsKey(expectedItem));
        assertEquals(expectedAmount, sut.getOrders().get(expectedItem));
    }

    @Test
    public void checkout_sufficientBalance_addsToPaymentHistory() {
        // Arrange
        arrangeBalance();
        arrangeUser();
        sut.add(xbox, 1); // 199.99

        // Act
        sut.checkOut();

        // Assert
        verify(userRepository).addPaymentHistory("Frank", new BigDecimal("199.99"));
    }

    @Test
    public void checkout_insufficientBalance_doesNotAddToPaymentHistory() {
        // Arrange
        arrangeUser();
        arrangeBalance(new BigDecimal("199"));
        sut.add(xbox, 1); // 199.99

        // Act
        assertThrows(InsufficientBalanceException.class, () -> sut.checkOut());

        // Assert
        verifyNoPaymentHistory();
    }

    @Test
    public void checkout_insufficientBalance_doesNotDoPayment() {
        // Arrange
        arrangeUser();
        arrangeBalance(new BigDecimal("199"));
        var sut = new ShoppingCart("username", userRepository, bankingService);
        sut.add(xbox, 1); // 199.99

        // Act
        assertThrows(InsufficientBalanceException.class, () -> sut.checkOut());

        // Assert
        verifyNoPayment();
    }

    @Test
    public void checkout_insufficientBalanceAfterChecking_throwsException() {
        // Arrange
        arrangeUser();
        arrangeBalance();
        var expectedException = new InsufficientBalanceException("1235", new BigDecimal(199), new BigDecimal("199.99"));
        doThrow(expectedException).when(bankingService).makePayment(anyString(), any());
        var sut = new ShoppingCart("username", userRepository, bankingService);
        sut.add(xbox, 1); // 199.99

        // Act
        var actualException = assertThrows(InsufficientBalanceException.class, () -> sut.checkOut());

        // Assert
        assertEquals(expectedException, actualException);
    }

    private void arrangeBalance() {
        arrangeBalance(new BigDecimal("300"));
    }

    private void arrangeBalance(BigDecimal balance) {
        when(bankingService.getBalance(anyString())).thenReturn(balance);
    }

    
    private void arrangeUser() {
        arrangeUser(new UserBuilder().build());
    }
    private void arrangeUser(User user) {
        when(userRepository.getUser(anyString())).thenReturn(user);
    }
    
    private void verifyNoPayment() {
        verify(bankingService, never()).makePayment(anyString(), any());
    }

    private void verifyNoPaymentHistory() {
        verify(userRepository, never()).addPaymentHistory(anyString(), any(BigDecimal.class));
    }
}
