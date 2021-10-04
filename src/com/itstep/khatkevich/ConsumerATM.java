package com.itstep.khatkevich;

import java.util.Random;

public class ConsumerATM extends ATM implements Runnable {

    public ConsumerATM(BankCard card) {
        super(card);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (card.getCash() < 1000 && card.getCash() > 0) {
            withdraw();
            try {
                Thread.sleep(1 + random.nextInt(2001));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
