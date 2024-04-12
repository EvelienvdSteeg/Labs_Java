import Bank.Account;
import Bank.AccountManager;
import Bank.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BankTest2 {


    @Mock
    private AccountManager accountManagerMock;

    @InjectMocks
    private Bank sut;


    @BeforeEach
    void setUp() {
        sut.setName("ING");

//       accountManagerMock = mock(Bank.AccountManager.class);
//        sut.setAccountManager(accountManagerMock);
    }

    @Test
    void checkIfNewAccountCanBeAdded() {

        //given
        Account account1 = new Account();
        account1.setNumber(1);
        account1.setBalance(100);
        account1.setInterestRate(1.2);

        doNothing().when(accountManagerMock.addNewAccount(any())).thenReturn(true);

        //when
        sut.addAccount(account1);

        //then

        verify(accountManagerMock).addNewAccount(any());


    }

    @Test
    void checkIfNewAccountCanBeAddedWithArgumentCaptor() {

        //given
        Account account1 = new Account();
        account1.setNumber(1);
        account1.setBalance(100);
        account1.setInterestRate(1.2);

        ArgumentCaptor<Account> arg = ArgumentCaptor.forClass(Account.class);



        //when
        sut.addAccount(account1);

        //then

        verify(accountManagerMock).addNewAccount(any());
        assertEquals(account1, arg.getValue());


    }


}