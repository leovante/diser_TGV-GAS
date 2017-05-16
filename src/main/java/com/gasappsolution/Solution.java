package com.javarush.task.task04.task0442;


/*
Суммирование
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main (String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int input = 0;
        while (input != -1) {
            input = Integer.parseInt(scanner.readLine());
            sum += input;
        }
        System.out.println(sum);



    }
}