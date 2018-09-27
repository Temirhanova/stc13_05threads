package ru.innopolis.stc13._9_java8_lambda.after;

import ru.innopolis.stc13._9_java8_lambda.before.NonFuncTaxCalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your salary");
        Integer salary = scanner.nextInt();
        System.out.println("Enter your country");
        scanner.nextLine();
        String country = scanner.nextLine();
        TaxColculate taxCalc = null;
        switch (country) {
            case "Russia" :
                taxCalc = (int summ)->{return summ*0.13;};
                break;
            case "USA" :
                taxCalc = (summ)->summ*0.13;
                break;
            case "Angola" :
                taxCalc = summ->summ*0.13;
                break;
        }
        System.out.println(taxCalc.calculateTax(salary));
    }
}
