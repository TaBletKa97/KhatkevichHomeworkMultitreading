package com.itstep.khatkevich;

public class BankCard {
    private String cardHolder;
    private int cash;

    public BankCard(String cardHolder, int cash) {
        this.cardHolder = cardHolder;
        this.cash = cash;
    }

    public synchronized int getCash() {
        return cash;
    }

    public synchronized void setCash(int cash) {
        this.cash = cash;
    }
}
