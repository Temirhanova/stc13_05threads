package ru.innopolis.stc13.threads.threadPoll.homaWork_9_lambda_and_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String fileName = "E:\\JAVA Innopolis\\5. потоки\\threads\\src\\ru\\innopolis\\stc13\\threads\\threadPoll\\result\\file1.txt";
        String stringBuffer = readFile(fileName);
        System.out.println(stringBuffer);
        try {
            Stream<String> stringStreamFromFiles = Files.lines(Paths.get("E:\\JAVA Innopolis\\5. потоки\\threads\\src\\ru\\innopolis\\stc13\\threads\\threadPoll\\result\\file1.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String readFile(String fileName){
        int i = -1;
        String text = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while ((i = fileInputStream.read()) != -1) {
                text += (char) i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
