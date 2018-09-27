package ru.innopolis.stc13.threads.threadPoll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FindWordTask implements Runnable{
    private List<String> resultList;
    private String source;
    private String[] words;

    public FindWordTask(List<String> resultList, String source, String[] words) {
        this.resultList = resultList;
        this.source = source;
        this.words = words;
    }

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(new File(source))) {
            Pattern pattern = Pattern.compile("[?.!]");
            scanner.useDelimiter(pattern);
            while (scanner.hasNext()) {
                checkWordsInSentence(scanner.next(), words);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private boolean checkWordInSentence(String sentence, String word) {
        sentence = sentence.toLowerCase();
        if (sentence.contains(word) == true)
            System.out.println("My sentence = " + sentence);
        return sentence.contains(word);
    }

    private void checkWordsInSentence(String sentence, String[] words) {
        for (String word : words) {
            if (checkWordInSentence(sentence, word)) {
                saveResultSentence(sentence);
                break;
            }
        }
    }

    private void saveResultSentence(String sentence) {
        synchronized (resultList) {
            resultList.add(sentence);
        }
    }

    public StringBuffer readFile(String fileName){
        int i = -1;
        StringBuffer text = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while ((i = fileInputStream.read()) != -1) {
                text.append(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    private void save(String fileName) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for(String s: resultList) {
                writer.write(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
