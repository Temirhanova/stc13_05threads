package ru.innopolis.stc13.threads.threadPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {

        List<String> resultList = new ArrayList<>();
        long start = System.nanoTime();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String path = "E:\\JAVA Innopolis\\5. потоки\\threads\\src\\ru\\innopolis\\stc13\\threads\\threadPoll\\result\\file1.txt";
//        int countFiles = 8;
//        String[] files = new String[countFiles];
//        for (int i = 1; i <= countFiles; i++) {
//            files[i - 1] = path + "\\file" + i + ".txt";
//        }
        String words[] = {"spring", "innopolis", "cat"};
        ConcurrentLinkedQueue<FindWordTask> queue = new ConcurrentLinkedQueue<>();
        ThreadPool threadPool = new ThreadPool(8, queue, resultList, path, words);
        threadPool.createThreads();

        for (int i = 0; i < 100_000; i++) {
            threadPool.createTask(i);
        }
        threadPool.shutdown();
        long end = System.nanoTime();
        System.out.println("time " + (end - start));

        scanner.nextLine();
    }
}
