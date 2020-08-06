package com.leetcode.medium;


/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class canJump_55 {

    //反向思考 如果不能跳出，肯定是存在0，可以跳出，说明可以跳过0
    //那么如何判断是否能跳出0呢？
    // 设当前0的索引为index，用i遍历index-1至0，找到一个数大于index-i即可跳出0
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        if (nums[0] == 0 && nums.length != 1) return false;
        for (int i = 1; i < nums.length - 1; i++) { //只要考虑前n-1个即可，最后一个是否为0不重要
            if (nums[i] == 0 && !passZero(nums, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean passZero(int nums[], int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] > index - i) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump_1(int[] nums) {
        if (nums.length == 0) return true;
        int tmp = 0; //最远可以到达的位置
        for (int i = 0; i < nums.length; i++) {
            if (i <= tmp) {  //遍历找到当前元素可以达到的最大距离
                tmp = Math.max(tmp, nums[i] + i);
                if (tmp >= nums.length - 1) return true;
            }
        }
        return false;
    }
}
