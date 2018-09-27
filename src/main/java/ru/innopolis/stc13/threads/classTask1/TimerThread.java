package ru.innopolis.stc13.threads.classTask1;

public class TimerThread extends BaseThread {
    private Integer n;

    public TimerThread(Integer n, Counter counter) {
        super.counter = counter;
        this.n = n;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (counter) {
                if ((this.counter.getCount() % n) == 0) {
                    System.out.println("Sec "+ n);
                }

                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            try {
//                wait();
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
