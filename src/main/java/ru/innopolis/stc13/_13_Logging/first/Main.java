package ru.innopolis.stc13._13_Logging.first;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.err.println("gggg");
        System.out.println("dfgd");

        try {
            System.setErr(new PrintStream(new FileOutputStream("errLog.log")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.err.println("Message to file");
        try {
            throw new Exception("Exeption message");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
