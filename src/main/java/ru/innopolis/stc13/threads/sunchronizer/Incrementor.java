package ru.innopolis.stc13.threads.sunchronizer;

public class Incrementor extends Thread {
    Monitor monitorA;
    Monitor monitorB;

    public Incrementor(Monitor monitorA, Monitor monitorB) {
        this.monitorA = monitorA;
        this.monitorB = monitorB;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            synchronized (monitorA) {
                monitorA.setStore(monitorA.getStore()+1);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitorB) {
                    monitorB.setStore(monitorB.getStore()+1);
                }
            }

        }
    }
}
