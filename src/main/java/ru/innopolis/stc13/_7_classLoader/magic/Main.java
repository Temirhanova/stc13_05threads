package ru.innopolis.stc13._7_classLoader.magic;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader parentClassLoader = Magic.class.getClassLoader();
        Class magicClass = parentClassLoader.loadClass("ru.innopolis.stc13._7_classLoader.magic.Magic");
        Magic magic = (Magic) magicClass.newInstance();
        magic.cast();

        KingMagicClassLoader kingMagicClassLoader = new KingMagicClassLoader(parentClassLoader);
        Class kindMagicClass = kingMagicClassLoader.loadClass("ru.innopolis.stc13._7_classLoader.magic.Magic");
        kindMagicClass.getMethod("cast").invoke(kindMagicClass.newInstance(), null);
    }
}
