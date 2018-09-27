package ru.innopolis.stc13._6_reflection_proxy.proxy2;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Counter counter = new MyCounter();
        CounterInvocationHadller counterInvocationHadller = new CounterInvocationHadller(counter);
        Counter proxy = (Counter) Proxy.newProxyInstance(MyCounter.class.getClassLoader(), new Class[]{Counter.class}, counterInvocationHadller);
        System.out.println("real counter");
        counter.count();
        System.out.println("proxy counter");
        proxy.count();
    }
}
