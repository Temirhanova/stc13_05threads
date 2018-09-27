package ru.innopolis.stc13.threads.classTask1;

public class CounterThread extends BaseThread {
    private Integer timeOut;
    private Integer timer;

    public CounterThread(Integer timeOut, Counter counter) {
        super.counter = counter;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {


        super.run();
        System.out.println("start");
        while (!isInterrupted()) {
            synchronized (counter) {
                System.out.println("incValue " + this.getCounter());
                this.inc();
                this.counter.notifyAll();

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
