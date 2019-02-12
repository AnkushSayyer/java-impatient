package com.hashmap.excercise.chapter1;

import java.util.Random;

/**
 * Write a program that produces a random string of letters and digits by generating a random
 * long value and printing it in base 36.
 */

public class RandomsQ10 {

    private Random rand = new Random();

    public void performQueris() {

        //Get random length to create random string
        int lengthOfString = getRandomLength();

        //Create random string
        String randomString = getRandomString(lengthOfString);

        //Generate a random long number
        long randomLong = getRandomLong();

        //Convert this random long to base 36
        String base36 = longToBase36(randomLong);

    }

    private String longToBase36(final long randomLong) {
        final int base = 36;
        StringBuilder sb = new StringBuilder();

        long number = randomLong;
        while (number>0){
            sb.append(getBaseVal(number%base));
            number/=base;
        }

        return sb.reverse().toString();
    }

    private char getBaseVal(long n){
        if(n>=0 && n<=9)
            return (char)(n+48);
        else
            return (char)(n-10+'A');
    }

    private long getRandomLong() {
        return Math.abs(rand.nextLong());
    }

    private String getRandomString(final int length) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++){
            char c = (char)(rand.nextInt(26)+65);

            if(rand.nextBoolean())
                c = (char)(c+32);

            sb.append(c);
        }
        return sb.toString();
    }

    private int getRandomLength() {
        return rand.nextInt(20)+1;
    }



}
