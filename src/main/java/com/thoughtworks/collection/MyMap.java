package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private final String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(i -> i * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(i -> letters[i - 1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        ArrayList<String> result = new ArrayList<>();
        for (Integer num : array) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (num > 0) {
                if (num % 26 == 0) {
                    temp.add(26);
                    num = num / 26 - 1;
                    continue;
                }
                temp.add(num % 26);
                num = num / 26;
            }
            Collections.reverse(temp);
            result.add(temp.stream().map(i -> letters[i - 1]).collect(Collectors.joining()));
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        array.sort(Comparator.reverseOrder());
        return array;
    }

    public List<Integer> sortFromSmall() {
        array.sort(Comparator.naturalOrder());
        return array;
    }
}
