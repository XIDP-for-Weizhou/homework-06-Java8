package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum =0;
        if (leftBorder > rightBorder){
            int temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder =temp;
        }

        for (int i = leftBorder;i <= rightBorder;i++){
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum =0;

        if (leftBorder > rightBorder){
            int temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder =temp;
        }

        for (int i = leftBorder;i <= rightBorder;i++){
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(i -> i * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i) % 2 !=0){
                arrayList.set(i,arrayList.get(i)*3+2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 != 0).mapToInt(i -> i * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        double medianResult;

        List<Integer> evenArrayList = arrayList.stream().filter( i -> i % 2 == 0).collect(Collectors.toList());

        if (evenArrayList.size() % 2 == 0){
            int medianIndex = evenArrayList.size() / 2 -1;
            medianResult =  (evenArrayList.get(medianIndex) + (double)evenArrayList.get(medianIndex + 1)) / 2;
        } else{
            int medianIndex = evenArrayList.size() / 2 ;
            medianResult = evenArrayList.get(medianIndex);
        }

        return medianResult;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.averagingDouble(i -> i));
    }

    public boolean isIncludedInEven(List<Integer> arrayList, Integer specialElement) {
        List<Integer> evetArrayList = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return evetArrayList.contains(specialElement);
    }

    public List<Integer> getUnrepeatedFromEven(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Map<Object, List<Integer>> collect = arrayList.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));
        collect.get(true).sort(Comparator.naturalOrder());
        collect.get(false).sort(Comparator.reverseOrder());

        ArrayList<Integer> result = new ArrayList<>();

        result.addAll(collect.get(true));
        result.addAll(collect.get(false));

        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i =0;i<arrayList.size()-1;i++){
            Integer firstNumber = arrayList.get(i);
            Integer secondNumber = arrayList.get(i+1);
            int element = (firstNumber + secondNumber)*3;
            result.add(element);
        }
        return result;    }
}
