package ru.innopolis.stc13.threads.sunchronizer;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Monitor monitorA = new Monitor();
        Monitor monitorB = new Monitor();
        Incrementor thread1 = new Incrementor(monitorA, monitorB);
        Incrementor thread2 = new Incrementor(monitorB, monitorA);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println((System.currentTimeMillis() - startTime) + " " + monitorA.getStore());
    }
}
