package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] temp = text.trim().split("\\s+");
        for (String word : temp) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.removeAll(Collections.singleton(wordToBeRemoved));
    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        boolean[] fromCheck = new boolean[fromWords.length];
        boolean go = true;
        for (int i=0; i<fromWords.length; i++) {
            for (String word : wordsArrayList) {
                if (fromWords[i].equals(word)) {
                    fromCheck[i]=true;
                    break;
                }
                fromCheck[i]=false;
            }
        }
        for (boolean check : fromCheck) {
            if (check==false) {
                go = false;
                break;
            }
        }
        if (go==true) {
            String source = "";
            String replacement = "";
            String allWords = "";
            for (String word : fromWords) {
                source+= word + " ";
            }
            source = source.trim();
            for (String word : toWords) {
                replacement+= word + " ";
            }
            replacement = replacement.trim();
            for (String word : wordsArrayList) {
                allWords+= word + " ";
            }
            allWords = allWords.trim();
            allWords = allWords.replaceAll(source, replacement);
            String[] temp = allWords.trim().split("\\s+");
            wordsArrayList.clear();
            for (String word : temp) {
                wordsArrayList.add(word);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
