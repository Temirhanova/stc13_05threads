package ru.innopolis.stc13._14_JUnit_4.first;

public class Summator{
    public int summ(int arg1, int arg2){
        return arg1+arg2;
    }

    public void doSome(int arg){
        if (arg == 5){
            throw new RuntimeException();
        }
    }
}