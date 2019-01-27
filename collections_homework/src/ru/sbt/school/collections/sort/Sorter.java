package ru.sbt.school.collections.sort;
import java.util.ArrayList;
import java.util.HashMap;

public class Sorter {


    public static void uniqueWords(ArrayList<String> words) {

    HashMap<String, Integer> wordToCount = new HashMap<>();

    for (String word : words) {
        if (!wordToCount.containsKey(word)) {
            wordToCount.put(word, 0);
        }
        wordToCount.put(word, wordToCount.get(word) + 1);
    }
    for (String word : wordToCount.keySet()) {
        if (wordToCount.get(word) == 2 || wordToCount.get(word) == 3 || wordToCount.get(word) == 4)
        System.out.println("Слово "+word + " встречается в файле  " + wordToCount.get(word) + " раза");
        else  System.out.println("Слово "+word + " встречается в файле  " + wordToCount.get(word) + " раз");
    }





}
}
