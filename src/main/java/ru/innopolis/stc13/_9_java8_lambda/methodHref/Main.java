package ru.innopolis.stc13._9_java8_lambda.methodHref;

public class Main {
    public static void main(String[] args) {
        Greeter sayHi = new GreeterImpl() :: sayHiBrigth;
        sayHi.sayHi();
    }
}
