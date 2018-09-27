package ru.innopolis.stc13._14_JUnit_4.tests.realExemple.WordFinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class WordFinderUserTest {
    public static final String FILE_ANY = "file://any";
    public static final String WORD = "";
    private WordFinderUser wordFinderUser;
    private WordFinder wordFinder = Mockito.mock(WordFinder.class);
    private final static String FIRST_SENTENCE = "Doing test";
    private final static String SECOND_SENTENCE = "Let's to it";

    @BeforeEach
    void beforeEach() {
        wordFinderUser = new WordFinderUser(wordFinder);
    }

    @Test
    void doWordNullTest() {
        when(wordFinder.getSentenses(any())).thenReturn(null);
        assertDoesNotThrow(()->wordFinderUser.doWord(FILE_ANY, WORD));
    }

    @Test
    void doWordEmptySetTest() {
        when(wordFinder.getSentenses(any())).thenReturn(Collections.emptySet());
        try {
            wordFinderUser.doWord(FILE_ANY, WORD);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder, times(0)).checkIfWordInSentense(any(), any());
        verify(wordFinder, times(0)).writeSentenceToResult(any());
    }

    @Test
    void doWordTrue() {
/*        Set<String> set = new HashSet<>();
        set.add(FIRST_SENTENCE);
        set.add(SECOND_SENTENCE);
        when(wordFinder.getSentenses(any())).thenReturn(set);*/
        when(wordFinder.getSentenses(any())).thenReturn(new HashSet<>(Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE)));
        when(wordFinder.checkIfWordInSentense(FIRST_SENTENCE, WORD)).thenReturn(true);
        when(wordFinder.checkIfWordInSentense(SECOND_SENTENCE, WORD)).thenReturn(false);
        try {
            wordFinderUser.doWord(FILE_ANY, WORD);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder, times(1)).writeSentenceToResult(FIRST_SENTENCE);
        verify(wordFinder, times(0)).writeSentenceToResult(SECOND_SENTENCE);

    }

    @Test
    public void doWordURLForming(){
        final ArgumentCaptor<URL> argument = ArgumentCaptor.forClass(URL.class);
        try {
            wordFinderUser.doWord(FILE_ANY, WORD);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        verify(wordFinder).getSentenses(argument.capture());
        assertEquals(FILE_ANY, argument.getValue().toString());
    }

    @Test
    public void doWordBadURL() {
        assertThrows(MalformedURLException.class, ()->wordFinderUser.doWord("", ""));
    }
}