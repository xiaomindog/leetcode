package com.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class subsets_78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            int t = i;
            int count = 0;
            while (t > 0) {
                if ((t & 1) == 1) {
                    list.add(nums[count]);
                }
                t >>= 1;
                count++;
            }
            res.add(list);
        }
        return res;
    }

    static List<List<Integer>> ans;

    public static List<List<Integer>> subsets_1(int[] nums) {
        ans = new ArrayList<>();
        //ans.add(new ArrayList<>());
        if (nums.length == 0) return ans;
        for (int i = 0; i <= nums.length; i++) {
            helper(nums, 0, i, new ArrayList<>());
        }
        return ans;
    }

    //参数k表示在n个数中取出k个数
    public static void helper(int[] nums, int x, int k, List<Integer> list) {

        if (k == 0) {
            ans.add(new ArrayList<>(list));
        }
        if (x >= nums.length) return;

        for (int i = x; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, k - 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        int nthBit = 1 << 4;
        //System.out.println(1 << 4);
        for (int i = 0; i < (int) Math.pow(2, 4); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
            //System.out.println(bitmask);
        }
    }
}