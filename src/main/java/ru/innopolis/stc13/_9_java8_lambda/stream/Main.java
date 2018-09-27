package ru.innopolis.stc13._9_java8_lambda.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("v1","v2","v3","v4","v5","v4","v7","v8","v9","v1","v2");
        List<String> distinct = collection.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);

        String join = collection.stream().collect(Collectors.joining(":", "_", "_"));
        System.out.println(join);

        Map<String, String> map = collection.stream().distinct().collect(Collectors.toMap((p)->p.substring(1,2), (p)->p.substring(0,1)));
        System.out.println(map);


    }
}
