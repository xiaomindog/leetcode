package com.jianzhi;

/*
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * */

import java.util.HashMap;
import java.util.Map;

public class duplicate_3 {
    public static boolean duplicate01(int numbers[], int length, int[] duplication) {
        duplication[0] = -1;
        if (length < 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {

            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;

            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            map.put(numbers[i], i);
        }

        return false;
    }

    public static boolean duplicate02(int numbers[], int length, int[] duplication) {
        duplication[0] = -1;
        if (length < 0) return false;
        int[] flag = new int[length];
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
            flag[numbers[i]] += 1;

        }
        for (int i = 0; i < length; i++) {
            if (flag[i] >= 2) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    public static boolean duplicate03(int numbers[], int length, int[] duplication) {
        duplication[0] = -1;
        if (length < 0) return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;

            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }

        }
        return false;
    }


    /*题目改编：P41
     * 不修改数组找出重复的数字，长度为n+1的数组中所有数字在0-n范围内，找出重复的数字*/
    public static int countRange(int[] nums, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static int getDuplication(int[] nums, int lenth) {
        if (nums.length < 0) return -1;
        int start = 1, end = lenth - 1;
        while (end >= start) {
            int middle = (end - start) / 2 + start;

            int count = countRange(nums, lenth, start, end);

            //循环的出口
            if (end == start) {
                if (count > 1) return start;
                else break;
            }

            if (count > (middle - start) + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] duplication = new int[nums.length];
        duplicate01(nums, 8, duplication);
        for (int i = 0; i < duplication.length; i++) {
            System.out.println(duplication[i]);
        }
    }
}
