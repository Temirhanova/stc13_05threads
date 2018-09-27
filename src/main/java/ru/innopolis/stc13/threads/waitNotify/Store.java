package ru.innopolis.stc13.threads.waitNotify;

public class Store {
    private int products = 0;

    public synchronized void get() {
        while (products<1) {
            System.out.println("wait for put");
            try {
                wait(); // нужен для того чтобы перевести текуший объект в режим ожидания для того чтобы мог сработать метод put()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products--;
        System.out.println("Покупатель купил 1 товар!");
        System.out.println("Товаров на складе: " + products);
        notify();// нужен для того чтобы освободить объект
    }

    public synchronized void put() {
        while (products>=5) {
            System.out.println("wait for get");
            try {
                wait();// нужен для того чтобы перевести текуший объект в режим ожидания для того чтобы мог сработать метод get()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products++;
        System.out.println("Производитель привез 1 товар");
        System.out.println("Товар на складе: " + products);
        notify();// нужен для того чтобы освободить объект
    }
}
