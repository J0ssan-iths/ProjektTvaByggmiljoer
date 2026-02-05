package se.iths.josefine.projekttvabyggmiljoer.model;

import org.springframework.stereotype.Service;
import se.iths.josefine.projekttvabyggmiljoer.component.AccountComponent;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.AmountOverstepsMaxamountException;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.NotEnoghBalanceException;
import se.iths.josefine.projekttvabyggmiljoer.exceptions.WrongInputException;

@Service
public class ATMService {

    //Refererar till AccountComponent
    private AccountComponent accountComponent;

    private static final int maxWithdrawal = 10000;

    //Injiceras via konstruktor (dependency injection)
    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    //Metod regler
    public void withdrawal(int amount) {

        if (amount <= 0) {
            throw new WrongInputException("Beloppet måste vara över 0kr vid uttag");
        }
        if (amount > 10000) {
            throw new AmountOverstepsMaxamountException("Beloppet får inte överstiga 10000kr vi duttag");
        }
        if (amount > accountComponent.getBalance()) {
            throw new NotEnoghBalanceException("Du har inte lagom med pengar");
        }

        accountComponent.withdrawal(amount);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new WrongInputException("Beloppet måste vara större än 0kr");
        }
        accountComponent.deposit(amount);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }
}
