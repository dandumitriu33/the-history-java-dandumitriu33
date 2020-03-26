package com.codecool.thehistory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] tempArray = text.trim().split("\\s+");

        String[] resultArray = new String[wordsArray.length+tempArray.length];
        for (int i=0; i<wordsArray.length; i++) {
            resultArray[i]=wordsArray[i];
        }
        for (int i=wordsArray.length; i<resultArray.length; i++) {
            resultArray[i]=tempArray[i-wordsArray.length];
        }
        wordsArray = new String[resultArray.length];
        for (int i=0; i<resultArray.length; i++) {
            wordsArray[i]=resultArray[i];
        }

    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        String[] tempArray = new String[wordsArray.length];
        int counter = 0;
        for (int i=0; i<wordsArray.length; i++) {
            if (wordsArray[i].equals(wordToBeRemoved)) {
                counter++;
            }
            else {
                tempArray[i-counter] = wordsArray[i];
            }
        }
        wordsArray = new String[tempArray.length - counter];
        for (int i=0; i<wordsArray.length; i++) {
            wordsArray[i]=tempArray[i];
        }

    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray= new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        String[] tempArray = new String[wordsArray.length];
        for (int i=0; i<wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        // checking if all words from fromWords are actually words inside wordsArray
        boolean go = true;
        Set<String> tempSet = new HashSet<String>(Arrays.asList(wordsArray));
        boolean[] isWord = new boolean[fromWords.length];
        for (int i=0; i<fromWords.length; i++) {
            for (String existingWord : tempSet) {
                if (fromWords[i].equals(existingWord)) {
                    isWord[i]=true;
                    break;
                }
                isWord[i]=false;
            }
        }
        for (int i=0; i<isWord.length; i++) {
            if (isWord[i]==false) go=false;
        }
        // if all fromWords are valid words, replacement starts
        if (go==true) {
            int fromLength = fromWords.length;
            int toLength = toWords.length;
            int resultLength = wordsArray.length;
            for (int i=0; i<(wordsArray.length-fromLength+1); i++) {
                if (Arrays.equals(Arrays.copyOfRange(wordsArray, i, i + fromLength), fromWords)) {
                    i+=fromLength-1;
                    resultLength = resultLength-fromLength+toLength;
                }
            }
            String[] result = new String[resultLength];
            int k=0;
            for (int i=0; i<(wordsArray.length); i++) {
                if (Arrays.equals(Arrays.copyOfRange(wordsArray, i, i + fromLength), fromWords)) {
                    for (int j=0; j<toWords.length; j++) {
                        result[k]=toWords[j];
                        k++;
                    }
                    i+=fromLength-1;
                }
                else if (!Arrays.equals(Arrays.copyOfRange(wordsArray, i, i + fromLength), fromWords)){
                    result[k] = wordsArray[i];
                    k++;
                }
            }
            wordsArray= new String[resultLength];
            for (int i=0; i<resultLength; i++) {
                wordsArray[i]=result[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
