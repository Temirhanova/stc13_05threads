package ru.innopolis.stc13._14_JUnit_4.first;

public class Main {
    public static void main(String[] args) {
        Summator summator = new Summator();
        System.out.println(summator.summ(1,2));

        summator.doSome(4);
        summator.doSome(5);
    }
}
