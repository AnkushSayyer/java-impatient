package com.hashmap.excercise.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Write a program that stores Pascal’s triangle up to a given n in an
 * ArrayList<ArrayList<Integer>>.
 */

public class PascalTriangle {

    private ArrayList<ArrayList<Integer>> pascalTriangle;

    public void printPascalTriangle() {

        for (ArrayList<Integer> al:pascalTriangle
             ) {
            System.out.println(al);
        }
    }

    public void generatePascalTriangle(int n) {

        if(n==0) {
            System.out.println("Invalid Input");
            return;
        }

        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        if(n==1) {
            return;
        }


        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(1).add(1);
        pascalTriangle.get(1).add(1);

        if(n==2) {
            return;
        }

        for(int i=2; i<n; i++){
            pascalTriangle.add(new ArrayList<>());
            pascalTriangle.get(i).add(1);

            for (int j=0; j<pascalTriangle.get(i-1).size()-1; j++){
                pascalTriangle.get(i).add(pascalTriangle.get(i-1).get(j) + pascalTriangle.get(i-1).get(j+1));
            }

            pascalTriangle.get(i).add(1);
        }

        printPascalTriangle();

    }
}
