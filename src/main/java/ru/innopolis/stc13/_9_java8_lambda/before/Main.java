package ru.innopolis.stc13._9_java8_lambda.before;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your salary");
        Integer salary = scanner.nextInt();
        System.out.println("Enter your country");
        String country = scanner.nextLine();
        NonFuncTaxCalc taxCalc = null;
        switch (country) {
            case "Russia" :
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int summ) {
                        return summ*0.3;
                    }
                };
                break;
            case "USA" :
            taxCalc = new NonFuncTaxCalc() {
                @Override
                public double calculateTax(int summ) {
                    return summ*0.5;
                }
            };
            break;case "Angola" :
            taxCalc = new NonFuncTaxCalc() {
                @Override
                public double calculateTax(int summ) {
                    return summ*0.56;
                }
            };
            break;
        }
    }

}
