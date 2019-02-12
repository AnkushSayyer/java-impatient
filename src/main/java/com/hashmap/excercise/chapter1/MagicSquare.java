package com.hashmap.excercise.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Write a program that reads a two-dimensional array of integers and determines whether it is a
 * magic square (that is, whether the sum of all rows, all columns, and the diagonals is the same).
 * Accept lines of input that you break up into individual integers, and stop when the user enters a
 * blank line. For example, with the input
 *
 * 16 3 2 13
 * 3 10 11 8
 * 9 6 7 12
 * 4 15 14 1
 * (Blank line)
 *
 * your program should respond affirmatively.
 */

public class MagicSquare {

    private ArrayList<String> input;
    private BufferedReader br;
    private int arr[][];

    public void performQueries() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input = new ArrayList<>();

        getInput();

        generateSquare();

        printSquare();

        System.out.println("Is Magic Square = "+isMagicSquare());
    }

    private boolean isMagicSquare() {
        int sum = getInitialSum();

        if(!checkRows(sum))
            return false;

        if(!checkColumns(sum))
            return false;

        if(!checkDiagonals(sum))
            return false;

        return true;
    }

    private boolean checkDiagonals(int sum) {
        int curSum = 0;
        for(int i=0; i<arr.length; i++)
            curSum+=arr[i][i];

        if(sum!=curSum)
            return false;

        if(!checkOtherDiagonal(sum))
            return false;

        return true;
    }

    private boolean checkOtherDiagonal(int sum) {

        int curSum = 0;
        for(int i=0; i<arr.length; i++){
            curSum = curSum + arr[i][arr[0].length-i-1];
        }

        if(curSum!=sum)
            return false;

        return true;
    }

    private boolean checkColumns(int sum) {

        int curSum = 0;

        for(int j=0; j<arr[0].length; j++){
            for(int i=0; i<arr.length; i++)
                curSum+=arr[i][j];

            if(sum!=curSum)
                return false;

            curSum = 0;
        }

        return true;
    }

    private int getInitialSum() {
        int sum = 0;
        for (int ele:arr[0]) {
            sum+=ele;
        }
        return sum;
    }

    private boolean checkRows(int sum) {
        int curSum = 0;
        for (int a[]:arr) {
            for (int ele:a) {
                curSum+=ele;
            }
            if(sum!=curSum)
                return false;
            curSum = 0;
        }
        return true;
    }

    private void printSquare() {
        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    private void generateSquare() {

        arr = new int[input.size()][];

        for (int i=0; i<input.size(); i++){
            String s[] = input.get(i).split(" ");
            arr[i] = createRow(s);
        }

    }

    private int[] createRow(String[] s) {
        int row[] = new int[s.length];
        for(int i=0; i<s.length; i++)
            row[i] = Integer.parseInt(s[i]);

        return row;
    }

    private void getInput() throws IOException {
        String inp = br.readLine();
        while(!inp.isBlank()){
            input.add(inp);
            inp = br.readLine();
        }
    }
}
