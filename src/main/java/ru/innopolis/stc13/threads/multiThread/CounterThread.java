package ru.innopolis.stc13.threads.multiThread;

//public class CounterThread extends Thread {
public class CounterThread implements Runnable {
    @Override
    public void run() {
        long res2 = 0;
        for (int i = 0; i < 600_000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            res2 +=i;
        }
        System.out.println(res2);
    }
}
