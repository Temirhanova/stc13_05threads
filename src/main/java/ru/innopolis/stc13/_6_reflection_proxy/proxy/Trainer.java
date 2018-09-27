package ru.innopolis.stc13._6_reflection_proxy.proxy;

public interface Trainer {
    public void teach();
    public void eat();
    @Logged public void talk();

}
