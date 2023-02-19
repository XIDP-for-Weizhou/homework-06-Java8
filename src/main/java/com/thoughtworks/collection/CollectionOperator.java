package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        if (left < right){
            for (int i = left;i<=right; i++){
                result.add(i);
            }
        }else {
            for (int i =left;i>=right;i--){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        CollectionOperator collectionOperator = new CollectionOperator();
        List<Integer> listByInterval = collectionOperator.getListByInterval(left, right);
        return listByInterval.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());    }

    public List<Integer> popEvenElements(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElement(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i: firstArray) {
            for (int j:secondArray) {
                if (i==j){
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
        firstList.addAll(Arrays.asList(secondArray));
        return firstList.stream().distinct().collect(Collectors.toList());    }
}
