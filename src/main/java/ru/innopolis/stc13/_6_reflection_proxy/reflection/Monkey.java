package ru.innopolis.stc13._6_reflection_proxy.reflection;

public class Monkey {
    private String name;
    public Integer age;
    private String contry;
    private String subtype;

    private final int numLegs = 2;

    public String getName() {
        return name;
    }

    public String getContry() {
        return contry;
    }
     private void saySmth(String speech) {
         System.out.println(speech);
     }
}
