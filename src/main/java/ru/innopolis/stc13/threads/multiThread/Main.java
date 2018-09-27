package ru.innopolis.stc13.threads.multiThread;

public class Main {

//    1 создание потоков
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        1 вариант
//        CounterThread counterThread = new CounterThread();
//        counterThread.start();

        CounterThread counterThread = new CounterThread();
        Thread newThread = new Thread(counterThread);
        newThread.start();
        long res = 0;
        for (int i = 0; i < 590_000; i++) {
            res +=i;
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        System.out.println(res);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
