package ru.innopolis.stc13._9_java8_lambda.cycle;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8);
        number.forEach((Integer value) -> System.out.println(value));
        number.forEach(System.out::println);
    }
}
