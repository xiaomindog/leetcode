package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class myTest {
    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        int numRows = 4;
        A.add(new ArrayList<>());
        A.get(0).add(1); //第一行第一个元素为1
        for (int i = 1; i < numRows; i++) {
            List<Integer> B = new ArrayList<>();
            B.add(1);
            for (int j = 1; j < i; j++) {
                B.add(A.get(i - 1).get(j) + A.get(i - 1).get(j - 1));
            }
            B.add(1);
            A.add(B);
        }
        System.out.println(A);
    }
}
