package ru.innopolis.stc13._6_reflection_proxy.reflection;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
/*        Capucin mrJenkins = new Capucin(10, 100, 33);
        Field field = mrJenkins.getClass().getDeclaredField("footsize");
        field.setAccessible(true);
        System.out.println(field.get(mrJenkins));
        field.set(mrJenkins, 34);
        System.out.println(field.get(mrJenkins));

        Field tailLeangthField = mrJenkins.getClass().getDeclaredField("tailLength");
        tailLeangthField.setAccessible(true);
        System.out.println(tailLeangthField.get(mrJenkins));
        tailLeangthField.set(mrJenkins, 45);
        System.out.println(tailLeangthField.get(mrJenkins));*/

        Capucin abou = new Capucin(50);
        Class<Capucin> clazz = (Class<Capucin>) abou.getClass();
        ReflectionUtils.printClass(clazz);
    }
}
