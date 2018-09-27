package ru.innopolis.stc13._6_reflection_proxy.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static void printClass(Class clazz) {
        System.out.println("FIELDS: ");
        printField(clazz);
        System.out.println("DECLARED FIELDS: ");
        printDeclaredField(clazz);
        System.out.println("METHOND");
        printMethods(clazz);
        Class parentClass = clazz.getSuperclass();
        if (parentClass != null) {
            printClass(parentClass);
        }

    }

    private static void printMethods(Class clazz) {
        methodIterator(clazz.getMethods());
    }

    private static void methodIterator(Method[] methods) {
        for (Method method: methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getName());
            System.out.println("Parameters: ");
            for (Class parameterClass: method.getParameterTypes()) {
                System.out.println(parameterClass.getName() + ", ");
            }
        }
    }

    private static void printDeclaredField(Class clazz) {
        fieldIterator(clazz.getDeclaredFields());
    }

    private static void printField(Class clazz) {
        fieldIterator(clazz.getFields());
    }

    private static void fieldIterator(Field[] declaredFields) {
        for (Field field: declaredFields) {
            System.out.println("name = " + field.getName());
            System.out.println("type = " + field.getType());
            System.out.println("modifier = " + field.getModifiers());
        }
    }




}
