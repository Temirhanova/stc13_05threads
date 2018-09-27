package ru.innopolis.stc13.threads.classTask1;

public class BaseThread extends Thread {

    protected Counter counter;

    public Integer getCounter() {
        return counter.getCount();
    }

    public void inc() {
        counter.setCount(counter.getCount()+1);
    }
}
