package ru.innopolis.stc13._9_java8_lambda.classWork1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int a =7, b =9;
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8);

        FuncSumm funcSumm = (int a1, int b1) ->{return a1+b1;};
        System.out.println("summ = " + funcSumm.summ(a,b));

        FuncMax funcMax = (List<Integer> list) -> list.stream().max(Integer::compare).get();
        System.out.println("max = " + funcMax.max(number));

        FuncAverage funcAverage = (List<Integer> list) -> list.stream().mapToDouble(a1->a1).average().getAsDouble();
        System.out.println("average = " + funcAverage.average(number));

        FuncFactorial funcFactorial = (input) ->(input < 1 ? 0 : Stream.iterate(1, n->n+1).limit(Math.abs(input)).reduce(1, (c,d) -> c*d));
        System.out.println("factorial = " + funcFactorial.factorial(9));
    }
}
