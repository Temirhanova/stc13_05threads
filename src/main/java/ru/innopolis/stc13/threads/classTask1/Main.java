package ru.innopolis.stc13.threads.classTask1;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setCount(0);
        CounterThread counterThread = new CounterThread(100, counter);
        counterThread.start();
        TimerThread timerThread3 = new TimerThread(3, counter);
        timerThread3.start();
        TimerThread timerThread5 = new TimerThread(5, counter);
        timerThread5.start();
        TimerThread timerThread11 = new TimerThread(11, counter);
        timerThread11.start();
    }
}
