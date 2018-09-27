package ru.innopolis.stc13._14_JUnit_4.second;

public class HelperImpl implements Helper {
    @Override
    public Integer someHelperHethod(Integer a, Integer b) {
        return (a + b) * 2;
    }

    @Override
    public void anotherHelperMethod(Integer a, Integer b) {
        System.out.println((a + b) * 2);
    }
}
