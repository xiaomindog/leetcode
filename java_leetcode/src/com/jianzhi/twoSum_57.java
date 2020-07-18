package com.jianzhi;

import java.util.HashMap;


/**
 * two sum
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */

public class twoSum_57 {
    //双指针
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) return new int[]{nums[i], nums[j]};
            else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }

    //哈希表
    public static int[] twoSum_1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return new int[2];
    }


    public static void main(String[] args) {
        int n[] = new int[]{2, 7, 9, 11, 15};
        int res[] = twoSum(n, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
