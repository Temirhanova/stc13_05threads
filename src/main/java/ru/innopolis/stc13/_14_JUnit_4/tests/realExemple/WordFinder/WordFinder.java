package ru.innopolis.stc13._14_JUnit_4.tests.realExemple.WordFinder;

import java.net.URL;
import java.util.Set;

public interface WordFinder {
    Set<String> getSentenses(URL resourse);
    boolean checkIfWordInSentense(String sentense, String word);
    void writeSentenceToResult(String sentence);
}
