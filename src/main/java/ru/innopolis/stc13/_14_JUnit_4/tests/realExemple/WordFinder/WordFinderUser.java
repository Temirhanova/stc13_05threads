package ru.innopolis.stc13._14_JUnit_4.tests.realExemple.WordFinder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WordFinderUser {
    WordFinder wordFinder;
    public WordFinderUser (WordFinder wordFinder) {
        this.wordFinder = wordFinder;
    }

    public void doWord(String resource, String word) throws MalformedURLException{
        try {
            URL url;
            try {
                url = new URL(resource);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw e;
            }
            Set<String> sentences = wordFinder.getSentenses(url);
            if (sentences != null) {
                for (String sentence: sentences) {
                    if(wordFinder.checkIfWordInSentense(sentence, word)) {
                        wordFinder.writeSentenceToResult(sentence);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
