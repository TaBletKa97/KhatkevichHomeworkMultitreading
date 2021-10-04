package com.itstep.khatkevich;

import java.util.Random;

public class ATM {
    BankCard card;

    public ATM(BankCard card) {
        this.card = card;
    }

    public void checkBalance() {
        System.out.println(card.getCash());
    }

    public synchronized void withdraw() {
        Random random = new Random();
        int cash = card.getCash();
        int newCash = cash - (5 + random.nextInt(6));
        card.setCash(newCash);
        System.out.printf("Совершена транзакция на %d рублей. Текущий баланс: %d, Поток: %s\n", cash - newCash, newCash, Thread.currentThread().getName());
    }

    public synchronized void topUpBalance() {
        Random random = new Random();
        int cash = card.getCash();
        int newCash = cash + (5 + random.nextInt(6));
        card.setCash(newCash);
        System.out.printf("Совершено пополнение счета на %d рублей. Текущий баланс: %d, Поток: %s\n", newCash - cash, newCash, Thread.currentThread().getName());
    }
}
