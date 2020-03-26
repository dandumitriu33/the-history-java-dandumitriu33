package com.codecool.thehistory;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        String[] temp = text.trim().split("\\s+");
        for (int i=0; i<temp.length; i++) {
            wordsLinkedList.add(temp[i]);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsLinkedList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        while (wordsLinkedList.contains(from)) {
            int tempIndex = wordsLinkedList.indexOf(from);
            wordsLinkedList.set(tempIndex, to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        if (wordsLinkedList.containsAll(Arrays.asList(fromWords))) {
            String source = "";
            String replacement = "";
            String allWords = "";
            for (String word : fromWords) {
                source += word + " ";
            }
            source = source.trim();
            for (String word : toWords) {
                replacement += word + " ";
            }
            replacement = replacement.trim();
            for (String word : wordsLinkedList) {
                allWords += word + " ";
            }
            allWords = allWords.trim();
            allWords = allWords.replaceAll(source, replacement);
            String[] temp = allWords.trim().split("\\s+");
            wordsLinkedList.clear();
            wordsLinkedList.addAll(Arrays.asList(temp));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
