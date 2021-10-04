package com.itstep.khatkevich;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prog {
    public static void main(String[] args) {
        Random random= new Random();
        BankCard bankCard = new BankCard("Абобус", 500);
//        ArrayList<Thread> atms = new ArrayList<>();
//        for (int i = 0; i < 3+ random.nextInt(3); i++) {
//            if (random.nextBoolean()) {
//                com.itstep.khatkevich.ProducerATM producerATM = new com.itstep.khatkevich.ProducerATM(bankCard);
//                atms.add(new Thread(producerATM));
//                System.out.println("Добавлен com.itstep.khatkevich.ProducerATM");
//            } else {
//                com.itstep.khatkevich.ConsumerATM consumerATM = new com.itstep.khatkevich.ConsumerATM(bankCard);
//                atms.add(new Thread(consumerATM));
//                System.out.println("Добавлен com.itstep.khatkevich.ConsumerATM");
//            }
//        }
//        atms.forEach(Thread::start);
//        System.out.println("Ну вот и все");
        int numOfThreads = 3 + random.nextInt(3);
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        for (int i = 0; i < numOfThreads; i++) {
            executorService.submit(new ProducerATM(bankCard));
            executorService.submit(new ConsumerATM(bankCard));
        }
        executorService.shutdown();
    }
}
