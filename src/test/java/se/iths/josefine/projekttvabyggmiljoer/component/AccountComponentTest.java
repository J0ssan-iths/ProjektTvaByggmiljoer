package se.iths.josefine.projekttvabyggmiljoer.component;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {

    AccountComponent accountComponent;

    //Körs innan varje test så att saldot alltid börjar på 0
    @BeforeEach
    void setUp() {
        accountComponent = new AccountComponent();
    }

    //Testar så saldot är 0 från start
    @Test
    void getBalanceTest() {
        assertEquals(0, accountComponent.getBalance());
    }

    @Test
    void withdrawltTest() {
        accountComponent.withdrawal(100);
        assertEquals(-100, accountComponent.getBalance());
    }

    @Test
    void depostitTest() {
        accountComponent.deposit(150);
        assertEquals(150, accountComponent.getBalance());
    }

    @Test
    void depositAndWithdrawlTest() {
        accountComponent.deposit(300);
        accountComponent.withdrawal(100);
        assertEquals(200, accountComponent.getBalance());
    }
}
