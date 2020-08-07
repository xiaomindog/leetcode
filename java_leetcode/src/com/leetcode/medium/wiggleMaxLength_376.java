package com.leetcode.medium;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
 * 第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class wiggleMaxLength_376 {


    //利用2个变量分别记录down的个数和up的个数
    //down和up的更新分别取决于前面的up和down
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                down = up + 1; //如果该元素上升，则前面的下降序列长度+1，该摆动序列变为上升
            }
            if (nums[i] < nums[i - 1]) {
                up = down + 1; //如果该元素下降 则前面的上升序列长度+1，该摆动序列变为下降
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLength_1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) { //这边实际上只用于检查前2个是否相等
                i++;
                continue;
            } else if (nums[i] > nums[i - 1]) {
                while (i < nums.length && nums[i] >= nums[i - 1]) {
                    i++;
                }
                count++;

            } else {
                while (i < nums.length && nums[i] <= nums[i - 1]) {
                    i++;
                }
                count++;
            }
        }
        return count;
    }
}
