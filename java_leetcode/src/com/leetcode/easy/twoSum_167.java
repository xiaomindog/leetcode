package com.leetcode.easy;

//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

public class twoSum_167 {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return new int[0];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            System.out.println(i + "---" + j);
            if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int b[] = new int[]{2, 7, 11, 15};
        int[] a = twoSum(b, 9);
    }
}
