package com.jianzhi;

/**
 * 一个整型数组 nums 里除两个数字之外，
 * 其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class singleNumbers_56_I {

    public static int[] singleNumbers(int[] nums) {
        if (nums.length <= 0) return new int[0];
        //1.所有数字异或
        int n = 0;
        for (int i : nums) {
            n ^= i;
        }
        //2.从低位开始 找到n中第一个为1的位
        int first_1 = 0;
        while ((n & 1) == 0) {
            first_1++;
            n >>= 1;
        }
        //3.按该位0和1 分开
        int res[] = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> first_1 & 1) == 1) {
                res[0] ^= nums[i];
            } else
                res[1] ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 2};
        int[] ans = singleNumbers(nums);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
