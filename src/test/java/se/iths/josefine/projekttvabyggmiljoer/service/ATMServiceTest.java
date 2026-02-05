package se.iths.josefine.projekttvabyggmiljoer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.josefine.projekttvabyggmiljoer.component.AccountComponent;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.AmountOverstepsMaxamountException;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.NotEnoghBalanceException;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.WrongInputException;
import se.iths.josefine.projekttvabyggmiljoer.model.ATMService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @InjectMocks
    ATMService atmService;

    @Mock
    AccountComponent accountComponent;

    WrongInputException wrongInputException;
    AmountOverstepsMaxamountException amountOverstepsMaxamountException;
    NotEnoghBalanceException notEnoghBalanceException;


    @Test
    void wrongInputExceptionDepositTest() {
        assertThrows(WrongInputException.class, () ->
                atmService.deposit(0));
        assertThrows(WrongInputException.class, () ->
                atmService.deposit(-100));
    }

    @Test
    void wrongInputExceptionWithdrawTest() {
        assertThrows(WrongInputException.class, () ->
                atmService.withdrawal(0));
        assertThrows(WrongInputException.class, () ->
                atmService.withdrawal(-100));
    }

    @Test
    void AmountOverstepsMaxamountExceptionWithdrawTest() {
        assertThrows(AmountOverstepsMaxamountException.class, () -> atmService.withdrawal(10001));
    }

    @Test
    void NotEnoghBalanceExceptionWithdrawTest() {
        assertThrows(NotEnoghBalanceException.class, () ->
                atmService.withdrawal(400));
    }

    @Test
    void correctWithdrawTest() {
        when(accountComponent.getBalance()).thenReturn(500);
        atmService.withdrawal(200);
        verify(accountComponent).withdrawal(200);
    }

    @Test
    void correctDepositTest() {
        atmService.deposit(400);
        verify(accountComponent).deposit(400);
    }

    @Test
    void getBalanceTest() {
        when(accountComponent.getBalance()).thenReturn(500);
        int balance = atmService.getBalance();
        verify(accountComponent).getBalance();
        assertEquals(500, balance);
    }

}
