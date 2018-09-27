package ru.innopolis.stc13._6_reflection_proxy.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Trainer mikhail = new JavaTrainer();
        TrainingCenter trainingCenter = new TrainingCenter(mikhail);
        Trainer stc = (Trainer) Proxy.newProxyInstance(TrainingCenter.class.getClassLoader(), new Class[]{Trainer.class}, trainingCenter);
        System.out.println("Without proxy:");
        mikhail.eat();
        mikhail.teach();
        System.out.println("with proxy:");
        stc.eat();
        stc.teach();
        stc.talk();

        Trainer fakeStc = (Trainer) Proxy.newProxyInstance(TrainingCenter.class.getClassLoader(), new Class[]{Trainer.class}, new FaceTrainingCenter());

        System.out.println("Fake stc:");
        fakeStc.eat();
        fakeStc.teach();
        fakeStc.talk();
    }

}
