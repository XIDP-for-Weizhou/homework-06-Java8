package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int i = this.random.nextInt(3);
        List<Integer> result = new ArrayList<>();
        while (number > i){
            result.add(number - i);
            number -= i;
        }
        return result;   }
}
