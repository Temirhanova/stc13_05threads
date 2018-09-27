package ru.innopolis.stc13._6_reflection_proxy.proxy;

public class JavaTrainer implements Trainer {
    @Override
    public void teach() {
        System.out.println("Trainer.teach() - Java is really complicared");
    }

    @Override
    public void eat() {
        System.out.println("Trainer.eat() - I like to eat Mango");
    }
    @Logged
    @Override
    public void talk() {
        System.out.println("Trainer.talk() - Where is your homework?");
    }
}
