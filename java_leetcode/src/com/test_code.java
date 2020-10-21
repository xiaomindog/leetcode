package com;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class test_code {

    public static void main(String[] args) {
        Integer a[] = new Integer[]{4, 5, 3, 6, 1, 7, 10, 8, 9};
        Arrays.sort(a, (t1, t2) -> t2 - t1);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();

        Queue<Integer> queue = new PriorityQueue<>((t1, t2) -> t2 - t1);

        int ss = Integer.parseInt("12");
        System.out.println(ss);
    }
    

}
