package ru.innopolis.stc13._6_reflection_proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CounterInvocationHadller implements InvocationHandler {
    Counter counter;

    public CounterInvocationHadller(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = counter.getClass();
        if(clazz.getMethod(method.getName()).getAnnotation(Logged.class) != null) {
            Long start = System.currentTimeMillis();
            System.out.println("Method " + method.getName() + " called");
            Object result = method.invoke(counter, args);
            System.out.println("Operator time" + (System.currentTimeMillis() - start));
            return result;
        } else {
            return method.invoke(counter, args);
        }
    }
}
