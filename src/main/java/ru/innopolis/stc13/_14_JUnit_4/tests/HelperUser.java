package ru.innopolis.stc13._14_JUnit_4.tests;

public class HelperUser {
    private Helper helper;

    public HelperUser(Helper helper) {
        this.helper = helper;
    }

    public Integer helperUserTethod(Integer a, Integer b) {
        Integer a1 = ((a+10)+b);
        Integer b1 = b*12;
        return helper.someHeplper(a1, b1);
    }
}
