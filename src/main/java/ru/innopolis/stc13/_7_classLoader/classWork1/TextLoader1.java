package ru.innopolis.stc13._7_classLoader.classWork1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TextLoader1 extends ClassLoader{
    public TextLoader1(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("Text1")) {
            String dest = "file:D://Text1.class";
            byte[] classData = null;
            try (InputStream inputStream  =  new URL(dest).openConnection().getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
                int data = inputStream.read();
                while (data != -1) {
                    byteArrayOutputStream.write(data);
                    data = inputStream.read();
                }
                inputStream.close();
                classData = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, classData, 0, classData.length);
        } else {
            return super.loadClass(name);
        }
    }
}
