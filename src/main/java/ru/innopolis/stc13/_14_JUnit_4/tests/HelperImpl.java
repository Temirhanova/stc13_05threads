package ru.innopolis.stc13._14_JUnit_4.tests;

public class HelperImpl implements Helper {
    @Override
    public Integer someHeplper(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public void anotherHelperMethods(Integer a, Integer b) {
        System.out.println(a + "; "+b);
    }
}
