package ru.innopolis.stc13._9_java8_lambda.thread;

public class Main {
    public static void main(String[] args) {
        //первая версия как по-старинке
       System.out.println("Message from t1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Message from thread");
            }
        }).start();
        // вторая версия с ссылкой на лямбду
        System.out.println("Message from t1");
        new Thread(() -> System.out.println("Message from thread")).start();

    }
}
