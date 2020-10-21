package com.leetcode.medium;

/**
 * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
 * 其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内
 * 说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？
 * （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 **/
public class productExceptSelf_238 {
    //上三角和下三角
    public int[] productExceptSelf(int[] nums) {
        int output[] = new int[nums.length];
        int p = 1, q = 1; //主对角线为1
        for (int i = 0; i < nums.length; i++) {
            output[i] = p;
            p *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= q;
            q *= nums[i];
        }
        return output;
    }
}
