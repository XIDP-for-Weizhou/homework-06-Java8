package com.thoughtworks.collection;


import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer::max).orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer::min).orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingDouble(Integer::intValue));
    }

    public double getMedian() {
        return getbasicMedian();
    }

    public double getOrderedMedian() {
        return getbasicMedian();
    }

    private double getbasicMedian() {
        int medianIndex;
        double medianResult;

        if (arrayList.size() % 2 == 0){
            medianIndex = arrayList.size() / 2 -1 ;
            medianResult = (arrayList.get(medianIndex) + (double) arrayList.get(medianIndex+1))/2;
        }else {
            medianIndex = arrayList.size() / 2 ;
            medianResult = arrayList.get(medianIndex);
        }
        return medianResult;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(i -> i % 2 == 0).findFirst().orElse(0);
    }

    public int getIndexOfFirstEven() {
        Integer firstEven = arrayList.stream().filter(i -> i % 2 == 0).findFirst().orElse(0);
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean isEqual = false;

        if (this.arrayList.size() == arrayList.size()){
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (this.arrayList.get(i).equals(arrayList.get(i))) isEqual = true;
                else {
                    isEqual = false;
                    break;
                }

            }
        }
        return isEqual;
    }



    public int getLastOdd() {
        List<Integer> oddList = arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        int lastIndex = oddList.size()-1;
        return oddList.get(lastIndex);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddList = arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        int lastIndex = oddList.size()-1;
        Integer lastOdd = oddList.get(lastIndex);
        return arrayList.indexOf(lastOdd);
    }
}
