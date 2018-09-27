package ru.innopolis.stc13._6_reflection_proxy.reflection;

public class Capucin extends Monkey {
    public int charming;
    protected int harmfull;
    private int footsize;
    private final int tailLength = 40;

    public Capucin(int charming, int harmfull, int footsize) {
        this.charming = charming;
        this.harmfull = harmfull;
        this.footsize = footsize;
    }

    public Capucin(int charming) {
        this(charming, 1, 38);
    }

    protected void washFace(){
        System.out.println("Face is cleaned");
    }

    private void washEars() {
        System.out.println("Ears are washed");
    }

    public void eatBananas(int count) {
        System.out.println("Ate " + count + " bananas");
    }
}
