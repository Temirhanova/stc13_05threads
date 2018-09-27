package ru.innopolis.stc13._7_classLoader.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Human humanProxy = (Human) Proxy.newProxyInstance(EuropeanHuman.class.getClassLoader(),
                new Class[]{Human.class}, new HumanInvocation());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            humanProxy.eat("bread", 2);
            System.out.println(humanProxy.say());
            humanProxy.sleep(6);
            scanner.nextLine();
        }





        /*Human human = new EuropeanHuman();
        System.out.println(human.say());
        human.eat("banana", 5);
        ClassLoader parentLoader = EuropeanHuman.class.getClassLoader();
        HumanLoader humanLoader = new HumanLoader(parentLoader);
        Class humanClass = humanLoader.loadClass("EuropeanHuman");
        System.out.println(humanClass.getMethod("say").invoke(humanClass.newInstance(), null));
        */
    }
}
