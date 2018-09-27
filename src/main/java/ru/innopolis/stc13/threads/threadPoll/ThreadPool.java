package ru.innopolis.stc13.threads.threadPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
    private int limit;
    private ConcurrentLinkedQueue<FindWordTask> queue;
    boolean isWorkerThreadPool = true;
    private List<String> resultList;
    private String source;
    private String[] words;

    public ThreadPool(int limit, ConcurrentLinkedQueue<FindWordTask> queue, List<String> resultList, String source, String[] words) {
        this.limit = limit;
        this.resultList = resultList;
        this.source = source;
        this.words = words;
        for (int i = 0; i < this.limit; i++) {
            Thread thread = new Thread();
            thread.start();
        }
        this.queue = queue;
    }

    public void createThreads() {
        for (int i = 0; i < this.limit; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        while (isWorkerThreadPool == true) {
                            FindWordTask runnable = queue.poll();
                            if (runnable != null) {
                                runnable.run();
                            } else {
                                new RuntimeException("Очередь пуста!!!");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void createTask(long i) {
        FindWordTask runnable = new FindWordTask(resultList, source, words) {
            @Override
            public void run() {
                new FindWordTask(resultList, source, words).run();
            }
        };

        this.queue.add(runnable);
    }

    public void shutdown() {
        isWorkerThreadPool = false;
    }


}


