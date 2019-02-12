package com.hashmap.excercise.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Write a program that prints a lottery combination, picking six distinct numbers between 1 and
 * 49. To pick six distinct numbers, start with an array list filled with 1 . . . 49. Pick a random
 * index and remove the element. Repeat six times. Print the result in sorted order.
 */

public class Lottery {

    private ArrayList<Integer> numbers;
    private  ArrayList<StringBuilder> lotteryNumbers;

    public void performQueries() {

        Lottery lottery = new Lottery();

        lottery.numbers = new ArrayList<>();
        lottery.lotteryNumbers = new ArrayList<>();

        lottery.initalizeArrayList();

        lottery.addLotteryNumbers();

        lottery.sortLotteryNumbers();

    }

    private void sortLotteryNumbers() {
        Collections.sort(lotteryNumbers);
    }

    private void addLotteryNumbers() {
        for (int i=0; i<6; i++){
            lotteryNumbers.add(generateLotteryNumber());
        }
    }

    private StringBuilder generateLotteryNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<6; i++) {
            sb.append(getRandomFromNumbers());
        }
        return sb;
    }

    private int getRandomFromNumbers() {
        int rand = new Random().nextInt(numbers.size());
        int randFromList = numbers.get(rand);
        numbers.remove(rand);
        return randFromList;
    }

    private void initalizeArrayList() {
        for(int i=1; i<49; i++){
            numbers.add(i);
        }
    }
}
