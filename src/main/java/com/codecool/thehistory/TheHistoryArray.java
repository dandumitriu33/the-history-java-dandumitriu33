package com.codecool.thehistory;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
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
        for (int i=0; i<wordsArray.length; i++) {
            System.out.println(wordsArray[i]);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
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
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray= new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        String[] tempArray = new String[wordsArray.length];
        for (int i=0; i<wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        boolean go = true;
        boolean[] isWord = new boolean[fromWords.length];
        for (int i=0; i<fromWords.length; i++) {
            for (String existingWord : wordsArray) {
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
        if (go==true) {
            String fromSection = "";
            String toSection = "";
            String allWords = "";
            for (int i = 0; i < wordsArray.length; i++) {
                allWords += wordsArray[i] + " ";
            }
            allWords = allWords.trim();
            System.out.println("aw: " + allWords + ".");
            for (int i = 0; i < fromWords.length; i++) {
                fromSection += fromWords[i] + " ";
            }
            fromSection = fromSection.trim();
            for (int i = 0; i < toWords.length; i++) {
                toSection += toWords[i] + " ";
            }
            toSection = toSection.trim();
            System.out.println("pre rep: " + allWords);
            allWords = allWords.replace(fromSection, toSection);
            System.out.println("post rep: " + allWords);
            wordsArray = allWords.split(" ");
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
