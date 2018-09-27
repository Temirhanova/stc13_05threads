package ru.innopolis.stc13._6_reflection_proxy.proxy2;


public class MyCounter implements Counter {
    @Logged
    @Override
    public void count() {
        System.out.println("1-2-3-4-5");
    }
}
