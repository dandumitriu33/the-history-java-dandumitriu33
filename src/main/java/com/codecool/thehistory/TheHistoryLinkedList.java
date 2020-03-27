package com.codecool.thehistory;

import java.util.*;
import java.util.LinkedList;

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
        ListIterator<String> iter = wordsLinkedList.listIterator();
        while(iter.hasNext()) {
            String tempWord=iter.next();
            if (tempWord.equals(from)) {
                iter.previous();
                iter.remove();
                iter.add(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        System.out.println(wordsLinkedList);
//        LinkedList<String> resultList = new LinkedList<String>();
        String[] temp = new String[fromWords.length];
//        System.out.println("res list: "+resultList);
        if (wordsLinkedList.containsAll(Arrays.asList(fromWords))) {
            ListIterator<String> iter = wordsLinkedList.listIterator();

            while (iter.hasNext()) {
                String tempWord = iter.next();
                System.out.println("mv forward");
                System.out.println("looking at: " + tempWord);
                if (tempWord.equals(fromWords[0])) {
                    iter.previous();
                    System.out.println("mv back");
                    int counter = 0;
                    for (int i=0; i<fromWords.length; i++) {
                        if (iter.hasNext()) {
                            temp[i] = iter.next();
                            counter++;
                            System.out.println("mv fw");
                        }
                    }
                    if (counter!=fromWords.length) {
                        for (int i=0; i<counter; i++) {
                            iter.previous();
                            System.out.println("mv bk repair");
                        }
                        counter=0;
                        temp=null;
                    }
                    else {
                        for (int j = 0; j < fromWords.length; j++) {
                            if (iter.hasPrevious()) {
                                iter.previous();
                                System.out.println("mv bk");
                            }
                        }
                    }
                    if (Arrays.equals(temp, fromWords)) {
                        System.out.println("eq");
                        for (int i=0; i<fromWords.length; i++) {
                            iter.next();
                            iter.remove();
                            System.out.println("rm fw");
                        }
                        for (int j=0; j<toWords.length; j++) {
//                            iter.next();
                            iter.add(toWords[j]);
                            System.out.println("add fw");
                        }
                    }
                    else {
                        iter.next();
                    }
                }
                else {
                    continue;
                }
            }



        }
//            System.out.println("ini from: "+Arrays.asList(fromWords));
//            System.out.println("ini to: "+Arrays.asList(toWords));
//            int i=0;
//            while (i<wordsLinkedList.size()) {
//                System.out.println("i: "+i+" < " + wordsLinkedList.size());
//            if (!wordsLinkedList.get(i).equals(fromWords[0])) {
//                System.out.println("i: "+i + " wordsLL[i]: " + wordsLinkedList.get(i));
//                resultList.add(wordsLinkedList.get(i));
//                i++;
//            }
//            else {
//                try {
//                ListIterator list_Iter = wordsLinkedList.listIterator(i);
//
//                    for (int j = 0; j < fromWords.length; j++) {
//                        temp[j] = (String) list_Iter.next();
//                    }
//                    System.out.println("temp: " + Arrays.toString(temp) + " fromWords: " + Arrays.toString(fromWords));
//                    if (Arrays.equals(temp, fromWords)) {
//                        System.out.println("eq\n");
//                        resultList.addAll(Arrays.asList(toWords));
//                        System.out.println("workd");
//                        i += fromWords.length;
//                        System.out.println("i strange?: " + i);
//                    } else {
//                        System.out.println("no eq\n");
//                        resultList.add(wordsLinkedList.get(i));
//                        i++;
//                    }
//                }
//                catch (NoSuchElementException e) {
//                    resultList.add(wordsLinkedList.get(i));
//                    i++;
//                }
//            }
//            }
//
//            wordsLinkedList.clear();
//            ListIterator list_Iter2 = resultList.listIterator(0);
//            while (list_Iter2.hasNext()) {
//                wordsLinkedList.add((String) list_Iter2.next());
//            }
//        }


//            System.out.println("ini from: "+Arrays.asList(fromWords));
//            System.out.println("ini to: "+Arrays.asList(toWords));
//            for (int i=0; i<wordsLinkedList.size(); i++) {
//                try {
//                    System.out.println("starting for i: "+i+ " sublist: "+ wordsLinkedList.subList(i, i + fromWords.length));
//                    if (wordsLinkedList.subList(i, i + fromWords.length).equals(Arrays.asList(fromWords))) {
//                        System.out.println("contains");
//                        resultList.addAll(Arrays.asList(toWords));
//                        i += fromWords.length - 1;
//                        System.out.println("res list: " + resultList);
//                    } else {
//                        System.out.println("does not contain");
//                        resultList.add(wordsLinkedList.get(i));
//                        System.out.println("res list: " + resultList);
//                    }
//                }
//                catch (IndexOutOfBoundsException e) {
//                    resultList.add(wordsLinkedList.get(i));
//                    System.out.println("catch res list: " + resultList);
//                }
//            }
//
//

//            String source = "";
//            String replacement = "";
//            String allWords = "";
//            for (String word : fromWords) {
//                source += word + " ";
//            }
//            source = source.trim();
//            for (String word : toWords) {
//                replacement += word + " ";
//            }
//            replacement = replacement.trim();
//            for (String word : wordsLinkedList) {
//                allWords += word + " ";
//            }
//            allWords = allWords.trim();
//            allWords = allWords.replaceAll(source, replacement);
//            String[] temp = allWords.trim().split("\\s+");
//            wordsLinkedList.clear();
//            wordsLinkedList.addAll(Arrays.asList(temp));
//            wordsLinkedList.clear();
//            ListIterator list_iter = resultList.listIterator(0);
//            while(list_iter.hasNext()) {
//                wordsLinkedList.add((String) list_iter.next());
//            }
//        }


//        System.out.println(wordsLinkedList);
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
