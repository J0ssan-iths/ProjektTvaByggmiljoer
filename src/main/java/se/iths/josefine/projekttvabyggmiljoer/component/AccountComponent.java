package se.iths.josefine.projekttvabyggmiljoer.component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {

    //Attribute
    private int balance = 0;

    //Constructor
    public AccountComponent(int balance) {
        this.balance = balance;
    }

    public AccountComponent() {
    }

    //Deposit method
    public void deposit(int amount) {
        balance += amount;
    }

    //withdrawl method
    public void withdrawal(int amount) {
        balance -= amount;
    }

    //getBalance method
    public int getBalance() {
        return balance;
    }
}
