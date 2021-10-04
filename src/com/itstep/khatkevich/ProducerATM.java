package com.itstep.khatkevich;

import java.util.Random;

public class ProducerATM extends ATM implements Runnable {

    public ProducerATM(BankCard card) {
        super(card);
    }

    @Override
    public void run() {
        Random random = new Random();
        while (card.getCash() < 1000 && card.getCash() > 0) {
            topUpBalance();
            try {
                Thread.sleep(2000 + random.nextInt(3001));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
